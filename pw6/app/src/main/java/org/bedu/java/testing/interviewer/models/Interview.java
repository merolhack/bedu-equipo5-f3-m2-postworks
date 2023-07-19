package org.bedu.java.testing.interviewer.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Lenin Meza
 */
public class Interview {
    public static ArrayList<Interview> data;

    public Candidate candidate;

    public Interviewer interviewer;

    public InterviewType type;

    public Technology technology;

    public Discipline discipline;

    public Interview(Candidate candidate, Interviewer interviewer, InterviewType type, Technology technology, Discipline discipline) {
        this.candidate = candidate;
        this.interviewer = interviewer;
        this.type = type;
        this.technology = technology;
        this.discipline = discipline;
    }

    public Interview add() {
        data.add(this);
        return this;
    }

    public void delete() throws Exception{
        Interview interview = data.stream().filter(a -> a.candidate == this.candidate).collect(Collectors.toList()).get(0);

        if (interview != null) {
            data.remove(this);
        } else {
            throw new Exception("Interview not found");
        }
    }

    public void save(
            Candidate candidate, Interviewer interviewer, InterviewType type, Technology technology, Discipline discipline
    ) {
        try {
            this.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        if (candidate != null) {
            this.candidate = candidate;
        }
        if (interviewer != null) {
            this.interviewer = interviewer;
        }
        if (type != null) {
            this.type = type;
        }
        if (technology != null) {
            this.technology = technology;
        }
        if (discipline != null) {
            this.discipline = discipline;
        }

        data.add(this);
    }
}
