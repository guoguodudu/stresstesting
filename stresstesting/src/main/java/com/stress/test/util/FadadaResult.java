package com.stress.test.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class FadadaResult<T> implements Serializable {
    private String code;
    private String msg;
    private T data;
}
