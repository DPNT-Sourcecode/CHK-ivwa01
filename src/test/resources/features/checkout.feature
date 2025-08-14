Feature: CHK R1 - Supermarket checkout

  Scenario: Calculate total for a single item A
    Given a basket with item "A"
    When I calculate the total
    Then the total should be 50