package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pages.DateWidgetsPage;
import pages.DragAndDropPage;
import pages.HomePage;
import pages.ViewsPage;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private DragAndDropPage dragAndDropPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        viewsPage = new ViewsPage(driver);
        dateWidgetsPage = new DateWidgetsPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test(priority = 1, enabled = true)
    public void clickAccessibility() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
        driver.navigate().back();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Animation']")).click();
        driver.navigate().back();
    }

    @Test(priority = 2, enabled = true)
    public void checkAlert() throws InterruptedException {
        homePage.clickApp();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons")).click();
        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        AppiumBy.className("android.widget.Button"), 0));
        WebElement element = driver.findElements(
                AppiumBy.className("android.widget.Button")).get(0);
        ((JavascriptExecutor) driver).executeScript(
                "mobile: longClickGesture",
                Map.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "duration", 1000));
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/radio_button")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"OK\")")).click();
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test(priority = 3, enabled = true)
    public void dragAndDrop() throws InterruptedException {
        homePage.clickViews();
        viewsPage.clickDragAndDrop();
        dragAndDropPage.dragElement();
        dragAndDropPage.assertDragText();
    }

    @Test(priority = 4, enabled = true)
    public void dateHandle() throws InterruptedException {
        homePage.clickViews();
        viewsPage.clickDateWidgets();
        dateWidgetsPage.clickDialog();
        dateWidgetsPage.clickChangeDate();
        dateWidgetsPage.clickNextMonth();
        dateWidgetsPage.clickNextMonth();
        dateWidgetsPage.selectDate11();
        dateWidgetsPage.clickOK();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}