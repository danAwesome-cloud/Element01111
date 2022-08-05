import java.io.*;
import java.util.Locale;
import java.util.Scanner;
public class Candidate_apply {
    public  static String username="";
    void page_option() { //this method display candidates page, it allows candidate to log in with correct details.


        System.out.println("Enter your username");
        Scanner log1 = new Scanner(System.in);
        username = log1.nextLine();
        System.out.println("Enter your password");
        Scanner log2 = new Scanner(System.in);
        String password = log2.nextLine();

// the code bellow read the text file to a string to compare password with user input.
        String d0b_red = " ";
        try {
            BufferedReader dob_reader = new BufferedReader(new FileReader(username + "dob" + ".txt"));

            d0b_red = dob_reader.readLine();
        } catch (IOException e) {
            System.out.println("Something Went Wrong");

        }

//this if statement will check if the password is correct and login.
        if (password.equalsIgnoreCase(d0b_red)) {
            System.out.println("Welcome!  " + username);
            Candidate_apply candidate_apply = new Candidate_apply();
            candidate_apply.page_option2();

        } else { // this else statement block alert the user they have inputted wrong login details and takes them back to the login page.

            System.out.println("Incorrect username or password");
            System.out.println("Your default password is your date of birth");
            Candidate_apply candidate_apply = new Candidate_apply();
            candidate_apply.page_option();
        }
    }

    void page_option2() { // this method allows the user to view their profile apply for job, view messages, change password and log out.
        System.out.println("""
                Welcome! to Intergence Jobs Page Please select an Option:
                Profile
                Jobs
                Messages
                Edit_Password
                Logout""");

        Scanner new_Password1 = new Scanner(System.in);
        Scanner useroption1 = new Scanner(System.in);
        String useroption;
        useroption = useroption1.nextLine();

        if (useroption.matches("Profile")) {//this if block allows candidates to view their profile.
            read_file(username);
            Candidate_apply candidate_apply = new Candidate_apply();
            candidate_apply.page_option2();
        }


        if (useroption.matches("Edit_Password")) { //the if statement block allows user to change password.
            System.out.println("Enter a new password: ");
            String new_password1 = new_Password1.nextLine();


            try {

                BufferedWriter newpassword = new BufferedWriter(new FileWriter(username + "dob" + ".txt", false));
                newpassword.write(new_password1);
                newpassword.close();
                System.out.println("Password Changed Successfully ");

            } catch (IOException e) {

                System.out.println("An error occurred when trying to change password");

            }

            Candidate_apply candidate_apply = new Candidate_apply();
            candidate_apply.page_option2();
        }


        if (useroption.matches("Messages")) {
            System.out.println("Response will be sent directly to your E-mail address");
            Candidate_apply candidate_apply = new Candidate_apply();
            candidate_apply.page_option2();
        }


        if (useroption.matches("Jobs")) { //this block of code allow user to apply for jobs and take pre interview question.
            System.out.println("This are the Jobs available");
            Admin_Login.Read_line("job_name_done.txt");
            System.out.println("Enter the Job title you want to apply:");
            Scanner job_title = new Scanner(System.in);
            Scanner user_choice = new Scanner(System.in);
            Scanner ans_ques1 = new Scanner(System.in);
            Scanner ans_ques2 = new Scanner(System.in);
            Scanner ans_ques3 = new Scanner(System.in);
            String ans_que1;
            String ans_que2;
            String ans_que3;
            String user_choice1;
            String job_title1;



            job_title1 = job_title.nextLine();



            System.out.println("To apply for this job you need to take some pre interview question");
            System.out.println("Press 1 to proceed or any other key to go back to your page:");


            user_choice1 = user_choice.nextLine();

            if (user_choice1.matches("1")) {
                read_file(job_title1); // this line of code uses user input to display the correct pre interview question.

                System.out.println("*******IMPORTANT INFORMATION**********");
                System.out.println("Questions are multiple choice answer as applicable");
                System.out.println("Answers duration are saved and the performance result will be available immediately you are done with the test:");



                System.out.println("Question 1 answer :");
                ans_que1 = ans_ques1.nextLine();
                String ans1 = ans_que1.toLowerCase(Locale.ROOT);
                System.out.println("Question 2 answer :");
                ans_que2 = ans_ques2.nextLine();
                String ans2 = ans_que2.toLowerCase(Locale.ROOT);
                System.out.println("Question 3 answer :");
                ans_que3 = ans_ques3.nextLine();
                String ans3 = ans_que3.toLowerCase(Locale.ROOT);
                if (ans1.matches("d")) {
                    ans1 = "50";
                } else {
                    ans1 = "0";
                }
                if (ans2.matches("b")) {
                    ans2 = "50";
                } else {
                    ans2 = "0";
                }
                if (ans3.matches("a")) {
                    ans3 = "50";
                } else {
                    ans3 = "0";
                }
                int answer1 = Integer.parseInt(ans1);
                int answer2 = Integer.parseInt(ans2);
                int answer3 = Integer.parseInt(ans3);
                int score = answer1 + answer2 + answer3;
                System.out.println("You scored " + score + " points out of 150 points");
                System.out.println("Thanks for taking the test you will get a response from the admin within 24 hours");
                try {
                    BufferedWriter candidatescore = new BufferedWriter(new FileWriter("Candidate_scores.txt", true));
                    candidatescore.write("Username ---- " + username + " Job Title ----- " + job_title1 + " Score = " + score);
                    candidatescore.write("\n");
                    candidatescore.close();
                } catch (IOException e) {
                    System.out.println("An error Occurred when trying to save your result");

                }
                Candidate_apply candidate_apply = new Candidate_apply();
                candidate_apply.page_option2();
            }

        }
        if (useroption.matches("Logout")) {
            System.out.println("You have been Log out Successfully!");
            Login pageLogin1 = new Login();
            pageLogin1.log();
        }


    }





    private void read_file(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(username + ".txt"));
            String line;
            while ((line = reader.readLine()) !=null)
            System.out.println(line);
            reader.close();
        }catch (IOException e){
            System.out.println("You have Inputted a wrong Job, please check the list of jobs and apply again");
        }
        Candidate_apply candidate_apply = new Candidate_apply();
        candidate_apply.page_option2();
    }
}