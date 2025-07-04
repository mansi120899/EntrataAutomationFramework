package com.entrata.pages;

import com.entrata.base.CommonToAll;
import com.entrata.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage class represents the landing page (home page) of Entrata.com.
 * It includes the locator and action related to verifying the homepage's main announcement heading.
 */

public class HomePage extends CommonToAll {
    WebDriver driver;

    /** Constructor to initialize WebDriver instance for this page class. */
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Locator for the red banner heading:
     * "Entrata Receives $200 Million Investment from Blackstone"
     * This heading is used as a visual confirmation that the homepage has loaded correctly.
     */

    // Step 1 - Page Locators
    private By page_heading = By.xpath("//div[@class='h2-link-text bar' and contains(text(), 'Entrata Receives $200 Million')]");


    //Step 2 - Page Actions
    /**
     * This method performs the following actions:
     * 1. Opens the Entrata homepage.
     * 2. Waits until the banner heading becomes visible.
     * 3. Returns the heading text. */

    public String homePageHeading()
    {
        openEntrataUrl();
        WaitHelpers.visibilityOfElement(page_heading);
        return getText(page_heading);
    }

}
