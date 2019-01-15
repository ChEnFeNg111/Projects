package com.westos.saasmarketing.marketingprogram.dao;

import com.westos.saasmarketing.marketingprogram.domain.CustomerProgram;
import com.westos.saasmarketing.marketingprogram.domain.Industry;
import com.westos.saasmarketing.marketingprogram.domain.MarketingProgram;
import com.westos.saasmarketing.marketingprogram.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * dao层负责与数据库交互
 * @author chen
 */
@Mapper
@Component
public interface UserManageMapper {


    void addProgram(MarketingProgram marketingProgram);

    @Insert("insert into saas_program_industry values(#{programId},#{industryId})")
    void addProgramIndustry(Map<Object,Object> map);

    @Insert("insert into saas_program_class values(#{programId},#{rfmclass})")
    void addProgramClass(Map<Object,Object> map);

    @Select("select orderid,qiyeid,programid,buyingtime,buyingmoney from  saas_customerprogram where qiYeId=#{qiYeId} limit #{start},#{size}")
    List<CustomerProgram> findAllCustomerProgram(Map<Object,Object> map);

    @Select("select programid,name,author,program_image,price,program_file,describtion, publish_time, status, count, pay,checkstatus from saas_marketing_program where programid=#{programId} ")
    MarketingProgram findMarketingProgram(int programId);

    @Select("select rfmclass from saas_program_class where programid=#{programId}")
    List<String> findClassById(int programId);


    @Select("select programid from saas_customerprogram where qiyeid=#{qiYeId}")
    int findProgramId(int qiYeId);

    @Update("update saas_qiye set password=#{newPassword} where username=#{username}")
    void updatePassword(Map<String,String> map);

    @Select("select count(*) from saas_customerprogram where qiyeid=#{qiYeId}")
    int countProgram(int qiYeId);

    @Select("select industryid from saas_program_industry where qiyeid=#{qiYeId}")
    int findIndustryId(int qiYeId);

    @Select("select programid,name,author,program_image,price,program_file,describtion, publish_time, status, count, pay,checkstatus from saas_marketing_program where author=#{qiYeId} limit #{start},#{size}")
    List<MarketingProgram> findUploadProgram(Map<Object,Object> map);

    @Select("select industryId,industryName,parentid from saas_industry where parentid=#{parentId}")
    List<Industry> findByParentId(int parenId);

    @Select("select count(*)  from saas_marketing_program where author=#{qiYeId}")
    int findCount(int qiYeId);

    @Select("select username,password from saas_qiye where qiYeId=#{qiYeId}")
    User findUser(int qiYeId);





}
