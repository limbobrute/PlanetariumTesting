Feature: User Story 1
  As a new user, a person should be able to open an account to
  save celestial findings

  Scenario Outline: Testing for valid New Credentials
    Given The user is on the login page
    Then The user clicks the register link
    When the user provides a valid "<username>"
    And the user provides a "<password>"
    When The user submits the credentials
    Then The user should get a browser alert saying "<Expected result>"

  Examples:
    |username                         |password                     |Expected result         |
    |Excal-ibur_2012                  |Harr-ow_2017                 |Account Creation Success|
    |Limbo                            |Harr-ow_2017                 |Invalid username alert  |
    |Mesa                             |Harr-ow_2017                 |Invalid username alert  |
    |Trinity_andExcalibur_best_friends|Harr-ow_2017                 |Invalid username alert  |
    |2014Hydriod                      |Harr-ow_2017                 |Invalid username alert  |
    |Limbo!!                          |Harr-ow_2017                 |Invalid username alert  |
    |Excal-ibur_2012                  |L0ki                         |Invalid password alert  |
    |Excal-ibur_2012                  |LimboIsTheBestWarframeForever|Invalid password alert  |
    |Excal-ibur_2012                  |3quinox                      |Invalid password alert  |
    |Excal-ibur_2012                  |Atlas1sTher0ck!!             |Invalid password alert  |
    |Excal-ibur_2012                  |atlas2019                    |Invalid password alert  |
    |Excal-ibur_2012                  |ATLAS2019                    |Invalid password alert  |
    |Excal-ibur_2012                  |Ash                          |Invalid password alert  |