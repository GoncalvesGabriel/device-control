package br.com.rash.devicecontrol.config.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rest.user.control")
public @Data class UserControlRestProperties {

  private String url;

  private String userEndPoint;

}
