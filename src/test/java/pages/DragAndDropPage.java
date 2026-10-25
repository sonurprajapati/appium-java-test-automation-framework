package pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import locators.DragAndDropLocators;

public class DragAndDropPage {

    private final AndroidDriver driver;
    WebDriverWait wait;

    public DragAndDropPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void dragElement() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(DragAndDropLocators.SOURCE));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(DragAndDropLocators.TARGET));
        WebElement source = driver.findElement(DragAndDropLocators.SOURCE);
        WebElement target = driver.findElement(DragAndDropLocators.TARGET);
        ((JavascriptExecutor) driver).executeScript(
                "mobile: dragGesture",
                Map.of(
                        "elementId", ((RemoteWebElement) source).getId(),
                        "endX", target.getRect().getX() + target.getRect().getWidth() / 2,
                        "endY", target.getRect().getY() + target.getRect().getHeight() / 2));
    }

    public void assertDragText() {
        WebElement dragText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        DragAndDropLocators.DRAGTEXT));
        String actualText = dragText.getText();
        System.out.println("Actual drag result: " + actualText);
        Assert.assertEquals(
                actualText,
                "Dropped!",
                "Drag and drop operation did not succeed!");
    }
}
