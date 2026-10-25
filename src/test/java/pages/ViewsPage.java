package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import locators.ViewsLocators;

public class ViewsPage {

    private final AndroidDriver driver;

    public ViewsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickDateWidgets() {
        driver.findElement(ViewsLocators.DATE_WIDGETS).click();
    }

    public void clickDragAndDrop() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Drag and Drop\")")).click();
    }
}