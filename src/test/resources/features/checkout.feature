Feature: CHK R1 - Supermarket checkout

  Scenario: Calculate total for a single item - A
    Given a basket with item "A"
    When I calculate the total
    Then the total should be 50

  Scenario: Calculate total for multiple items - no offers
    Given a basket with items "ABC"
    When I calculate the total
    Then the total should be 115

  Scenario: Calculate total for special offer - A
    Given a basket with items "AAA"
    When I calculate the total
    Then the total should be 130

  Scenario: Calculate total for special offer - B
    Given a basket with items "BBB"
    When I calculate the total
    Then the total should be 55

  Scenario: Calculate total for special offers - Mixed items ABC
    Given a basket with items "ABC"
    When I calculate the total
    Then the total should be 155

  Scenario: Invalid input
    Given a basket with items "XYZ"
    When I calculate the total
    Then the total should be -1

  Scenario: No items
    Given a basket with items ""
    When I calculate the total
    Then the total should be -1