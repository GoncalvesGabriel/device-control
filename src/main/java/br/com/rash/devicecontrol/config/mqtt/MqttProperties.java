package br.com.rash.devicecontrol.config.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "br.com.fiap.devicecontrol.mqtt")
public @Data class MqttProperties {

  private String url;

  private String clientId;

  private String topicDeviceFull;

}
