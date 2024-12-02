package com.emre.elements;

import com.emre.helper.HookImpl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.MobileElement;
import com.google.gson.JsonArray;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;

public class ElementsParser extends HookImpl {

    public MobileElement findElementBy(String elementKey) throws FileNotFoundException, MalformedURLException {
        MobileElement element = null;
        String filePath = "src/test/java/com/emre/elements/elements.json";
        FileReader reader = new FileReader(filePath);

        JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

            String key = jsonObject.get("key").getAsString();
            if (key.equals(elementKey)) {

                String value = jsonObject.get("value").getAsString();
                String type = jsonObject.get("type").getAsString();

                switch (type) {
                    case "xpath":
                        return (MobileElement) appiumDriver.findElementByXPath(value);
                    case "id":
                        return (MobileElement) appiumDriver.findElementById(value);
                    case "className":
                        return (MobileElement) appiumDriver.findElementByClassName(value);
                    case "name":
                        return (MobileElement) appiumDriver.findElementByName(value);
                    case "accessibilityId":
                        return (MobileElement) appiumDriver.findElementByAccessibilityId(value);
                    case "cssSelector":
                        return (MobileElement) appiumDriver.findElementByCssSelector(value);
                    default:
                        System.out.println("Unsupported type: " + type);
                        break;
                }
            }
        }
        return element;
    }

    public List findElementsBy(String elementKey) throws FileNotFoundException, MalformedURLException {
        List element = null;
        String filePath = "src/test/resources/datas/elements.json";
        FileReader reader = new FileReader(filePath);

        JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

            String key = jsonObject.get("key").getAsString();
            if (key.equals(elementKey)) {

                String value = jsonObject.get("value").getAsString();
                String type = jsonObject.get("type").getAsString();

                switch (type) {
                    case "xpath":
                        return (List) appiumDriver.findElementByXPath(value);
                    case "id":
                        return (List) appiumDriver.findElementById(value);
                    case "className":
                        return (List) appiumDriver.findElementByClassName(value);
                    case "name":
                        return (List) appiumDriver.findElementByName(value);
                    case "accessibilityId":
                        return (List) appiumDriver.findElementByAccessibilityId(value);
                    case "cssSelector":
                        return (List) appiumDriver.findElementByCssSelector(value);
                    default:
                        System.out.println("Unsupported type: " + type);
                        break;
                }
            }
        }
        return element;
    }
}