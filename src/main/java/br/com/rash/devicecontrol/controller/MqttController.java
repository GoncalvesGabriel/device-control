package br.com.rash.devicecontrol.controller;

import br.com.rash.devicecontrol.config.mqtt.MqttProperties;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mqtt")
public class MqttController {

    @Autowired
    IMqttClient client;

    @Autowired
    MqttProperties properties;

    @PostMapping("publish")
    public void publishMessage( ) throws org.eclipse.paho.client.mqttv3.MqttException {
        String message = "Message Teste";
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(0);
        mqttMessage.setRetained(true);

        client.publish(properties.getTopicDeviceFull(), mqttMessage);
    }

}