package org.bedu.java.testing.interviewer.services;

import org.bedu.java.testing.interviewer.models.Interviewer;
import org.bedu.java.testing.interviewer.models.InterviewerStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Lenin Meza
 */
@ExtendWith(MockitoExtension.class)
public class ValidateInterviewerMockTest {

    @InjectMocks
    private ValidateInterviewer validate;

    @Mock
    private Interviewer interviewer;

    @BeforeEach
    public void setUp() throws Exception {
        Interviewer.data = new ArrayList<>();

        // We insert a interviewer for testing delete and save
        Interviewer.data.add(new Interviewer("Lenin Jose", "Meza", "lenin@meza.com", true, true));
    }

    @Test
    @DisplayName("Validate Interviewer Mock: Name basic")
    public void validateName_basic() {
        boolean expectedResult = true;
        validate = new ValidateInterviewer(); // Business logic
        InterviewerStub dataServiceMock = mock(InterviewerStub.class); // Data service
        lenient().when(dataServiceMock.getInterviewer()).thenReturn(Interviewer.data.get(0));
        validate.setInterviewer(dataServiceMock);

        assertEquals(expectedResult, true);
    }
}
