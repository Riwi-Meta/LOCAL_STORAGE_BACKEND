package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cash_machines")
public class Cash {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "cash", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<CashRegister> cashRegister;


    @ManyToOne
    @JoinColumn(name="branch_id", referencedColumnName="id")
    private Branch branch;
}
