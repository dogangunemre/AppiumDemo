package com.emre.helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class HookImpl extends DriverImpl {
    public static AppiumDriver appiumDriver;

    public AppiumDriver createAppiumDriver(Boolean isAndroid) throws MalformedURLException {

        if (isAndroid){
            DesiredCapabilities capabilities = androidCapabilities();
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }
        else{
            DesiredCapabilities capabilities = iosCapabilities();
            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }
        return appiumDriver;
    }
}