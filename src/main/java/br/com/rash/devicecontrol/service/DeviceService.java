package br.com.rash.devicecontrol.service;

import br.com.rash.devicecontrol.entity.Device;
import br.com.rash.devicecontrol.entity.vo.DeviceVo;
import br.com.rash.devicecontrol.factory.Factory;
import br.com.rash.devicecontrol.repository.device.DeviceRepository;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

  @Autowired
  private DeviceRepository repository;

  @Autowired
  private Factory<DeviceVo, Device> factory;

  public Device save(DeviceVo deviceVo) {
    Optional<Device> optional = repository.findByQRCode(deviceVo.getQrCode());
    if(optional.isPresent()) {
      return optional.get();
    }
    Device device =  factory.create(deviceVo);
    repository.save(device);
    return device;
  }

  public Collection<DeviceVo> findByUser(String user) {
    return repository.findByUser(user);
  }
}
