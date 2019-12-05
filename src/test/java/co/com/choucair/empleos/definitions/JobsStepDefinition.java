package co.com.choucair.empleos.definitions;

import co.com.choucair.empleos.steps.ChoucairJobsStep;
import co.com.choucair.empleos.steps.DataModelStep;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;

import java.awt.*;
import java.util.List;

public class JobsStepDefinition {

    @Steps
    ChoucairJobsStep choucairJobsStep;

    @Given("^that (.*) wants to access choucair jobs$")
    public void thatLuisWantsToAccessChoucairJobs(String luis) {
        choucairJobsStep.openPage();
        choucairJobsStep.openJobs();
        choucairJobsStep.scrollSearchJobs();
    }

    @When("^he performs the search on the page$")
    public void hePerformsTheSearchOnThePage(List<DataModelStep> data) throws AWTException {
        choucairJobsStep.registrarData(data);
    }

    @Then("^he verifies that the text searched is displayed on the screen$")
    public void heVerifiesThatTheTextSearchedIsDisplayedOnTheScreen(List<DataModelStep> data) {
        choucairJobsStep.checkText(data);
    }

    @Given("^that (.*) wants to join performance work$")
    public void thatLuisWantsToJoinPerformanceWork(String luis) {
        choucairJobsStep.openPage();
        choucairJobsStep.openJobs();
        choucairJobsStep.clickOnJobOffer();
    }

    @When("^he  fills  the form$")
    public void heFillsTheForm(List<DataModelStep> data) throws AWTException {
        choucairJobsStep.applyToJob(data);
    }

    @Then("^he verifies that the text please verify the captcha is displayed on the screen$")
    public void heVerifiesThatTheTextPleaseVerifyTheCaptchaIsDisplayedOnTheScreen(List<DataModelStep> data) {
        choucairJobsStep.checkTextOnApplyJob(data);
    }

    @Given("^that (.*) wants search a word in the section jobs$")
    public void thatLuisWantsSearchAWordInTheSectionJobs(String luis) {
        choucairJobsStep.openPage();
        choucairJobsStep.openJobs();
        choucairJobsStep.scrollSearchJobs();
    }

    @When("^he write the word (.*)$")
    public void heWriteTheWordMedico(String word) {
        choucairJobsStep.writeWord(word);
    }

    @Then("^he sees the text (.*)$")
    public void heSeesTheTextNoHayTrabajosCorrespondientesATuBúsqueda(String textNoWork) {
        choucairJobsStep.checkTextNoWork(textNoWork);
    }

}
