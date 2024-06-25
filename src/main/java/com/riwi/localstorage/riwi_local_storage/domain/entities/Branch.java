package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(length = 50)
    private String country;

    @Column( name = "postal_code", length = 50)
    private String postalCode;

    @Column(length = 50)
    private String phone;

    // Type must be changed to "Store" in the future
    // @ManyToOne
    // @JoinColumn(name = "store_id", referencedColumnName = "id",nullable = false)
    private String store;
    
}
