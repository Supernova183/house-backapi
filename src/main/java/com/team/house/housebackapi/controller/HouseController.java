package com.team.house.housebackapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.entity.Users;
import com.team.house.housebackapi.service.HouseService;
import com.team.house.housebackapi.util.FileUploadUtil;
import com.team.house.housebackapi.util.HouseCondition;
import com.team.house.housebackapi.util.PagePrameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RestController   //全返回数据
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("/fabuHouse")
    @CrossOrigin(value = "*",allowCredentials ="true" )
    public String fabuHouse(House house, HttpSession session,@RequestParam(value ="pfile",required =false) MultipartFile pfile){
        //house对象用于获取表单数据
        try {
            String path="d:\\images"; //设置文件存储位置
            //调用工具类实现上传
            String filename= FileUploadUtil.upload(pfile,path);
            house.setPath(filename);
            //1.调用业务将信息保存数据库
            //1.1 设置出租房的编号   利用时间毫秒数
            house.setId(System.currentTimeMillis()+"");
            System.out.println(house.getId());
            //1.2 设置所属用户
            // 开发时，如果登入还没实现，可以设置默认值
            // house.setUserId(固定值);
            //登入实现啦，获取登入人的编号
            Users users=(Users) session.getAttribute("logininfo");
            house.setUserId(users.getId());
            houseService.addHouse(house);
            //2.实现文件上传
            return "{\"result\":1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":0}";
    }

    @RequestMapping("/getHouseByPage")
    @CrossOrigin(value = "*",allowCredentials ="true" )
    public Map<String,Object> getHouseByPage(PagePrameter pagePrameter,HttpSession session){
        //调用业务获取数据
        pagePrameter.setPageSize(5);  //每页5条
        Users users=(Users)session.getAttribute("logininfo");
        PageInfo<House> pageInfo=houseService.getHouseByUserId(users.getId(),pagePrameter);  //用户id
        System.out.println("输出数据数量"+pageInfo.getList().size());
        Map<String,Object> map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages());  //封装总页
        map.put("rows",pageInfo.getList()); //封装当前页的记录
        return map;
    }
    @RequestMapping("/delHouse")
    @CrossOrigin(value = "*",allowCredentials ="true")
    public String delHouse(String id,String filename){
        //调用业务删除出租房
        int temp=houseService.delHouse(id);
        if(temp>0) {
            //删除的图片
            File file=new File("d:\\images\\"+filename);
            if(file.exists()){
                file.delete();  //删除
            }
            return "{\"result\":1}";
        }
        else
            return "{\"result\":0}";
    }
    @RequestMapping("/searchHouse")
    @CrossOrigin(value = "*",allowCredentials ="true")
    public Map<String,Object> searchHouse(HouseCondition houseCondition){
        houseCondition.setPageSize(4);  //设置每页大小
        //调用业务
        PageInfo<House> pageInfo=houseService.getBroswerHouse(houseCondition);
        //返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages());  //总页
        map.put("rows",pageInfo.getList());   //当前页数据
        return map;
    }




}
