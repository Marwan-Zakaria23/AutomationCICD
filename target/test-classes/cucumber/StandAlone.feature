
@tag
Feature: Purchase the order from Ecomrce Website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page

  @Regression
Scenario Outline: positive test of submitting order

Given Logged in with username "<username>" and password "<password>"

When I add the product "<productname>"  to cart

And checkout the cart with product "<productname>" and submit it

Then "THANKYOU FOR THE ORDER." message is displayed



Examples:

| username | password | productname |

| marwan9@gmail.com | Marwan@239 | ADIDAS ORIGINAL |


  
   
   
   
