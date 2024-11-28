Feature: Verify Homepage Load

  @Test1
  Scenario: Verify that the homepage loads successfully.
    Given I am on the homepage of Urban Ladder.
    Then The page title should contain "Urban Ladder".
