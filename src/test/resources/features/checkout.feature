Feature: CHK R1 - Supermarket checkout

  @r1
  Scenario: Calculate total for a single item - A
    Given a basket with item "A"
    When I calculate the total
    Then the total should be 50

  @r1
  Scenario: Calculate total for multiple items - no offers
    Given a basket with items "ABC"
    When I calculate the total
    Then the total should be 100

  @r1
  Scenario: Calculate total for special offer - A
    Given a basket with items "AAA"
    When I calculate the total
    Then the total should be 130

  @r1
  Scenario: Calculate total for special offer - B
    Given a basket with items "BBB"
    When I calculate the total
    Then the total should be 75

  @r1
  Scenario: Calculate total for special offers - Mixed items ABC
    Given a basket with items "AAABB"
    When I calculate the total
    Then the total should be 175

  @r1
  Scenario: Invalid input
    Given a basket with items "XYZ"
    When I calculate the total
    Then the total should be -1

  @r1
  Scenario: No items
    Given a basket with items ""
    When I calculate the total
    Then the total should be -1