package org.bedu.java.testing.interviewer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Lenin Meza
 */
public class MenuTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private final String exitCommand = "4\n";

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    @DisplayName("Add new interviewer")
    public void addNewInterviewer() throws Exception {
        final String interviewerName = "Lenin";
        final String interviewerLastName = "Meza";
        final String interviewerEmail = "merolhack@gmail.com";
        final String addNewInterviewerCommand = "1\n" + interviewerName + "\n" + interviewerLastName + "\n" + interviewerEmail + "\n1\n" + exitCommand;
        provideInput(addNewInterviewerCommand);

        Menu.main(new String[0]);
        final String output = getOutput();
        System.out.println("output: " + output);
        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }

    @Test
    @DisplayName("Get interviewer")
    public void getInterviewer() throws Exception {
        final String interviewerName = "Lenin";
        final String interviewerLastName = "Meza";
        final String interviewerEmail = "merolhack@gmail.com";
        final String addNewInterviewerCommand = "1\n" + interviewerName + "\n" + interviewerLastName + "\n" + interviewerEmail + "\n1\n";
        final String getInterviewerCommand = "2\n" + interviewerEmail + "\n";
        provideInput(addNewInterviewerCommand + getInterviewerCommand + exitCommand);

        Menu.main(new String[0]);
        final String output = getOutput();

        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }
}
