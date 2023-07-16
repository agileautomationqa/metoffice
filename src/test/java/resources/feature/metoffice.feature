Feature: Met Office API
 As a user I want to verify data in the MetOffice webpage

  Scenario: Check if I can verify MetOffice siteList data
    Given I am on MetOffice Webpage
    When I send request to get all sitelist endpoint data for the daily and three-hourly forecast data
    Then  I should able to get a valid status code 200
    And I navigate sitelist and find the Location ID for "Croydon"
    And I query daily forecast data for the "Croydon" location



