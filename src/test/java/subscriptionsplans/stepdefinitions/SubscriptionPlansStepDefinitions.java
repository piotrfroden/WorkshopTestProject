package subscriptionsplans.stepdefinitions;

import io.cucumber.java.en.Then;
import subscriptionsplans.steps.SubscriptionPlansSteps;
import subscriptionsplans.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.runner.RunWith;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(CucumberWithSerenity.class)
public class SubscriptionPlansStepDefinitions extends PageObject {
  private static final String pageTitle = "Pricing | Exchange Rates API";
  private final Actor client = Actor.named("client");
  Utils utils;
  SubscriptionPlansSteps subscriptionPlansSteps;
  String requestedNamePlan = null;

  @Before
  public void setTheStage() throws Exception {
    utils = new Utils();
    System.setProperty("java.net.useSystemProxies", "true");
    utils.setUpConfiguration();
    OnStage.setTheStage(new OnlineCast());
  }

  @Given("Open Subscription Plans page")
  public void viewSubscriptionPlansPage(){
    getDriver().get(utils.url);
    client.can(BrowseTheWeb.with(getDriver()));
    subscriptionPlansSteps = new SubscriptionPlansSteps();
    subscriptionPlansSteps.openSubscriptionPlansPage();
    assertThat(getDriver().getTitle().equals(pageTitle)).isTrue();
  }

  @When("User select {string}")
  public void userSelectBillingPeriod(String billingPeriod){
    System.out.println(billingPeriod);
    subscriptionPlansSteps.setSubscriptionPlansPeriod(billingPeriod);
  }

  @When("User select {string} requests monthly and press sign up")
  public void userSelectNumberOfRequestsMonthly(String numberRequests) throws InterruptedException {
    System.out.println("Liczba requestów miesięcznie - " + numberRequests);
    requestedNamePlan = subscriptionPlansSteps.selectPaneByNumberRequestMonthly(numberRequests);
  }

  @Then("Set personal data for order")
  public void setOrderPersonalData() throws InterruptedException {
    assertThat(getDriver().getTitle().equals("Sign Up - Exchangeratesapi")).isTrue();
    TimeUnit.SECONDS.sleep(3);
    subscriptionPlansSteps.setOrderPersonalData();
  }

  @Then("Accept agreements and press Sign Up to subscribe")
  public void pressSignUpToSubscribe() {
    subscriptionPlansSteps.submitPersonalDataAndSubscribe();
  }

  @Then("Check plan for given number requests")
  public void checkPlanForGivenRequests(){
    assertThat(requestedNamePlan).isNotNull();;
    assertThat(subscriptionPlansSteps.getNameOfSelectedPlan().contains(requestedNamePlan)).isTrue();
  }

  @After
  public void closeDriver() {
    if(getDriver() != null) {
      getDriver().close();
    }
  }
}
