Feature: Products Feature
  # Test Case 4
  Scenario: Verify that clicking on a product opens the product details page
    Given Home page is visible successfully
    When Click on a random product displayed on the home page
    Then Verify that the product details page is opened
    And Ensure that product details in the home page same as in the product page

  # Test Case 5
  Scenario: Verify that a product can be added to the shopping cart
    Given Home page is visible successfully
    When Click on a lighting category on the home page
    And Go to Lamps
    And Click on Add to Bag button on a random product
    And Click on the same product and add it to the bag
    Then Ensure that quantity displayed in the bag is two

  # Test Case 6
  Scenario: Verify Add to Favorite button Functionality
    Given Home page is visible successfully
    When Add a random product to the favorite
    And Click on View button
    Then Ensure the product displayed
    And Remove the product from the favorite page