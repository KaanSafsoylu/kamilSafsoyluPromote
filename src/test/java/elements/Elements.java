package elements;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Elements {

    private static final Map<String, By> LOCATORS = new HashMap<>();

    static {

        // Login Page Elements

        LOCATORS.put("enterUsernameTxt", By.xpath("//div[text()='Enter username*']"));
        LOCATORS.put("enterPasswordTxt", By.xpath("//div[text()='Enter password*']"));
        LOCATORS.put("usernameInput", By.cssSelector("input[placeholder='Username']"));
        LOCATORS.put("passwordInput", By.cssSelector("input[placeholder='Password']"));
        LOCATORS.put("loginButton", By.xpath("//div[text()='Login']"));

        // Account Elements

        LOCATORS.put("logoutButton",By.xpath("//div[text()='Logout']"));
        LOCATORS.put("moneyTransferButton",By.xpath("//div[text()='Open Money Transfer']"));

        // Login Error Elements
        LOCATORS.put("wrongCredentials",By.xpath("//div[text()='Username or Password Invalid!']"));

        //My Account Page Elements
        LOCATORS.put("myAccountTxt",By.xpath("//div[text()='My account']"));
        LOCATORS.put("accountNameTxt",By.xpath("//div[text()='Account name']"));
        LOCATORS.put("givenAccountNameTxt",By.xpath("//div[text()='Account name']/following-sibling::div"));
        LOCATORS.put("creationTimeTxt",By.xpath("//div[text()='Creation time']"));
        LOCATORS.put("amountTxt",By.xpath("//div[text()='Amount']"));
        LOCATORS.put("transferMoneyButton",By.xpath("//div[text()='Transfer money']"));
        LOCATORS.put("addMoneyButton",By.xpath("//div[text()='Add money']"));
        LOCATORS.put("editAccountButton",By.xpath("//div[text()='Edit account']"));

        //Edit Account Page Elements
        LOCATORS.put("editAccPopUp",By.xpath("(//div[text()='Edit account'])[2]"));
        LOCATORS.put("editAccNameInput",By.cssSelector("input[autocapitalize='sentences']"));
        LOCATORS.put("updateButton",By.xpath("//div[text()='UPDATE']"));

        //Add Money Page Elements
        LOCATORS.put("cardNumberInput",By.xpath("//div[text()='Card number']/following-sibling::input"));
        LOCATORS.put("cardHolderInput",By.xpath("//div[text()='Card holder']/following-sibling::input"));
        LOCATORS.put("expiryDateInput",By.xpath("//div[text()='Expiry date']/following-sibling::input"));
        LOCATORS.put("cvvInput",By.xpath("//div[text()='CVV']/following-sibling::input"));
        LOCATORS.put("AmountInput",By.xpath("//div[text()='Amount']/following-sibling::input"));
        LOCATORS.put("addButton",By.xpath("//div[text()='Add']"));
        LOCATORS.put("lastTransactionTxt",By.xpath("(//div[text()='Amount:']/following-sibling::div/div)[1]"));

        //Add Money Errors
        LOCATORS.put("tooShortError",By.xpath("//div[contains(text(),'Too short')]"));
        LOCATORS.put("tooLongError",By.xpath("//div[contains(text(),'Too long')]"));
        LOCATORS.put("requiredError",By.xpath("//div[text()='Required']"));
        LOCATORS.put("wrongDateError",By.xpath("//div[text()='Wrong date. Please give a correct date']"));
        LOCATORS.put("amountMustBeNumberError",By.xpath("//div[contains(text(),'amount must be a `number` type')]"));

        //Transfer Money Page Elements

        LOCATORS.put("senderAccountTxt",By.xpath("//div[text()='Sender account']"));
        LOCATORS.put("receiverAccountTxt",By.xpath("//div[text()='Receiver account']"));
        LOCATORS.put("sendAmountInput",By.xpath("//div[text()='Receiver account']/following::input"));
        LOCATORS.put("sendButton",By.xpath("//div[text()='Send']"));
    }


    public static By getLocator(String locatorName) {
        By locator = LOCATORS.get(locatorName);
        if (locator == null) {
            throw new IllegalArgumentException("Given Locator Not Found Check Elements class for : " + locatorName);
        }
        return locator;
    }

}


