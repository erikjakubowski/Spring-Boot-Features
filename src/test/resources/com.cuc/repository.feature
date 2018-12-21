@txn
Feature: Finding a customer by name
  Background: Preload DB Mock Data
    Given spring-customers fixture is loaded

  Scenario: Load one customer
    Given 2 customers available
    When searching for customer by name CucUmbEr-Mr-Cuc-Umb-Er-Sr
    Then customer ssn will be 534-65-7656