package com.emre.step;

import com.emre.elements.ElementsParser;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;

import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class StepImpl extends ElementsParser {

    ElementsParser parser = new ElementsParser();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @And("startApplication")
    public void startApplication() throws MalformedURLException {
        appiumDriver = createAppiumDriver(true);
    }

    @And("Swipe down")
    public void swipeCoordinates(int startX, int startY, int endX, int endY, int count) throws InterruptedException {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        var tapPoint = new Point(580, 775);

        var tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(
                Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                tapPoint.x, tapPoint.y
        ));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(Arrays.asList(tap));

        logger.info("swipe down");
        waitBySecond(1);
    }

    @And("Wait {int} seconds")
    public void waitBySecond(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
        logger.info("{} seconds waited", seconds);
    }

    @And("{string} verify if element exists")
    public void isExistElement(String elementKey) throws FileNotFoundException, MalformedURLException {
        assertTrue(findElementBy(elementKey).isDisplayed());
        logger.info("{}  element is on the page", elementKey);
    }
    @And("clicked enter")
    public void clickedEnter() {
        appiumDriver.getKeyboard().pressKey(Keys.ENTER);
        logger.info("clickedEnter");
    }

    @And("Find element by {string} clear and send keys {string}")
    public void sendKeysByKey(String elementKey, String text) throws FileNotFoundException, MalformedURLException {
        MobileElement webElement = findElementBy(elementKey);
        webElement.clear();
        webElement.setValue(text);
        logger.info("{} text was written to the {}  text ", elementKey, text);
    }

    @And("Find element by {string} clear")
    public void clearByKey(String elementKey) throws FileNotFoundException, MalformedURLException {
        MobileElement webElement = findElementBy(elementKey);
        webElement.clear();
        logger.info("{} area cleared", elementKey);
    }


    @And("Find element by {string} and send keys {string}")
    public void sendKeysByKeyNotClear(String elementKey, String text) throws FileNotFoundException, MalformedURLException {
        findElementBy(elementKey).sendKeys(text);
        Assertions.assertEquals(findElementBy(elementKey).getAttribute("text"), text);
        logger.info("{} The value in the element and the {} value are the same ", elementKey, text);
    }

    @And("click {string}")
    public void iClick(String elementKey) throws FileNotFoundException, MalformedURLException {
        findElementBy(elementKey).click();
        logger.info("{} clicked ", elementKey);
    }


    @And("long press {string}")
    public void longPress(String elementKey) throws FileNotFoundException, MalformedURLException {
        iClick(elementKey);
        MobileElement longPress = (MobileElement) new WebDriverWait(appiumDriver, 30).until(elementToBeClickable(MobileBy.AccessibilityId("Long press me")));
        new Actions(appiumDriver).clickAndHold(longPress).perform();
        logger.info("{} element was pressed for a long time ", elementKey);
    }
}



