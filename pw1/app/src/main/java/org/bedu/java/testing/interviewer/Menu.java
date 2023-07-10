package org.bedu.java.testing.interviewer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Lenin Meza
 */
public class Menu {
    private final String onlyNumbers = "[0-9]";
    Scanner sc;

    public Menu() throws Exception {
        this.sc = new Scanner(System.in);
        Interviewer.data = new ArrayList<Interviewer>();
        Interviewer.loadDataFromFile();
        showMainMenu();
    }

    public static void main(String[] args) throws Exception {
        new Menu();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }



    public void showMainMenu() throws Exception {
        int option = 0;
        while (option != 4) {
            System.out.println("Seleccione la operación a realizar:");
            System.out.println("1. Dar de alta un entrevistador");
            System.out.println("2. Consultar un entrevistador");
            System.out.println("3. Modificar un entrevistador");
            System.out.println("4. Salir");
            try {
                option = this.sc.nextInt();
                this.sc.nextLine();
                switch (option) {
                    case 1:
                        addInterviewer();
                        break;
                    case 2:
                        searchInterviewer();
                        break;
                    case 3:
                        modifyInterviewer();
                        break;
                }
            } catch (IllegalStateException | InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                // throw new NoSuchElementException(e.getMessage());
            }
        }
        this.sc.close();
        System.out.println("Programa terminado");
    }

    public void addInterviewer() {
        System.out.println("Ingrese el nombre del entrevistador: ");
        String name = this.sc.nextLine();
        System.out.println("Ingrese el apellido del entrevistador: ");
        String lastName = this.sc.nextLine();
        System.out.println("Ingrese el email del entrevistador: ");
        String email = this.sc.nextLine();
        System.out.println("El entrevistador se encuentra activo? (1=Si/2=No)");
        Boolean isActive = this.sc.nextInt() == 1;
        sc.nextLine();
        Interviewer interviewer = new Interviewer(name, lastName, email, isActive);
        interviewer.add();
        System.out.println(interviewer.toString());
    }

    public void searchInterviewer() {
        System.out.println("Ingrese el email del entrevistador a consultar:");
        String email = this.sc.nextLine();

        Interviewer interviewer = Interviewer.getByEmail(email);

        if (interviewer != null) {
            System.out.println("Entrevistador encontrado:");
            System.out.println(interviewer);
        } else {
            System.out.println("Entrevistador no encontrado");
        }
    }

    public void modifyInterviewer() {
        System.out.println("Ingrese el email del entrevistador a modificar:");
        String email = null;
        while (this.sc.hasNextLine()) {
            email = this.sc.nextLine();
            break;
        }
        Interviewer interviewer = Interviewer.getByEmail(email);
        if (interviewer != null) {
            System.out.println("Entrevistador encontrado:");
            System.out.println(interviewer);
            System.out.println("Ingrese el nuevo nombre del entrevistador: (Enter para mantener actual)");
            String name = this.sc.nextLine();
            System.out.println("Ingrese el nuevo apellido del entrevistador: (Enter para mantener actual)");
            String lastName = this.sc.nextLine();
            System.out.println("Ingrese el nuevo email del entrevistador: (Enter para mantener actual)");
            String newEmail = this.sc.nextLine();
            System.out.println("El entrevistador se encuentra activo? (1=Si/2=No)");
            Boolean isActive = Boolean.valueOf((this.sc.nextInt() == 1));
            this.sc.nextLine();
            interviewer.save(name, lastName, newEmail, isActive);
        } else {
            System.out.println("Entrevistador no encontrado");
        }
    }
}
