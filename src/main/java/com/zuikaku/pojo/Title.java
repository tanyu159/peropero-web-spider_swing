package com.zuikaku.pojo;

/**
 * 实体类Title，本子的标题与链接
 */
public class Title {
    /**
     * 本子标题
     */
    private String titleStr;
    /**
     * 本子地址url
     */
    private String url;

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Title(String titleStr, String url) {
        this.titleStr = titleStr;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Title{" +
                "titleStr='" + titleStr + '\'' +
                ", url='" + url + '\'' +
                '}'+"\n";
    }

    public Title() {
    }
}
