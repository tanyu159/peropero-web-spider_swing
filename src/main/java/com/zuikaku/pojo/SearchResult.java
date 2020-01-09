package com.zuikaku.pojo;

/**
 * 搜索结果实体类
 */
public class SearchResult {
    /**
     * 总共记录数(本子数量)
     */
    private int totalRecordCount;
    /**
     * 当前页数
     */
    private int currentPageCount;
    /**
     * 总页数
     */
    private int totalPageCount;
    /**
     * 搜索关键字
     */
    private String keyWord;

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public int getCurrentPageCount() {
        return currentPageCount;
    }

    public void setCurrentPageCount(int currentPageCount) {
        this.currentPageCount = currentPageCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public SearchResult(int totalRecordCount, int currentPageCount, int totalPageCount, String keyWord) {
        this.totalRecordCount = totalRecordCount;
        this.currentPageCount = currentPageCount;
        this.totalPageCount = totalPageCount;
        this.keyWord = keyWord;
    }

    public SearchResult() {
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "totalRecordCount=" + totalRecordCount +
                ", currentPageCount=" + currentPageCount +
                ", totalPageCount=" + totalPageCount +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }
}
