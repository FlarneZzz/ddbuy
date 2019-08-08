package com.kgc.solr;

import com.kgc.solr.entity.Student;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author 王建兵
 * @Classname SolrTest
 * @Description TODO
 * @Date 2019/8/3 8:23
 * @Created by Administrator
 */
public class SolrTest6 {
    //实现查询功能
    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solrj操作索引库的步骤:
        //1.创建solr服务器对象
        String solrUrl="http://localhost:8000/solr/";
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        //2.执行查询
        //2.1.创建查询条件条件
        SolrQuery  query=new SolrQuery();
        query.set("q","name:*");  //设置查询条件
        query.setSort("age",SolrQuery.ORDER.desc); //设置排序

        //设置
        query.setStart((2-1)*3);  //设置起始位置  （页码-1）*页大小
        query.setRows(3); //设置每页大小

        //2.2.执行查询
        QueryResponse queryResponse=httpSolrClient.query(query);
        //2.3获取查询结果
        List<Student> list=queryResponse.getBeans(Student.class);
        for (Student s:list) {
            System.out.println("学号:"+s.getXh()+"姓名:"+s.getName()+"年龄:"+s.getAge()+"性别:"+s.getSex());
        }


        /*SolrDocumentList list=queryResponse.getResults();
        Iterator<SolrDocument> iterator=list.iterator();
        while(iterator.hasNext()){
            SolrDocument document=iterator.next();
            System.out.println(document.get("name"));
        }*/
    }
}
