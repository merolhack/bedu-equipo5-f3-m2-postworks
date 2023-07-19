package org.bedu.java.testing.interviewer.services;

import org.bedu.java.testing.interviewer.models.Interviewer;

class ValidateInterviewerStub implements IValidateInterviewer {

    private Interviewer interviewer;

    @Override
    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    @Override
    public boolean validateName() {
        return true;
    }

    @Override
    public boolean validateLastName() {
        return true;
    }
}
