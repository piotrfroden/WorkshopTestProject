Feature: User want to create free subscriptions plan

  Scenario: User open subscription plans page
      Given Open Subscription Plans page
       When User select 'Monthly billing'
        And User select '500001' requests monthly and press sign up
       Then Check plan for given number requests

  Scenario: User open subscription plans page
    Given Open Subscription Plans page
    When User select 'Yearly billing'
    And User select '500001' requests monthly and press sign up
    Then Check plan for given number requests
