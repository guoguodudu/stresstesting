package com.stress.test.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "sys_permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    private String name;

    private String code;

    private String discription;

    private String url;

    private Integer pid;

    private Integer sort;

    @Column(name = "is_delete")
    private Boolean isDelete;

}