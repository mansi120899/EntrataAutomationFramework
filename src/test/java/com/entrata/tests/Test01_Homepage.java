package com.entrata.tests;

import com.entrata.base.CommonToAllTest;
import com.entrata.driver.DriverManager;
import com.entrata.pages.HomePage;
import com.entrata.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.entrata.driver.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Class: Test01_Homepage
 * Purpose: To verify that the homepage of Entrata displays the correct headline and page title.
 */

public class Test01_Homepage extends CommonToAllTest{
    @Description("TC#1- Verify that headline is shown on the entrata.com")
    @Test
    public void test_entrataHomePageHeading() throws Exception
    {
        // Step 1: Create an instance of HomePage to access page methods
        HomePage homepage = new HomePage(DriverManager.getDriver());

        // Step 2: Fetch the headline text from the homepage
        String red_headline = homepage.homePageHeading();
        System.out.println(red_headline);

        // Step 3: Assertion - Verify the headline is not blank/null/empty
        assertThat(red_headline).isNotBlank().isNotNull().isNotEmpty();

        // Step 4: Assertion - Verify the actual headline matches the expected value from properties file
        Assert.assertEquals(red_headline,PropertiesReader.readKey("expected_headline"),"Headline text does not match expected value");

        // Step 5: Assertion - Verify the browser page title is as expected
        String expectedTitle = "Property Management Software | Entrata®";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title doesn't match");
    }


}
