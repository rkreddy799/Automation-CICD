
@tag
Feature: Purchase order from Ecomm website
  I want to use this template for my feature file
  
  Background:
  Given I landed on ECOOM page
  

  @Regression
  Scenario: Positive test of Submitting order
    Given I want to login with username<name> and password<password>
    When Add Product <product> to cart
    And checkout <product>and Submit the order
    Then "Thank you for the order." message displayed on confirmation page
    

    Examples: 
      | name              | password    | product  |
      | ravitest@gmail.com| Ravirama@12 | ZARA COAT 3 |
    
