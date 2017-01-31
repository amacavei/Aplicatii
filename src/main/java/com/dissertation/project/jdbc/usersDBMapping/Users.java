package com.dissertation.project.jdbc.usersDBMapping;

import com.dissertation.project.jdbc.rolesDBMapping.Roles;
import org.dozer.Mapping;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Mapping("id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Mapping("first_name")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Mapping("family_name")
    @Column(name = "family_name", nullable = false)
    private String familyName;

    @Mapping("e_mail")
    @Column(name = "e_mail", nullable = false)
    private String email;

    @Mapping("phone")
    @Column(name = "phone", nullable = false)
    private String phone;

    @Mapping("language")
    @Column(name = "language", nullable = false)
    private String language;

    @Mapping("id_picture")
    @Column(name = "id_picture")
    private String pictureId;

    @Mapping("login")
    @Column(name = "login", nullable = false)
    private String login;

    @Mapping("password")
    @Column(name = "password", nullable = false)
    private String password;

    @Mapping("birth_date")
    @Column(name = "birth_date")
    private Date birthDate;

    @Mapping("enabled")
    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "id_role", table = "roles", referencedColumnName = "id")})
    private Set<Roles> roles = new HashSet<Roles>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }
}
