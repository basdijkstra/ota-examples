package stepdefinitions;

import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DataTablesSteps {

    @Given("^(.*) play their home games at (.*)$")
    public void club_play_their_home_games_at_stadium(String club, String stadium) {
        System.out.printf("%s play their home games at %s%n", club, stadium);
    }

    @Given("the following clubs and their stadiums")
    public void the_following_clubs_and_their_stadiums(Map<String, String> stadiums) {
        stadiums.forEach((club, stadium) ->
                System.out.printf("%s play their home games at %s%n", club, stadium)
        );
    }

    @Given("^(.*) of (.*), born on (.*), plays for Juventus since the (.*) season$")
    public void name_of_country_born_on_date_plays_for_club_since_the_years_season(String name, String nationality, String dateOfBirth, String firstSeason) {
        System.out.printf("%s of %s, born on %s, plays for Juventus since the %s season%n", name, nationality, dateOfBirth, firstSeason);
    }

    @Given("the following Juventus players")
    public void the_following_juventus_players(List<Map<String, String>> players) {
        for(Map<String, String> player : players) {
            System.out.printf("%s of %s, born on %s, plays for Juventus since the %s season%n",
                    player.get("name"), player.get("nationality"), player.get("dateOfBirth"), player.get("atJuventusSince"));
        }
    }

    @Given("^the final result of the Derby d'Italia played on (.*) was Internazionale (\\d+), Juventus (\\d+)$")
    public void the_final_result_of_the_derby_dItalia_played_on_date_was_Internazionale_score_Juventus_score(String date, int interGoals, int juveGoals) {
        System.out.printf("The final result of the Derby d'Italia played on %s was Internazionale %d, Juventus %d", date, interGoals, juveGoals);
    }

    @Given("the following historic Derby d'Italia results")
    public void the_following_historic_derby_dItalia_results(Map<String, Map<String, Integer>> results) {
        results.forEach((date, scores) ->
                System.out.printf("The final result of the Derby d'Italia played on %s was Internazionale %d, Juventus %d%n",
                        date, scores.get("Internazionale"), scores.get("Juventus"))
        );
    }
}
