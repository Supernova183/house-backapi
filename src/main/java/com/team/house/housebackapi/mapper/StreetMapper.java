package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.entity.Street;
import com.team.house.housebackapi.entity.StreetExample;
import java.util.List;
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

public interface StreetMapper {
    @Delete({
        "delete from street",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into street (ID, NAME, ",
        "DISTRICT_ID)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{districtId,jdbcType=INTEGER})"
    })
    int insert(Street record);

    @InsertProvider(type=StreetSqlProvider.class, method="insertSelective")
    int insertSelective(Street record);

    @SelectProvider(type=StreetSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="DISTRICT_ID", property="districtId", jdbcType=JdbcType.INTEGER)
    })
    List<Street> selectByExample(StreetExample example);

    @Select({
        "select",
        "ID, NAME, DISTRICT_ID",
        "from street",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="DISTRICT_ID", property="districtId", jdbcType=JdbcType.INTEGER)
    })
    Street selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StreetSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Street record);

    @Update({
        "update street",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "DISTRICT_ID = #{districtId,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Street record);
}