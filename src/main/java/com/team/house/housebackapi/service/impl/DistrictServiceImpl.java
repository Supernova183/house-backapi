package com.team.house.housebackapi.service.impl;

import com.team.house.housebackapi.entity.District;
import com.team.house.housebackapi.entity.DistrictExample;
import com.team.house.housebackapi.mapper.DistrictMapper;
import com.team.house.housebackapi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired(required = false)
    DistrictMapper districtMapper;
    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
