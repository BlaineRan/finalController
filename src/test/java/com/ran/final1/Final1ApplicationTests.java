package com.ran.final1;

import com.ran.final1.util.RanUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Final1ApplicationTests {

    @Test
    void contextLoads() {
        Map<String,String> map = new HashMap<>();
        map.put("account","1819153268");
        map.put("password","Zwh020716");
        map.put("access","admin");

        System.out.println(RanUtil.jwtGenerate(map,1));
        System.out.println(RanUtil.parse(RanUtil.jwtGenerate(map,1),RanUtil.secretKey).get("account").toString());
    }

}
