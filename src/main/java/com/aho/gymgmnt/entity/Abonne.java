package com.aho.gymgmnt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Abonne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firsName;
    private String lastName;

    private String cin;
    private String photo;
    private String certifMed;

    @OneToMany(mappedBy = "abonne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Abonnement> subscriptionList;


}
