Feature: HLO R2 - say hello to friend

 Scenario Outline: greet friend by name
  Given a friend named "<name>"
  When I say hello
  Then the message should be "Hello, <name>"

  Examples:
   | name      |
   | Alice     |
   | Bob       |
   | John      |
   | ""        |
   | Craftsman |
   | Mr. X     |