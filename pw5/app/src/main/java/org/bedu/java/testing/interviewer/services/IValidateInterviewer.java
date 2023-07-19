package org.bedu.java.testing.interviewer.services;

import org.bedu.java.testing.interviewer.models.Interviewer;

public interface IValidateInterviewer {

    public void setInterviewer(Interviewer interviewer);

    public boolean validateName();

    public boolean validateLastName();

}
