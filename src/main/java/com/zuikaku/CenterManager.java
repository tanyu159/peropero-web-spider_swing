package com.zuikaku;

import com.zuikaku.pojo.SearchResult;

import java.io.File;

/**
 * 中央管理器,管理整个应用爬虫
 */
public class CenterManager {

    private static CenterManager instance;
    /**
     * 搜索结果pojo对象持有
     */
    private SearchResult searchResult;

    /**
     * 输出文件夹
     */
    private File outPutFile;

    /**
     * 开始下载页数
     */
    private int startPageCount;

    /**
     * 结束下载页数
     */
    private int endPageCount;

    public int getStartPageCount() {
        return startPageCount;
    }

    public void setStartPageCount(int startPageCount) {
        this.startPageCount = startPageCount;
    }

    public int getEndPageCount() {
        return endPageCount;
    }

    public void setEndPageCount(int endPageCount) {
        this.endPageCount = endPageCount;
    }

    public File getOutPutFile() {
        return outPutFile;
    }

    public void setOutPutFile(File outPutFile) {
        this.outPutFile = outPutFile;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    /**
     * 是否已经生成一次结果了
     */
    private boolean resulted=false;

    public boolean isResulted() {
        return resulted;
    }

    public void setResulted(boolean resulted) {
        this.resulted = resulted;
    }



    public static CenterManager getInstance() {
        if(instance==null)
        {
            instance=new CenterManager();
        }
        return instance;
    }
    private CenterManager(){}


}
