package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.mapper.TbItemMapper;
import com.kgc.service.SolrService;
import com.kgc.util.SolrProduct;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = SolrService.class)
@Component
public class SolrServiceImpl implements SolrService {
    @Value("${solr.pagesize}")
    private Integer pageSize;
    @Autowired(required = false)
    private TbItemMapper tbItemMapper;
    @Autowired
    private SolrClient solrClient;
    @Override
    public boolean importIndex() {
        List<SolrProduct> allSolrProduct = tbItemMapper.getAllSolrProduct();
        try {
            solrClient.addBeans(allSolrProduct);
            solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Object> searchProduct(String condition, Integer page) {
        Map<String, Object> map=null;
        SolrQuery query = new SolrQuery();//封装查询条件
        if(condition==null||condition.equals("")){
            query.set("q","title:*");
        }else{
            query.set("q","title:"+condition);
        }
        //分页
        query.setStart((page-1)*pageSize);
        query.setRows(pageSize);
        //排序 asc 降序 desc升序
        query.setSort("price",SolrQuery.ORDER.asc);
        try {
            QueryResponse reponse = solrClient.query(query);
            //获取当前页的数据
            List<SolrProduct> list = reponse.getBeans(SolrProduct.class);
            //获取总行数(总记录数)
            long totalRecords = reponse.getResults().getNumFound();
            int totalPage =(int) Math.ceil(totalRecords * 1.0 / pageSize);
              map=new HashMap<>();
              map.put("rows",list);
              map.put("totalPage",totalPage);
        } catch (Exception e) {
               e.printStackTrace();
        }
        return map;
    }
}
