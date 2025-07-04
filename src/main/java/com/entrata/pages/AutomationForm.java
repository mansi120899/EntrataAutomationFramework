package com.entrata.pages;

import com.entrata.base.CommonToAll;
import com.entrata.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * This class handles interactions on the "AI & Automation Suite" product page and the form submission.
 * It automates the navigation to the demo form and fills out the required fields.
 */
public class AutomationForm extends CommonToAll {
    WebDriver driver;

    public AutomationForm(WebDriver driver){
        this.driver = driver;
    }

    //Page Locators
    private By p1 = By.xpath("//div[text()='AI & Automation Suite']/ancestor::a");
    private By demo = By.xpath("//div[@class='button_text' and text()='Book a demo']");

    private By firstname = By.id("FirstName");
    private By lastname = By.id("LastName");
    private By email = By.id("Email");
    private By phone = By.id("Phone");
    //WebElement company = driver.findElement(By.id("Company"));
    private By company1 = By.id("Company");

    //Page Actions
    /**
     * This method navigates to the Entrata homepage,
     * clicks on "AI & Automation Suite", then clicks on "Book a demo". */
    public void productsAutomationForm()
    {
        openEntrataUrl();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement element_p1 = wait.until(ExpectedConditions.elementToBeClickable(p1));
        actions.moveToElement(element_p1).click().perform();
        WaitHelpers.waitJVM(3000); // Replace with proper waits ideally

        WebElement element_p2 = wait.until(ExpectedConditions.elementToBeClickable(demo));
        actions.moveToElement(element_p2).click().perform();
        WaitHelpers.waitJVM(3000);
    }

    /**
     * This method fills out the demo request form with provided data. */
    public void fill_form(String user, String last, String mail, String phoneno)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Fill in first name, last name, and email
        enterInput(firstname,user);
        enterInput(lastname,last);
        enterInput(email,mail);

        // Fill in company name via Actions (used for special input handling)
        WebElement element_p3 = wait.until(ExpectedConditions.elementToBeClickable(company1));
        actions.moveToElement(element_p3).click().sendKeys("Cognizant cdc midc").perform();
        WaitHelpers.waitJVM(6000);

        // Fill in phone number
        enterInput(phone,phoneno);

        // Select unit count from dropdown
        WebElement unitDropdown = driver.findElement(By.id("Unit_Count__c"));
        Select select = new Select(unitDropdown);
        select.selectByVisibleText("301 - 2000");
        WaitHelpers.waitJVM(6000);

        // Enter job title
        WebElement title = driver.findElement(By.id("Title"));
        title.sendKeys("SDET");

        // Select "I am" dropdown option
        WebElement demoRequestDropdown = driver.findElement(By.id("demoRequest"));
        Select select1 = new Select(demoRequestDropdown);
        select1.selectByVisibleText("an Owner/Operator or Property Manager");
        WaitHelpers.waitJVM(6000);

        // Verify selected option
        String selected = select1.getFirstSelectedOption().getText();
        if (selected.equals("an Owner/Operator or Property Manager")) {
            System.out.println("Option selected successfully!");
        } else {
            System.out.println("Selection failed. Current selection: " + selected);
        }

    }


}
