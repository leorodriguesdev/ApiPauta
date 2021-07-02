package com.api.pauta.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Pautas implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
    private String theme;


}
