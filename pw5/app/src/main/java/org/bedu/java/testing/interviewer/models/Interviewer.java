package org.bedu.java.testing.interviewer.models;

import java.io.*;
import java.util.ArrayList;

/**
 * Data service
 *
 * @author Lenin Meza
 */
public class Interviewer implements Serializable {
    public static ArrayList<Interviewer> data;

    public int id;
    public String name;
    public String lastName;
    public String email;
    public Boolean isActive;
    public Boolean isAdmin;

    public Interviewer(
            String name,
            String lastName,
            String email,
            Boolean isActive,
            Boolean isAdmin
    ) {
        this.id = data.size() + 1;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }

    public Interviewer add() {
        data.add(this);
        Interviewer.saveDataToFile();
        return this;
    }

    public void delete() throws Exception{
        Interviewer interviewer = Interviewer.getByEmail(this.email);

        if (interviewer != null) {
            data.remove(this);
            Interviewer.saveDataToFile();
        } else {
            throw new Exception("Interviewer not found");
        }
    }

    public void save(
            String name,
            String lastName,
            String email,
            Boolean isActive,
            Boolean isAdmin
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
        this.isAdmin = isAdmin;

        data.add(this);
    }

    public static Interviewer getByEmail(String email) {
        for (Interviewer interviewer: data) {
            if (interviewer.email.equals(email))
                return interviewer;
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nID: " + this.id +
                "\nName: " + this.name +
                "\nLast Name: " + this.lastName +
                "\nEmail: " + this.email +
                "\nIs Active: " + this.isActive +
                "\nIs Admin: " + this.isAdmin + "\n";
    }

    public static void saveDataToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./interviewers");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(Interviewer.data);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void loadDataFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./interviewers");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Interviewer> fileData = (ArrayList<Interviewer>) inputStream.readObject();
            Interviewer.data.clear();
            Interviewer.data.addAll(fileData);
            inputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            if (e.getMessage() != null && !e.getMessage().contains("No such file or directory"))
                e.printStackTrace();
        }
    }
}
