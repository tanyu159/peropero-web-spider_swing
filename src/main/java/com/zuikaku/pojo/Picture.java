package com.zuikaku.pojo;

/**
 *  实体类图片，即要下载的本子，包含序号(文件名)以及URL
 */
public class Picture {
    @Override
    public String toString() {
        return "Picture{" +
                "pictureName='" + pictureName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}'+"\n";
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Picture() {
    }

    public Picture(String pictureName, String pictureUrl) {
        this.pictureName = pictureName;
        this.pictureUrl = pictureUrl;
    }

    private String pictureName;
    private String pictureUrl;
}
