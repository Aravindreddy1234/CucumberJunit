
@All
Feature: Values Validation

@CountValidation
Scenario: Values count validation

Given the user is on homepage
When the user finds the count of the values
Then the user validates the count as '5'

@ValuesGreaterThanZero
Scenario: All Values greater than zero and sum equals to all individual values

Given the user is on homepage
When the user fetches list of values
Then the user validates that all the values are greater than zero
And the user validates that toatl sum value is equals to all values added

@CurrencyFormatting
Scenario: Currencies are formatted validation

Given the user is on homepage
When the user fetches all currencies
Then the user validates that all the values are currency formatted
