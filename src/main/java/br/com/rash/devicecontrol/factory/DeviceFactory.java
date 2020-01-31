package br.com.rash.devicecontrol.factory;

import br.com.rash.devicecontrol.entity.Device;
import br.com.rash.devicecontrol.entity.UserIdentify;
import br.com.rash.devicecontrol.entity.vo.DeviceVo;
import br.com.rash.devicecontrol.entity.vo.UserIdentifyVo;
import br.com.rash.devicecontrol.service.UserIdentifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceFactory implements Factory<DeviceVo, Device>{

  @Autowired
  private UserIdentifyService userIdentifyService;

  public Device create(DeviceVo deviceVo) {
    UserIdentifyVo userIdentifyVo = new UserIdentifyVo();
    userIdentifyVo.setUser(deviceVo.getUser());
    UserIdentify userIdentify = userIdentifyService.findOrCreate(userIdentifyVo);
    return Device.builder().qrCode(deviceVo.getQrCode()).userIdentify(userIdentify).build();
  }
}
