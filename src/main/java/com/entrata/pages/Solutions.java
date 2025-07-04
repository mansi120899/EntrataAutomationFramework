package com.entrata.pages;

import com.entrata.base.CommonToAll;
import com.entrata.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * This class handles interactions with the "Solutions" tab on the Entrata homepage.
 * It automates the flow of hovering over the Solutions menu and clicking on the "Multifamily" option.
 */

public class Solutions extends CommonToAll {
    WebDriver driver;

    public Solutions(WebDriver driver){
        this.driver = driver;
    }
    //private By sol = By.xpath("//div[@class='nav_link w-dropdown-toggle']//div[text()='Solutions']");

    public void solutionsMultiFamily()
    {
        openEntrataUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Hover over "Solutions" tab
        WebElement solutionsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nav_link w-dropdown-toggle']//div[text()='Solutions']")));
        actions.moveToElement(solutionsTab).perform();

        // Wait for "Multifamily" to become visible and click
        WebElement multifamilyOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Multifamily']")));
        multifamilyOption.click();

    }

}
