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
public class DisciplineTest {
    static String existingDisciplineName = "Discipline 1";
    static String existingDisciplineSlug = "discipline-1";
    static String existingDisciplineDescription = "Lorem ipsum dolor";
    
    @BeforeEach
    public void setUp() throws Exception {
        Discipline.data = new ArrayList<>();

        // We insert a discipline for testing delete and save
        Discipline.data.add(new Discipline(existingDisciplineName, existingDisciplineSlug, existingDisciplineDescription));
    }

    @Test
    @DisplayName("Add")
    public void add() {
        Discipline interviewer = new Discipline("Discipline 2", "discipline-2", "Lorem ipsum dolor");
        interviewer.add();
        int expectedId = Discipline.data.size();
        assertEquals(expectedId, interviewer.id, "Discipline ID should be the new List's size");
    }

    @Test
    @DisplayName("Save")
    public void save() {
        int originalListSize = Discipline.data.size();
        String expectedSlug = "New";
        Discipline existingDiscipline = Discipline.data.get(0);
        System.out.println("Discipline.data.size(): " + Discipline.data.size());
        existingDiscipline.save("", expectedSlug, "");

        int newListSize = Discipline.data.size();
        System.out.println("Discipline.data.size(): " + Discipline.data.size());
        int lastDisciplineIndex = newListSize - 1;
        Discipline latestDiscipline = Discipline.data.get(lastDisciplineIndex);

        assertEquals(originalListSize, newListSize, "List size should be the same");
        assertEquals(expectedSlug, latestDiscipline.slug, "Slug should have been updated");
        assertEquals(existingDiscipline.name, latestDiscipline.name, "Name should have not been updated");
    }

    @Test
    @DisplayName("Delete")
    public void delete() {
        Discipline existingDiscipline = Discipline.data.get(0);
        int expectedSize = Discipline.data.size() - 1;
        try {
            existingDiscipline.delete();
        } catch (Exception e) {
            fail("Unexpected Exception received: " + e.getMessage());
        }
        int actualSize = Discipline.data.size();
        assertEquals(
                expectedSize,
                actualSize,
                "List should be smaller"
        );
    }
}
