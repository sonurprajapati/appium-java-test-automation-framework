package pages;

import io.appium.java_client.android.AndroidDriver;
import locators.DateWidgetsLocators;

public class DateWidgetsPage {

    private final AndroidDriver driver;

    public DateWidgetsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickDialog() {
        driver.findElement(DateWidgetsLocators.DIALOG).click();
    }

    public void clickChangeDate() {
        driver.findElement(DateWidgetsLocators.CHANGE_DATE).click();
    }

    public void clickNextMonth() {
        driver.findElement(DateWidgetsLocators.NEXT_MONTH).click();
    }

    public void selectDate11() {
        driver.findElement(DateWidgetsLocators.DATE_11).click();
    }

    public void clickOK() {
        driver.findElement(DateWidgetsLocators.OK_BUTTON).click();
    }
}