package com.DEVLooping.cruddemo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_type")
public class UserType {

    // definir campos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usertype")
    private int id;
    @Column(name = "name_type")
    private String name_type;
    @Column(name = "desc_type")
    private String desc_type;

    // definir constructores, getters y setters

    @Override
    public String toString() {
        return "UserType [id=" + id + ", name_type=" + name_type + ", desc_type=" + desc_type + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public String getDesc_type() {
        return desc_type;
    }

    public void setDesc_type(String desc_type) {
        this.desc_type = desc_type;
    }
    
    public UserType() {
    }
    public UserType(int id) {
        this.id = id;
    }

    public UserType(int id, String name_type, String desc_type) {
        this.id = id;
        this.name_type = name_type;
        this.desc_type = desc_type;
    }



}
