package com.aurora.emby.common.dto;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.aurora.emby.common.dto.ApiCode.SUCCESS;


public class PageResponse<T> extends Response {

    private static final long serialVersionUID = 1L;

    private int totalCount = 0;

    private int pageSize = 1;

    private int pageIndex = 1;

    private Collection<T> data;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            return 1;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    public int getPageIndex() {
        if (pageIndex < 1) {
            return 1;
        }
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public List<T> getData() {
        return null == data ? Collections.emptyList() : new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return this.totalCount % this.pageSize == 0 ? this.totalCount
                / this.pageSize : (this.totalCount / this.pageSize) + 1;
    }



    public static PageResponse buildSuccess() {
        return (PageResponse) new PageResponse()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage());
    }

    public static PageResponse buildFailure(ApiCode apiCode) {
        return (PageResponse) new PageResponse()
                .setCode(apiCode.getCode())
                .setMessage(apiCode.getMessage());
    }

    public static <T> PageResponse<T> of(int pageSize, int pageIndex) {
        PageResponse<T> response = new PageResponse<>();
        response.setCode(SUCCESS.getCode());
        response.setMessage(SUCCESS.getMessage());
        response.setData(Collections.emptyList());
        response.setTotalCount(0);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }

    public static <T> PageResponse<T> of(Collection<T> data, int totalCount, int pageSize, int pageIndex) {
        PageResponse<T> response = new PageResponse<>();
        response.setData(data);
        response.setTotalCount(totalCount);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        response.setCode(SUCCESS.getCode());
        response.setMessage(SUCCESS.getMessage());
        return response;
    }

}

