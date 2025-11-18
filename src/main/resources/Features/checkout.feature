Feature: CheckOut Feature
  # Test Case 7
  Scenario: Verify User Cannot Place Order Without OTP Verification
  Given Home page is visible successfully
  When Add a random product to the bag
  And Click on View button
  And Go to checkout & fill billing address fields
  And Choose delivery date and time
  And Choose payment method & place order
  Then Ensure OTP message displayed