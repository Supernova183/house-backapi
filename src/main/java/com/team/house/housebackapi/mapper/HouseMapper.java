package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.entity.HouseExample;
import java.util.List;

import com.team.house.housebackapi.util.HouseCondition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HouseMapper {
    @Delete({
        "delete from house",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into house (ID, USER_ID, ",
        "TYPE_ID, TITLE, DESCRIPTION, ",
        "PRICE, PUBDATE, FLOORAGE, ",
        "CONTACT, STREET_ID, ",
        "ispass, isdel, path)",
        "values (#{id,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER}, ",
        "#{typeId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{pubdate,jdbcType=DATE}, #{floorage,jdbcType=INTEGER}, ",
        "#{contact,jdbcType=VARCHAR}, #{streetId,jdbcType=INTEGER}, ",
        "#{ispass,jdbcType=INTEGER}, #{isdel,jdbcType=INTEGER}, #{path,jdbcType=VARCHAR})"
    })
    int insert(House record);

    @InsertProvider(type=HouseSqlProvider.class, method="insertSelective")
    int insertSelective(House record);

    @SelectProvider(type=HouseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="TYPE_ID", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="PUBDATE", property="pubdate", jdbcType=JdbcType.DATE),
        @Result(column="FLOORAGE", property="floorage", jdbcType=JdbcType.INTEGER),
        @Result(column="CONTACT", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="STREET_ID", property="streetId", jdbcType=JdbcType.INTEGER),
        @Result(column="ispass", property="ispass", jdbcType=JdbcType.INTEGER),
        @Result(column="isdel", property="isdel", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR)
    })
    List<House> selectByExample(HouseExample example);

    @Select({
        "select",
        "ID, USER_ID, TYPE_ID, TITLE, DESCRIPTION, PRICE, PUBDATE, FLOORAGE, CONTACT, ",
        "STREET_ID, ispass, isdel, path",
        "from house",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="TYPE_ID", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="PUBDATE", property="pubdate", jdbcType=JdbcType.DATE),
        @Result(column="FLOORAGE", property="floorage", jdbcType=JdbcType.INTEGER),
        @Result(column="CONTACT", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="STREET_ID", property="streetId", jdbcType=JdbcType.INTEGER),
        @Result(column="ispass", property="ispass", jdbcType=JdbcType.INTEGER),
        @Result(column="isdel", property="isdel", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR)
    })
    House selectByPrimaryKey(String id);

    @Select({
            "select",
            " house.*,type.`NAME` AS tname,street.`NAME` AS sname, district.`NAME` AS dname",
            "from house",
            "LEFT JOIN `type` ON house.`TYPE_ID`=type.`ID`",
            "LEFT JOIN street ON house.`STREET_ID`= street.`ID`",
            "LEFT JOIN `district` ON street.`DISTRICT_ID`=district.`ID`",
            "where user_id = #{userid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="TYPE_ID", property="typeId", jdbcType=JdbcType.INTEGER),
            @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="PUBDATE", property="pubdate", jdbcType=JdbcType.DATE),
            @Result(column="FLOORAGE", property="floorage", jdbcType=JdbcType.INTEGER),
            @Result(column="CONTACT", property="contact", jdbcType=JdbcType.VARCHAR),
            @Result(column="STREET_ID", property="streetId", jdbcType=JdbcType.INTEGER),
            @Result(column="ispass", property="ispass", jdbcType=JdbcType.INTEGER),
            @Result(column="isdel", property="isdel", jdbcType=JdbcType.INTEGER),
            @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
            @Result(column="Name", property="tname", jdbcType=JdbcType.VARCHAR),
            @Result(column="Name", property="sname", jdbcType=JdbcType.VARCHAR),
            @Result(column="Name", property="dname", jdbcType=JdbcType.VARCHAR)
    })
    List<House> getHouseByUser(Integer userid);

    @Select({
            "<script>",
            "select",
            " house.*,type.`NAME` AS tname,street.`NAME` AS sname, district.`NAME` AS dname",
            "from house",
            "LEFT JOIN `type` ON house.`TYPE_ID`=type.`ID`",
            "LEFT JOIN street ON house.`STREET_ID`= street.`ID`",
            "LEFT JOIN `district` ON street.`DISTRICT_ID`=district.`ID`",
            "where 1=1",
            "<if test='title!=null'>and title like concat('%',#{title},'%')</if>",
            "<if test='did!=null'>and district.id=#{did}</if>",
            "<if test='sid!=null'>and street.id=#{sid}</if>",
            "<if test='tid!=null'>and type_id=#{tid}</if>",
            "<if test='startPrice!=null'>and  price > #{startPrice}</if>",
            "<if test='endPrice!=null'>and price &lt; #{endPrice}</if>",
            "</script>"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="TYPE_ID", property="typeId", jdbcType=JdbcType.INTEGER),
            @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="PUBDATE", property="pubdate", jdbcType=JdbcType.DATE),
            @Result(column="FLOORAGE", property="floorage", jdbcType=JdbcType.INTEGER),
            @Result(column="CONTACT", property="contact", jdbcType=JdbcType.VARCHAR),
            @Result(column="STREET_ID", property="streetId", jdbcType=JdbcType.INTEGER),
            @Result(column="ispass", property="ispass", jdbcType=JdbcType.INTEGER),
            @Result(column="isdel", property="isdel", jdbcType=JdbcType.INTEGER),
            @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
            @Result(column="Name", property="tname", jdbcType=JdbcType.VARCHAR),
            @Result(column="Name", property="sname", jdbcType=JdbcType.VARCHAR),
            @Result(column="Name", property="dname", jdbcType=JdbcType.VARCHAR)
    })
    List<House> getBroswerHouse(HouseCondition houseCondition);

    @UpdateProvider(type=HouseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(House record);

    @Update({
        "update house",
        "set USER_ID = #{userId,jdbcType=INTEGER},",
          "TYPE_ID = #{typeId,jdbcType=INTEGER},",
          "TITLE = #{title,jdbcType=VARCHAR},",
          "DESCRIPTION = #{description,jdbcType=VARCHAR},",
          "PRICE = #{price,jdbcType=DECIMAL},",
          "PUBDATE = #{pubdate,jdbcType=DATE},",
          "FLOORAGE = #{floorage,jdbcType=INTEGER},",
          "CONTACT = #{contact,jdbcType=VARCHAR},",
          "STREET_ID = #{streetId,jdbcType=INTEGER},",
          "ispass = #{ispass,jdbcType=INTEGER},",
          "isdel = #{isdel,jdbcType=INTEGER},",
          "path = #{path,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(House record);


}