package com.riwi.localstorage.riwi_local_storage.domain.entities;

import java.time.LocalDate;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
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
@Table(name = "subscritions")

public class Suscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    // @ManyToOne
    // @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @Column(name = "customer_id")
    private String customer;

    // @ManyToOne
    // @JoinColumn(name = "membership_id", referencedColumnName = "id")
    // Relation with entity membership
    @Column(name = "membership_id")
    private String membership;
}
