package com.stress.test.demo;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class Demo2 {

    private String name;
    private String password;

    public Demo2() {

    }

    public static void main(String[] args) {


        List<Demo> demos = Lists.newArrayList();
        Demo demo = new Demo();
        demo.setName("12");
        demo.setPassword("45");
        demos.add(demo);
        Demo demo1 = new Demo();
        demo1.setName("121");
        demo1.setPassword("451");
        demos.add(demo1);
        for (int i=4;i<100000000;i++) {
            Demo demo4 = new Demo();
            demo4.setName("121");
            demo4.setPassword("451");
            demos.add(demo4);
        }


        List<Demo2> demo2List4 = Lists.newArrayList();

        long start1 = System.currentTimeMillis();
        demos.parallelStream().filter(Objects::nonNull).forEach(e -> {
            Demo2 demo2 = new Demo2();
            BeanUtils.copyProperties(e, demo2);
            demo2List4.add(demo2);
        });
        long end1 = System.currentTimeMillis();
        System.out.println("程序运行时间333："+(end1-start1)+"ms");

        List<Demo2> demo2List = Lists.newArrayList();
        long start = System.currentTimeMillis();
        demo2List = demos.stream().filter(Objects::nonNull).map(e -> {
                    Demo2 demo2 = new Demo2();
                    BeanUtils.copyProperties(e, demo2);
                    return demo2;
                }
        ).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间："+(end-start)+"ms");









    }
}
