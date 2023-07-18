package org.bedu.java.testing.interviewer.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Lenin Meza
 */
public class InterviewTest {
    Candidate existingCandidate;
    Interviewer existingInterviewer;
    InterviewType existingInterviewType;
    Technology existingTechnology;
    Discipline existingDiscipline;
    @BeforeEach
    public void setUp() throws Exception {
        Interview.data = new ArrayList<>();
        Candidate.data = new ArrayList<>();
        Interviewer.data = new ArrayList<>();
        InterviewType.data = new ArrayList<>();
        Technology.data = new ArrayList<>();
        Discipline.data = new ArrayList<>();

        Candidate candidate = new Candidate("Candidate", "Test", "candidate@test.com", true);
        Interviewer interviewer = new Interviewer("Interviewer", "Test", "interviewer@test.com", true, true);
        InterviewType interviewType = new InterviewType("Interview Type", "interview-type-1", "Lorem Ipsum Dolor");
        Technology technology = new Technology("Technology 1", "technology-1", "Lorem Ipsum Dolor");
        Discipline discipline = new Discipline("Discipline 1", "discipline-1", "Lorem Ipsum Dolor");

        Candidate.data.add(candidate);
        Interviewer.data.add(interviewer);
        InterviewType.data.add(interviewType);
        Technology.data.add(technology);
        Discipline.data.add(discipline);

        // We insert a interview for testing delete and save
        Interview.data.add(new Interview(candidate, interviewer, interviewType, technology, discipline));
    }

    @Test
    @DisplayName("Add")
    public void add() {
        existingCandidate = new Candidate("Lenin", "Meza", "merolhack@gmail.com", true);
        existingInterviewer = new Interviewer("Pedro", "Piedra", "pedro.piedra@gmail.com", true, true);
        existingInterviewType = new InterviewType("Tipo 1", "type-1", "Lorem Ipsum Dolor");
        existingTechnology = new Technology("Tecnología 1", "tecnologia-1", "Lorem Ipsum Dolor");
        existingDiscipline = new Discipline("Disciplina 1", "disciplina-1", "Lorem Ipsum Dolor");

        Interview interview = new Interview(existingCandidate, existingInterviewer, existingInterviewType, existingTechnology, existingDiscipline);
        interview.add();
        Interview expectedInterview = Interview.data.get(1);
        assertEquals(existingCandidate, expectedInterview.candidate, "Candidate should be the new List's size");
    }

    @Test
    @DisplayName("Save")
    public void save() {
        int originalListSize = Interview.data.size();

        existingCandidate = new Candidate("Lenin", "Meza", "merolhack@gmail.com", true);
        existingInterviewer = new Interviewer("Pedro", "Piedra", "pedro.piedra@gmail.com", true, true);
        existingInterviewType = new InterviewType("Tipo 1", "type-1", "Lorem Ipsum Dolor");
        existingTechnology = new Technology("Tecnología 1", "tecnologia-1", "Lorem Ipsum Dolor");
        existingDiscipline = new Discipline("Disciplina 1", "disciplina-1", "Lorem Ipsum Dolor");

        Interview existingInterview = Interview.data.get(0);
        System.out.println("Interviewer.data.size(): " + Interview.data.size());
        existingInterview.save(null, existingInterviewer, null, null, null);

        int newListSize = Interview.data.size();
        System.out.println("Interviewer.data.size(): " + Interview.data.size());
        int lastInterviewerIndex = newListSize - 1;
        Interview latestInterviewer = Interview.data.get(lastInterviewerIndex);

        assertEquals(originalListSize, newListSize, "List size should be the same");
        assertEquals(existingInterviewer, latestInterviewer.interviewer, "Interviewer should have been updated");
        assertEquals(existingInterview.candidate, latestInterviewer.candidate, "Candidate should have not been updated");
    }
}
