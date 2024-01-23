import java.util.*;
import java.time.LocalDate; // Import the LocalDate class
import java.time.LocalTime; //Import the localTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class HospitalManagement {
    public static void main(String[] args) {
        int doctorCount = 3, patientCount = 3;
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter DATE_FOMATTER = DateTimeFormatter.ofPattern("MMM/dd/yyyy");
        DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("hh:mm a");

        String localDate = DATE_FOMATTER.format(LocalDate.now());
        String localTime = TIME_FORMATTER.format(LocalTime.now());

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("            *** Welcome to S.B.A HOSPITAL MANAGEMENT SYSTEM  ***");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Date: " + localDate);
        System.out.println("\t\t\t\t\t\tTime: " + localTime);

        // DOCTOR
        Doctor[] dr = new Doctor[6];
        for (int i = 0; i < dr.length; i++) {
            dr[i] = new Doctor();
        }

        dr[0].id = "401";
        dr[0].name = "Dr Zamin";
        dr[0].specialization = "General Surgeon";
        dr[0].timing = "12:00 pm - 4:00 pm";
        dr[0].days = "Mon - Wed - Thur";
        dr[0].room = "FRF-105";

        dr[1].id = "402";
        dr[1].name = "Dr Furqan";
        dr[1].specialization = "Heart Surgeon";
        dr[1].timing = "10:00 pm - 2:00 pm";
        dr[1].days = "Wed - Thur - Sun";
        dr[1].room = "FRF-101";

        dr[2].id = "403";
        dr[2].name = "Dr Sidra";
        dr[2].specialization = "Neurosurgeon";
        dr[2].timing = "02:00 pm - 08:00 pm";
        dr[2].days = "Mon - Wed - Sun";
        dr[2].room = "SNF-109";

        // PATIENT
        Patient[] p = new Patient[10];

        for (int i = 0; i < p.length; i++) {
            p[i] = new Patient();
        }

        p[0] = new Patient("Faiza Ali", "101", "Female", 21, "Discharged");  
        p[1] = new Patient("Asad Khan", "102", "Male", 18, "Admitted");
        p[2] = new Patient("Bilal Khan", "103", "Male", 20, "Waiting");
    

        int mainMenu = 1, choice, doctorMenu, patientMenu, appointMenu;

        while (mainMenu == 1) {
            System.out.println("\n                                    MAIN MENU");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("  1.Doctos  2. Patients  3.Appointment 4.Exit");
            System.out.println("-----------------------------------------------------------------------------------");

            System.out.print("Enter the number according to Menu : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    System.out.println("                      *** DOCTOR SECTION ***");
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    doctorMenu = 1;
                    while (doctorMenu == 1) {
                        System.out.println("1.Doctors List \n2.Register New Doctor");
                        System.out.print("Enter choice : ");
                        int option = sc.nextInt();

                        switch (option) {
                            case 1:
                                // Doctor list
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------");
                                System.out.println("id \t Name\t\t Specialist\t\t Timing \t\t Days \t\t\t Room No.");
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------------------------");

                                for (int i = 0; i < doctorCount; i++) {
                                    dr[i].showInfo();
                                }
                                break;

                            case 2:
                                // Add Doctor - can only perform by admin
                                System.out.print("Enter your Admin Password : ");
                                String password = sc.next();
                                if (password.equals("123")) {
                                    dr[doctorCount].addDoctor();
                                    doctorCount++;
                                } else {
                                    System.out.println("You're not authorized !!");
                                }
                                break;

                            default:
                                System.out.println("Invalid choice !");
                                break;
                        }
                        System.out.print("\nTo Go Back Enter (1) or To Main Menu Enter (0) : ");
                        doctorMenu = sc.nextInt();
                    }

                    break;

                // Patient Menu
                case 2:
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    System.out.println("                     *** PATIENT SECTION ***");
                    System.out.println(
                            "--------------------------------------------------------------------------------");

                    patientMenu = 1;
                    while (patientMenu == 1) {
                        System.out.println("1.Register New Patient\n2.Existing Patients List");
                        System.out.print("Enter choice : ");
                        int option = sc.nextInt();

                        switch (option) {
                            case 1:
                                p[patientCount].addPatient();
                                patientCount++;
                                break;

                            case 2:
                                System.out.println(
                                        "--------------------------------------------------------------------------------");
                                System.out.println("id \tName \t\t\tGender \t\tAge \tStatus");
                                System.out.println(
                                        "--------------------------------------------------------------------------------");
                                for (int i = 0; i < patientCount; i++) {
                                    p[i].showInfo();

                                }
                                break;
                            default:
                                System.out.println("Invalid choice !");
                                break;
                        }
                        System.out.print("\nTo Go Back Enter (1) or To Main Menu Enter (0) : ");
                        patientMenu = sc.nextInt();
                    }
                    break;

                case 3:
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    System.out.println("                     *** APPOINTMENT SECTION ***");
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    appointMenu = 1;
                    while (appointMenu == 1) {
                        System.out.println("1.Make Appointment \n2.Appointment Status");
                        System.out.print("Enter Choice (1 or 2): ");
                        int appointmentOption = sc.nextInt();

                        // patient Id - pid
                        String pid;
                        if (appointmentOption == 1 | appointmentOption == 2) {
                            System.out.print("\nEnter your Patient Id : ");
                            pid = sc.next();
                        } else {
                            System.out.println("Invalid Appointmetn Option !!");
                            break;
                        }

                        switch (appointmentOption) {
                            case 1:
                                boolean patientFound = false;
                                for (int i = 0; i < patientCount; i++) {
                                    if (p[i].id.equals(pid)) {

                                        patientFound = true;
                                        // Already have appointment
                                        if (p[i].appointmentStatus) {
                                            System.out.println(p[i].name
                                                    + " You Can't Make Another Appointment, You Already Have An Appointment !!");
                                            break;
                                        }
                                        System.out.println("****** RECORD FOUND SUCCESSFULLY ******");
                                        System.out.println("\nASSALAM O ALAIKUM : " + p[i].name);
                                        System.out.println("\n----- Here is the list of Doctor: ----- ");
                                        // Doctor selection for appointment
                                        for (int j = 0; j < doctorCount; j++) {
                                            System.out.println((j + 1) + ". " + dr[j].name + " (" + dr[j].specialization
                                                    + ") \t " + dr[j].timing);
                                        }

                                        System.out.print("\nSelect the doctor (1 2 3) : ");
                                        int drSelection = sc.nextInt();
                                        Doctor appointDoctor = dr[drSelection - 1];
                                        p[i].appointmentSuccessfull(appointDoctor.name, appointDoctor.specialization,
                                                appointDoctor.days, appointDoctor.timing);

                                    }
                                }
                                if (!patientFound) {
                                    System.out.println(" ******* YOU'RE NOT REGISTERED ! ******* ");
                                    System.out.println(
                                            "To Register yourself \nGo to Main Menu -> 2.Patient -> 1.Register New Patient");
                                }
                                break;

                            case 2:
                                boolean haveAppointment = false;
                                for (int i = 0; i < patientCount; i++) {
                                    if (p[i].id.equals(pid) && p[i].appointmentStatus) {
                                        haveAppointment = true;
                                        System.out.println("****** RECORD FOUND SUCCESSFULLY ******");
                                        System.out.println("\n----- ASSALAM O ALAIKUM -----\n ");
                                        System.out.println("-------------------------");
                                        System.out.println("YOUR APPOINTMENT DETAILS");
                                        System.out.println("-------------------------");
                                        System.out.println("Name: " + p[i].name);
                                        System.out.println("Appointment Day: " + p[i].appointmentDay);
                                        System.out.println("Appointment Time: " + p[i].appointmentTime);
                                        System.out.println("Appointment With: " + p[i].appointmentWithDr);

                                    }
                                }
                                if (!haveAppointment) {
                                    System.out.println(" ******* YOU DON'T HAVE APPOINTMENT ! ******* ");
                                    System.out.println(
                                            "To Make Appointment \nGo to Main Menu -> 2.Appointment -> 1.Make Appointment ");
                                    System.out.println("--OR--");
                                    System.out.println("Go Back");
                                }
                                break;

                            default:
                                System.out.println("Invalid Entry for Appointment !!");
                                break;
                        }

                        System.out.print("\nTo Go Back Enter (1) or To Main Menu Enter (0) : ");
                        appointMenu = sc.nextInt();

                    }

                    break;

                // Exit the program
                case 4:
                    System.out.println("\n****** EXITING S.B.A HOSPITAL MANAGEMENT SYSTEM. (GOODBYE!) ******\n");
                    mainMenu = 0;
                    break;

                default:
                    System.out.println("\n0. Exit \n1. Main Menu :  ");
                    System.out.print("Enter choice : ");
                    mainMenu = sc.nextInt();
                    if (mainMenu == 0)
                        System.out.println("****** EXITING S.B.A HOSPITAL MANAGEMENT SYSTEM. (GOODBYE!) ******\n");
                    break;
            }

        }

        sc.close();

    }
}
