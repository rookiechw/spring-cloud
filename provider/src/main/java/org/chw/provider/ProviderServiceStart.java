package org.chw.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderServiceStart {
  public static void main(String[] args) {
    SpringApplication.run(ProviderServiceStart.class, args);
  }
}
