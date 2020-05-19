package com.zuikaku.rule;

import com.zuikaku.CenterManager;
import com.zuikaku.pojo.SearchResult;
import com.zuikaku.pojo.Title;
import com.zuikaku.utils.WebSpider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析每页的本子标题以及当前页面信息
 */
public class TitleRule extends BaseRule {
    public List<Title> getContentList(String url) {

        String htmlStr = WebSpider.getH5Code(url);
        Document document = Jsoup.parse(htmlStr);
        // 找到本页结果信息(当前页数，总页数，总记录数)【只用进行一次】
        if (!CenterManager.getInstance().isResulted()) {
            String totalRecordStr = document.getElementsByClass("fl_list").get(0).getElementsByTag("span").get(0).text();
            int totalRecordCount = Integer.parseInt(totalRecordStr.replaceAll("\\D", ""));
            int currentPageCount = 1;//默认为1页，如果解析没问题说明有大于1页，在被重新赋值
            int totalPageCount = 1;//默认为1页，如果解析没问题说明有大于1页，在被重新赋值
            try {
                String currentPageCountStr = document.getElementsByClass("current").get(0).text();
                currentPageCount = Integer.parseInt(currentPageCountStr.replaceAll("\\D", ""));
                String totalPageCountStr = document.getElementsByClass("page-numbers").get(document.getElementsByClass("page-numbers").size() - 2).text();
                totalPageCount = Integer.parseInt(totalPageCountStr.replaceAll("\\D", ""));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("记录较少，只满1页");
            }

            SearchResult searchResult = new SearchResult();
            searchResult.setCurrentPageCount(currentPageCount);
            searchResult.setTotalPageCount(totalPageCount);
            searchResult.setTotalRecordCount(totalRecordCount);
            CenterManager.getInstance().setSearchResult(searchResult);
            CenterManager.getInstance().setResulted(true);
        }

        //找到本页的标题信息列表
        Element divElement = document.getElementsByClass("update_area").get(0);
        Elements aLabels = divElement.getElementsByTag("a");//获得所有本子的超链接标题
        List<Title> titleList = new ArrayList<Title>();
        //只有前10是
        for (int i = 0; i <= 9; i++) {
            Element aLabel = aLabels.get(i);
            String href = aLabel.attr("href");
            String titleStr = aLabel.attr("title");
            Title title = new Title();
            title.setTitleStr(titleStr);
            title.setUrl(href);
            titleList.add(title);
        }

        return titleList;
    }
}
