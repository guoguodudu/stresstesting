package com.stress.test.enums;


import java.util.Arrays;

public enum SendtypeEnum {

    SENDTYPESIMPLE(1,"简单类型"),
    SENDTYPEHTML(2,"html类型"),
    SENDTYPEIMAGE(3,"路径图片"),
    SENDTYPEIFILE(4,"路径附件");

    private String name;
    private Integer value;

    public String getName() {
        return name;
    }


    public Integer getValue() {
        return value;
    }



     SendtypeEnum(Integer value, String name ) {
        this.name = name;
        this.value = value;
    }

    public static SendtypeEnum getById(Integer id) {
        return Arrays.stream(values()).filter(sendtypeEnum -> sendtypeEnum.getValue().intValue()==id.intValue())
                .findFirst().orElse(null);
    }

}
