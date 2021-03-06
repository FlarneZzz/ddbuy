package com.kgc.util;


import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author 王建兵
 * @Classname SolrProduct
 * @Description TODO
 * @Date 2019/8/3 10:16
 * @Created by Administrator
 */
//新建商品实体
public class SolrProduct implements Serializable {
   @Field
   private Long pid;
   @Field
   private String title;
   @Field
   private Double price;
   @Field
   private String image;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
