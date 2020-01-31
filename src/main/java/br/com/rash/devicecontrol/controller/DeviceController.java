package br.com.rash.devicecontrol.controller;

import br.com.rash.devicecontrol.entity.Device;
import br.com.rash.devicecontrol.entity.vo.DeviceVo;
import br.com.rash.devicecontrol.service.DeviceService;
import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devices")
public class DeviceController {

  @Autowired
  private DeviceService deviceService;

  @GetMapping("{id}")
  public Collection<Device> findByUser(@PathVariable Long id, @RequestParam String user) {
    Collection<DeviceVo> devices = deviceService.findByUser(user);
    return Collections.EMPTY_LIST;
  }
}
