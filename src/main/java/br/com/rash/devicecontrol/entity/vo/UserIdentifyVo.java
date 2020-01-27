package br.com.rash.devicecontrol.entity.vo;

import br.com.rash.devicecontrol.enumx.Country;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data
class UserIdentifyVo {

  private Long id;

  private Country country;

  private String user;

  private Set<DeviceVo> devices;

}
