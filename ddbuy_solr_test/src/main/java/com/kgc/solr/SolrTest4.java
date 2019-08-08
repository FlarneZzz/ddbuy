package com.kgc.solr;

import com.kgc.solr.entity.Student;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname SolrTest
 * @Description TODO
 * @Date 2019/8/3 8:23
 * @Created by Administrator
 */
public class SolrTest4 {
    //以java对象的方式添加索引
    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solrj操作索引库的步骤:
        //1.创建solr服务器对象
        String solrUrl="http://localhost:8000/solr/";
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        //2.使用httpSolorClient的方法操作索引
        //创建学生对象
        Student student=new Student(107,"小张",21,"男");

        httpSolrClient.addBean(student);
        httpSolrClient.commit();
        System.out.println("添加成功");

    }
}
