package br.com.rash.devicecontrol.repository.device;

import br.com.rash.devicecontrol.entity.Device;
import br.com.rash.devicecontrol.entity.vo.DeviceVo;
import java.util.List;
import java.util.Optional;

public interface CustomDeviceRepository {

  List<DeviceVo> findByUser(String user);

  Optional<Device> findByQRCode(String qrCode);
}
