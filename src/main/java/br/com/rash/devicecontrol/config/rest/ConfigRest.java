package br.com.rash.devicecontrol.config.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigRest {

  @Bean
  public RestTemplate rest() {
    return new RestTemplate();
  }
}
