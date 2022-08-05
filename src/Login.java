import java.util.Scanner;
    public class Login {
        void log() {
            System.out.println("Hello! do you want to login as a 'Candidate' or 'Admin'");  // This line of code prompt the user to login as an admin or a candidate.
            Scanner login1 = new Scanner(System.in);
            System.out.println("Type Your Response");
            String position = " ";
            while(!position.matches("Candidate") || !position.matches("Admin")) {

                position = login1.nextLine();
                if (position.matches("Candidate") || position.matches("Admin")) {
                    System.out.println("You chose: " + position);
                    break;
                }
            }
            //The block of code above check if the character inputted is either candidate or admin.
            if (position.matches("Candidate") ) {
               Candidate_register candidateRegister = new Candidate_register();
                candidateRegister.can_register();
            }
// this block of code above allow user that picked candidate to register if they have not.
            if(position.matches("Candidate")){
                Candidate_apply candidate_apply = new Candidate_apply();
                candidate_apply.page_option();
            }
            // This block of code above allows candidate to log in with the correct login details
            if(position.matches("Admin")){
              Admin_Login adminLogin = new Admin_Login();
              adminLogin.admin_page_option();

            }
            //This block of code above allows admin to log in with the correct admin details.
        }





    }


