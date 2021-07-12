Feature: User want to create free subscriptions plan

  Scenario: User open subscription plans page
      Given Open Subscription Plans page
       When User select 'Monthly billing'
        And User select '100000' requests monthly and press sign up
        And Set personal data for order
        And Accept agreements and press Sign Up to subscribe
