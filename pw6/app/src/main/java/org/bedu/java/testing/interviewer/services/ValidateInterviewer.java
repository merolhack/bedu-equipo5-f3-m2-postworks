package org.bedu.java.testing.interviewer.services;

import org.bedu.java.testing.interviewer.models.Interviewer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Business logic
 *
 * @author Lenin Meza
 */
public class ValidateInterviewer implements IValidateInterviewer {

    Interviewer interviewer;

    /**
     *
     * @param interviewer
     */
    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }
    public boolean validateName() {
        String regex = "^[A-Z]+([ '-][a-zA-Z]+)*$";
        if (this.interviewer.name.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.interviewer.name);
        if (matcher.matches()) {
            return false;
        }
        return true;
    }

    public boolean validateLastName() {
        String regex = "^[A-Z]+([ '-][a-zA-Z]+)*$";
        if (this.interviewer.lastName.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.interviewer.lastName);
        if (matcher.matches()) {
            return false;
        }
        return true;
    }
}
