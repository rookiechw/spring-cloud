package org.chw.provider.rest;

import org.chw.provider.redis.RedisTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class HelloRest {
  @Autowired
  private RedisTests redisTests;

  @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除", httpMethod = "GET",
      produces = "application/json", tags = "用户操作")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String",
          paramType = "path"),
      @ApiImplicitParam(name = "name", value = "姓名", dataType = "int", paramType = "query")})
  @RequestMapping(value = "hello", method = RequestMethod.GET)
  public String sayHello() {
    this.redisTests.add(null,null);
    return "hello";
  }
}
