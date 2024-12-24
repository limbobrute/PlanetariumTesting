Feature: User Story 4
  Users should be able to add new findings

 Scenario Outline:Testing restrictions on types of images the user can upload
   Given The user is on the Home page
   When  The user clicks the add finding link
   When The user enters a "<Planet name>"
   And  The user submits a photo file of "<photo type>" type
   And  The user submits the data
   Then The user gets a "<result>" browser alert

 Examples:
   |Planet name|photo type|result                           |
   |Equinox    |.jpg      |Accepted data                    |
   |Chroma     |.png      |Accepted data                    |
   |Da-gath    |.webp     |Browser Alert: Invalid photo type|

 Scenario Outline:Testing to make sure the requirements for unique names with certain restrictions
   Given The user is on the Home page
   When  The user clicks the add finding link
   When The user enters a "<Planet name>"
   And  The user submits the data
   Then The user gets a "<Result>" and returned to the home page

 Examples:
   |Planet name                  |Result                                        |
   |Lavos                        |Data added                                    |
   |Da-gath                      |Browser Alert: Invalid Planet Name            |
   |Garuda!                      |Browser Alert: Invalid Planet Name            |
   |WhySoManyOptionsJustChooseOne|Browser Alert: Too many characters            |