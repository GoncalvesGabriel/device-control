package br.com.rash.devicecontrol.entity;

import br.com.rash.devicecontrol.converter.CountryConverter;
import br.com.rash.devicecontrol.enumx.Country;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_IDENTIFY")
@NoArgsConstructor
public @Data class UserIdentify {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_IDENTIFY_ID")
  private Long id;

  @NotNull
  @Column(name = "COUNTRY")
  @Convert(converter = CountryConverter.class)
  private Country country;

  @NotNull
  @Column(name = "USER_NAME")
  private String userName;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userIdentify")
  private Set<Device> devices = new HashSet<>();

  @Builder
  public UserIdentify(Long id, @NotNull Country country, @NotNull String user) {
    this.id = id;
    this.country = country;
    this.userName = user;
  }
}
