package br.com.rash.devicecontrol.listener;

import br.com.rash.devicecontrol.config.mqtt.MqttProperties;
import br.com.rash.devicecontrol.listener.action.MessageAction;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttListener {

  private IMqttClient client;

  private MessageAction action;

  @Autowired
  public MqttListener(IMqttClient client, MqttProperties properties, MessageAction action) throws MqttException {
    this.client = client;
    this.action =  action;
    this.client.subscribe(properties.getTopicDeviceFull(), (topic, message) -> {
      action.messageReceiver(message.getPayload());
    });
  }
}
