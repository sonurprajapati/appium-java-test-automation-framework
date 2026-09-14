import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {

    public static AndroidDriver getDriver() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("emulator-5554");
        options.setApp("apps/ApiDemos-debug.apk");

        return new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options
        );
    }
}