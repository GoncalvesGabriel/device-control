package br.com.rash.devicecontrol.service;

import br.com.rash.devicecontrol.entity.UserIdentify;
import br.com.rash.devicecontrol.entity.vo.UserIdentifyVo;
import br.com.rash.devicecontrol.factory.UserIdentifyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIdentifyService {

  @Autowired
  private UserIdentifyFactory factory;

  public UserIdentify findByUser(UserIdentifyVo userVo) {
    return factory.findOrCreate(userVo);
  }
}
