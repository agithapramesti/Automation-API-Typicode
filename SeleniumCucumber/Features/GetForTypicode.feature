@GetTypicodeFeature
Feature: Get Data for Typicode

  Scenario: Verify get typicode data is successful
    Given prepare a GET to typicode endpoint
    When send GET to typicode endpoint
    Then receive GET response successfully with response code is "200"