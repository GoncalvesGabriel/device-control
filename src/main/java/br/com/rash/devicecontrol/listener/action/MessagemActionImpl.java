package br.com.rash.devicecontrol.listener.action;

import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Component;

@Component
public class MessagemActionImpl implements MessageAction {

  @Override
  public void messageReceiver(byte[] message) {
    try {
      System.out.println(new String(message, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      System.out.println("Deu Erro na message");
    }
  }
}
