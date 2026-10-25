package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class DateWidgetsLocators {

    public static final By DIALOG =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Dialog\")"
            );

    public static final By CHANGE_DATE =
            AppiumBy.accessibilityId("change the date");

    public static final By NEXT_MONTH =
            AppiumBy.id("android:id/next");

    public static final By DATE_11 =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"11\")"
            );

    public static final By OK_BUTTON =
            AppiumBy.id("android:id/button1");

}