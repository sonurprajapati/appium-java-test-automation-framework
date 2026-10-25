package tests;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.DriverManager;

public class ApiDemosTest {

    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverManager.getDriver();
    }

    @Test
    public void clickAccessibility() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Animation']")).click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"App\")")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons")).click();
        Thread.sleep(500);
        WebElement element = driver.findElements(AppiumBy.className("android.widget.Button")).get(0);
        ((JavascriptExecutor) driver).executeScript(
        "mobile: longClickGesture",
        Map.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "duration", 1000
        )
        );
        Thread.sleep(500);
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/radio_button")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"OK\")")).click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Drag and Drop\")")).click();
        Thread.sleep(500);






    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}