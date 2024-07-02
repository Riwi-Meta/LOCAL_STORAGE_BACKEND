package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone", nullable = false)
  private Long phone;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "enable", nullable = false)
  private Boolean isEnable;

  @OneToMany(
    mappedBy = "company",
    orphanRemoval = false,
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL
  )
  private List<Supplier> suppliers = new ArrayList<>();
}
