package br.com.rash.devicecontrol.converter;

import br.com.rash.devicecontrol.enumx.Country;
import javax.persistence.AttributeConverter;

public class CountryConverter implements AttributeConverter<Country, String> {

  @Override
  public String convertToDatabaseColumn(Country country) {
    return country.getAbbreviation();
  }

  @Override
  public Country convertToEntityAttribute(String abbreviation) {
    return Country.getEnum(abbreviation);
  }
}
