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

  @r2
  Scenario Outline: CHK_R2 - Basic and special offer pricing
    Given a basket with items "<items>"
    When I calculate the total
    Then the total should be <total>
    Examples:
      | items                | total |
      | A                    | 50    |
      | AAA                  | 130   |
      | AAAAA                | 200   |
      | AAAAAA               | 250   |
      | AAAAAAAA             | 330   |
      | B                    | 30    |
      | BB                   | 45    |
      | E                    | 40    |
      | EE                   | 80    |
      | EEB                  | 80    |
      | EEBB                 | 110   |
      | EEEEBB               | 160   |
      | ABCDE                | 155   |
      | AAAAAEEBAA           | 310   |
      | a                    | -1    |
      | ABCDEF               | -1    |
      | ""                   | -1    |