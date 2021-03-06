package org.chw.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceStart {
  public static void main(String[] args) {
    SpringApplication.run(EurekaServiceStart.class, args);
  }
}
