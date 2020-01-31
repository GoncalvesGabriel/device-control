package br.com.rash.devicecontrol.service;

import br.com.rash.devicecontrol.entity.UserIdentify;
import br.com.rash.devicecontrol.entity.vo.UserIdentifyVo;
import br.com.rash.devicecontrol.factory.Factory;
import br.com.rash.devicecontrol.repository.userIdentify.UserIdentifyRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIdentifyService {

  @Autowired
  UserIdentifyRepository repository;

  @Autowired
  private Factory<UserIdentifyVo, UserIdentify> factory;

  public UserIdentify findOrCreate(UserIdentifyVo userVo) {
    Optional<UserIdentify> userIdentifyOp = repository.findByUser(userVo.getUser());
    if (userIdentifyOp.isPresent()) {
      return userIdentifyOp.get();
    }

    UserIdentify userIdentify = factory.create(userVo);
    repository.save(userIdentify);

    return userIdentify;
  }
}
