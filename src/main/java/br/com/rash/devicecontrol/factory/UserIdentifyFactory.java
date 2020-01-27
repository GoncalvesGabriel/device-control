package br.com.rash.devicecontrol.factory;

import br.com.rash.devicecontrol.entity.UserIdentify;
import br.com.rash.devicecontrol.entity.vo.UserIdentifyVo;
import br.com.rash.devicecontrol.enumx.Country;
import br.com.rash.devicecontrol.repository.userIdentify.UserIdentifyRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserIdentifyFactory implements Factory<UserIdentifyVo, UserIdentify> {

  @Autowired
  private UserIdentifyRepository repository;

  @Override
  public UserIdentify findOrCreate(UserIdentifyVo representation) {
    Optional<UserIdentify> userIdentify = repository.findByUser(representation.getUser());
    if (userIdentify.isPresent()) {
      return userIdentify.get();
    }
    return UserIdentify.builder().user(representation.getUser()).country(Country.BRAZIL).build();
  }




}
