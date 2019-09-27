package com.stress.test.domain;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    private Integer age;

    private String address;

    public void setString(@NonNull String kk){
        address=kk;
    }

}