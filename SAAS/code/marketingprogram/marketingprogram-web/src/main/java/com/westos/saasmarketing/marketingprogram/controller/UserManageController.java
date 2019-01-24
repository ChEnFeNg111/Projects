package com.westos.saasmarketing.marketingprogram.controller;

import com.westos.saasmarketing.marketingprogram.domain.*;
import com.westos.saasmarketing.marketingprogram.dto.UploadMarketingDTO;
import com.westos.saasmarketing.marketingprogram.service.UserManageService;

import com.westos.saasmarketing.marketingprogram.vo.CustomerHistoryProgramVO;
import com.westos.saasmarketing.marketingprogram.vo.CustomerProgramVO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * web层处理前端页面与后端交互的
 *
 * @author chen
 */
@Controller
@RequestMapping("/usermanage")
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    private static  Map<Object,Object> classMap =new HashMap<>();

    static{

        classMap.put("1","重要保持客户");
        classMap.put("2","重要价值客户");
        classMap.put("3","重要发展客户");
        classMap.put("4","重要挽留客户");
        classMap.put("5","一般维持客户");
        classMap.put("6","有价值推广客户");
        classMap.put("7","潜力客户");
        classMap.put("8","流失客户");
    }


    /**
     * 上传文案：
     * 根据表单提交的数据进行 营销方案的上传
     *
     * @param req
     * @return 上传成功的 uploadSuccess.jsp页面
     */
    @RequestMapping("/uploadmarketing")
    public String uploadindex(HttpServletRequest req,int qiYeId) {

        // 创建一个集合 存放 提交的表单数据
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        // 获取一个 将上传文件存入服务器磁盘 的一个工具类
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 获取 核心文件上传 工具类
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);


        try {

            String name = null;
            //String author = null;
            String programImage = null;
            //Integer parentId = 0;
            Integer industryId = 0;
            Double price = 0.0;
            String programFile = null;
            String describtion=null;


            //获取表单提交的 各部分数据  的一个集合
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);

            // 遍历集合
            for (FileItem item : fileItems) {

                //普通文本
                if(item.isFormField()){
                    String fieldName = item.getFieldName();
                    String value = item.getString("utf-8");
                    System.out.println(fieldName+"----"+value);
                    if(fieldName.equals("programClass")){
                        //多选
                        list.add(value);
                    }else {
                        hashMap.put(fieldName,value);
                    }

                }else{// 文件文本
                    if(item.getSize()>0){
                        item.write(new File("G:\\file\\"+item.getName()));
                    }
                    String fieldName = item.getFieldName();
                    String value = item.getName();
                    System.out.println(fieldName+"----"+value);
                    hashMap.put(fieldName,value);
                }
            }



            for (String s : hashMap.keySet()) {
                if(s.equals("name")){
                    name = hashMap.get(s);
                }

           /* if(s.equals("author")){
                author = hashMap.get(s);
            }*/

                if(s.equals("programImage")){
                    programImage = hashMap.get(s);
                }

           /* if(s.equals("parentId")){
                parentId = Integer.parseInt(hashMap.get(s));
            }*/

                if(s.equals("industryId")){
                    industryId = Integer.parseInt(hashMap.get(s));
                }

                if(s.equals("price")){
                    price = Double.valueOf(hashMap.get(s));
                }

                if(s.equals("programFile")){
                    programFile = hashMap.get(s);
                }

                if(s.equals("describtion")){
                    describtion = hashMap.get(s);
                }
            }


            // 创建一个 UploadMarketingDTO 对象，用于存放表单提交的数据
            UploadMarketingDTO uploadmarketingDTO = new UploadMarketingDTO();
            uploadmarketingDTO.setName(name);

            //放入qiYeId,充当外键
            uploadmarketingDTO.setAuthor(String.valueOf(qiYeId));

            uploadmarketingDTO.setProgramImage(programImage);
            uploadmarketingDTO.setPrice(price);
            uploadmarketingDTO.setProgramFile(programFile);
            uploadmarketingDTO.setDescribtion(describtion);
            uploadmarketingDTO.setPublishTime(new Timestamp(System.currentTimeMillis()));

            int programId = userManageService.addProgram(uploadmarketingDTO);

            //
            for (String s : list) {
                Map<Object,Object> map2 = new HashMap<>();
                map2.put("programId",programId);
                map2.put("rfmclass",s);
                userManageService.addProgramClass(map2);
            }


            //
            Map<Object,Object> map1 = new HashMap<>();
            map1.put("programId",programId);
            map1.put("industryId",industryId);

            userManageService.addProgramIndustry(map1);

            return "uploadSuccess";

        } catch (Exception e) {
            return "uploadfail";
        }


    }

    /**
     * 购买记录：
     * 根据 用户的企业id（qiYeId） 查出该用户在购买记录表中的所有购买记录，
     * 再根据购买记录中的 方案id（programid） 查出购买方案的详细信息
     * 最后封装成一个购买记录的页面显示对象（CustomerProgramVO） 展示到页面上
     *
     * @param qiYeId
     * @return
     */
    @RequestMapping("/customerhistory")
    @ResponseBody
    public ModelAndView customer(String page, int qiYeId) {

        ModelAndView mv = new ModelAndView();
        List<CustomerProgramVO> list = new ArrayList<>();
        Page p = new Page();


        int page1 = 1;
        if (page != null) {
            //获取当前页数
            page1 = Integer.parseInt(page);
        }
        p.setPage(page1);

        Map<Object,Object> map = new HashMap();
        map.put("qiYeId",qiYeId);
        map.put("start",p.getStart());
        map.put("size",p.getSize());


        //根据qiYeId查出购买过的方案id,进行分页查询
        List<CustomerProgram> allCustomerProgram = userManageService.findAllCustomerProgram(map);


        for (CustomerProgram customerProgram : allCustomerProgram) {

            //购买记录的页面显示对象
            CustomerProgramVO vo = new CustomerProgramVO();

            vo.setBuyingTime(customerProgram.getBuyingTime());

            //根据 方案id 查询  方案信息
            int programId = customerProgram.getProgramId();
            MarketingProgram marketingProgram = userManageService.findMarketingById(programId);

            vo.setProgramName(marketingProgram.getName());
            vo.setAuthor(marketingProgram.getAuthor());
            vo.setProgramFile(marketingProgram.getProgramFile());


            // 根据 方案id 查询 方案分类
            List<String> className = userManageService.findClassById(programId);
            List<String> rfmclass = new ArrayList<>();
            for (String s : className) {
                String  o = (String) classMap.get(s);
                rfmclass.add(o);
            }

            vo.setList(rfmclass);


            list.add(vo);
        }

        //此用户的购买记录总数
        int count = userManageService.countProgram(qiYeId);


        p.setList(list);
        p.setCount(count);

        mv.addObject("p", p);

        //要跳转的 购买记录 userindex.jsp 页面
        mv.setViewName("userindex");

        return mv;
    }


    /**
     * 上传记录：
     * 根据 企业id 找到对应的 营销方案id
     * 再根据 营销方案id 找出所有的上传过的营销方案信息
     * 最后返回一个上传记录的页面显示对象（CustomerHistoryProgramVO）
     *
     * @param qiYeId
     * @return
     */
    @RequestMapping("/uploadhistory")
    @ResponseBody
    public ModelAndView uploadHistory(String page, int qiYeId) {
        ModelAndView mv = new ModelAndView();
        Page p = new Page();

        int page1 = 1;
        if (page != null) {
            //获取当前页数
            page1 = Integer.parseInt(page);
        }
        p.setPage(page1);

        Map<Object,Object> map = new HashMap();
        map.put("qiYeId",qiYeId);
        map.put("start",p.getStart());
        map.put("size",p.getSize());

        //根据 营销方案表的 author对应 qiyeid 查找出上传过的营销方案
        List<MarketingProgram> marketingPrograms = userManageService.findUploadProgram(map);

        List<CustomerHistoryProgramVO> list = new ArrayList<>();

        for (MarketingProgram marketingProgram : marketingPrograms) {

            CustomerHistoryProgramVO vo = new CustomerHistoryProgramVO();

            // 根据  方案id 查询 方案分类
            List<String> className = userManageService.findClassById(marketingProgram.getProgramId());
            List<String> rfmclass = new ArrayList<>();
            for (String s : className) {
                String  o = (String) classMap.get(s);
                rfmclass.add(o);
            }
            vo.setList(rfmclass);

            vo.setProgramName(marketingProgram.getName());
            vo.setPrice(marketingProgram.getPrice());
            vo.setCheckStatus(marketingProgram.getCheckStatus());
            vo.setPublishTime(marketingProgram.getPublishTime());
            vo.setCount(marketingProgram.getCount());

            list.add(vo);
        }

        int count = userManageService.findCount(qiYeId);
        System.out.println(count);

        p.setCount(count);
        p.setList(list);


        mv.addObject("p", p);
        mv.setViewName("upload");

        return mv;
    }

    /**
     * 修改密码：
     * 根据 用户名 和 新密码 对数据库中的企业用户表进行修改密码的操作
     *
     *
     * @param newPassword
     * @return
     */
    @RequestMapping("/updatepassword")
    public String updatePassword(int qiYeId,String newPassword) {



        if(newPassword.equals("")){
            return "updatefail";
        }

        System.out.println(qiYeId+""+newPassword);

        User user = userManageService.findUser(qiYeId);

        if(user == null){
            return "updatefail";
        }

        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("newPassword", newPassword);

        //根据 用户名 修改 密码
        userManageService.updatePassword(map);

        return "updateSuccess";
    }


    /**
     * 下载附件
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/downloadfile/*")
    public void downloadFile(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // 1) 如果要把文件进行下载操作
        resp.setContentType("application/octet-stream");
        resp.addHeader("content-disposition","attachment;filename=1.txt");



        // 把【浏览器的路径】 转换为 【服务器的磁盘路径】
        // 获取浏览器实际输入路径
        String uri = req.getRequestURI();

        String[] strings = uri.split("/");
        for (int i = 0; i < strings.length; i++) {
            if(i == strings.length-1){
                uri = strings[i];
            }
        }



        // 从本地磁盘路径上下载图片
        String path = "G:\\file\\" + uri;

        System.out.println(path);



        if( !new File(path).exists() ) {
                // 如果文件不存在，返回404
               resp.sendError(404);

                throw new FileNotFoundException("文件不存在");
        }

        // 如果存在，从文件输入流读取，向响应的输出流写
        FileInputStream is = new FileInputStream(path);
        OutputStream os = resp.getOutputStream();
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);



    }


    @RequestMapping("/findByParentId")
    @ResponseBody
    public List<Industry> findByParentId(int parentId){
        List<Industry> list = userManageService.findByParentId(parentId);
        return list;
    }
}
