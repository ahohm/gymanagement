package com.aho.gymgmnt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Abonne abonne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;


    private LocalDate startDate;
    private LocalDate endDate;

    public Abonnement(Abonne abonne, Category category, LocalDate startDate, LocalDate endDate) {
        this.abonne = abonne;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
