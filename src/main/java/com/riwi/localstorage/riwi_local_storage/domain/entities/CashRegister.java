package com.riwi.localstorage.riwi_local_storage.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cash_registers")
public class CashRegister {

    @OneToOne
    @JoinColumn(name = "cash_id", referencedColumnName = "id")
    private Cash cash;

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

}
