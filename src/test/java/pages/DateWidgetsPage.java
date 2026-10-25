package pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import locators.DateWidgetsLocators;

public class DateWidgetsPage {

    private final AndroidDriver driver;
    WebDriverWait wait;

    public DateWidgetsPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickDialog() {
        driver.findElement(DateWidgetsLocators.DIALOG).click();
    }

    public void clickChangeDate() {
        driver.findElement(DateWidgetsLocators.CHANGE_DATE).click();
    }

    public void clickNextMonth() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DateWidgetsLocators.NEXT_MONTH));
        driver.findElement(DateWidgetsLocators.NEXT_MONTH).click();
    }

    public void selectDate11() {
        driver.findElement(DateWidgetsLocators.DATE_11).click();
    }

    public void clickOK() {
        driver.findElement(DateWidgetsLocators.OK_BUTTON).click();
    }
}