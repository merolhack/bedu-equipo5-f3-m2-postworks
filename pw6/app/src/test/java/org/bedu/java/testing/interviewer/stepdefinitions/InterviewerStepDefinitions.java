package org.bedu.java.testing.interviewer.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bedu.java.testing.interviewer.models.Interviewer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterviewerStepDefinitions {

    private Interviewer interviewer;

    private String existingInterviewerName = "Lenin";
    private String existingInterviewerLastName = "Meza";
    private String existingInterviewerEmail = "lenin@meza.com";

    @Given("name, lastName and email")
    public void name_last_name_and_email() {
        Interviewer.data = new ArrayList<>();
        // We insert a interviewer for testing delete and save
        Interviewer.data.add(new Interviewer(existingInterviewerName, existingInterviewerLastName, existingInterviewerEmail, true, true));
    }
    @When("the interviewer name is Lenin, lastName is lenin@meza.com, email is lenin@meza.com and isActive is set to true")
    public void the_candidate_name_is_lenin_last_name_is_lenin_meza_com_email_is_lenin_meza_com_and_is_active_is_set_to_true() {
        Interviewer existingInterviewer = Interviewer.data.get(0);
        assertEquals(existingInterviewer.name, existingInterviewerName, "The interviewer name is Lenin");
    }
    @Then("the interviewer should be created")
    public void the_interviewer_should_be_created() {
        int originalListSize = Interviewer.data.size();
        assertEquals(originalListSize, 1, "The interviewer array is one");
    }
}
