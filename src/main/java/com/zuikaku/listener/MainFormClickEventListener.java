package com.zuikaku.listener;

import com.zuikaku.CenterManager;
import com.zuikaku.pojo.BenZi;
import com.zuikaku.pojo.Picture;
import com.zuikaku.pojo.SearchResult;
import com.zuikaku.pojo.Title;
import com.zuikaku.rule.PictureRule;
import com.zuikaku.rule.TitleRule;
import com.zuikaku.utils.DownLoadBenZi;
import com.zuikaku.view.MainForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

/**
 * 主窗体按钮点击事件监听器
 */
public class MainFormClickEventListener implements ActionListener {
    /**
     * 主面板的官网链接输入框
     */
    private JTextField urlTextField;

    /**
     * 主面板的搜索关键字输入框
     */
    private JTextField keywordTextField;
    /**
     * 总记录数Label
     */
    private JLabel totalRecordCountLabel;
    /**
     * 总页数Label
     */
    private JLabel totalPageCountLabel;
    /**
     * 当前页数Label
     */
    private JLabel currentPageCountLabel;
    /**
     * 开始爬取页数
     */
    private JTextField startPageCountTextField;
    /**
     * 结束爬取页数
     */
    private JTextField endPageCountTextField;
    /**
     * 控制面板输出
     */
    private JTextArea consoleTextArea;

    /**
     * 当前本子下载信息label
     */
    private JLabel currentBenZiDownloadLabel;

    /**
     * 当前本子下载进度条
     */
    private JProgressBar currentBenZiDownloadProcessBar;

    private MainForm mainForm;

    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public JProgressBar getCurrentBenZiDownloadProcessBar() {
        return currentBenZiDownloadProcessBar;
    }

    public void setCurrentBenZiDownloadProcessBar(JProgressBar currentBenZiDownloadProcessBar) {
        this.currentBenZiDownloadProcessBar = currentBenZiDownloadProcessBar;
    }

    public JLabel getCurrentBenZiDownloadLabel() {
        return currentBenZiDownloadLabel;
    }

    public void setCurrentBenZiDownloadLabel(JLabel currentBenZiDownloadLabel) {
        this.currentBenZiDownloadLabel = currentBenZiDownloadLabel;
    }

    public JTextField getUrlTextField() {
        return urlTextField;
    }

    public void setUrlTextField(JTextField urlTextField) {
        this.urlTextField = urlTextField;
    }

    public JTextField getKeywordTextField() {
        return keywordTextField;
    }

    public void setKeywordTextField(JTextField keywordTextField) {
        this.keywordTextField = keywordTextField;
    }

    public JLabel getTotalRecordCountLabel() {
        return totalRecordCountLabel;
    }

    public void setTotalRecordCountLabel(JLabel totalRecordCountLabel) {
        this.totalRecordCountLabel = totalRecordCountLabel;
    }

    public JLabel getTotalPageCountLabel() {
        return totalPageCountLabel;
    }

    public void setTotalPageCountLabel(JLabel totalPageCountLabel) {
        this.totalPageCountLabel = totalPageCountLabel;
    }

    public JLabel getCurrentPageCountLabel() {
        return currentPageCountLabel;
    }

    public void setCurrentPageCountLabel(JLabel currentPageCountLabel) {
        this.currentPageCountLabel = currentPageCountLabel;
    }

    public JTextField getStartPageCountTextField() {
        return startPageCountTextField;
    }

    public void setStartPageCountTextField(JTextField startPageCountTextField) {
        this.startPageCountTextField = startPageCountTextField;
    }

    public JTextField getEndPageCountTextField() {
        return endPageCountTextField;
    }

    public void setEndPageCountTextField(JTextField endPageCountTextField) {
        this.endPageCountTextField = endPageCountTextField;
    }

    public JTextArea getConsoleTextArea() {
        return consoleTextArea;
    }

    public void setConsoleTextArea(JTextArea consoleTextArea) {
        this.consoleTextArea = consoleTextArea;
    }

    public void actionPerformed(ActionEvent e) {
        TitleRule titleRule = new TitleRule();
        SearchResult searchResult = null;
        switch (e.getActionCommand()) {
            case "search":
                //控制台信息显示
                consoleTextArea.append("准备工作√-正在获取数据,请稍后...\n");
                //进行第一次爬取
                titleRule.getContentList(urlTextField.getText() + "/?s=" + keywordTextField.getText());
                searchResult = CenterManager.getInstance().getSearchResult();
                searchResult.setKeyWord(keywordTextField.getText());
                //已经得到结果，在面板上显示
                totalRecordCountLabel.setText("总记录数:" + searchResult.getTotalRecordCount());
                totalPageCountLabel.setText("总页数:" + searchResult.getTotalPageCount());
                currentPageCountLabel.setText("当前页:" + searchResult.getCurrentPageCount());
                consoleTextArea.append("准备工作√-搜索结果获取完毕!\n");
                break;
            case "selectFileDialog":
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = jFileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(null, "设置成功");
                    consoleTextArea.append("准备工作√-输出文件夹设置完毕!\n");
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "设置输出文件夹是必要的一步，必须设置");
                    consoleTextArea.append("准备工作×-输出文件夹没有设置!\n");
                }
                File outPutDialog = jFileChooser.getSelectedFile();//获得输出文件夹
                System.out.println("选择的目录为:"+outPutDialog.getAbsolutePath());
                CenterManager.getInstance().setOutPutFile(outPutDialog);
                break;
            case "download":
                // 进行检查
                consoleTextArea.append("准备工作√-正在进行检查...\n");
                boolean isPass = checkArgs();
                if (isPass) {
                    //将开始页数和结束页数设置进去
                    CenterManager.getInstance().setStartPageCount(Integer.parseInt(startPageCountTextField.getText()));
                    CenterManager.getInstance().setEndPageCount(Integer.parseInt(endPageCountTextField.getText()));
                    consoleTextArea.append("准备工作√-检查通过!\n");
                    consoleTextArea.append("进行中⚪-开始下载!\n");
                    mainForm.validate();
                    PictureRule pictureRule = new PictureRule();
                    //TODO 进行下载
                    //页循环
                    for (int i = CenterManager.getInstance().getStartPageCount(); i <= CenterManager.getInstance().getEndPageCount(); i++) {
                        String url = urlTextField.getText() + "/page/" + i + "?s=" +CenterManager.getInstance().getSearchResult().getKeyWord();
                        //获得每页的10个本子标题封面
                        List<Title> titleList = titleRule.getContentList(url);
                        //对本页的10个本子进行访问获得里面的图片
                        for (Title title : titleList) {
                            String titleName = title.getTitleStr();
                            consoleTextArea.append("正在下载⚪-"+titleName+"\n");//控制台追加信息输出
                            String benZiUrl = title.getUrl();
                            List<Picture> pictureList=pictureRule.getContentList(benZiUrl);
                            BenZi benZi=new BenZi();
                            benZi.setTitle(titleName);
                            benZi.setPictureList(pictureList);
                            boolean isOk = DownLoadBenZi.download(benZi,CenterManager.getInstance().getOutPutFile().getAbsolutePath()+"\\");
                            if(isOk){
                                consoleTextArea.append("下载完成√-"+titleName);
                            }else{
                                consoleTextArea.append("下载失败×-"+titleName);
                            }
                        }
                    }
                    consoleTextArea.append("任务完成√-所有选定本子均已下载成功!");
                    JOptionPane.showMessageDialog(null,"所有选定本子均已下载成功!");
                } else {
                    consoleTextArea.append("准备工作×-检查未通过");
                    JOptionPane.showMessageDialog(null, "参数检查失败！无法开始");
                }


                break;
            case "clearConsole":
                consoleTextArea.setText("");//清空控制台信息
                break;
        }
    }

    /**
     * 检查参数
     *
     * @return
     */
    private boolean checkArgs() {
        if (CenterManager.getInstance().getOutPutFile() == null) {
            JOptionPane.showMessageDialog(null, "没有设置输出文件夹！无法开始");
            return false;
        }
        if (CenterManager.getInstance().getSearchResult() == null) {
            JOptionPane.showMessageDialog(null, "没有进行关键字搜索！无法开始");
            return false;
        }
        int startPageCount = -1;
        int endPageCount = -1;
        if (startPageCountTextField.getText() == null || startPageCountTextField.getText().equals("") || endPageCountTextField.getText() == null || endPageCountTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "开始页数或结束页数没有填写！无法开始");
            return false;
        } else {
            try {
                startPageCount = Integer.parseInt(startPageCountTextField.getText());
                endPageCount = Integer.parseInt(endPageCountTextField.getText());
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                JOptionPane.showMessageDialog(null, "页数应该为一个数字");
                return false;
            }
        }
        if (startPageCount <= 0) {
            JOptionPane.showMessageDialog(null, "开始页数至少为1");
            return false;
        }
        if (endPageCount > CenterManager.getInstance().getSearchResult().getTotalPageCount()) {
            JOptionPane.showMessageDialog(null, "结束页数不能大于最大页数");
            return false;
        }
        return true;
    }
}
