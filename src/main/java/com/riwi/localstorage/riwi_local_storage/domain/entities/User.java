package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "phone", nullable = true, length = 20)
    private String phone;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    // @ManyToOne
    // @JoinColumn(name = "role_id", referencedColumnName = "id",nullable = false)
    // Relation with entity role
    private String role;

    // @OneToMany(
    // mappedBy = "user",
    // fetch = FetchType.LAZY,
    // cascade = CascadeType.ALL)
    // Relation with entity subscription
    private List<String> subscriptions;
}
