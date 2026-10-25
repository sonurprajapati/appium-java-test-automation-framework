package locators;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class DragAndDropLocators {

    public static final By SOURCE = AppiumBy.id("io.appium.android.apis:id/drag_dot_3");

    public static final By TARGET = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");

    public static final By DRAGTEXT = AppiumBy.id("io.appium.android.apis:id/drag_result_text");

}
