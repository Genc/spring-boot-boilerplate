package com.hiringglobal.mobile.model;

import jakarta.persistence.*;

@Entity
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String linkCv;

    @Column(length = 255)
    private String name;

    @ManyToOne
    private Resume resume;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLinkCv() {
        return linkCv;
    }

    public void setLinkCv(String linkCv) {
        this.linkCv = linkCv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
