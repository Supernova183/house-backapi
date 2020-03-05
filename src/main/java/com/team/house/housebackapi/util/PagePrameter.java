package com.team.house.housebackapi.util;

public class PagePrameter {
   private Integer page=1;
   private Integer pageSize=2;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
