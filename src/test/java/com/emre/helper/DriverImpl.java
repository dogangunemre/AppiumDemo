package com.emre.helper;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class DriverImpl {
    String bundleId = "com.emre.test.enterprise";
    String App_Package = "com.akakce.akakce";
    String App_Activity = "com.akakce.akakce.ui.splash.SplashActivity";
    //String apkPath = new File("src/test/resources/apk/ApiDemos.apk").getAbsolutePath();
    DesiredCapabilities capabilities = new DesiredCapabilities();


    public DesiredCapabilities androidCapabilities() {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", App_Package);
        capabilities.setCapability("AppActivity", App_Activity);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        capabilities.setCapability("appium:udid", "R58M62S4CSM");
        // capabilities.setCapability("app", apkPath);

        return capabilities;
    }

    public DesiredCapabilities iosCapabilities() {
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("bundleId", bundleId);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.UDID, "a17767370e84fba960142a7d4d2e0e11c2b41299");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.5.7");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        capabilities.setCapability("sendKeyStrategy", "setValue");
        // capabilities.setCapability("app", apkPath);


        return capabilities;

    }
}
