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
public class SolrTest {
    public static void main(String[] args) throws IOException, SolrServerException {
        //使用solrj操作索引库的步骤:
        //1.创建solr服务器对象
        String solrUrl="http://localhost:8000/solr/";
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(solrUrl + "new_core").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        //2.使用httpSolorClient的方法操作索引
        //创建solrinputDocument
        SolrInputDocument document=new SolrInputDocument();
        //document.addField("域名称","值");
        document.addField("xh",106);
        document.addField("name","小王发");
        document.addField("age",22);
        document.addField("sex","男");
        httpSolrClient.add(document); //添加

        httpSolrClient.commit();
        System.out.println("添加成功");

    }
}
