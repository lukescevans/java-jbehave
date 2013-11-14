/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bjss.jplay.testing.web;

import org.jbehave.web.selenium.WebDriverProvider;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 *
 * @author David.Paterson
 */
public class PageFactory {
 
    private final WebDriverProvider driverProvider;
    private Login login;
    //private FindSteps findSteps;
    // More pages as needed
    
    public PageFactory(WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }
    
    public Login login(){
        if ( login == null ){
            login = new Login(driverProvider);            
            initElements(driverProvider.get(), login);            
        }
        return login;
    }
}
