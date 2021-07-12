Feature: User want to create free subscriptions plan

  Scenario: User open subscription plans page
      Given Open Subscription Plans page
       When User select 'Monthly billing'
        And User select '250' requests monthly and press sign up
       Then Check plan for given number requests
        And Set personal data for order
        And Accept agreements and press Sign Up to subscribe

  Scenario: User open subscription plans page
    Given Open Subscription Plans page
    When User select 'Yearly billing'
    And User select '250' requests monthly and press sign up
    Then Check plan for given number requests
    And Set personal data for order
    And Accept agreements and press Sign Up to subscribe
