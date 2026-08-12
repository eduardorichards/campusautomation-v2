package com.eduardorichards.pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eduardorichards.core.config.ConfigReader;
import com.eduardorichards.core.driver.DriverManager;


public abstract class AbstractPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @FindBy(tagName = "h1")
    private WebElement pageHeading;

    @FindBy(css = "[data-name='CareerJourney']")
    private WebElement careerJourneyLink;

    @FindBy(css = "[data-name='Skills']")
    private WebElement skillsLink;

    @FindBy(css = "[data-name='Blog']")
    private WebElement blogLink;

    @FindBy(css = "[data-name='About']")
    private WebElement aboutUsLink;

    protected AbstractPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.getExplicitWaitSeconds()));
        PageFactory.initElements(driver, this);
    }

    protected abstract String getUrlFragment();

    public boolean isLoaded() {
        return waitForUrlToContain(getUrlFragment());
    }

    public String getHeadingText() {
        isLoaded();
        return getElementText(pageHeading);
    }

    protected WebElement getPageHeadingElement() {
        return pageHeading;
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean waitForUrlToContain(String fragment) {
        try {
            return wait.until(ExpectedConditions.urlContains(fragment));
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void waitForTextToChange(WebElement element, String previousText) {
        wait.until(driver -> !element.getText().equals(previousText));
    }

    protected String getElementText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    protected void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void clickCareerJourney() {
        clickElement(careerJourneyLink);
    }

    public void clickSkills() {
        clickElement(skillsLink);
    }

    public void clickBlog() {
        clickElement(blogLink);
    }

    public void clickAboutUs() {
        clickElement(aboutUsLink);
    }
}
