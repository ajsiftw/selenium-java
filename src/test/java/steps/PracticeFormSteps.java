package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.PracticeFormPage;
import utils.DriverManager;
import java.util.Objects;

public class PracticeFormSteps {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @When("User clicks on forms")
    public void user_clicks_on_forms() {
        practiceFormPage.clickForms();
    }

    @When("User clicks on practice form")
    public void user_clicks_on_practice_form() {
        practiceFormPage.clickPracticeForm();
    }

    @Then("Page contains text {string}")
    public void page_contains(String text) {
        Assert.assertTrue(Objects.requireNonNull(DriverManager.getDriver().getPageSource()).contains(text));
    }

    @When("User enters first name as {string} and last name as {string}")
    public void user_enters_first_name_as_and_last_name_as(String firstName, String lastName) {
        practiceFormPage.addFirstName(firstName);
        practiceFormPage.addLastName(lastName);
    }

    @When("User enters email as {string}")
    public void user_enters_email_as(String email) {
        practiceFormPage.addEmail(email);
    }

    @When("User selects a gender as {string}")
    public void user_selects_a_gender_as(String gender) {
        switch (gender) {
            case "male" -> practiceFormPage.clickGenderMale();
            case "female" -> practiceFormPage.clickGenderFemale();
            case "other" -> practiceFormPage.clickGenderOther();
            default -> practiceFormPage.clickGenderOther();
        }
    }

    @When("User enters his phone number as {string}")
    public void user_enters_his_phone_number_as(String mobile) {
        practiceFormPage.addMobile(mobile);
    }

    @When("User select his birth date as year {string} month {string} day 23rd")
    public void user_select_his_birth_date_as_year_month_day(String year, String month) {
        practiceFormPage.addDateOfBirth(year, month);
    }

    @When("User adds his subjects as {string}")
    public void user_adds_his_subjects_as(String subjects) {
        practiceFormPage.addSubject(subjects);
    }

    @When("User selects his hobbies as {string}")
    public void user_selects_his_hobbies_as(String hobbies) {
        switch (hobbies) {
            case "sports" -> practiceFormPage.clickHobbiesSports();
            case "reading" -> practiceFormPage.clickHobbiesReading();
            case "music" -> practiceFormPage.clickHobbiesMusic();
            default -> practiceFormPage.clickHobbiesReading();
        }
    }

    @When("User uploads a picture")
    public void user_uploads_a_picture() {
        practiceFormPage.clickUploadPicture();
    }

    @When("User adds his address as {string}")
    public void user_adds_his_address_as(String currentAddress) {
        practiceFormPage.addCurrentAddress(currentAddress);
    }

    @When("User selects a state as {string} and a city as {string}")
    public void user_selects_a_state_as_and_a_city_as(String state, String city) {
        practiceFormPage.selectState(state);
        practiceFormPage.selectCity(city);
    }

    @When("User clicks submit")
    public void user_clicks_submit() {
        practiceFormPage.clickSubmit();
    }

}
