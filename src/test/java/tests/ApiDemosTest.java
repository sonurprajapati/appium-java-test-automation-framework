package tests;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pages.DateWidgetsPage;
import pages.HomePage;
import pages.ViewsPage;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.DriverManager;

public class ApiDemosTest {

    private AndroidDriver driver;
    private HomePage homePage;
    private ViewsPage viewsPage;
    private DateWidgetsPage dateWidgetsPage;

    @BeforeMethod
        public void setUp() throws Exception {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        viewsPage = new ViewsPage(driver);
        dateWidgetsPage = new DateWidgetsPage(driver);
    }

    @Test(priority = 1, enabled = false)
    public void clickAccessibility() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Animation']")).click();
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);        
    }

    @Test(priority = 2, enabled = false)
    public void checkAlert() throws InterruptedException{
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
    }

    @Test(priority = 3, enabled = false)
    public void dragAndDrop() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Drag and Drop\")")).click();
        Thread.sleep(500);
        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_3"));
        WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        ((JavascriptExecutor) driver).executeScript(
            "mobile: dragGesture",
            Map.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", target.getRect().getX() + target.getRect().getWidth() / 2,
                "endY", target.getRect().getY() + target.getRect().getHeight() / 2
            )
        );
        Thread.sleep(500);
        WebElement dragText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertTrue(dragText.isDisplayed(), "Dragged");
        Thread.sleep(500);
    }

    @Test (priority = 1)
    public void dateHandle() throws InterruptedException {

        // driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        // Thread.sleep(500);
        // driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Date Widgets\")")).click();
        // Thread.sleep(500);
        // driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Dialog\")")).click();
        // Thread.sleep(500);
        // driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"change the date\"]")).click();
        // Thread.sleep(500);
        // driver.findElement(AppiumBy.id("android:id/next")).click();
        // Thread.sleep(100);
        // driver.findElement(AppiumBy.id("android:id/next")).click();
        // Thread.sleep(500);
        // driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"11\")")).click();
        // Thread.sleep(500);
        // driver.findElement(AppiumBy.id("android:id/button1")).click();
        // Thread.sleep(500);

        homePage.clickViews();
        Thread.sleep(500);

        viewsPage.clickDateWidgets();
        Thread.sleep(500);

        dateWidgetsPage.clickDialog();
        Thread.sleep(500);

        dateWidgetsPage.clickChangeDate();
        Thread.sleep(500);

        dateWidgetsPage.clickNextMonth();
        Thread.sleep(100);

        dateWidgetsPage.clickNextMonth();
        Thread.sleep(500);

        dateWidgetsPage.selectDate11();
        Thread.sleep(500);

        dateWidgetsPage.clickOK();
        Thread.sleep(500);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}