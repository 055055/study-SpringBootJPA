package com.example.springstudyjpa.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Account {
    @Id @GeneratedValue
    //@id @generatevalue하면 id자동으로 들어감?
    private Long id;

    private String username;

    private String password;

    private String email;

    private boolean active;

}
