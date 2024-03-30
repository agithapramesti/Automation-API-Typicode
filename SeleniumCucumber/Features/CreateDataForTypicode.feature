@CreateTypicodeFeature
Feature: Create Data for Typicode

  #-------------------------- Positive Testcase --------------------------
  Scenario: Verify create typicode data with valid request is successful
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "12"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And create response with title should be "recommendation"
    And create response with body should be "motorcycle"
    And create response with userId should be "12"
    And create response with id is not NULL

  #-------------------------- Negative Testcase --------------------------
  Scenario Outline: Verify create typicode data with duplicate request
    Given prepare create request data with title is "<title>"
    When prepare create request data with body is "<body>"
    And prepare create request data with userId is "<userId>"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "<responseCode>"
    And create response with title should be "<title>"
    And create response with body should be "<body>"
    And create response with userId should be "<userId>"
    And create response with id is not NULL
    Examples:
    | title          | body       | userId | responseCode |
    | recommendation | motorcycle | 12     | 201          |
    | recommendation | motorcycle | 12     | 201          |

  Scenario: Verify create typicode data with id is exist
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "12"
    And prepare create request data with id is "1"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"

  Scenario: Verify create typicode data with title is empty
    Given prepare create request data with title is ""
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "12"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And create response with title should be ""

  Scenario: Verify create typicode data with body is empty
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is ""
    And prepare create request data with userId is "12"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And create response with body should be ""

  Scenario: Verify create typicode data with userId is zero
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "0"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And prepare create request data with userId is "0"

  Scenario: Verify create typicode data with title is null
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "12"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And create response with title is null

  Scenario: Verify create typicode data with body is null
    Given prepare create request data with title is "recommendation"
    And prepare create request data with userId is "12"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And create response with body is null

  Scenario: Verify create typicode data with userId is null
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userIdNull is "true"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And create response with userId is null

  Scenario: Verify create typicode data with userId with long digit
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "1000000000000000000000"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And prepare create request data with userId is "1e+21"

  Scenario: Verify create typicode data with userId in decimal
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "1.0"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And prepare create request data with userId is "1"

  Scenario: Verify create typicode data with userId minus
    Given prepare create request data with title is "recommendation"
    When prepare create request data with body is "motorcycle"
    And prepare create request data with userId is "-1"
    And send post to typicode endpoint
    Then receive create response successfully with response code is "201"
    And prepare create request data with userId is "-1"