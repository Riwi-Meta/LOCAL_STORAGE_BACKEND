package com.riwi.localstorage.riwi_local_storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cash_registers")
public class CashRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false, length = 100)
    private Date date;

    @Column(nullable = false, length = 100)
    private Double total_amount;

    @Column(nullable = false, length = 100)
    private String note;

    @Column(nullable = false, length = 100)

    private Double finish_amount;

    @Column(nullable = false, length = 100)

    private Double init_amount;

    @ManyToOne
    @JoinColumn(name="cash_id", referencedColumnName="id")
    private Cash cash;
}
