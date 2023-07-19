package org.bedu.java.testing.interviewer.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Lenin Meza
 */
public class Candidate implements Serializable {

    public static ArrayList<Candidate> data;

    public int id;
    public String name;
    public String lastName;
    public String email;
    public Boolean isActive;

    public Candidate(String name, String lastName, String email, Boolean isActive) {
        this.id = data.size() + 1;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;
    }

    public Candidate add() {
        data.add(this);
        return this;
    }

    public void delete() throws Exception{
        Candidate candidate = Candidate.getByEmail(this.email);

        if (candidate != null) {
            data.remove(this);
        } else {
            throw new Exception("Candidate not found");
        }
    }

    public void save(
            String name,
            String lastName,
            String email,
            Boolean isActive
    ) {
        try {
            this.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        if (!name.equals("")) {
            this.name = name;
        }
        if (!lastName.equals("")) {
            this.lastName = lastName;
        }
        if (!email.equals("")) {
            this.email = email;
        }
        this.isActive = isActive;

        data.add(this);
    }

    public static Candidate getByEmail(String email) {
        for (Candidate candidate: data) {
            if (candidate.email.equals(email))
                return candidate;
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nID: " + this.id +
                "\nName: " + this.name +
                "\nLast Name: " + this.lastName +
                "\nEmail: " + this.email +
                "\nIs Active: " + this.isActive + "\n";
    }
}
