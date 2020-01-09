package com.zuikaku.pojo;

import java.util.List;

/**
 * 本子实体类-下载本子时直接调用该对象
 */
public class BenZi {
    /**
     * 本子的标题
     */
    private String title;

    /**
     * 图片列表
     */
    private List<Picture> pictureList;

    @Override
    public String toString() {
        return "BenZi{" +
                "title='" + title + '\'' +
                ", pictureList=" + pictureList +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public BenZi(String title, List<Picture> pictureList) {
        this.title = title;
        this.pictureList = pictureList;
    }

    public BenZi() {
    }
}
