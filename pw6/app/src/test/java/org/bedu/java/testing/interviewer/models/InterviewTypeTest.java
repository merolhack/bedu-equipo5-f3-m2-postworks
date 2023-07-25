package org.bedu.java.testing.interviewer.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Lenin Meza
 */
public class InterviewTypeTest {
    static String existingInterviewTypeName = "Type 1";
    static String existingInterviewTypeSlug = "type-1";
    static String existingInterviewTypeDescription = "Initial type";
    
    @BeforeEach
    public void setUp() throws Exception {
        InterviewType.data = new ArrayList<>();

        // We insert a interview type for testing delete and save
        InterviewType.data.add(new InterviewType(existingInterviewTypeName, existingInterviewTypeSlug, existingInterviewTypeDescription));
    }

    @Test
    @DisplayName("Add")
    public void add() {
        InterviewType interviewType = new InterviewType("Type 2", "type-2", "Lorem ipsum dolor");
        interviewType.add();
        int expectedId = InterviewType.data.size();
        assertEquals(expectedId, interviewType.id, "InterviewTest Type ID should be the new List's size");
    }

    @Test
    @DisplayName("Save")
    public void save() {
        int originalListSize = InterviewType.data.size();
        String expectedSlug = "new-slug";
        InterviewType existingInterviewType = InterviewType.data.get(0);
        System.out.println("InterviewType.data.size(): " + InterviewType.data.size());
        existingInterviewType.save("", expectedSlug, "");

        int newListSize = InterviewType.data.size();
        System.out.println("InterviewType.data.size(): " + InterviewType.data.size());
        int lastInterviewTypeIndex = newListSize - 1;
        InterviewType latestInterviewType = InterviewType.data.get(lastInterviewTypeIndex);

        assertEquals(originalListSize, newListSize, "List size should be the same");
        assertEquals(expectedSlug, latestInterviewType.slug, "Slug should have been updated");
        assertEquals(existingInterviewType.name, latestInterviewType.name, "Name should have not been updated");
    }

    @Test
    @DisplayName("Delete")
    public void delete() {
        InterviewType existingInterviewType = InterviewType.data.get(0);
        int expectedSize = InterviewType.data.size() - 1;
        try {
            existingInterviewType.delete();
        } catch (Exception e) {
            fail("Unexpected Exception received: " + e.getMessage());
        }
        int actualSize = InterviewType.data.size();
        assertEquals(
                expectedSize,
                actualSize,
                "List should be smaller"
        );
    }
}
