package com.riwi.localstorage.riwi_local_storage.domain.entities;

import java.util.List;

import com.riwi.localstorage.riwi_local_storage.util.enums.StatusType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Branch> branches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    
    @OneToOne(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Custom custom;

 
}
