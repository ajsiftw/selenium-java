package pages;

import org.openqa.selenium.By;

public class PracticeFormPage extends BasePage {

    private static final By menuForms = By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/span/div/div[1]");
    private static final By menuPracticeForm = By.xpath("//*[contains(text(),'Practice Form')]");
    private static final By txtFirstName = By.id("firstName");
    private static final By txtLastName = By.id("lastName");
    private static final By txtEmail = By.id("userEmail");
    private static final By radioGenderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private static final By radioGenderFemale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private static final By radioGenderOther = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label");
    private static final By txtMobile = By.id("userNumber");
    private static final By calendarDateOfBirth = By.id("dateOfBirthInput");
    private static final By calendarMonth = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select");
    private static final By calendarYear = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select");
    private static final By calendarDay = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[3]");
    private static final By txtSubjects = By.id("subjectsInput");
    private static final By checkboxHobbiesSports = By.cssSelector("label[for='hobbies-checkbox-1']");
    private static final By checkboxHobbiesReading = By.cssSelector("label[for='hobbies-checkbox-1']");
    private static final By checkboxHobbiesMusic = By.cssSelector("label[for='hobbies-checkbox-1']");
    private static final By uploadPicture = By.id("uploadPicture");
    private static final By txtCurrentAddress = By.id("currentAddress");
    private static final By selectState = By.id("react-select-3-input");
    private static final By selectCity = By.id("react-select-4-input");
    private static final By buttonSubmit = By.id("submit");

    public void clickForms() {
        click(menuForms);
    }

    public void clickPracticeForm() {
        click(menuPracticeForm);
    }

    public void addFirstName(String firstName) {
        enterText(txtFirstName, firstName);
    }

    public void addLastName(String lastName) {
        enterText(txtLastName, lastName);
    }

    public void addEmail(String email) {
        enterText(txtEmail, email);
    }

    public void clickGenderMale() {
        click(radioGenderMale);
    }

    public void clickGenderFemale() {
        click(radioGenderFemale);
    }

    public void clickGenderOther() {
        click(radioGenderOther);
    }

    public void addMobile(String mobile) {
        enterText(txtMobile, mobile);
    }

    public void addDateOfBirth(String year, String month) {
        click(calendarDateOfBirth);
        selectByVisibleText(calendarMonth, month);
        selectByVisibleText(calendarYear, year);
        click(calendarDay);
    }

    public void addSubject(String subjects) {
        enterTextPressEnter(txtSubjects, subjects);
    }

    public void clickHobbiesSports() {
        click(checkboxHobbiesSports);
    }

    public void clickHobbiesReading() {
        click(checkboxHobbiesReading);
    }

    public void clickHobbiesMusic() {
        click(checkboxHobbiesMusic);
    }

    public void clickUploadPicture() {
        uploadFile(uploadPicture);
    }

    public void addCurrentAddress(String currentAddress) {
        enterText(txtCurrentAddress, currentAddress);
    }

    public void selectState(String state) {
        enterTextPressEnter(selectState, state);
    }

    public void selectCity(String city) {
        enterTextPressEnter(selectCity, city);
    }

    public void clickSubmit() {
        click(buttonSubmit);
    }

}
