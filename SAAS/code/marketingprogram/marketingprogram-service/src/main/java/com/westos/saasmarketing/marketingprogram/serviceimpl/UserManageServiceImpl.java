package com.westos.saasmarketing.marketingprogram.serviceimpl;

import com.westos.saasmarketing.marketingprogram.domain.Industry;
import com.westos.saasmarketing.marketingprogram.domain.User;
import com.westos.saasmarketing.marketingprogram.dao.UserManageMapper;
import com.westos.saasmarketing.marketingprogram.domain.CustomerProgram;
import com.westos.saasmarketing.marketingprogram.domain.MarketingProgram;
import com.westos.saasmarketing.marketingprogram.dto.UploadMarketingDTO;
import com.westos.saasmarketing.marketingprogram.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * service层负责 业务逻辑处理
 * @author chen
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserManageMapper userManageMapper;


    public int addProgram(UploadMarketingDTO uploadMarketingDTO) {

        MarketingProgram marketingProgram=new MarketingProgram();

        marketingProgram.setName(uploadMarketingDTO.getName());
        marketingProgram.setAuthor(uploadMarketingDTO.getAuthor());
        marketingProgram.setProgramImage(uploadMarketingDTO.getProgramImage());
        marketingProgram.setPrice(uploadMarketingDTO.getPrice());
        marketingProgram.setProgramFile(uploadMarketingDTO.getProgramFile());
        marketingProgram.setDescribtion(uploadMarketingDTO.getDescribtion());
        marketingProgram.setPublishTime(uploadMarketingDTO.getPublishTime());


        userManageMapper.addProgram(marketingProgram);

        return marketingProgram.getProgramId();
    }

    public void addProgramIndustry(Map<Object,Object> map) {
        userManageMapper.addProgramIndustry(map);
    }

    public void addProgramClass(Map<Object, Object> map) {
        userManageMapper.addProgramClass(map);
    }

    public List<CustomerProgram> findAllCustomerProgram(Map<Object,Object> map) {
        return userManageMapper.findAllCustomerProgram(map);
    }

    public MarketingProgram findMarketingById(int programId) {
        return userManageMapper.findMarketingProgram(programId);
    }

    public List<String> findClassById(int programId) {
        return userManageMapper.findClassById(programId);
    }

    public int findProgramId(int qiYeId) {
        return userManageMapper.findProgramId(qiYeId);
    }

    public void updatePassword(Map<String,String> map) {
        userManageMapper.updatePassword(map);
    }

    public int countProgram(int qiYeId){
        return userManageMapper.countProgram(qiYeId);
    }

    public int findIndustryId(int qiYeId) {
        return userManageMapper.findIndustryId(qiYeId);
    }

    public List<MarketingProgram> findUploadProgram(Map<Object,Object> map) {
        return userManageMapper.findUploadProgram(map);
    }

    public List<Industry> findByParentId(int parentId) {
        return userManageMapper.findByParentId(parentId);
    }

    public int findCount(int qiYeId) {
        return userManageMapper.findCount(qiYeId);
    }

    public User findUser(int qiYeId) {
        return userManageMapper.findUser(qiYeId);
    }

}
