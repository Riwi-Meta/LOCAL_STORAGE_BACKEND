package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column( name = "postal_code", length = 50)
    private String postalCode;

    @Column(length = 50)
    private String country;

    @Column(length = 100)
    private String location;

    @Column(length = 50)
    private String phone;



    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Cash> cash;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id",nullable = false)
    private Store store;
    
}
