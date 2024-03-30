package com.DEVLooping.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    // definir campos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "bio")
    private String bio;
    @Column(name = "country_id")
    private int country_id;
    @Column(name = "profile_pic")
    private String profile_pic;
    @Column(name = "username")
    private String username;
    @Column(name = "dob")
    private String dob;
    @Column(name = "password")
    private String password;

    // definir constructores
    public User() {
    }

    public User(String email, String bio, int country_id, String profile_pic, String username, String dob,
            String password) {
        this.email = email;
        this.bio = bio;
        this.country_id = country_id;
        this.profile_pic = profile_pic;
        this.username = username;
        this.dob = dob;
        this.password = password;
    }
    // definir getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", bio=" + bio + ", country_id=" + country_id
                + ", profile_pic=" + profile_pic + ", username=" + username + ", dob=" + dob + ", password=" + password
                + "]";
    }

}
