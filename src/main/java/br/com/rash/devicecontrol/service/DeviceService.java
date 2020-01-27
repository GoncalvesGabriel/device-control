package br.com.rash.devicecontrol.service;

import br.com.rash.devicecontrol.entity.Device;
import br.com.rash.devicecontrol.entity.vo.DeviceVo;
import br.com.rash.devicecontrol.factory.DeviceFactory;
import br.com.rash.devicecontrol.repository.device.DeviceRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

  @Autowired
  private DeviceRepository repository;

  @Autowired
  private DeviceFactory factory;

  public void savOrUpdate(DeviceVo deviceVo) {
    Device device =  factory.findOrCreate(deviceVo);
  }

  public Collection<Device> findByIdAndUser(Long id, String user) {
    return null;
  }
}
