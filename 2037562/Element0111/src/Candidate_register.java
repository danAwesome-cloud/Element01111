import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;

public class Candidate_register {
    // this method allow user to register and save their details in a text file.
    void can_register(){

        Scanner useroption2 = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        Scanner email = new Scanner(System.in);
        Scanner phone = new Scanner(System.in);
        Scanner username = new Scanner(System.in);
        Scanner password = new Scanner(System.in);
        Scanner qualif = new Scanner(System.in);
        Scanner birth = new Scanner(System.in);


        System.out.println("If you are a new user press 1 to register else other key to login");
        String useroption3 = " ";
        useroption3 = useroption2.nextLine();


        if (useroption3.matches("1") ){
            try {
                System.out.println("Create Username: ");
                String dob1= " ";
               String filename = username.nextLine();
               FileWriter candidateusername = new FileWriter("candidat.txt",true);//this line of code save username of users that register.
                PrintWriter pw = new PrintWriter(candidateusername);
                pw.println(filename);
                pw.close();
                BufferedWriter candidateprofile = new BufferedWriter(new FileWriter(filename + ".txt",true));
                BufferedWriter dob = new BufferedWriter(new FileWriter(filename +"dob"+ ".txt",true));
                System.out.println("Enter full name:");
                candidateprofile.write("Name: " + name.nextLine());
                candidateprofile.write("\n");
                System.out.println("Enter Email address: ");
                candidateprofile.write("Email address:" + email.nextLine());
                candidateprofile.write("\n");
                System.out.println("Enter Phone Number: ");
                candidateprofile.write("Phone Number:" + phone.nextLine());
                candidateprofile.write("\n");
                System.out.println("Enter your most recent Qualification:");
                candidateprofile.write("Qualification:" + qualif.nextLine());
                candidateprofile.write("\n");
                System.out.println("Enter your Date of birth in this format! Day / Month / Year : ");
                dob1=birth.nextLine();
                candidateprofile.write("Date of Birth:" + dob1);
                dob.write(dob1);
                dob.close();
                candidateprofile.write("\n");
                System.out.println("Your date of birth is your default password!!");
                candidateprofile.close();
                System.out.println("Account has been created successfully! Check your email address for confirmation");
            }catch (IOException e) {

                System.out.println("Registration Failed");

            }



        }




    }



}
