package com.example.hook;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import com.example.PF.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
    public static WebDriver driver;
    public static ParaBankHomePage parabankPF;
    public static RegisterPage registerPF;

    @Before
    public void setUp() {
        // local
        driver = new ChromeDriver();

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // nettoyage préventif (utile surtout si le profil n'est pas 100% neuf)
        driver.manage().deleteAllCookies();

        parabankPF = new ParaBankHomePage(driver);
        registerPF = new RegisterPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            // nettoyage cookies + local/session storage avant fermeture
            try {
                driver.manage().deleteAllCookies();
                ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
                ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
            } catch (Exception e) {
                // ignore si la page n'est pas chargée ou déjà fermée
            }

            driver.quit();
            driver = null;
        }
    }
}