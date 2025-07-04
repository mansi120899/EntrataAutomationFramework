package com.entrata.tests;

import com.entrata.base.CommonToAllTest;
import com.entrata.driver.DriverManager;
import com.entrata.pages.AutomationForm;
import com.entrata.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

/**
 * Test Class: Test02_AI_AutomationForm
 * Purpose: To test navigation to the Automation Suite  in Home page and fill out the "Book a Demo" form.
 */

public class Test02_AI_AutomationForm extends CommonToAllTest {
    @Owner("Mansi Mahajan")
    @Description("TC#2- Interacting with Forms")
    @Test
    public void productsAutomationForm()
    {
        // Step 1: Create an instance of the AutomationForm page class
        AutomationForm productpage = new AutomationForm(DriverManager.getDriver());

        // Step 2: Navigate to AI & Automation Suite product page and click "Book a Demo"
        productpage.productsAutomationForm();

        // Step 3: Fill out the demo request form using test data read from the properties file
        productpage.fill_form(
                PropertiesReader.readKey("username"),
                PropertiesReader.readKey("lastname"),
                PropertiesReader.readKey("email"),
                PropertiesReader.readKey("phone"));
    }

}
