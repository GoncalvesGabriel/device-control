package br.com.rash.devicecontrol.config.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMQTT {

  @Autowired
  private MqttProperties properties;

  @Bean
  public IMqttClient mqttClinte() throws MqttException {
    MqttConnectOptions options = new MqttConnectOptions();
    options.setAutomaticReconnect(true);
    options.setConnectionTimeout(10);
    options.setCleanSession(true);
    IMqttClient client = new MqttClient(properties.getUrl(), properties.getClientId());
    client.connect(options);
    return client;
  }

}
