package org.bedu.java.testing.interviewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InterviewerTest {
    static String existingInterviewerName = "Lenin";
    static String existingInterviewerLastName = "Meza";
    static String existingInterviewerEmail = "merolhack@gmail.com";

    @BeforeEach
    public void setUp() throws Exception {
        Interviewer.data = new ArrayList<>();

        // We insert a user for testing delete and save
        Interviewer.data.add(new Interviewer(existingInterviewerName, existingInterviewerLastName, existingInterviewerEmail, true));
    }

    @Test
    @DisplayName("Add")
    public void add() {
        Interviewer interviewer = new Interviewer("Test", "User", "any@email.com", true);
        interviewer.add();
        int expectedId = Interviewer.data.size();
        assertEquals(expectedId, interviewer.id, "Interviewer ID should be the new List's size");
    }


    @Test
    @DisplayName("Save")
    public void save() {
        int originalListSize = Interviewer.data.size();
        String expectedLastName = "New";
        Interviewer existingInterviewer = Interviewer.data.get(0);
        System.out.println("Interviewer.data.size(): " + Interviewer.data.size());
        existingInterviewer.save("", expectedLastName, "", true);

        int newListSize = Interviewer.data.size();
        System.out.println("Interviewer.data.size(): " + Interviewer.data.size());
        int lastInterviewerIndex = newListSize - 1;
        Interviewer latestInterviewer = Interviewer.data.get(lastInterviewerIndex);

        assertEquals(originalListSize, newListSize, "List size should be the same");
        assertEquals(expectedLastName, latestInterviewer.lastName, "Last Name should have been updated");
        assertEquals(existingInterviewer.name, latestInterviewer.name, "Name should have not been updated");
    }

    @Test
    @DisplayName("Get by email")
    public void getByEmail() {
        Interviewer result = Interviewer.getByEmail(existingInterviewerEmail);
        assertNotNull(result, "Interviewer should be found");
        assertEquals(existingInterviewerName, result.name, "Unexpected Interviewer Name");
        assertEquals(existingInterviewerLastName, result.lastName, "Unexpected Interviewer Last Name");
    }

    @Test
    @DisplayName("Get by non existing email")
    public void getByNonExistingEmail() {
        String nonExistingEmail = "nonexisting@gmail.com";
        Interviewer result = Interviewer.getByEmail(nonExistingEmail);
        assertNull(result, "Interviewer should not be found");
    }
}
