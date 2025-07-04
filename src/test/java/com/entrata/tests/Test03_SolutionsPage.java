package com.entrata.tests;

import com.entrata.base.CommonToAllTest;
import com.entrata.driver.DriverManager;
import com.entrata.listeners.RetryAnalyzer;
import com.entrata.listeners.ScreenshotListener;
import com.entrata.pages.Solutions;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test Class: Test03_SolutionsPage
 * Purpose: To verify navigation to the "Multifamily" page under the "Solutions" tab.
 */

// Listener to capture screenshots on test failure
@Listeners(ScreenshotListener.class)
// Retry failed test automatically as per custom RetryAnalyzer
@Test(retryAnalyzer = RetryAnalyzer.class)
public class Test03_SolutionsPage extends CommonToAllTest
{
    // Logger instance for logging test steps and messages
    private static final Logger logger = LogManager.getLogger(Test03_SolutionsPage.class);
    @Owner("Mansi Mahajan")
    @Description("TC#3- Navigating to Solution Page")
    @Test
    public void solutionPageNavigation()
    {
        logger.info("Starting the Solution Page Testcases");

        // Step 1: Create an instance of the Solutions page class
        Solutions sol = new Solutions(DriverManager.getDriver());

        // Step 2: Perform the action to hover over "Solutions" and click on "Multifamily"
        sol.solutionsMultiFamily();

        logger.info("Solution Page Testcases Completed");
    }
}
