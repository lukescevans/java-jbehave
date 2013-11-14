/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjss.jplay.steps;

import bjss.jplay.testing.web.PageFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

/**
 *
 * @author David.Paterson
 */
public class LoginSteps {

    final private PageFactory pages;
    
    public LoginSteps(PageFactory pages) {
        this.pages = pages;
    }
    
    @Given("I am on the $pagename Page")
    public void givenPageName(@Named("pagename") String pagename) {

        if (pagename.equalsIgnoreCase("GMail")) {
            
            pages.login().gotoLogin();
            
        }
        
    }
    
    @Given("a user named $username")
    public void givenUserName(@Named("username") String username) {

        pages.login().enterUserName(username);
        
    }

    @Given("the password is $password")
    public void givenPassword(@Named("password") String password) {

        pages.login().enterPassword(password);
        
    }

    @When("I login")
    public void whenLogin() {

        pages.login().clickLogin();
        
    }

    @Then("Error Message Displayed Is $errormessage")
    public boolean thenErrorMessageDisplayed(@Named("errormessage") String errormessage) {
        
        if (pages.login().showingErrorMessage()) {        
            return pages.login().getErrorMessage().equals(errormessage);
        } else {
            return false;
        }
    }
    
    @Then("Login Succeeded")
    public void thenLoginSucceeded() {
    }

}
