package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cash_registers")
public class CashRegister {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "finish_amount", nullable = false)
    private Double finishAmount;

    @Column(name = "init_amount", nullable = false)
    private Double initAmount;

    @ManyToOne
    @JoinColumn(name="cash_id", referencedColumnName="id")
    private Cash cash;
}
