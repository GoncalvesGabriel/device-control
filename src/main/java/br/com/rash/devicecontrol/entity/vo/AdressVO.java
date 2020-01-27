package br.com.rash.devicecontrol.entity.vo;

import br.com.rash.devicecontrol.entity.Adress;
import br.com.rash.devicecontrol.enumx.Country;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdressVO {

  private Integer number;

  private Country country;

  private String street;

  private String zipCode;

  public AdressVO(Adress adress) {
    this.zipCode = adress.getZipCode();
    this.street = adress.getStreet();
    this.country = adress.getCountry();
    this.number = adress.getNumber();
  }


}
