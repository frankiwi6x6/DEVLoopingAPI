package com.DEVLooping.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permission")

public class Permission {
    @Id
    @Column(name = "id_permission")
    private int id;

    @Column(name = "name_permission")
    private String name_permission;

    @Column(name = "desc_permission")
    private String desc_permission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_permission() {
        return name_permission;
    }

    public void setName_permission(String name_permission) {
        this.name_permission = name_permission;
    }

    public String getDesc_permission() {
        return desc_permission;
    }

    public void setDesc_permission(String desc_permission) {
        this.desc_permission = desc_permission;
    }

    public Permission() {
    }

    public Permission(int id, String name_permission, String desc_permission) {
        this.id = id;
        this.name_permission = name_permission;
        this.desc_permission = desc_permission;
    }

    @Override
    public String toString() {
        return "Permission [id=" + id + ", name_permission=" + name_permission + ", desc_permission=" + desc_permission
                + "]";
    }

}
