package br.com.rash.devicecontrol.rest;

import br.com.rash.devicecontrol.config.rest.UserControlRestProperties;
import br.com.rash.devicecontrol.entity.vo.UserIdentifyVo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserIdentifyRestClient implements RestClient<UserIdentifyVo> {

  @Autowired
  private RestTemplate template;

  @Autowired
  private UserControlRestProperties properties;

  @Override
  public UserIdentifyVo getRepresentation(UserIdentifyVo incompleteRepresentatio) {
    Map<String, String> params = new HashMap<>();
    params.put("cpfCnpj", incompleteRepresentatio.getUser());
    String urlFull = String.format("%s%s", this.properties.getUrl(), this.properties.getUserEndPoint());
    UserIdentifyVo userIdentifyVo = template.getForObject(urlFull, UserIdentifyVo.class, params);
    return userIdentifyVo;
  }
}
