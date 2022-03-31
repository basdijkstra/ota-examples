Feature: Data table types examples
  As a Cucumber scholar
  I want to learn more about converting data tables to types
  So I can process data tables more efficiently

  Scenario: Listing book details
    Given the following books
      | title                           | author              | yearOfPublishing |
      | To kill a mockingbird           | Harper Lee          | 1960             |
      | The catcher in the rye          | J.D. Salinger       | 1951             |
      | The great Gatsby                | F. Scott Fitzgerald | 1925             |
      | The life of Lazarillo de Tormes | [anonymous]         | 1544             |
    When I do nothing
    Then I expect to have the following books
      | title                           | author              | yearOfPublishing |
      | The life of Lazarillo de Tormes | [anonymous]         | 1544             |
      | The great Gatsby                | F. Scott Fitzgerald | 1925             |
      | To kill a mockingbird           | Harper Lee          | 1960             |
      | The catcher in the rye          | J.D. Salinger       | 1951             |
