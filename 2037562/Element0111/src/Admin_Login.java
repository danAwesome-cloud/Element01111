// imported packages for my code.
import java.io.*;
import java.util.Scanner;

public class Admin_Login {
    protected String password1;
// This the method for the admin  login page.

    void admin_page_option() {


        Scanner password = new Scanner(System.in);
        System.out.println("Enter your username");
        Scanner adminname = new Scanner(System.in);
        String admin_name= "";
        String adminPassword = "";
        admin_name = adminname.nextLine();




        if (admin_name.endsWith("@intergence.com")) {  //This line of code will check if the username includes the company mail @intergence.com.
            System.out.println("Enter your password");
            password1 = password.nextLine();


            try {
                BufferedReader adminpassword = new BufferedReader(new FileReader("Admin_Password.txt"));
                adminPassword = adminpassword.readLine();
            } catch (IOException e) {
                System.out.println("Something Went Wrong");
            }
            //this block of code above will read the admin password in a file to a string in the code.



            if (password1.equalsIgnoreCase(adminPassword)) {  //
                System.out.println("You have log in to the admin Successfully");
            } else {
                System.out.println("You have inputted a wrong password ");
                Admin_Login adminLogin = new Admin_Login();
                adminLogin.admin_page_option();
            }
            //this block of code above will check if the password inputted is correct.

            Admin_Login adminLogin = new Admin_Login();
            adminLogin.admin_page_option2();






        } else {
            System.out.println("Incorrect username!!!!");
            System.out.println("Your username is  your company personal email address ");
            Admin_Login adminLogin = new Admin_Login();
            adminLogin.admin_page_option();
        }
        //this block of code above will tell the username is wrong and loop back to the login page.
    }


    //This method will shows the admin page options.
    void admin_page_option2() {


        System.out.println("""
                Welcome! to Intergence Jobs Admin Page Please select an Option:\s
                 1. View candidates Profile\s
                 2. Edit Jobs \s
                 3. Edit Questions \s
                 4. View candidate scores\s
                    Press Any other key to log out""");
        //this block of code above will show what you can do as an admin.

        String adminoption;
        Scanner adminoption1 = new Scanner(System.in);
        String filename;
        Scanner username = new Scanner(System.in);
        adminoption = adminoption1.nextLine();


// The if statement check the user input to be directed the page option of their choice.
        if (adminoption.matches("1")) {


            try {
                System.out.println("Here is the list of Candidates username enter the candidate username you want to view its profile");
                BufferedReader reader = new BufferedReader(new FileReader("candidat.txt"));
                String line;
                while ((line = reader.readLine()) != null)
                    System.out.println(line);
                reader.close();
                filename = username.nextLine();
                BufferedReader reader2 = new BufferedReader(new FileReader(filename + ".txt"));
                String line2;
                while ((line2 = reader2.readLine()) != null)
                    System.out.println(line2);
                reader2.close();
            } catch (IOException e) {
                System.out.println("Sorry No candidates to display at this time");
            }
            //this block of code above will display the usernames of candidate that have registered on this system.



            Admin_Login adminLogin = new Admin_Login();
            adminLogin.admin_page_option2();
            //this code will loop back to the page option
        }



        if (adminoption.matches("2")) { //the block of code in this if statement allows admin to remove jobs


            System.out.println("To add or remove jobs press 1 !! else any other key");
            Scanner adminoption2 = new Scanner(System.in);
            String adminoption3;
            Scanner adminoption4 = new Scanner(System.in);
            String adminoption5;
            adminoption3 = adminoption2.nextLine();

            if (adminoption3.matches("1")) {

                System.out.println("To add job press 2 and to remove job press 3!! else any other key");
                adminoption5 = adminoption4.nextLine();



                if (adminoption5.matches("2")) {

                    System.out.println("Please Enter the job title you want to add:");
                    Scanner addjob = new Scanner(System.in);
                    String addjob11 = (addjob.nextLine());


                    try {
                        FileWriter jobsname = new FileWriter("job_name_done.txt", true);
                        PrintWriter pw = new PrintWriter(jobsname);
                        pw.write("\n");
                        pw.print(addjob11);
                        pw.close();
                        System.out.println(addjob11 + " as be added to jobs successfully");
                        System.out.println("Here is the list of Jobs Available");
                        Read_line("job_name_done.txt");


                    } catch (IOException e) {
                        System.out.println("An error occurred");

                    }

                }
                //this block of code above will allow admin to add jobs.


                if (adminoption5.matches("3")) { //this if statement block allows admin to remove job

                    try {

                        System.out.println("Please Enter the job title you want to remove:");
                        Scanner removejob = new Scanner(System.in);
                        String removejob1 = removejob.nextLine();

                        FileWriter tempFile = new FileWriter("remove_job.txt");
                        PrintWriter pw = new PrintWriter(tempFile);
                        pw.println(removejob1);
                        pw.close();


                        PrintWriter pw1 = new PrintWriter("jobsnames.txt");
                        BufferedReader br1 = new BufferedReader(new FileReader("job_name_done.txt"));
                        String line1 = br1.readLine();


                        while (line1 != null) {
                            boolean flag = false;
                            BufferedReader br2 = new BufferedReader(new FileReader("remove_job.txt"));
                            String line2 = br2.readLine();

                            while (line2 != null) {
                                if (line1.equals(line2)) {
                                    flag = true;
                                    break;
                                }

                                line2 = br2.readLine();
                            }

                            if (!flag)
                                pw1.println(line1);

                            line1 = br1.readLine();

                        }

                        pw1.flush();

                        br1.close();
                        pw1.close();

                        System.out.println("Job as be removed successfully");


                    } catch (IOException e) {

                        System.out.println("No job has been removed");

                    }
                    String line;
                    StringBuilder content = new StringBuilder();


                    try {
                        FileReader fr = new FileReader("jobsnames.txt");
                        BufferedReader br = new BufferedReader(fr);

                        for (line = br.readLine(); line != null; line = br.readLine())
                            content.append(line).append("\n");

                        br.close();


                        try {
                            FileWriter fw = new FileWriter("job_name_done.txt");
                            fw.write(content.toString());
                            fw.close();
                        } catch (IOException ioe) {
                            System.out.println("\nSomething went wrong!");
                        }


                    } catch (IOException ioe) {
                        System.out.println("\nSomething went wrong!");

                    }

                    Read_line("job_name_done.txt");
                }

            }
            Admin_Login adminLogin = new Admin_Login();
            adminLogin.admin_page_option2();
        }





                        if (adminoption.matches("3")) { //this if statement block will allow admin to add and remove pre interview question.


                            System.out.println("Here is the list of available Jobs");
                            Read_line("job_name_done.txt");
                            System.out.println("To edit pre interview Question enter the job title: ");
                            Scanner adminoption9 = new Scanner(System.in);
                            String adminoption8;
                            Scanner question = new Scanner(System.in);


                            adminoption8 = adminoption9.nextLine();
                            System.out.println(adminoption8);


                            System.out.println("To add question press 1 to remove question press 2: ");
                            Scanner admin_option_ques = new Scanner(System.in);
                            String admin_option_ques1;

                            admin_option_ques1 = admin_option_ques.nextLine();

                            if (admin_option_ques1.matches("1")) {

                                try {
                                    BufferedWriter job_ques_name = new BufferedWriter(new FileWriter(adminoption8 + ".txt", true));
                                    System.out.println("Enter pre interview question for " + adminoption8 + ":");
                                    job_ques_name.write("\n");
                                    job_ques_name.write(question.nextLine());
                                    job_ques_name.close();
                                    Read_line(adminoption8 + ".txt");
                                } catch (IOException e) {
                                    System.out.println("An error occurred");

                                }
                            }


                            if (admin_option_ques1.matches("2")) {
                                try {
                                    BufferedWriter job_ques_name1 = new BufferedWriter(new FileWriter(adminoption8 + ".txt", false));
                                    job_ques_name1.write("\n");
                                    job_ques_name1.close();
                                    System.out.println("Pre interview question for " + adminoption8 + " has been removed successfully");
                                } catch (IOException e) {
                                    System.out.println("An error occurred");

                                }


                            }


                            Admin_Login adminLogin1 = new Admin_Login();
                            adminLogin1.admin_page_option2();
                        }


                if (adminoption.matches("4")) { // this block of code shows candidates scores.


            Read_line("Candidate_scores.txt");
        Admin_Login adminLogin2 = new Admin_Login();
        adminLogin2.admin_page_option2();

            }

                else { //this else statement block will allow admin to log out of the admin page.
                    System.out.println("You have successfully log out");
                   Login adminLogin1 = new Login();
                    adminLogin1.log();
                }
        }



        // the method bellow read text file into a string and print it out to the screen.

    static void Read_line(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line5;
            while ((line5 = reader.readLine()) !=null)
                System.out.println(line5);
            reader.close();
        }catch (IOException e){
           System.out.println("An error Occurred");

        }
    }

}