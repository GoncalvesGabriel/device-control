package br.com.rash.devicecontrol.repository.device;

import br.com.rash.devicecontrol.entity.vo.DeviceVo;
import java.util.List;

public interface CustomDeviceRepository {

  List<DeviceVo> findByUserAndId(String user, Long id);

}
