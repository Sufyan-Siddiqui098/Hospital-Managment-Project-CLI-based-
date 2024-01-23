import java.util.Scanner;

public class Patient extends Person {
    String status; 
    boolean appointmentStatus;
    String appointmentTime, appointmentDay, appointmentWithDr;
  

    Patient (String name, String id, String sex, int age,  String status){
        super(name, sex, id, age);
        this.status = status; 
        appointmentStatus = false;
    }

    Patient (){
        name = null;
        id = null;
    }
    void addPatient (){
        Scanner sc = new Scanner(System.in);
        //patient id
        System.out.print("Id:- ");
        id = sc.nextLine();

        System.out.print("Name:- ");
        name = sc.nextLine();

        System.out.print("Age:- ");
        age = sc.nextInt();

        System.out.print("Sex (Male/Female):- ");
        sex = sc.next();

        System.out.println("-- Select Status -- ");
        System.out.println("1.Waiting \n2.Discharged \n3.Admitted");
        System.out.print("Enter Status : ");
        int tempStatus = sc.nextInt();
        
        if(tempStatus==1) status= "Waiting";
        else if(tempStatus==2) status = "Discharged";
        else if(tempStatus==3) status = "Admitted";
        else status= "N/A";

    }



    void showInfo(){
        if(name!=null || id!=null)
        System.out.println(id +"\t" + name +"\t\t" + sex + "\t\t"  + age + "\t" + status );
    }

    void appointmentSuccessfull (String drName, String drSpecialist, String aptDay, String aptTime) {
       
        appointmentDay = aptDay.substring(0, 3);
        appointmentTime = aptTime;
        appointmentStatus = true;
        appointmentWithDr = drName + "  (" + drSpecialist + ")";

        System.out.println("\n****** Operation Perform Successfully !! ******");
        System.out.println(name.toUpperCase() + " You have an appointment on comming \"" + appointmentDay + "\" between (" + appointmentTime + ") with \"" + drName.toUpperCase() + "\" (" + drSpecialist + ")");
        System.out.println("Please come on time.");
        System.out.println("GOD BLESS YOU !");
    }


}
