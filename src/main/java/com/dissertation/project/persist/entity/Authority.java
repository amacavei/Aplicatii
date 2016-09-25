package com.dissertation.project.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by cmarineata on 9/25/2016.
 */

@Entity
@Table(name = "authority")

public class Authority {

    @Id
    @GenericGenerator(name = "generator" , strategy = "increment")
    @GeneratedValue(generator = "generator")
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
