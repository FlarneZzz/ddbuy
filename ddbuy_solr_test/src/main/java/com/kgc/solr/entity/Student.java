package com.kgc.solr.entity;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author 王建兵
 * @Classname Student
 * @Description TODO
 * @Date 2019/8/3 8:48
 * @Created by Administrator
 */
//学生类
public class Student  {
   //使用Field注解定义一个solr域对应一个属性
   //写value:指定域名与属性对应，不写value，则域名与属性名相同
    @Field(value = "xh")
    private Integer xh;
    @Field
    private String name;
    @Field
    private Integer age;
    @Field
    private String sex;

    public Student() {
    }

    public Student(Integer xh, String name, Integer age, String sex) {
        this.xh = xh;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
