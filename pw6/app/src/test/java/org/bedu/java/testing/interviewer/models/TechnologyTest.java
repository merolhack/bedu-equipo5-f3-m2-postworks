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
public class TechnologyTest {
    static String existingTechnologyName = "Technology 1";
    static String existingTechnologySlug = "technology-1";
    static String existingTechnologyDescription = "Lorem ipsum dolor";
    
    @BeforeEach
    public void setUp() throws Exception {
        Technology.data = new ArrayList<>();

        // We insert a technology for testing delete and save
        Technology.data.add(new Technology(existingTechnologyName, existingTechnologySlug, existingTechnologyDescription));
    }

    @Test
    @DisplayName("Add")
    public void add() {
        Technology interviewer = new Technology("Technology 2", "technology-2", "Lorem ipsum dolor");
        interviewer.add();
        int expectedId = Technology.data.size();
        assertEquals(expectedId, interviewer.id, "Technology ID should be the new List's size");
    }

    @Test
    @DisplayName("Save")
    public void save() {
        int originalListSize = Technology.data.size();
        String expectedSlug = "New";
        Technology existingTechnology = Technology.data.get(0);
        System.out.println("Technology.data.size(): " + Technology.data.size());
        existingTechnology.save("", expectedSlug, "");

        int newListSize = Technology.data.size();
        System.out.println("Technology.data.size(): " + Technology.data.size());
        int lastTechnologyIndex = newListSize - 1;
        Technology latestTechnology = Technology.data.get(lastTechnologyIndex);

        assertEquals(originalListSize, newListSize, "List size should be the same");
        assertEquals(expectedSlug, latestTechnology.slug, "Slug should have been updated");
        assertEquals(existingTechnology.name, latestTechnology.name, "Name should have not been updated");
    }

    @Test
    @DisplayName("Delete")
    public void delete() {
        Technology existingTechnology = Technology.data.get(0);
        int expectedSize = Technology.data.size() - 1;
        try {
            existingTechnology.delete();
        } catch (Exception e) {
            fail("Unexpected Exception received: " + e.getMessage());
        }
        int actualSize = Technology.data.size();
        assertEquals(
                expectedSize,
                actualSize,
                "List should be smaller"
        );
    }
}
