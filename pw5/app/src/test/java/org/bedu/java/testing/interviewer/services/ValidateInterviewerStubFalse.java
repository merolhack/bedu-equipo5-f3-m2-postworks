package org.bedu.java.testing.interviewer.services;

import org.bedu.java.testing.interviewer.models.Interviewer;

class ValidateInterviewerStubFalse implements IValidateInterviewer {

    private Interviewer interviewer;

    @Override
    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    @Override
    public boolean validateName() {
        return false;
    }

    @Override
    public boolean validateLastName() {
        return false;
    }
}
