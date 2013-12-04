/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bjss.jplay.testing.web;

import junit.framework.Assert;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.library.DriverProvider;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Luke.Evans
 */
public class GoogleHomepage extends AbstractPage {
    
    private final String Homepagetitle = "Google";
    private final String GoogleHomepageURL = "http://www.google.com/";
    
    @FindBy(id = "gbqfq") //Search box
    private WebElement searchBox;
    
    @FindBy(id = "gbqfb") //Submit button
    private WebElement searchSubmit;
    
    //Constructor
    public GoogleHomepage(WebDriverProvider driverProvider) {
        super(driverProvider);
        
        //Check the page title is correct in the ctr
        //Assert.assertEquals(Homepagetitle, this.getTitle());                
    }
    
    /**
    *
    * @author Luke.Evans
    * Get page title and verify equal to Google
    */
    public boolean verifyPageTitle() {        
        return this.getTitle().equals(Homepagetitle);
    }
        
    public void doSearch(String searchTerm) {        
        //Goto yahoo home page
        this.navigate().to(GoogleHomepageURL);
        //check current page is correct
        verifyPageTitle();
        //Enter search text
        enterSearchTerm(searchTerm);
        //Click Search button
        this.clickSearch();      
    }  
    
    public void clickSearch() {       
        //WebDriverWait wait = new WebDriverWait(this, 10);		    
        this.searchSubmit.click();
    }
    
    public void enterSearchTerm(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }    
    
    public void navigateToHomepage() {        
        this.navigate().to(GoogleHomepageURL);            
    }  
    
    public String getSearchBoxText() {
        //Return upper case search term from yahoo search box
        return searchBox.getAttribute("value").toUpperCase();        
        
}  
}
