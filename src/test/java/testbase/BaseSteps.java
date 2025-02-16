package testbase;


import com.thoughtworks.gauge.Step;
import elements.Elements;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class BaseSteps extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(BaseSteps.class);
    HashMap<String, String> keyMap = new HashMap<String, String>();

    WebElement findElement(String locatorName) {
        By locator = Elements.getLocator(locatorName);
        return driver.findElement(locator);
    }

    List<WebElement> findElements(String locatorName) {
        By locator = Elements.getLocator(locatorName);
        return driver.findElements(locator);
    }

    private void hoverOnElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    @Step("Wait <second> Seconds")
    public void wait(int second) throws InterruptedException {
        Thread.sleep(1000 * second);
        BaseTest.getLog().pass("Waited " + second + " Seconds. ");
        logger.info("Waited " + second + " Seconds. ");
    }

    @Step("Go To <url> Address")
    public void goToUrl(String url) {
        driver.get(url);
        BaseTest.getLog().pass("Navigated to " + url + " Address");
        logger.info("Navigated to " + url + " Address");
    }

    @Step("Check If The URL Address Contains The Value <expectedUrl>")
    public void checkUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl != null && actualUrl.contains(expectedUrl)) {
            BaseTest.getLog().pass("Current url address contains the expected " + expectedUrl + " value.");
            logger.info("Current url address contains the expected " + expectedUrl + " value.");

        } else {
            BaseTest.getLog().fail("Current url address contains the expected " + expectedUrl + " value.");
            Assertions.fail("Current url address contains the expected " + expectedUrl + " value.");

        }
    }

    @Step("Check If Element <locatorName> Exist")
    public void checkElement(String locatorName) {
        if (findElements(locatorName).size() > 0) {
            BaseTest.getLog().pass(locatorName + " Element Exists on the Page");
            logger.info(locatorName + " Element Exists on the Page");
        } else {
            BaseTest.getLog().fail(locatorName + " Element Not Exists on the Page");
            Assertions.fail(locatorName + " Element Not Exists on the Page");
        }
    }

    @Step("Click The <locatorName> Element")
    public void clickElement(String locatorName) {
        WebElement element = findElement(locatorName);
        if (element != null) {
            element.click();
            BaseTest.getLog().pass("Clicked To The " + locatorName + " Element");
            logger.info("Clicked To The " + locatorName + " Element");
        } else {
            BaseTest.getLog().fail("The " + locatorName + " Element Doesn't Appeared On The Page");
            Assertions.fail("The " + locatorName + " Element Doesn't Appeared On The Page");
        }
    }

    @Step("Click If Element <locatorName> Exist")
    public void clickIfExist(String locatorName) {
        WebElement element = findElement(locatorName);
        if (element != null) {
            element.click();
            BaseTest.getLog().pass("Clicked To The " + locatorName + " Element");
            logger.info("Clicked To The " + locatorName + " Element");
        } else {
            BaseTest.getLog().fail("The " + locatorName + " Element Doesn't Appeared On The Page");
            Assertions.fail("The " + locatorName + " Element Doesn't Appeared On The Page");
        }
    }

    @Step("Check If <locatorName> Element's Attribute <attribute> Contains The Value <expectedValue>")
    public void checkElementAttributeContains(String locatorName, String attribute, String expectedValue) {

        String actualValue = findElement(locatorName).getAttribute(attribute).trim();
        if (actualValue.contains(expectedValue)) {
            BaseTest.getLog().pass("The " + attribute + " attribute in the " + locatorName + " element contains the expected " + expectedValue + " value.");
            logger.info("The " + attribute + " attribute in the " + locatorName + " element contains the expected " + expectedValue + " value.");
        } else {
            BaseTest.getLog().fail("The " + attribute + " attribute in the " + locatorName + " element doesn't contains the expected " + expectedValue + " value.");
            Assertions.fail("The " + attribute + " attribute in the " + locatorName + " element doesn't contains the expected " + expectedValue + " value.");
        }
    }

    @Step("Check If Element <locatorName> Contains Text <expectedText>")
    public void checkElementContainsText(String locatorName, String expectedText) {
        Boolean containsText = findElement(locatorName).getText().contains(expectedText);
        Assertions.assertTrue(containsText, "Expected text is not contained");
        BaseTest.getLog().pass(locatorName + " Element Contains The " + expectedText + " Value");
    }

    @Step("Send <text> Value To Element <locatorName>")
    public void sendKeys(String text, String locatorName) {
        findElement(locatorName).clear();
        findElement(locatorName).sendKeys(text);
        BaseTest.getLog().pass(text + " Value Writed To The " + locatorName + " Element.");
        logger.info(text + " Value Writed To The " + locatorName + " Element.");
    }

    @Step("Save The <value> To Hashmap As <valueVal>")
    public void getTxtFromApi(String value, String valueVal) throws IOException, InterruptedException {

        keyMap.put(valueVal, value);
        BaseTest.getLog().pass(" The " + value + " Saved To HashMap as " + valueVal);
        logger.info("The " + value + " Saved To HashMap as " + valueVal);

    }

    @Step("Check If Element <locatorName> Contains Text <valueVal> in HashMap")
    public void checkTxtFromHash(String locatorName, String valueVal) {
        String hashTxt = keyMap.get(valueVal).toString();
        Boolean containsText = findElement(locatorName).getText().contains(hashTxt);
        Assertions.assertTrue(containsText, "Expected text is not contained");
        BaseTest.getLog().pass(locatorName + " Element Contains The " + hashTxt + " Value");
        logger.info(locatorName + " Element Contains The " + hashTxt + " Value");
    }
}
