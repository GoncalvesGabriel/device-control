package br.com.rash.devicecontrol.factory;

import br.com.rash.devicecontrol.entity.UserIdentify;
import br.com.rash.devicecontrol.entity.vo.UserIdentifyVo;
import br.com.rash.devicecontrol.repository.userIdentify.UserIdentifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserIdentifyFactory implements Factory<UserIdentifyVo, UserIdentify> {

  @Autowired
  private UserIdentifyRepository repository;

  @Override
  public UserIdentify create(UserIdentifyVo representation) {
    return UserIdentify.builder().user(representation.getUser()).country(representation.getCountry()).build();
  }
}
