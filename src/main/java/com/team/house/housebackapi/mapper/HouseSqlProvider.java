package com.team.house.housebackapi.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.entity.HouseExample.Criteria;
import com.team.house.housebackapi.entity.HouseExample.Criterion;
import com.team.house.housebackapi.entity.HouseExample;
import java.util.List;

public class HouseSqlProvider {

    public String insertSelective(House record) {
        BEGIN();
        INSERT_INTO("house");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            VALUES("USER_ID", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTypeId() != null) {
            VALUES("TYPE_ID", "#{typeId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("TITLE", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("DESCRIPTION", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("PRICE", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPubdate() != null) {
            VALUES("PUBDATE", "#{pubdate,jdbcType=DATE}");
        }
        
        if (record.getFloorage() != null) {
            VALUES("FLOORAGE", "#{floorage,jdbcType=INTEGER}");
        }
        
        if (record.getContact() != null) {
            VALUES("CONTACT", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getStreetId() != null) {
            VALUES("STREET_ID", "#{streetId,jdbcType=INTEGER}");
        }
        
        if (record.getIspass() != null) {
            VALUES("ispass", "#{ispass,jdbcType=INTEGER}");
        }
        
        if (record.getIsdel() != null) {
            VALUES("isdel", "#{isdel,jdbcType=INTEGER}");
        }
        
        if (record.getPath() != null) {
            VALUES("path", "#{path,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(HouseExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("USER_ID");
        SELECT("TYPE_ID");
        SELECT("TITLE");
        SELECT("DESCRIPTION");
        SELECT("PRICE");
        SELECT("PUBDATE");
        SELECT("FLOORAGE");
        SELECT("CONTACT");
        SELECT("STREET_ID");
        SELECT("ispass");
        SELECT("isdel");
        SELECT("path");
        FROM("house");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(House record) {
        BEGIN();
        UPDATE("house");
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getTypeId() != null) {
            SET("TYPE_ID = #{typeId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("TITLE = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("DESCRIPTION = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("PRICE = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPubdate() != null) {
            SET("PUBDATE = #{pubdate,jdbcType=DATE}");
        }
        
        if (record.getFloorage() != null) {
            SET("FLOORAGE = #{floorage,jdbcType=INTEGER}");
        }
        
        if (record.getContact() != null) {
            SET("CONTACT = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getStreetId() != null) {
            SET("STREET_ID = #{streetId,jdbcType=INTEGER}");
        }
        
        if (record.getIspass() != null) {
            SET("ispass = #{ispass,jdbcType=INTEGER}");
        }
        
        if (record.getIsdel() != null) {
            SET("isdel = #{isdel,jdbcType=INTEGER}");
        }
        
        if (record.getPath() != null) {
            SET("path = #{path,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(HouseExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}