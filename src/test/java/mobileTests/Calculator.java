package mobileTests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Calculator {

    private AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String ambiente = "local"; // <--- troque por local para rodar no emulador da sua máquina
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL remoteUrl;

        switch (ambiente) {
            case "local":

                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("deviceName", "emulator-5554");
                desiredCapabilities.setCapability("automationName", "uiautomator2");
                desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
                desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
                desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
                remoteUrl = new URL("http://localhost:4723/wd/hub");

                break;
            case "remoto": // No SauceLabs
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("platformVersion", "9.0");
                desiredCapabilities.setCapability("browserName", "");
                desiredCapabilities.setCapability("appiumVersion", "1.19.2");
                desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
                desiredCapabilities.setCapability("deviceOrientation", "portrait");
                desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
                desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
                desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
                desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
                desiredCapabilities.setCapability("SAUCE_USERNAME", "dh04iterasys");
                desiredCapabilities.setCapability("SAUCE_ACCESS_KEY", "6b3d69e3-3a5f-414a-8277-f4976c7e4888");

                remoteUrl = new URL("https://dh04iterasys:6b3d69e3-3a5f-414a-8277-f4976c7e4888@ondemand.us-west-1.saucelabs.com:443/wd/hub");
                break;
            default:
                remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
                break;
        }

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
    }


    @Test
    public void somar() {

        MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_5");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_6");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals("11", lblResultado.getText());

    }


    @Test
    public void multiplicar() {

        MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("divide");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals("3", lblResultado.getText());

    }


    @Test
    public void dividir() {

        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("multiply");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals("28", lblResultado.getText());
    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
