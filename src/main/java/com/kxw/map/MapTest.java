package com.kxw.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kangxiongwei
 * @date 2020-04-10 14:31
 */
public class MapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("1", "123");
        System.out.println(map);
    }


}
