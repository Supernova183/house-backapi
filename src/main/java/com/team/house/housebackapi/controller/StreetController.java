package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.entity.Street;
import com.team.house.housebackapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController   //全返回数据
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/getStreetByDid")  //传递区域的编号
    @CrossOrigin(value = "*" ,allowCredentials = "true")
    public List<Street> getStreetByDid(Integer did)
    {
        return streetService.getStreetByDid(did);
    }

}
