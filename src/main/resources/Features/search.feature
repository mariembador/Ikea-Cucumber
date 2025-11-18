Feature: Search Feature
  # Test Case 3
  Scenario: Verify that the search bar returns relevant product results
    Given Home page is visible successfully
    When Enter a product keyword in the search bar
    And Click the search icon
    Then Ensure the products displayed related to the keyword