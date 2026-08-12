package com.eduardorichards.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.eduardorichards.pages.HomePage;
import com.eduardorichards.pages.ProgramDetailPage;
import com.eduardorichards.pages.TrainingProgramsPage;

public class LocationFilterTest extends BaseTest {

    @Test
    public void shouldFilterProgramsByLocation() {
        HomePage homePage = new HomePage();
        homePage.navigateTo();

        homePage.clickFindAProgram();
        TrainingProgramsPage trainingProgramsPage = new TrainingProgramsPage();
        assertEquals(trainingProgramsPage.getHeadingText(), "Training programs");

        trainingProgramsPage.openLocationFilter();
        assertTrue(trainingProgramsPage.isLocationDropdownOpen());

        trainingProgramsPage.selectCountry("Argentina");
        assertTrue(trainingProgramsPage.isFilterApplied());

        String expectedTitle = trainingProgramsPage.captureFirstResultCardTitle();
        trainingProgramsPage.clickFirstResultCard();

        ProgramDetailPage programDetailPage = new ProgramDetailPage();
        assertEquals(programDetailPage.getHeadingText(), expectedTitle);
    }
}