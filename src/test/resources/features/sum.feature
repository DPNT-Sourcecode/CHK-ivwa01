Feature: SUM R1 - add two integers

  Scenario: add 2 and 2
    Given two integers 2 and 2
    When I sum the numbers
    Then the result should be 4

  Scenario: add zero and a positive number
    Given two integers 0 and 7
    When I sum the numbers
    Then the result should be 7

  Scenario: add a negative and a positive number that cancel each other
    Given two integers -5 and 5
    When I sum the numbers
    Then the result should be 0

  Scenario: add two negative numbers
    Given two integers -3 and -4
    When I sum the numbers
    Then the result should be -7

  Scenario: add a positive and a larger negative number
    Given two integers 4 and -10
    When I sum the numbers
    Then the result should be -6

  Scenario: add large positive numbers
    Given two integers 1000 and 2000
    When I sum the numbers
    Then the result should be 3000
