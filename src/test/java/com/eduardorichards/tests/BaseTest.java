package com.eduardorichards.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.eduardorichards.core.driver.DriverManager;

/**
 * Base class for all test classes.
 * Handles WebDriver lifecycle (creation and teardown) so that each test
 * method runs with a fresh, isolated browser session on its own thread.
 */
public class BaseTest {

    @BeforeMethod
    public void setUp() {
        // Explicitly initializes the driver for this thread before the test runs.
        // Page Objects would trigger this lazily on first use anyway (see
        // AbstractPage),
        // but doing it here makes the browser session's start point explicit and
        // visible.
        DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
