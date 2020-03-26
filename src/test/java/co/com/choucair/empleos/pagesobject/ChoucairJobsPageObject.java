package co.com.choucair.empleos.pagesobject;

import co.com.choucair.empleos.steps.DataModelStep;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@DefaultUrl("https://www.choucairtesting.com/")
public class ChoucairJobsPageObject extends PageObject {

    @FindBy(xpath = "//li[@id='menu-item-550']//a[contains(text(),'Empleos')]")
    WebElementFacade CLICK_JOBS;

    @FindBy(xpath = "//ul[@class='job_listings']")
    WebElementFacade SCROLL_TO_JOBS_SECTION;

    @FindBy(id = "search_keywords")
    WebElementFacade ENTER_KEY_WORD;

    @FindBy(id = "search_location")
    WebElementFacade ENTER_LOCATION;

    @FindBy(className = "search_submit")
    WebElementFacade BUTTON_SEARCH_JOBS;

    @FindBy(xpath = "//ul[@class='job_listings']/li")
    WebElementFacade ANSWER;

    @FindBy(xpath = "//div[@class='location']")
    WebElementFacade ANSWER_LOCATION;

    @FindBy(xpath = "//li[@class='post-387 job_listing type-job_listing status-publish has-post-thumbnail hentry job_position_featured']//a")
    WebElementFacade JOB_OFFER;

    @FindBy(id = "cookie_action_close_header")
    WebElementFacade ACEPT_COOKIES;

    @FindBy(xpath = "//input[contains(@class,'application_button button')]")
    WebElementFacade BUTTON_SING_UP_FOR_WORK;

    @FindBy(name = "your-name")
    WebElementFacade ENTER_NAME;

    @FindBy(name = "your-email")
    WebElementFacade ENTER_EMAIL;

    @FindBy(name = "tel")
    WebElementFacade ENTER_PHONE;

    @FindBy(name = "estudios")
    WebElementFacade ENTER_STUDIES;

    @FindBy(name = "exp")
    WebElementFacade ENTER_EXPERIENCE;

    @FindBy(name = "auto")
    WebElementFacade ENTER_YOUR_KNOWS_OF_AUTOMATION;

    @FindBy(name = "salario")
    WebElementFacade ENTER_YOUR_WAGE_WISH;

    @FindBy(name = "curso")
    WebElementFacade SELECT_AVAILABILITY;

    @FindBy(name = "your-message")
    WebElementFacade ENTER_MESSAGE;

    @FindBy(xpath = "//input[@name='file-736']")
    WebElementFacade UPLOAD_FILE;

    @FindBy(xpath = "//input[@class='wpcf7-form-control wpcf7-submit']")
    WebElementFacade BUTTON_SEND;

    @FindBy(xpath = "//span[contains(text(),'Por favor verifica el captcha')]")
    WebElementFacade CAPTCHA;

    @FindBy(className = "no_job_listings_found")
    WebElementFacade NO_WORK_FOR_THE_SEARCH;




    public void openJobsModule() {
        CLICK_JOBS.click();
    }

    public void scrollToJobs() {
        Scroll.to(SCROLL_TO_JOBS_SECTION);
    }

    public void addDataToSearch(List<DataModelStep> data) throws AWTException {
        ENTER_KEY_WORD.sendKeys(data.get(0).getKeyword());
        BUTTON_SEARCH_JOBS.click();
    }

    public void verifySearch(List<DataModelStep> data) {
        assertThat(ANSWER.getText(), containsString(data.get(0).getResult()));
    }

    public void openJobOffer() {
        Scroll.to(SCROLL_TO_JOBS_SECTION);

        ACEPT_COOKIES.click();
        JOB_OFFER.click();
        Scroll.to(BUTTON_SING_UP_FOR_WORK);
        BUTTON_SING_UP_FOR_WORK.click();
    }

    public void fillForm(List<DataModelStep> data) {
        ENTER_NAME.sendKeys(data.get(0).getName());
        ENTER_EMAIL.sendKeys(data.get(0).getEmail());
        ENTER_PHONE.sendKeys(data.get(0).getPhone());
        ENTER_STUDIES.sendKeys(data.get(0).getStudies());
        ENTER_EXPERIENCE.sendKeys(data.get(0).getExperience());
        ENTER_YOUR_KNOWS_OF_AUTOMATION.sendKeys(data.get(0).getKnowAboutAutomation());
        ENTER_YOUR_WAGE_WISH.sendKeys(data.get(0).getWageAspiration());

        SELECT_AVAILABILITY.click();
        List<WebElement> listOptionsP = getDriver().findElements(By.tagName("option"));
        for (int i = 0; i < listOptionsP.size(); i++) {
            if (listOptionsP.get(i).getText().equals(data.get(0).getAvailability())) {
                listOptionsP.get(i).click();
                break;
            }
        }
        ENTER_MESSAGE.sendKeys(data.get(0).getAdditionalMessage());
        BUTTON_SEND.click();
    }

    public void verifyCaptcha(List<DataModelStep> data) {
        assertThat(CAPTCHA.getText(), containsString(data.get(0).getResultText()));
    }

    public void word(String word) {
        ENTER_KEY_WORD.sendKeys(word);
        BUTTON_SEARCH_JOBS.click();
    }

    public void verifyResultTextNoWork(String textNoWork) {
        assertThat(NO_WORK_FOR_THE_SEARCH.getText(), containsString(textNoWork));
    }

    public void writeDataToBothFields(List<DataModelStep> data) {
        ENTER_KEY_WORD.sendKeys(data.get(0).getKeyword());
        ENTER_LOCATION.sendKeys(data.get(0).getLocation());
        BUTTON_SEARCH_JOBS.click();
    }

    public void verifyKeyWord(String keyWord) {
        assertThat(keyWord, containsText(ANSWER.getText()));
    }

    public void verifyLocation(String location) {
        assertThat(location, containsText(ANSWER_LOCATION.getText()));
    }
}
