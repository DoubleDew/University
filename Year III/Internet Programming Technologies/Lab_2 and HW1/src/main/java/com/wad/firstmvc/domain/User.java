package com.wad.firstmvc.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    public User() {}

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name;}
    public String getEmail() { return email; }


    public void setId(Long id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setEmail(String email){ this.email = email; }
}
