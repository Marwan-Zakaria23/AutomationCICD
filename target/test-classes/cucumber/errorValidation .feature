
@tag
Feature: errorValidation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
   Given I landed on Ecommerce Page
   When Logged in with username "<username>" and password "<password>"
    Then "Incorrect email or password." error message is displayed .

Examples:

| username | password |

| marwan9@gmail.com | Marwan@23 | 