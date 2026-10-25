package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ViewsLocators {

    public static final By DATE_WIDGETS =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Date Widgets\")"
            );

}