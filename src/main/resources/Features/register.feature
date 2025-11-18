Feature: Register Feature
  # Test Case 1
  @login
  @Before(order=1)
  Scenario: Verify that a new user can register successfully
    Given Home page is visible successfully
    When Click login button
    And Navigate to the Create Account page
    And Enter valid data
    And Click on Register button
    Then Verify that user logged in successfully
  @login
  # Test Case 2
  Scenario: Verify that an existing user can log in
    Given Home page is visible successfully
    When Click login button
    And Enter valid email and password
    And Click on Login button
    Then Verify that user logged in successfully
    Then Delete account