Feature: User want to create free subscriptions plan

  Scenario Outline: User open subscription plans page
    Given Open Subscription Plans page
    When User select '<billingPeriod>'
    And User select '<numberRequests>' requests monthly and press sign up
    Then Check plan for given number requests
    And Set personal data for order
    And Accept agreements and press Sign Up to subscribe

    Examples:
      | billingPeriod | numberRequests |
      | Monthly Billing | 0 |
      | Monthly Billing | 250 |
      | Monthly Billing | 10000 |
      | Monthly Billing | 100000 |
      | Monthly Billing | 500000 |
      | Monthly Billing | 500001 |
      | Yearly Billing  | 0 |
      | Yearly Billing  | 250 |
      | Yearly Billing  | 10000 |
      | Yearly Billing  | 100000 |
      | Yearly Billing  | 500000 |
      | Yearly Billing  | 500001 |
