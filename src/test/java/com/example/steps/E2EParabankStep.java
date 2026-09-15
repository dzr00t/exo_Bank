package com.example.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.example.PF.*;
import com.example.hook.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;

public class E2EParabankStep {
    WebDriver driver = BaseTest.driver;
    ParaBankHomePage parabankPF = BaseTest.parabankPF;
    RegisterPage registerPF = BaseTest.registerPF;
    Faker faker = new Faker(new java.util.Locale("fr"));

    String nom = faker.name().lastName();
    String prenom = faker.name().firstName();
    String adress = faker.address().fullAddress();
    String city = faker.address().city();
    String state = faker.address().state();
    String ZIP = faker.address().zipCode();
    String PN = faker.phoneNumber().phoneNumberInternational();
    String SSN = faker.phoneNumber().phoneNumberInternational()+"953450";
    double nbr=  Math.floor(Math.random()*100);
    String username = "salim"+nbr;
    String password = faker.internet().password();
    
    
  

    
    @Given("Visiter le site web {string}")
    public void Visiter_le_site_web(String s) {
        driver.get(ParaBankHomePage.URL);
    }

    @When("Je clique sur Register")
    public void Je_clique_sur_Register() {
        parabankPF.ClickRegister();
    }

    @Then("je suis rederiger vers la page de creation de compte")
    public void je_suis_rederiger_vers_la_page_de_creation_de_compte() {
        assertTrue(driver.getCurrentUrl().contains("/register.htm"));
    }

    @When("Je remplis le formulaire dinscription")
    public void Je_remplis_le_formulaire_dinscription() {

        registerPF.RemplirFormulaireInscription(username, username, username, username, username, username, username, username);
        registerPF.RemplirIdentifiants(username,username);
        registerPF.ClickConfirme();

    }

    @Then("le message Welcome est afficher")
    public void le_message_Welcome_est_afficher() {
        assertTrue(registerPF.isSucessDisplayed());
    }

    @When("je clique sur logout")
    public void je_clique_sur_logout() {
        registerPF.ClickLogout();
    }

    @Then("je suis rederiger vers la page dacceuil")
    public void je_suis_rederiger_vers_la_page_dacceuil() {
        assertTrue(driver.getCurrentUrl().contains("/index.htm"));
    }

    @Then("je remplis les identifiants valide username {string} password {string}")
    public void je_remplis_les_identifiants_valide_username_password(String s, String s2) {
        parabankPF.RemplirIdentifiants(username,username);
    }

    @Then("je suis rederiger vers mon compte")
    public void je_suis_rederiger_vers_mon_compte() {
        assertTrue(driver.getCurrentUrl().contains("/overview.htm"));
    }


}
