
@tag
Feature: Error validation on login with incorrect details
  I want to use this template for my feature file

 

  @ErrorValidation
  Scenario Outline: Error Validation
    Given I landed on ECOOM page
    Given I want to login with username<name> and password<password>
    
    Then "Incorrect email or password." message is displayed

    
      Examples: 
      | name              | password   |
      | ravitest@gmail.com| Ravirama@1 | 
