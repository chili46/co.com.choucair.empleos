package co.com.choucair.empleos.steps;

import co.com.choucair.empleos.pagesobject.ChoucairJobsPageObject;
import net.thucydides.core.annotations.Step;

import java.awt.*;
import java.util.List;

public class ChoucairJobsStep {

    ChoucairJobsPageObject choucairJobsPageObject;

    @Step
    public void openPage() {
        choucairJobsPageObject.open();
    }

    @Step
    public void openJobs() {
        choucairJobsPageObject.openJobsModule();
    }

    @Step
    public void scrollSearchJobs() {
        choucairJobsPageObject.scrollToJobs();
    }

    @Step
    public void registrarData(List<DataModelStep> data) throws AWTException {
        choucairJobsPageObject.addDataToSearch(data);
    }

    @Step
    public void checkText(List<DataModelStep> data) {
        choucairJobsPageObject.verifySearch(data);
    }

    @Step
    public void clickOnJobOffer() {
        choucairJobsPageObject.openJobOffer();
    }

    @Step
    public void applyToJob(List<DataModelStep> data)throws AWTException{
        choucairJobsPageObject.fillForm(data);
    }

    public void checkTextOnApplyJob(List<DataModelStep> data) {
        choucairJobsPageObject.verifyCaptcha(data);

    }

    public void writeWord(String word) {
        choucairJobsPageObject.word(word);
    }

    public void checkTextNoWork(String textNoWork) {
        choucairJobsPageObject.verifyResultTextNoWork(textNoWork);
    }
}
