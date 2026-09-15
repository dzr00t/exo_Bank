package com.example.PF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    @FindBy(id = "customer.firstName") 
    private WebElement firstName;

    @FindBy(id = "customer.lastName") 
    private WebElement lastName;

    @FindBy(id = "customer.address.street") 
    private WebElement adressStreet;

    @FindBy(id = "customer.address.city") 
    private WebElement adressCity;

    @FindBy(id = "customer.address.state") 
    private WebElement adressState;

    @FindBy(id = "customer.address.zipCode") 
    private WebElement zipCode;

    @FindBy(id = "customer.phoneNumber") 
    private WebElement phoneNumber ;

    @FindBy(id = "customer.ssn") 
    private WebElement SSN ;

    //identifiants    
    @FindBy(id = "customer.username") 
    private WebElement username ;
    @FindBy(id = "customer.password") 
    private WebElement password ;
    @FindBy(id = "repeatedPassword") 
    private WebElement repeatedPassword ;

    //button
    @FindBy(css = "input[type='submit'][value='Register']") 
    private WebElement btn_confirm ;

    @FindBy(css = "[href='logout.htm']")
    private WebElement btn_logout;


    //mssg 
    @FindBy(className = "title")
    private WebElement mssg_sucess;

    @FindBy(id = "customer.username.errors")
    private WebElement errorMsg;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void RemplirFormulaireInscription(String firstname, String lastname,String adress, 
        String city, String state, String zipcode, String phone, String ssn){

            firstName.sendKeys(firstname);
            lastName.sendKeys(lastname);
            adressStreet.sendKeys(adress);
            adressCity.sendKeys(city);
            adressState.sendKeys(state);
            zipCode.sendKeys(zipcode);
            phoneNumber.sendKeys(phone);
            SSN.sendKeys(ssn);
    }

    public void RemplirIdentifiants(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        repeatedPassword.sendKeys(pass);
    }

    public void ClickConfirme(){
        btn_confirm.click();

    }

    public Boolean isSucessDisplayed(){
        return mssg_sucess.isDisplayed();

    }

    public void ClickLogout(){
        btn_logout.click();
    }

    
    
}
