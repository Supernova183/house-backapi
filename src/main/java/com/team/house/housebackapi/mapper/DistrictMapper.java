package com.team.house.housebackapi.mapper;

import com.team.house.housebackapi.entity.District;
import com.team.house.housebackapi.entity.DistrictExample;
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

public interface DistrictMapper {
    @Delete({
        "delete from district",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into district (ID, NAME)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(District record);

    @InsertProvider(type=DistrictSqlProvider.class, method="insertSelective")
    int insertSelective(District record);

    @SelectProvider(type=DistrictSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<District> selectByExample(DistrictExample example);

    @Select({
        "select",
        "ID, NAME",
        "from district",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR)
    })
    District selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DistrictSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(District record);

    @Update({
        "update district",
        "set NAME = #{name,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(District record);
}