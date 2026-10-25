package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import locators.HomeLocators;

public class HomePage {

    private final AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickViews() {
        driver.findElement(HomeLocators.VIEWS).click();
    }

    public void clickApp() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
    }
}