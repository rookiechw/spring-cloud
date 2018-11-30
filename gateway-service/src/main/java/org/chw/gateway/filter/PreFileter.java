package org.chw.gateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.chw.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class PreFileter extends ZuulFilter {
  private static final Logger LOGGER = LoggerFactory.getLogger(PreFileter.class);

  @Autowired
  private DiscoveryClient discoveryClient;

  @Override
  public String filterType() {
    return ROUTE_TYPE;
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return Boolean.TRUE;
  }

  @Override
  public Object run() {
    RequestContext cxt = RequestContext.getCurrentContext();
    HttpServletRequest request = cxt.getRequest();
    String version = request.getHeader("version");
    if (StringUtils.isNotBlank(version)) {
      String serviceId = String.valueOf(cxt.get(SERVICE_ID_KEY)).concat(version).toLowerCase();
      List<String> services = discoveryClient.getServices();
      if (CollectionUtil.isNotEmpty(services) && services.contains(serviceId)) {
        cxt.set("serviceId", serviceId);
      }
    }
    LOGGER.info(request.getRequestURI());
    return null;
  }
}
