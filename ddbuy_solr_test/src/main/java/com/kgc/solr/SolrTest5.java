package com.kgc.solr;

import com.kgc.solr.entity.Student;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王建兵
 * @Classname SolrTest
 * @Description TODO
 * @Date 2019/8/3 8:23
 * @Created by Administrator
 */
public class SolrTest5 {
    //以java对象的方式添加索引==批量添加
    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solrj操作索引库的步骤:
        //1.创建solr服务器对象
        String solrUrl="http://localhost:8000/solr/";
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        //2.使用httpSolorClient的方法操作索引
        //创建学生对象
        List<Student> list=new ArrayList<Student>();
        list.add(new Student(201,"杨过",21,"男"));
        list.add(new Student(202,"小龙女",21,"女"));
        list.add(new Student(203,"雕兄",22,"鸟类"));

        httpSolrClient.addBeans(list);  //批量添加
        httpSolrClient.commit();
        System.out.println("添加成功");

    }
}
