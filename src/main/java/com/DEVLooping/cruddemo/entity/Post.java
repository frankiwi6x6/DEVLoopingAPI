package com.DEVLooping.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "post")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "slug")
    private String slug;
    @Column(name = "status")
    private String status;
    @Column(name = "author_id")
    private int author_id;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "updated_at")
    private String updated_at;
    @Column(name = "published_at")
    private String published_at;
    @Column(name = "deleted_at")
    private String deleted_at;
    @Column(name = "content")
    private String content;

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post(int id, String title, String slug, String status, int author_id, String created_at, String updated_at,
            String published_at, String deleted_at, String content) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.status = status;
        this.author_id = author_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.published_at = published_at;
        this.deleted_at = deleted_at;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", slug=" + slug + ", status=" + status + ", author_id="
                + author_id + ", created_at=" + created_at + ", updated_at=" + updated_at + ", published_at="
                + published_at + ", deleted_at=" + deleted_at + ", content=" + content + "]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
