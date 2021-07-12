package subscriptionsplans.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SubscriptionPlanPage extends PageObject {

  @FindBy(xpath = "//*[@data-cycle = 'monthly']")
  private WebElement checkMonthly;

  @FindBy(xpath = "//*[@data-cycle = 'yearly']")
  private WebElement checkYearly;

  @FindBy(xpath = "//*[@class = 'free']")
  private  WebElement paneFree;

  @FindBy(xpath = "//*[@class = 'basic']")
  private  WebElement paneBasic;

  @FindBy(xpath = "//*[@class = 'professional highlighted']")
  private  WebElement paneProfessional;

  @FindBy(xpath = "//*[@class = 'business']")
  private  WebElement paneBusiness;

  WebDriverWait wdWait;

  public SubscriptionPlanPage() {
    PageFactory.initElements(getDriver(), this);
    wdWait = (new WebDriverWait(getDriver(), 10));
  }

  public void selectSubscriptionPeriodMothly() {
    wdWait.until(ExpectedConditions.elementToBeClickable(checkMonthly)).click();
  }

  public void selectSubscriptionPeriodYearly() {
    wdWait.until(ExpectedConditions.elementToBeClickable(checkYearly)).click();
  }

  public WebElement getSubscriptionFree() {
    return wdWait.until(ExpectedConditions.visibilityOf(paneFree));
  }

  public WebElement getSubscriptionBasic() {
    return wdWait.until(ExpectedConditions.visibilityOf(paneBasic));
  }

  public WebElement getSubscriptionProfessional() {
    return wdWait.until(ExpectedConditions.visibilityOf(paneProfessional));
  }

  public WebElement getSubscriptionBusiness() {
    return wdWait.until(ExpectedConditions.visibilityOf(paneBusiness));
  }
}
