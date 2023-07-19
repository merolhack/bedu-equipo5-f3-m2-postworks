Feature: Add interviewers

  Scenario: Add a new interviewer
    Given name, lastName and email
    When the interviewer name is Lenin, lastName is lenin@meza.com, email is lenin@meza.com and isActive is set to true
    Then the interviewer should be created
