package com.westos.saasmarketing.marketingprogram.domain;

import java.util.List;

public class Page<T> {

    private int page = 1;   //当前页,默认页数为1
    private int size = 5;  //   查询记录为10
    private int count = 0;  //   数据库中的记录总数
    private List<T> list;   //   存放查询到的数据
    private int num = 10;   //   默认显示的固定页数
    private int start;   // 起始位置



    public Page() {
    }

    public Page(String p){
        if(p!=null){
            this.page = Integer.parseInt(p);
        }
    }

    // limit 的 起始位置
    public int getStart(){
       start= (page-1)*size;
       return start;
    }

    // limit 的查询的大小
    public  int getSize(){
        return size;
    }

    // 得到总记录数
    public int getTotal(){

        return (count-1)/size +1;

        /*if( (count % size) ==0){
            return count/size;
        }else {
            return (count/size) +1;
        }*/
    }

    //首页
    public int getFirst(){
        return 1;
    }

    //尾页
    public int getLast(){
        return getTotal();
    }

    //上一页
    public int getPre(){
        if(page>1){
            return page-1;
        }else{
            return 1;
        }
    }

    //下一页
    public int getNext(){
        if(page< getTotal()){
            return page+1;
        }else{
            return getTotal();
        }
    }

    // 是否有上一页
    public boolean hasPre(){

        return page>1;

    }

    // 是否有下一页
    public boolean hasNext(){

        return page<getTotal();

    }

    // 是否是当前页面
    public boolean isCurrent(int i){
        return page == i ;
    }


    public  int getOne(){
        int startNum = 0;



        int right = num/2-1;   // 当前页面右边 固定 4 页
        int left  = num/2; // 当前页面左边 固定 5 页

        if(getTotal() < num ){
            startNum = 1;
        }else{
            if(page < (num/2)+1){ // <6
                startNum = 1;
            }else{
                if((page+right)<= getTotal()){
                    startNum = page-left;
                }else{
                    startNum =getTotal()-num +1;
                }
            }
        }

        return startNum;
    }

    public int getEnd() {
        int endNum = 0;


        int right = num/2-1;   // 当前页面右边 固定 4 页
        int left  = num/2; // 当前页面左边 固定 5 页


        if(getTotal() < num ){
            endNum   = getTotal();
        }else{
            if(page < (num/2)+1){ // <6
                endNum   = num;
            }else{
                if((page+right) <= getTotal()){
                    endNum   = page + right;
                }else{
                    endNum = getTotal();
                }
            }
        }

        return endNum;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
