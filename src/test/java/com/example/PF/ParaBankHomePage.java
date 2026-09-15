package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParaBankHomePage {
    public static final String URL = "https://parabank.parasoft.com/";
    WebDriver driver;
    @FindBy(css = "a[href='register.htm']")
    private WebElement btn_register;
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(css = "input[type='submit'][value='Log In']") 
    private WebElement btn_login ;


    public ParaBankHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickRegister(){
        btn_register.click();
    }
    

    public void RemplirIdentifiants(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        btn_login.click();

        
    }

}
