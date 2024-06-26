package com.riwi.localstorage.riwi_local_storage.domain.entities;

import java.time.LocalDate;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscritions")
@Builder
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

    //Relation with entity user
    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "user_id",referencedColumnName = "id")
    private User user;

    //Relation with entity membership
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id", referencedColumnName = "id", nullable = false)
    private Membership membership;
}
