package com.team.house.housebackapi;

import com.team.house.housebackapi.entity.TypeExample;
import com.team.house.housebackapi.mapper.TypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springbootdemo02ApplicationTests {
    @Autowired
    TypeMapper typeMapper;
    @Test
    void contextLoads() {
        System.out.println(typeMapper.selectByExample(new TypeExample()).size());
    }

}
