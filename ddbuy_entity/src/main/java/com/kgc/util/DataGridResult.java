package com.kgc.util;

import java.util.List;

/**
 * @author 王建兵
 * @Classname DataGridResult
 * @Description TODO
 * @Date 2019/7/26 10:32
 * @Created by Administrator
 */
//定义业务返回结果
public class DataGridResult<T>  implements  java.io.Serializable{
   private Long total;  //总行数
   private List<T> rows;  //代表当前页的数据

    public DataGridResult() {
    }

    public DataGridResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
