package org.bedu.java.testing.interviewer.services;

import org.bedu.java.testing.interviewer.models.Interviewer;
import org.bedu.java.testing.interviewer.models.InterviewerStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ValidateInterviewerStubTest {

    private ValidateInterviewerStub validate;
    private ValidateInterviewerStubFalse validateFalse;

    @BeforeEach
    public void setUp() throws Exception {
        Interviewer.data = new ArrayList<>();

        // We insert a interviewer for testing delete and save
        Interviewer.data.add(new InterviewerStub());
    }
    @Test
    @DisplayName("Validate Interviewer Stub: Name basic")
    public void validateName_basic() {
        boolean expectedResult = true;
        validate = new ValidateInterviewerStub();
        validate.setInterviewer(new InterviewerStub());
        boolean validated = validate.validateName();
        assertEquals(expectedResult, validated);
    }

    @Test
    @DisplayName("Validate Interviewer Stub: Name empty")
    public void validateName_empty() {
        boolean expectedResult = false;
        validateFalse = new ValidateInterviewerStubFalse();
        validateFalse.setInterviewer(new InterviewerStub());
        boolean validated = validateFalse.validateName();
        assertEquals(expectedResult, validated);
    }


}
