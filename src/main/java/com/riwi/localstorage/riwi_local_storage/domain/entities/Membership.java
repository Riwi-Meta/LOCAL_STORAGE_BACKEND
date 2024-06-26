package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "price", nullable = false)
    private Double price;

    
    @Column(name = "description", nullable = true)
    @Lob
    private String description;

    // @Column(name = "user_id", nullable = false)
    // @OneToMany(
    // mappedBy = "memberships",
    // fetch = FetchType.LAZY,
    // cascade = CascadeType.ALL)
    // Relation with entity subscription
    // NOTE: *** Check if the user entity has a direct relationship with memberships. ***
    @Column(name = "user_id")
    private String user;

    //Relation with entity suscription
    @OneToMany(mappedBy = "membership", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Suscription> suscriptions;
}
