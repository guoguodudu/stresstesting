package com.stress.test.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "sys_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    private String name;

    private String icon;

    private String email;

    private String login;

    private String password;

    private String salt;

    private Integer state;

    @Column(name = "is_delete")
    private Boolean isDelete;

}