Feature: Data table examples
  As a Cucumber scholar
  I want to learn more about using data tables as arguments
  So I can write better executable specifications

  Scenario: Listing football club stadiums - the verbose way
    Given Juventus play their home games at Allianz Stadium
    And AC Milan play their home games at San Siro
    And AS Roma play their home games at Stadio Olimpico

  Scenario: Listing football club stadiums - the clear way
    Given the following clubs and their stadiums
      | Juventus | Allianz Stadium |
      | AC Milan | San Siro        |
      | AS Roma  | Stadio Olimpico |

  Scenario: Listing football squad players - the verbose way
    Given Cristiano Ronaldo of Portugal, born on 05-02-1985, plays for Juventus since the 2018/2019 season
    And Matthijs de Ligt of the Netherlands, born on 12-08-1999, plays for Juventus since the 2019/2020 season
    And Giorgio Chiellini of Italy, born on 14-08-1984, plays for Juventus since the 2005/2006 season

  Scenario: Listing football squad players - the clear way
    Given the following Juventus players
      | name              | nationality     | dateOfBirth | atJuventusSince |
      | Cristiano Ronaldo | Portugal        | 05-02-1985  | 2018/2019       |
      | Matthijs de Ligt  | the Netherlands | 12-08-1999  | 2019/2020       |
      | Giorgio Chiellini | Italy           | 14-08-1984  | 2005/2006       |

  Scenario: Listing historic football match results - the verbose way
    Given the final result of the Derby d'Italia played on 17-01-2021 was Internazionale 2, Juventus 0
    And the final result of the Derby d'Italia played on 08-03-2020 was Internazionale 0, Juventus 2
    And the final result of the Derby d'Italia played on 06-10-2019 was Internazionale 1, Juventus 2

  Scenario: Listing historic football match results - the clear way
    Given the following historic Derby d'Italia results
      |            | Internazionale | Juventus |
      | 17-01-2021 | 2              | 0        |
      | 08-03-2020 | 0              | 2        |
      | 06-10-2019 | 1              | 2        |