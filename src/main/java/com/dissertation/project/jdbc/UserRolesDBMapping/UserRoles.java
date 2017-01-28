package com.dissertation.project.jdbc.UserRolesDBMapping;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")

public class UserRoles {

    @Id
    @GenericGenerator(name = "generator" , strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "id_user", nullable = false)
    private Long id_user;

    @Column(name = "id_role", nullable = false)
    private Long id_role;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId_user(){
        return id_user;
    }

    public void setId_user(Long id_user){
        this.id_user = id_user;
    }

    public Long getId_role(){
        return id_role;
    }

    public void setId_role(Long id_role){
        this.id_role = id_role;
    }
}
