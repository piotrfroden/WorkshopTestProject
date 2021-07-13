package subscriptionsplans.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SubPlanOrderDataPage extends PageObject {

  @FindBy(name = "email_address")
  private WebElement txtEmail;

  @FindBy(name = "password")
  private WebElement txtPassword;

  @FindBy(name = "first_name")
  private WebElement txtFirstname;

  @FindBy(name = "last_name")
  private WebElement txtLastname;

  @FindBy(name = "address")
  private WebElement txtAdress;

  @FindBy(name = "post_code")
  private WebElement txtPostalCode;

  @FindBy(name = "country_code")
  private WebElement txtCountry;

  @FindBy(name = "state")
  private WebElement txtState;

  @FindBy(name = "city")
  private WebElement txtCity;

  @FindBy(name = "tos_accepted")
  private WebElement checkboxAgreement;

  @FindBy(xpath = "//input[@name = 'submit']")
  private WebElement buttonSignUp;

  @FindBy(xpath = "//h2[contains(text(), 'Sign Up: ')]")
  private WebElement namePlan;

  @FindBy(xpath = "//*[@class='recaptcha-checkbox-border']")
  private WebElement checkboxCaptcha;

  WebDriverWait wdWait;

  public SubPlanOrderDataPage() {
    PageFactory.initElements(getDriver(), this);
    wdWait = (new WebDriverWait(getDriver(), 10));
  }

  public void setEmail(String email) {
    wdWait.until(ExpectedConditions.visibilityOf(txtEmail)).sendKeys(email);
  }

  public void setPassword(String password) {
    wdWait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(password);
  }

  public void setFirstname(String firstname) {
    wdWait.until(ExpectedConditions.visibilityOf(txtFirstname)).sendKeys(firstname);
  }

  public void setLastname(String lastname) {
    wdWait.until(ExpectedConditions.visibilityOf(txtLastname)).sendKeys(lastname);
  }

  public void setAdress(String adress) {
    wdWait.until(ExpectedConditions.visibilityOf(txtAdress)).sendKeys(adress);
  }

  public void setPostalCode(String postalCode) {
    wdWait.until(ExpectedConditions.visibilityOf(txtPostalCode)).sendKeys(postalCode);
  }

  public void selectCountry(String country) {
    wdWait.until(ExpectedConditions.visibilityOf(txtCountry)).sendKeys(country);
  }

  public void setState(String state) {
    wdWait.until(ExpectedConditions.visibilityOf(txtState)).sendKeys(state);
  }

  public void setCity(String city) {
    wdWait.until(ExpectedConditions.visibilityOf(txtCity)).sendKeys(city);
  }

  public void checkAgreement() {
    wdWait.until(ExpectedConditions.elementToBeClickable(checkboxAgreement)).click();
  }

  public void clickSignUp() {
    wdWait.until(ExpectedConditions.visibilityOf(buttonSignUp)).click();
  }

  public String getSelectedPlanName() {
    return wdWait.until(ExpectedConditions.visibilityOf(namePlan)).getText();
  }

  public void clickCaptcha() {
    wdWait.until(ExpectedConditions.visibilityOf(checkboxCaptcha)).click();
  }
}
