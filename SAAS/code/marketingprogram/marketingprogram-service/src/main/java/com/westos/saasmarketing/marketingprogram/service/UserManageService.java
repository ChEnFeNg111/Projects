package com.westos.saasmarketing.marketingprogram.service;


import com.westos.saasmarketing.marketingprogram.domain.*;
import com.westos.saasmarketing.marketingprogram.dto.UploadMarketingDTO;

import java.util.List;
import java.util.Map;

public interface UserManageService {

    int addProgram(UploadMarketingDTO uploadMarketingDTO);

    void addProgramIndustry(Map<Object,Object> map);

    void addProgramClass(Map<Object,Object> map);

    List<CustomerProgram> findAllCustomerProgram(Map<Object,Object> map);

    MarketingProgram findMarketingById(int programId);

    List<String> findClassById(int programId);

    int findProgramId(int qiYeId);

    void updatePassword(Map<String,String> map);

    int countProgram(int qiYeId);

    int findIndustryId(int qiYeId);

    List<MarketingProgram> findUploadProgram(Map<Object,Object> map);

    List<Industry> findByParentId(int parentId);

    int findCount(int qiYeId);

    User findUser(int qiYeId);
}
