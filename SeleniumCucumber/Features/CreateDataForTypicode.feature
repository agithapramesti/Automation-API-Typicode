@CreateTypicodeFeature
Feature: Create Data for Typicode

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