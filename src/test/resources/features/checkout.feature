Feature: Supermarket Checkout
  Tests for calculating the total price of items in a basket with special offers.

  @r1
  Scenario: No items
    Given a basket with items ""
    When I calculate the total
    Then the total should be -1

  @r1
  Scenario Outline: CHK_R1 - Basic and special offer pricing
    Given a basket with items "<items>"
    When I calculate the total
    Then the total should be <total>
    Examples:
      | items                | total |
      | A                    | 50    |
      | B                    | 30    |
      | C                    | 20    |
      | D                    | 15    |
      | AA                   | 100   |
      | AAA                  | 130   |
      | AAAA                 | 180   |
      | AAAAA                | 230   |
      | AAAAAA               | 260   |
      | BB                   | 45    |
      | BBB                  | 75    |
      | BBBB                 | 90    |
      | ABCD                 | 115   |
      | AAABB                | 175   |
      | ABCDCBAABCABBAAA     | 505   |
      | a                    | -1    |
      | ABCa                 | -1    |
      | -                    | -1    |

  @r2
  Scenario Outline: CHK_R2 - Basic and special offer pricing
    Given a basket with items "<items>"
    When I calculate the total
    Then the total should be <total>
    Examples:
      | items                | total |
      | A                    | 50    |
      | B                    | 30    |
      | C                    | 20    |
      | D                    | 15    |
      | E                    | 40    |
      | AA                   | 100   |
      | AAA                  | 130   |
      | AAAAA                | 200   |
      | AAAAAA               | 250   |
      | AAAAAAAA             | 330   |
      | BB                   | 45    |
      | BBB                  | 75    |
      | EEEEBB               | 160   |
      | EEB                  | 80    |
      | EEBB                 | 110   |
      | ABCDE                | 155   |
      | AAAAAEEBAA           | 310   |
      | a                    | -1    |
      | ABCDEF               | -1    |
      | -                    | -1    |
      |                      | 0     |