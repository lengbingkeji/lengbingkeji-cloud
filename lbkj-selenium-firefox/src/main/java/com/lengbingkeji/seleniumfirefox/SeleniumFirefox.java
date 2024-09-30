package com.lengbingkeji.seleniumfirefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * ClassName: SeleniumFirefox
 * Package: com.lengbingkeji.seleniumfirefox
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/3/18 15:32
 * @Version 1.0
 */
public class SeleniumFirefox {
    public static void main(String[] args) throws InterruptedException {
        //指定Firefox浏览器驱动的路径
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //System.setProperty("webdriver.firefox.marionette", "D:\\lengbing\\KaifaSoftware\\Firefox\\Geckodriver\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver", "D:\\lengbing\\KaifaSoftware\\Firefox\\Geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");


        //百度的首页地址
        String baiduHomePage = "https://www.baidu.com/";
        //baiduHomePage = "https://www.baidu.com/";

        //DesiredCapabilities.firefox();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setLegacy();

        //声明一个WebDriver
//        WebDriver driver = new FirefoxDriver();
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        //driver = new FirefoxDriver();
        //使浏览器窗口最大化
//        driver.manage().window().maximize();
        //打开百度
//        driver.get(baiduHomePage);

        //强制线程等待2秒中
        Thread.sleep(2000);

        //断言页面标题
//        assert driver.getTitle().equals("百度一下，你就知道");

        //在百度搜索输入框输入“Selenium”
//        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("Selenium");
        //点击搜索按钮
//        driver.findElement(By.xpath("//*[@id='su']")).clear();
        //强制线程等待2秒中
//        Thread.sleep(2000);
        //断言页面标题
//        assert driver.getTitle().equals("Selenium_百度搜索");

        //关闭浏览器窗口
//        driver.close();
        //结束driver
//        driver.quit();

    }
}
