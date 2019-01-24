package com.westos.saasmarketing.marketingprogram.controller;

import com.westos.saasmarketing.marketingprogram.domain.Industry;
import com.westos.saasmarketing.marketingprogram.dto.UploadMarketingDTO;
import com.westos.saasmarketing.marketingprogram.vo.CustomerHistoryProgramVO;
import com.westos.saasmarketing.marketingprogram.vo.CustomerProgramVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class UserManageControllerTest {

    @Autowired
    private UserManageController userManageController;


    private MockMvc mockMvc;

    @Before
    public void setup(){
        // 初始化数据
        this.mockMvc= MockMvcBuilders.standaloneSetup(userManageController).build();
    }


    @Test
    public void index() throws Exception {
        String url = "/usermanage/uploadmarketing";

        UploadMarketingDTO uploadmarketingDTO=new UploadMarketingDTO();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        uploadmarketingDTO.setName("方案一");
        uploadmarketingDTO.setAuthor("chen");
        uploadmarketingDTO.setProgramImage("1.png");
        uploadmarketingDTO.setParentId(0);
        uploadmarketingDTO.setIndustryId(1);
        uploadmarketingDTO.setList(list);
        uploadmarketingDTO.setPrice(666.66);
        uploadmarketingDTO.setProgramFile("1.file");
        uploadmarketingDTO.setDescribtion("describtion");

        MvcResult result1=this.mockMvc.perform(post(url)
                .param("qiYeId","1")
                .param("name",uploadmarketingDTO.getName())
                .param("author",uploadmarketingDTO.getAuthor())
                .param("programImage",uploadmarketingDTO.getProgramImage())
                .param("parentId", String.valueOf(uploadmarketingDTO.getParentId()))
                .param("industryId", String.valueOf(uploadmarketingDTO.getIndustryId()))
                .param("price", String.valueOf(uploadmarketingDTO.getPrice()))
                .param("programFile",uploadmarketingDTO.getProgramFile())
                .param("describtion",uploadmarketingDTO.getDescribtion())
        ).andExpect(status().isOk()).andDo(print()).andReturn();

        ModelAndView mv = result1.getModelAndView();



        assertEquals("uploadSuccess",mv.getViewName());

    }

    @Test
    public void customer() throws Exception {
        String url = "/usermanage/customerhistory?qiYeId=1";

        MvcResult result = this.mockMvc.perform(post(url)).andExpect(status().isOk()).andDo(print()).andReturn();

        List<String> list = new ArrayList<>();
        list.add("1");

        CustomerProgramVO vo = new CustomerProgramVO("方案一",list,"chen",new Timestamp(118,8,9,0,0,0,0),"1.file");

        ModelAndView mv = result.getModelAndView();
        CustomerProgramVO vo1 = (CustomerProgramVO) mv.getModel().get("vo");
        assertEquals(vo.getAuthor(),vo1.getAuthor());
        assertEquals("history",mv.getViewName());

    }

    @Test
    public void history() throws Exception {
        String url = "/usermanage/uploadhistory?qiYeId=1";

        MvcResult result = this.mockMvc.perform(post(url)).andExpect(status().isOk()).andDo(print()).andReturn();

        List<String> list = new ArrayList<>();
        list.add("1");
        CustomerHistoryProgramVO vo = new CustomerHistoryProgramVO("方案一",list,666.66,"oncheck",new Timestamp(118,8,9,0,0,0,0),0);

        ModelAndView mv = result.getModelAndView();
        CustomerHistoryProgramVO vo1 = (CustomerHistoryProgramVO) mv.getModel().get("vo");

        System.out.println(vo1);

        assertEquals(vo.getProgramName(),vo1.getProgramName());
        assertEquals("uploadHistory",mv.getViewName());
    }

    @Test
    public void updatePassword() throws Exception {
        String url="/usermanage/updatepassword/a/kobeBryant";

        MvcResult result = this.mockMvc.perform(post(url)).andDo(print()).andReturn();

        ModelAndView mv = result.getModelAndView();

        assertEquals("updateSuccess",mv.getViewName());
    }

    @Test
    public void test1(){
        List<Industry> list = userManageController.findByParentId(1);
        for (Industry industry : list) {
            System.out.println(list.size());
            System.out.println(industry);
        }
    }
}