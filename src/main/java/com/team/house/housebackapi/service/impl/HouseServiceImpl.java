package com.team.house.housebackapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.mapper.HouseMapper;
import com.team.house.housebackapi.service.HouseService;
import com.team.house.housebackapi.util.HouseCondition;
import com.team.house.housebackapi.util.PagePrameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUserId(Integer uid, PagePrameter pagePrameter) {
        PageHelper.startPage(pagePrameter.getPage(),pagePrameter.getPageSize());
        List<House> list=houseMapper.getHouseByUser(uid);
        return new PageInfo<>(list);

    }

    @Override
    public int delHouse(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        List<House> list=houseMapper.getBroswerHouse(houseCondition);
        return new PageInfo<>(list);
    }
}
