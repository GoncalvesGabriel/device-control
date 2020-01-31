package br.com.rash.devicecontrol.repository.device;

import br.com.rash.devicecontrol.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long>, CustomDeviceRepository {

}
