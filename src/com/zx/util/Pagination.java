package com.zx.util;

import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * <p/>
 * Created by zhangxin on 2015-07-31.
 */
public class Pagination {

    public static final Integer DEFAULT_PAGE_NUM = 1;
    public static final String DEFAULT_PAGE_NUM_STR = "1";
    public static final Integer PAGE_SIZE_2 = 2;
    public static final Integer PAGE_SIZE_5 = 5;
    public static final Integer PAGE_SIZE_10 = 10;
    public static final Integer PAGE_SIZE_15 = 15;
    public static final Integer PAGE_SIZE_20 = 20;

    //当前页码
    private int pageNum;
    //每页记录数
    private int pageSize;
    //总页数
    private int totalPage;
    //总记录数
    private long totalCount;
    //是否有上一页
    private boolean hasPrePage;
    //是否有下一页
    private boolean hasNextPage;
    //结果集
    private List<?> result;

    public Pagination() {
        //初始化数据
        this.pageNum = DEFAULT_PAGE_NUM;
        this.pageSize = PAGE_SIZE_10;
    }

    public Pagination(Map<String, Object> paginationMap) {
        this.pageNum = (Integer) paginationMap.get("pageNum");//当前页码
        this.pageSize = (Integer) paginationMap.get("pageSize");//每页记录数
        this.totalCount = (Long) paginationMap.get("totalCount");//总记录数
        this.result = (List) paginationMap.get("result");//结果集
        this.totalPage = (int) Math.ceil((double) ((float) totalCount / pageSize));//总页数
        this.hasPrePage = pageNum > DEFAULT_PAGE_NUM;//是否有上一页
        this.hasNextPage = pageNum < totalPage;//是否有下一页
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = (pageNum <= 0 ? DEFAULT_PAGE_NUM : pageNum);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = (pageSize <= 0 ? PAGE_SIZE_10 : pageSize);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
