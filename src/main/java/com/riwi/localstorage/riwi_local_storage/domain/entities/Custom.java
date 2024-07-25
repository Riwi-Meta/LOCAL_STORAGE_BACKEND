package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "customs")
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column( nullable = false)
    private int minimumStock;

    @OneToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

}
