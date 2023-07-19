package org.bedu.java.testing.interviewer.models;

import java.util.ArrayList;

public class InterviewerStub extends Interviewer {

    public static ArrayList<InterviewerStub> data;

    public InterviewerStub() {
        super("Lenin Jose", "Meza", "lenin@meza.com", true, true);
    }

    @Override
    public Interviewer add() {
        return super.add();
    }

    @Override
    public void delete() throws Exception {
        super.delete();
    }

    @Override
    public void save(String name, String lastName, String email, Boolean isActive, Boolean isAdmin) {
        super.save(name, lastName, email, isActive, isAdmin);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Interviewer getInterviewer() {
        return data.get(0);
    }
}
