package com.kgc.util;

import java.io.Serializable;

public class Page implements Serializable {
    private Integer page=1; //页码
    private Integer rows=3;//页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Page(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public Page() {
    }
}
