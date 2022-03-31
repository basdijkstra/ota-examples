package stepdefinitions;

import datatypes.Book;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;

public class DataTableTypesSteps {

    private List<Book> actualBooks;

    @DataTableType(replaceWithEmptyString = "[anonymous]")
    public Book bookEntryTransformer(Map<String, String> row) {
        return new Book(
            row.get("title"),
            row.get("author"),
            Integer.parseInt(row.get("yearOfPublishing"))
        );
    }

    @Given("the following books")
    public void theFollowingBooks(List<Book> books) {

        actualBooks = books;

        for(Book book: actualBooks) {
           System.out.printf(
                   "'%s', published in %d, was written by %s\n",
                   book.getTitle(),
                   book.getYearOfPublishing(),
                   book.getAuthor()
           );
        }
    }

    @When("I do nothing")
    public void iDoNothing() {

    }

    @Then("I expect to have the following books")
    public void iExpectToHaveTheFollowingBooks(List<Book> expectedBooks) {

        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedBooks, actualBooks));
    }
}
