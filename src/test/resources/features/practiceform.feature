Feature: Practice Form

  Background: Initial Practice Form Steps
    Given User opens URL "https://demoqa.com/login"

  Scenario: Submit Student Registration Form
    When User enters username as "ajsiftw" and password as "Password123!"
    And User clicks login
    Then Page title should be "DEMOQA"
    When User clicks on forms
    And User clicks on practice form
    Then Page contains text "Student Registration Form"
    When User enters first name as "George" and last name as "Radu"
    And User enters email as "super_email@gmail.com"
    And User selects a gender as "male"
    And User enters his phone number as "0777123456"
    And User select his birth date as year "1986" month "December" day 23rd
    And User adds his subjects as "Physics"
    And User selects his hobbies as "sports"
    And User uploads a picture
    And User adds his address as "Super Street 1, Building 2, Ap 3"
    And User selects a state as "NCR" and a city as "Delhi"
    And User clicks submit
    Then Page contains text "Thanks for submitting the form"

  Scenario Outline: Submit Student Registration Form Data Driven
    When User enters username as "<user>" and password as "<password>"
    And User clicks login
    Then Page title should be "DEMOQA"
    When User clicks on forms
    And User clicks on practice form
    Then Page contains text "Student Registration Form"
    When User enters first name as "<firstName>" and last name as "<lastName>"
    And User enters email as "<email>"
    And User selects a gender as "<gender>"
    And User enters his phone number as "<mobile>"
    And User select his birth date as year "<birthYear>" month "<birthMonth>" day 23rd
    And User adds his subjects as "<subject>"
    And User selects his hobbies as "<hobbies>"
    And User uploads a picture
    And User adds his address as "<address>"
    And User selects a state as "<state>" and a city as "<city>"
    And User clicks submit
    Then Page contains text "Thanks for submitting the form"

    Examples:
      | user    | password     | firstName | lastName | email          | gender | mobile     | birthYear | birthMonth | subject   | hobbies | address                                | state         | city   |
      | ajsiftl | Password123! | Georgiana | Radu     | hehe@gmail.com | female | 0727867423 | 1990      | January    | Maths     | Reading | Super Street 11, Building 22, Ap 33    | Uttar Pradesh | Agra   |
      | ajsiftd | Password123! | Alex      | Radu     | haha@gmail.com | other  | 0727867424 | 1995      | July       | Chemistry | Music   | Super Street 111, Building 222, Ap 333 | Haryana       | Karnal |