package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branches")
public class Branch {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String city;
    
    @Column(length = 50)
    private String province;

    @Column( name = "postal_code", length = 50)
    private String postalCode;

    @Column(length = 50)
    private String country;

    @Column(length = 50)
    private String phone;

    private boolean isEnable;

    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Cash> cash;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id",nullable = false)
    private Store store;
  
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Inventory> inventory;
    
    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Sale> sales;

}
