package com.zuikaku.utils;

import com.zuikaku.pojo.BenZi;
import com.zuikaku.pojo.Picture;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载本子工具类
 */
public class DownLoadBenZi {
    /**
     * 对本子进行下载
     *
     * @param benZi
     * @param rootPath 需要以/结尾,且rootPath存在且具有权限
     */
    public static boolean download(BenZi benZi, String rootPath) {
        File catalog = new File(rootPath + benZi.getTitle());
        if (!catalog.exists()) {
            boolean isCreate = catalog.mkdir();
            if (!isCreate) {
                //文件夹都创建失败，直接退出
                return false;
            }
        }else {
            return false;//说明本子下重复了，有两个相同的，就不下了
        }

        for (Picture temp : benZi.getPictureList()) {
            InputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                URL url = new URL(temp.getPictureUrl());
                inputStream = url.openStream();
                fileOutputStream = new FileOutputStream(rootPath + benZi.getTitle() + "\\" + temp.getPictureName() + ".jpg");
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null)
                        fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (inputStream != null)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return true;

    }
}
