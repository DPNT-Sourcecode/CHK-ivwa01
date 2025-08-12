@r1
Feature: HLO R1 - say hello

 Scenario Outline: greet a person by name
  Given a friend named "<name>"
  When I say hello
  Then the message should be "<message>"

  Examples:
   | name      | message       |
   | Alice     | Hello, World! |
   | Bob       | Hello, World! |
   | John      | Hello, World! |
   | ""        | Hello, World! |
   | Craftsman | Hello, World! |
   | Mr. X     | Hello, World! |
