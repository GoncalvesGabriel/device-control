package br.com.rash.devicecontrol.enumx;

import java.util.Arrays;
import java.util.Optional;
import lombok.Getter;

public enum Country {
  
  BRAZIL("BRAZIL", "BR");

  @Getter
  private final String name;

  @Getter
  private final String abbreviation;

  Country(String name, String abbreviation) {
    this.name = name;
    this.abbreviation = abbreviation;
  }

  public static Country getEnum(String abbreviation) {
    Optional<Country> country = Arrays.stream(Country.values()).filter(value -> value.getAbbreviation().equals(abbreviation)).findFirst();
    if(country.isPresent()) {
      return country.get();
    }
    throw new IllegalArgumentException(String.format("Country %s not found", abbreviation));
  }
}
