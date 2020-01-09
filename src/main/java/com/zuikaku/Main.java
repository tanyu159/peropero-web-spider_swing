package com.zuikaku;

import com.zuikaku.view.MainForm;

import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
//        //TEST单元测试代码
//        String keyWord="艦隊";
//        //String h5Code = WebSpider.getH5Code("https://peropero.pw/page/1?s="+keyWord);
////        System.out.println(h5Code);
//        TitleRule titleRule=new TitleRule();
//        List<Title> titleList = titleRule.getContentList("https://peropero.pw/page/1?s="+keyWord);
////        System.out.println(titleList);
//        PictureRule pictureRule=new PictureRule();
//        List<Picture> pictureList=pictureRule.getContentList(titleList.get(0).getUrl());
//        //构造一个Benzi对象测试下载
//        BenZi benZi=new BenZi();
//        benZi.setTitle(titleList.get(0).getTitleStr());
//        benZi.setPictureList(pictureList);
//        boolean isOk = DownLoadBenZi.download(benZi,"E:/BenZiOutPut/");
//        System.out.println(isOk);

        int n= JOptionPane.showConfirmDialog(null,"你正在使用爬虫工具对https://www.peropero.pw的本子进行爬取,请确保能够正常访问该网站","peropero本子爬取工具",JOptionPane.OK_CANCEL_OPTION);
        if(n==JOptionPane.YES_OPTION)
        {
            //打开主面板
            new MainForm();

        }
    }

}
