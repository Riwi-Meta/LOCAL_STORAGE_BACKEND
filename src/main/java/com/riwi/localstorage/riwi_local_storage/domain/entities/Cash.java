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
@Table(name = "cash_machines")
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @OneToMany(mappedBy = "cash", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Sale> sales;
  
    @OneToMany(mappedBy = "cash", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<CashRegister> cashRegister;

    @ManyToOne
    @JoinColumn(name="branch_id", referencedColumnName="id")
    private Branch branch;
}
