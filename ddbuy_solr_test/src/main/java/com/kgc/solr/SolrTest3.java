package com.kgc.solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * @author 王建兵
 * @Classname SolrTest
 * @Description TODO
 * @Date 2019/8/3 8:23
 * @Created by Administrator
 */
public class SolrTest3 {
    //修改索引
    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solrj操作索引库的步骤:
        //1.创建solr服务器对象
        String solrUrl="http://localhost:8000/solr/";
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        //2.修改索引  实现思路:先删除索引、添加索引
         //先删除索引
         httpSolrClient.deleteByQuery("xh:103");
         //创建新的过引
        SolrInputDocument document=new SolrInputDocument();
        //document.addField("域名称","值");
        document.addField("xh",103);
        document.addField("name","渊总2");
        document.addField("age",21);
        document.addField("sex","男");
        httpSolrClient.add(document); //添加

        //3.提交
        httpSolrClient.commit();
        System.out.println("修改成功");

    }
}
