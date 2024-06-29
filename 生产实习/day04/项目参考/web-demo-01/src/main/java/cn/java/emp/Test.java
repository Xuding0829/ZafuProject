package cn.java.emp;

import com.alibaba.fastjson.JSON;
import com.itheima.web.Emp;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Emp e = new Emp();
                e.setId(1);
                e.setName("11");
                List<Emp> list = new ArrayList<>();
                list.add(e);
        String json = JSON.toJSONString(list);
        System.out.println(json);
    }
}
