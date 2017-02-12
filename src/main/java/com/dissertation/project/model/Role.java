package com.dissertation.project.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by cmarineata on 9/25/2016.
 */

@Entity
@Table(name = "roles")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId(){
        return id;
    }

    public void setId(Long Id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
