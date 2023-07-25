package org.bedu.java.testing.interviewer.services;

import org.bedu.java.testing.interviewer.models.Interviewer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Lenin Meza
 */
public class ValidateInterviewerTest {
    private Interviewer interviewer;
    private IValidateInterviewer validate;

    private String existingInterviewerName = "Lenin Jose";
    private String existingInterviewerLastName = "Meza";
    private String existingInterviewerEmail = "lenin@meza.com";

    @BeforeEach
    public void setUp() throws Exception {
        Interviewer.data = new ArrayList<>();

        // We insert a interviewer for testing delete and save
        Interviewer.data.add(new Interviewer(existingInterviewerName, existingInterviewerLastName, existingInterviewerEmail, true, true));
    }

    @Test
    @DisplayName("Validate Interviewer: Name basic")
    public void validateName_basic() {
        boolean expectedResult = true;
        Interviewer existingInterviewer = Interviewer.data.get(0);
        validate = new ValidateInterviewer();
        validate.setInterviewer(existingInterviewer);
        boolean validated = validate.validateName();
        assertEquals(expectedResult, validated);
    }

    @Test
    @DisplayName("Validate Interviewer: Name empty")
    public void validateName_empty() {
        boolean expectedResult = false;
        interviewer = new Interviewer("", existingInterviewerLastName, existingInterviewerEmail, true, true);
        validate = new ValidateInterviewer();
        validate.setInterviewer(interviewer);
        boolean validated = validate.validateName();
        assertEquals(expectedResult, validated);
    }

    @Test
    @DisplayName("Validate Interviewer: Name one value")
    public void validateName_oneValue() {
        boolean expectedResult = true;
        interviewer = new Interviewer("Lenin", existingInterviewerLastName, existingInterviewerEmail, true, true);
        validate = new ValidateInterviewer();
        validate.setInterviewer(interviewer);
        boolean validated = validate.validateName();
        assertEquals(expectedResult, validated);
    }
}
