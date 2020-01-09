package com.zuikaku.rule;

import com.zuikaku.pojo.Picture;
import com.zuikaku.utils.WebSpider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片爬取规则
 */
public class PictureRule extends BaseRule {
    public List<Picture> getContentList(String url) {
        String htmlStr = WebSpider.getH5Code(url);
        //获得该页面的图片标签
        Document document = Jsoup.parse(htmlStr);
        Element pLabel = document.getElementsByClass("content").get(0).getElementsByTag("p").get(0);//获得装图片的p标签
        Elements imgLabels=pLabel.getElementsByTag("img");
        List<Picture> pictureList =new ArrayList<Picture>();
        for(int i=0;i<=imgLabels.size()-1;i++)
        {
            String pictureName=String.valueOf(i+1);
            String pictureUrl = imgLabels.get(i).attr("src");
            Picture picture=new Picture();
            picture.setPictureName(pictureName);
            picture.setPictureUrl(pictureUrl);
            pictureList.add(picture);
        }

        return pictureList;
    }
}
