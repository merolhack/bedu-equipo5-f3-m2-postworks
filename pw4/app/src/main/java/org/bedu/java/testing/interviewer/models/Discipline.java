package org.bedu.java.testing.interviewer.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Lenin Meza
 */
public class Discipline {
    public static ArrayList<Discipline> data;

    public int id;
    public String name;
    public String slug;
    public String description;

    public Discipline(String name, String slug, String description) {
        this.id = data.size() + 1;
        this.name = name;
        this.slug = slug;
        this.description = description;
    }

    public Discipline add() {
        data.add(this);
        return this;
    }

    public void delete() throws Exception{
        Discipline interviewerType = data.stream().filter(a -> a.id == id).collect(Collectors.toList()).get(0);

        if (interviewerType != null) {
            data.remove(this);
        } else {
            throw new Exception("Discipline not found");
        }
    }

    public void save(
            String name,
            String slug,
            String description
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
        if (!slug.equals("")) {
            this.slug = slug;
        }
        if (!description.equals("")) {
            this.description = description;
        }

        data.add(this);
    }
}
