package com.eduardorichards.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrainingProgramsPage extends AbstractPage {

    private static final String URL_FRAGMENT = "/training";
    private static final String FILTER_URL_FRAGMENT = "filter=";
    private static final String RESULT_CARD_XPATH = "//a[contains(@href, '/training/')]";
    private static final String CARD_TITLE_CSS = "[class*='training-card_card-name__']";

    @FindBy(xpath = "//div[@role='button' and normalize-space()='Location']")
    private WebElement locationFilterTrigger;

    @FindBy(css = "input[placeholder='Search']")
    private WebElement locationSearchInput;

    @FindBy(xpath = RESULT_CARD_XPATH)
    private List<WebElement> resultCards;

    public TrainingProgramsPage() {
        super();
    }

    @Override
    protected String getUrlFragment() {
        return URL_FRAGMENT;
    }

    public void openLocationFilter() {
        clickElement(locationFilterTrigger);
    }

    public boolean isLocationDropdownOpen() {
        waitForVisibility(locationSearchInput);
        return locationSearchInput.isDisplayed();
    }

    public void selectCountry(String countryName) {
        WebElement previousFirstCard = resultCards.isEmpty() ? null : resultCards.get(0);
        WebElement countryCheckBox = driver.findElement(
                By.xpath("//div[@class='text' and normalize-space(text())='" + countryName + "']"));
        clickElement(countryCheckBox);
        if (previousFirstCard != null) {
            wait.until(ExpectedConditions.stalenessOf(previousFirstCard));
        }
    }

    public boolean isFilterApplied() {
        return waitForUrlToContain(FILTER_URL_FRAGMENT);
    }

    public String captureFirstResultCardTitle() {
        WebElement firstCard = resultCards.get(0);
        WebElement titleElement = firstCard.findElement(By.cssSelector(CARD_TITLE_CSS));
        return getElementText(titleElement);
    }

    public void clickFirstResultCard() {
        clickElement(resultCards.get(0));
    }
}
