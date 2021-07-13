package subscriptionsplans.steps;

import subscriptionsplans.pages.SubPlanOrderDataPage;
import subscriptionsplans.pages.SubscriptionPlanPage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class SubscriptionPlansSteps extends UIInteractionSteps {
  SubscriptionPlanPage subscriptionPlanPage;
  SubPlanOrderDataPage subPlanOrderDataPage;

  @Step
  public void openSubscriptionPlansPage() {
    subscriptionPlanPage = new SubscriptionPlanPage();
    subPlanOrderDataPage = new SubPlanOrderDataPage();
  }

  @Step
  public void setSubscriptionPlansPeriod(String typeSubscriptionPlan) {
    if(typeSubscriptionPlan.equals("Monthly billing"))
      subscriptionPlanPage.selectSubscriptionPeriodMothly();
    else if(typeSubscriptionPlan.equals("Yearly billing"))
      subscriptionPlanPage.selectSubscriptionPeriodYearly();
  }

  @Step
  public String selectPaneByNumberRequestMonthly(String numberRequests) throws InterruptedException {
    int numRequests = Integer.parseInt(numberRequests);
    WebElement paneByNumRequests = null;
    String planName = null;
    if(numRequests <= 250){
      paneByNumRequests = subscriptionPlanPage.getSubscriptionFree();
    }else if(numRequests <= 10000){
      paneByNumRequests = subscriptionPlanPage.getSubscriptionBasic();
    }else if(numRequests <= 100000){
      paneByNumRequests = subscriptionPlanPage.getSubscriptionProfessional();
    }else if(numRequests <= 500000){
      paneByNumRequests = subscriptionPlanPage.getSubscriptionBusiness();
    }
    assertThat(paneByNumRequests).isNotNull();
    TimeUnit.SECONDS.sleep(2);
    System.out.println("selected options by number of requests \n" + paneByNumRequests.getText());
    //paneByNumRequests.findElement(By.xpath("//*[@class='signup_link']")).click();
    planName = paneByNumRequests.findElement(By.className("mc_header")).getText();
    System.out.println("selected plan name -" + planName);
    paneByNumRequests.findElement(By.className("signup_link")).click();
    return planName;
  }

  @Step
  public void setOrderPersonalData() throws InterruptedException {
    subPlanOrderDataPage.setEmail("test@test.test");
    subPlanOrderDataPage.setPassword("test123");
    subPlanOrderDataPage.setFirstname("Adam");
    subPlanOrderDataPage.setLastname("Cis");
    subPlanOrderDataPage.setAdress("Wawelska");
    subPlanOrderDataPage.setPostalCode("02-220");
    subPlanOrderDataPage.selectCountry("Poland");
    subPlanOrderDataPage.setState("Mazowieckie");
    subPlanOrderDataPage.setCity("Warszawa");
  }

  @Step
  public void submitPersonalDataAndSubscribe() {
    subPlanOrderDataPage.checkAgreement();
    subPlanOrderDataPage.clickCaptcha();
    subPlanOrderDataPage.clickSignUp();
  }

  @Step
  public String getNameOfSelectedPlan() {
    return subPlanOrderDataPage.getSelectedPlanName();
  }
}
