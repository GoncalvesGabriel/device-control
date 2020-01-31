package br.com.rash.devicecontrol.entity;

import br.com.rash.devicecontrol.converter.CountryConverter;
import br.com.rash.devicecontrol.enumx.Country;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADRESS")
@NoArgsConstructor
public @Data class Adress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ADRESS_ID")
  private Long id;

  @NotNull
  @Convert(converter = CountryConverter.class)
  @Column(name = "COUNTRY")
  private Country country;

  @NotNull
  @Column(name = "ZIP_CODE")
  private String zipCode;

  @Column(name = "STREET")
  private String street;

  @Column(name = "NUMBER")
  private Integer number;

  @JoinColumn(name = "DEVICE_ID")
  @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Device device;

  @Builder
  public Adress(Long id, @NotNull Country country, @NotNull String zipCode, String street, Integer number, @NotNull Device device) {
    this.id = id;
    this.country = country;
    this.zipCode = zipCode;
    this.street = street;
    this.number = number;
    this.device = device;
  }
}
