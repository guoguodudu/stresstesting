package com.stress.test.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "sys_role")
public class Role implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    private String name;

    private String code;

    private String description;

    private Integer state;

    @Column(name = "is_delete")
    private Boolean isDelete;
}