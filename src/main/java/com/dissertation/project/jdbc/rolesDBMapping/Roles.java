package com.dissertation.project.jdbc.rolesDBMapping;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "roles")

public class Roles {
    @Id
    @GenericGenerator(name = "generator" , strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
