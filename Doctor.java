import java.util.Scanner;

public class Doctor extends Person{
    String specialization, timing, days, room;


    void showInfo(){
        //avoid printing with null values.
        if(name!=null || id!=null)
        System.out.println(id +"\t" + name + " \t" + specialization + "\t\t"  + timing + " \t" + days +" \t" + room );
    }

    void addDoctor(){
        Scanner sc = new Scanner(System.in);
        //patient id
        System.out.print("Dr Id:- ");
        id = sc.nextLine();

        System.out.print("Dr Name(at least 8 character):- ");
        name = sc.nextLine();
        //For better indentation
        int nameLength = name.length();
        if(nameLength<8){
            for(int i =1 ; i< 8-nameLength; i++){
                name += " ";
            }
        }

        System.out.print("Dr Specialization:- ");
        specialization = sc.nextLine();
        //For better indentation
        int specialLength = specialization.length();
        if(specialLength<12){
            for(int i =1; i<12-specialLength; i++ ){
                specialization += " ";
            }
        }

       System.out.println("---- Dr Timing ----");
       System.out.print("Enter starting time example (12:00 pm) : ");
       timing = sc.nextLine();
       System.out.print("Enter End time e.g (2:00 am) : ");
       timing += " - " + sc.nextLine();

       System.out.println("\n------ Dr Days ------");
       System.out.println("Input day in 3 characters e.g (Mon)");
       for(int i =1 ; i<4; i++){
           System.out.print("Enter Day " + i + " : ");
        if(i==1){
            days = sc.nextLine();
        } else{
            days += " - " + sc.nextLine();
        }
       }

       System.out.print("Dr Room:- ");
       room = sc.nextLine();
    }
}
