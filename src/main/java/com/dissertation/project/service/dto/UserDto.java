package com.dissertation.project.service.dto;


import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserDto {

    @Mapping("id")
    private Long id;

    @Mapping("firstName")
    private String firstName;

    @Mapping("familyName")
    private String familyName;

    @Mapping("email")
    private String email;

    @Mapping("phone")
    private String phone;

    @Mapping("language")
    private String language;

    @Mapping("login")
    private String login;

    @Mapping("password")
    private String password;

    @Mapping("birthDate")
    private Date birthDate;

    @Mapping("roles")
    private Set<RoleDto> roles = new HashSet<RoleDto>();

    @Mapping("enabled")
    private Boolean enabled;

    @Mapping("pictureId")
    private Long pictureId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getRolesAsString() {
        StringBuffer sb = new StringBuffer();
        for (RoleDto a : this.getRoles()) {
            sb.append(a.getName());
            sb.append(", ");
        }
        return StringUtils.substring(sb.toString(), 0, sb.length() - 2);
    }
}