package br.com.rash.devicecontrol.entity.vo;

import br.com.rash.devicecontrol.entity.Adress;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data
class DeviceVo {

  private Long id;

  private String user;

  private String qrCode;

  private AdressVO adress;

  public DeviceVo(Long id, String qrCode, Adress adress, String user) {
    this.id = id;
    this.user = user;
    this.qrCode = qrCode;
    this.adress = new AdressVO(adress);
  }
}
