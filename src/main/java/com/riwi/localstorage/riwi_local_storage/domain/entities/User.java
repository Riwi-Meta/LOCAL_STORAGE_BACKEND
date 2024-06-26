package com.riwi.localstorage.riwi_local_storage.domain.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
