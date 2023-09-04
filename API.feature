Feature: Testing the API Framework

  Background: 
    Given User add the BaseURI and access token and get theRequestSpecification object

  Scenario: Test HTTP POST request
    Given User add "POST" BasePath
    And User add content type Header and Request Body for "POST" request
    Then user select the HTTP POST request
    And user capture Repository Name
    And user validate StatusCode as 201 and StatusLine as "HTTP/1.1 201 Created"
    And user validate the Response Header
    And User validate Response Body
