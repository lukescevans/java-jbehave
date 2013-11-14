/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bjss.jplay.testing.web;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author David.Paterson
 */
public class Login extends AbstractPage {
    
    @FindBy(css = "a#gmail-sign-in")
    private WebElement signInButton;
    
    @FindBy(css = "input#Email")
    private WebElement usernameField;
    
    @FindBy(css = "input#Passwd")
    private WebElement passwordField;
    
    @FindBy(css = "input#signIn")
    private WebElement loginButton;
    
    @FindBy(css = "span.error-msg")
    private WebElement errorMessage;
    
    public Login(WebDriverProvider driverProvider) {
        super(driverProvider);
    }
    
    public boolean pageIsShown() {
        return this.getTitle().equals("GMail");
    }
    
    public void gotoLogin() {
        this.navigate().to("http://gmail.com");
        signInButton.click();
        //pages.login().findElement(By.cssSelector("a.gmail-sign-in")).click();        
    }
    
    public void enterUserName(String username) {                
        //this.getDriverProvider().get().findElement(By.cssSelector("input.Email"));
        this.usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        //this.getDriverProvider().get().findElement(By.cssSelector("input.Passwd"));
        this.passwordField.sendKeys(password);
    }
    
    public void clickLogin() {
        //this.getDriverProvider().get().findElement(By.cssSelector("input.signIn"));
        this.loginButton.click();
    }
    
    public boolean showingErrorMessage() {
        return this.errorMessage.isDisplayed();
    }
    
    public String getErrorMessage() {
        return this.errorMessage.getText();
    }
}
