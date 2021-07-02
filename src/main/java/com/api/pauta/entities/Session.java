package com.api.pauta.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Session {

    @Id
    private Long id;

//    @OneToMany
    private String theme;

}
