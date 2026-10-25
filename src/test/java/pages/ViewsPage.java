package pages;

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
}