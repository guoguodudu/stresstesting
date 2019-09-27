package com.stress.test.demo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.stress.test.util.FadadaResult;
import com.stress.test.util.Kk;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class Dome implements Serializable {

    private String k;
    private String ll;
    private Kk kk;

    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("code",1);
        object.put("msg",3);
        Dome dome=new Dome();
        dome.setK("12");
        dome.setLl("34");


        Map map=new ConcurrentHashMap();

        List list =new ArrayList();
        Kk kk=new Kk();
        kk.setPp("12323");
        kk.setKp("45");
        dome.setKk(kk);
        object.put("data",dome);
        System.out.println(object);
        FadadaResult<Dome> fadadaResult= JSON.parseObject(object.toString(),new TypeReference<FadadaResult<Dome>>(){});
        System.out.println(fadadaResult.getData());
    }
}
