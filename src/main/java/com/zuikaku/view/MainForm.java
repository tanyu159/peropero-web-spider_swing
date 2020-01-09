package com.zuikaku.view;

import com.zuikaku.listener.MainFormClickEventListener;
import javafx.stage.Screen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * 主面板
 */
public class MainForm extends JFrame {

    /**
     * peropero官网连接label
     */
    private JLabel urlLabel;
    /**
     * peropero官网连接输入栏
     */
    private JTextField urlTextField;
    /**
     * 搜索关键字Label
     */
    private JLabel keyWordLabel;
    /**
     * 搜索关键字输入框
     */
    private JTextField keyWordTextField;
    /**
     * 搜索按钮，进行搜索，获得结果
     */
    private JButton searchBtn;
    /**
     * 搜索总记录数
     */
    private JLabel totalRecordCountLabel;
    /**
     * 搜索总页数
     */
    private JLabel totalPageCountLabel;
    /**
     * 当前页面数
     */
    private JLabel currentPageCountLabel;
    /**
     * 文件/目录选择器：选择本子生成的目录(按钮)
     */
    private JButton jFileChooserBtn;

    /**
     * 指定开始爬取的页数
     */
    private JLabel startPageCountLabel;
    /**
     * 指定开始爬取的页数的输入框
     */
    private JTextField startPageCountTextField;
    /**
     * 指定结束爬取的页数
     */
    private JLabel endPageCountLabel;
    /**
     * 指定结束爬取的页数的输入框
     */
    private JTextField endPageCountTextField;

    /**
     * 控制台输出信息
     */
    private JTextArea consoleInfoTextArea;

    /**
     * 清除控制台输出按钮
     */
    private JButton clearConsoleInputBtn;
    /**
     * 开始下载按钮
     */
    private JButton startDownloadBtn;

    /**
     * 提示信息Label
     */
    private JLabel tipMsgLabel;

    /**
     * 作者版本信息
     */
    private JLabel versionLabel;
    private MainFormClickEventListener clickEventListener;

    public MainForm(){
        initGUI();
        //初始化监听器
        clickEventListener=new MainFormClickEventListener();
        clickEventListener.setUrlTextField(urlTextField);
        clickEventListener.setKeywordTextField(keyWordTextField);
        clickEventListener.setTotalRecordCountLabel(totalRecordCountLabel);
        clickEventListener.setTotalPageCountLabel(totalPageCountLabel);
        clickEventListener.setCurrentPageCountLabel(currentPageCountLabel);
        clickEventListener.setStartPageCountTextField(startPageCountTextField);
        clickEventListener.setEndPageCountTextField(endPageCountTextField);
        clickEventListener.setConsoleTextArea(consoleInfoTextArea);
        clickEventListener.setMainForm(this);
        //事件绑定
        searchBtn.setActionCommand("search");
        searchBtn.addActionListener(clickEventListener);
        jFileChooserBtn.setActionCommand("selectFileDialog");
        jFileChooserBtn.addActionListener(clickEventListener);
        startDownloadBtn.setActionCommand("download");
        startDownloadBtn.addActionListener(clickEventListener);
        clearConsoleInputBtn.setActionCommand("clearConsole");
        clearConsoleInputBtn.addActionListener(clickEventListener);
    }

    /**
     * 初始化GUI组件，布局等
     */
    private void initGUI(){
        //使用空布局-一切自己来衡量
        setLayout(null);
        urlLabel=new JLabel("官网链接:");
        urlTextField=new JTextField("https://www.peropero.pw");
        keyWordLabel=new JLabel("搜索关键字:");
        keyWordTextField=new JTextField(20);
        searchBtn=new JButton("搜索");
        totalRecordCountLabel=new JLabel("总记录数:");
        totalPageCountLabel=new JLabel("总页数:");
        currentPageCountLabel=new JLabel("当前页:");
        jFileChooserBtn=new JButton("选择输出目录");//输出目录选择
        startPageCountLabel=new JLabel("爬取开始页数:");
        startPageCountTextField=new JTextField(5);
        endPageCountLabel=new JLabel("爬取结束页数:");
        endPageCountTextField=new JTextField(5);
        startDownloadBtn=new JButton("开始下载");
        consoleInfoTextArea=new JTextArea(25,9);//控制台输出
        clearConsoleInputBtn=new JButton("清空控制台");
        tipMsgLabel=new JLabel("开始下载后程序将会定住，当下载完成后可以在控制台查看下载结果!");
        versionLabel=new JLabel("Github:prprAbukuma Email:prprzuikaku@gmail.com Version:V2020-1-9");
//        点击按钮后会阻塞，无法动态的取得当前进度
//        currentBenZiDownloadProcessLabel=new JLabel("当前本子下载进度信息");
//        currentBenZiDownloadProcessBar=new JProgressBar();
//        totalBenZiDownloadProcessLabel=new JLabel("总进度信息");
//        totalBenZiDownloadProcessBar=new JProgressBar();
        add(urlLabel);
        add(urlTextField);
        add(keyWordLabel);
        add(keyWordTextField);
        add(searchBtn);
        add(totalRecordCountLabel);
        add(totalPageCountLabel);
        add(currentPageCountLabel);
        add(jFileChooserBtn);
        add(startPageCountLabel);
        add(startPageCountTextField);
        add(endPageCountLabel);
        add(endPageCountTextField);
        JScrollPane jScrollPane=new JScrollPane(consoleInfoTextArea);
        add(jScrollPane);
        add(clearConsoleInputBtn);
        add(startDownloadBtn);
        add(tipMsgLabel);
        add(versionLabel);
//        add(currentBenZiDownloadProcessLabel);
//        add(currentBenZiDownloadProcessBar);
//        add(totalBenZiDownloadProcessLabel);
//        add(totalBenZiDownloadProcessBar);
        urlLabel.setBounds(50,50,70,20);
        urlTextField.setBounds(130,50,150,20);
        keyWordLabel.setBounds(50,70,70,20);
        keyWordTextField.setBounds(130,70,150,20);
        searchBtn.setBounds(50,100,100,20);
        totalRecordCountLabel.setBounds(50,130,100,20);
        totalPageCountLabel.setBounds(150,130,100,20);
        currentPageCountLabel.setBounds(250,130,100,20);
        jFileChooserBtn.setBounds(50,160,130,20);
        startPageCountLabel.setBounds(50,190,100,20);
        startPageCountTextField.setBounds(150,190,70,20);
        endPageCountLabel.setBounds(250,190,100,20);
        endPageCountTextField.setBounds(350,190,70,20);
        consoleInfoTextArea.setEditable(false);//文本不可手动更改（只用于程序展示）
        jScrollPane.setBounds(450,50,300,150);
        clearConsoleInputBtn.setBounds(630,20,100,20);
        startDownloadBtn.setBounds(50,220,100,30);
//        currentBenZiDownloadProcessLabel.setBounds(50,260,150,20);
//        currentBenZiDownloadProcessBar.setBounds(50,280,200,20);
//        totalBenZiDownloadProcessLabel.setBounds(50,330,150,20);
//        totalBenZiDownloadProcessBar.setBounds(50,360,400,30);
        tipMsgLabel.setBounds(200,220,500,30);
        versionLabel.setBounds(50,5,500,30);
        //MainForm窗体设置
        int windowWidth = getWidth(); //获得窗口宽
        int windowHeight = getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        setBounds((screenWidth/2-windowWidth/2)-400, (screenHeight/2-windowHeight/2)-160,800,320);
        setVisible(true);
        setResizable(false);//不可拖动
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate();//验证组件，可以有
    }
}
