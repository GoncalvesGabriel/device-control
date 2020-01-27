package br.com.rash.devicecontrol.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEVICE")
@NoArgsConstructor
public @Data class Device {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "DEVICE_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "USER_IDENTIFY_ID")
  private UserIdentify userIdentify;

  @NotNull
  @Column(name = "CODE", columnDefinition = "SINGLE QR CODE DEVICE")
  private String qrCode;

  @OneToOne
  @JoinColumn(name = "ADRESS_ID")
  private Adress adress;

  @Builder
  public Device(Long id, String qrCode, UserIdentify userIdentify, Adress adress) {
    this.id = id;
    this.qrCode = qrCode;
    this.userIdentify =  userIdentify;
    this.adress = adress;
  }
}
