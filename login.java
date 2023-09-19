package ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class login {
    static  ArrayList<SignUp> list = new ArrayList<>();
    public static void main(String[] args) {
        method();
    }
    public static void method(){
        System.out.println("Welcome to Axis Bank");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the option :\n1.Signup \n2.Login\n3.Exit");
            int option = in.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Enter the name :");
                    String name = in.next();
                    System.out.println("Enter the age");
                    int age = in.nextInt();
                    String password;
                    String conPassword;
                    while (true) {
                        System.out.println("Enter the password :");
                        password = in.next();
                        System.out.println("Enter confirm password :");
                        conPassword = in.next();
                        if (!conPassword.equals(password)) {
                            System.out.println("Password and confirm password doesn't match");
                        } else break;
                    }
                    System.out.println("Enter the deposit amount :");
                    int balance = in.nextInt();
                    list.add(new SignUp( password, name, age,balance));
                    System.out.println("Registered successfully");
                }


                case 2 -> {
                    boolean found=false;
                    System.out.println("Enter your Account number:");
                    int idd = in.nextInt();
                    System.out.println("Enter the password :");
                    String password = in.next();
                    for (SignUp signUp : list) {
                        if (idd == signUp.getId() && password.equals(signUp.getPassword())) {
                            found=true;
                            account(idd);
                        }
                    }
                    if(!found){
                        System.out.println("Entered Account number or password is wrong");
                    }
                }
                case 3-> System.exit(0);
            }
        }
    }



    public static void account(int id){
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Enter the option : \n1.Detail \n2.Withdraw\n3.Deposit\n4.Main menu\n5.Exit");
            int option = in.nextInt();
            switch (option){
                case 1->{
                    for (SignUp signUp : list ) {
                        if (id == signUp.getId()) {
                            System.out.println(signUp);
                        }
                    }
                }


                case 2->{
                    System.out.println("Enter the withdraw amount :");
                    int withdraw = in.nextInt();
                    while(withdraw<0) {
                        System.out.println("Enter the valid withdraw amount :");
                        withdraw= in.nextInt();
                    }
                    for (SignUp signUp : list){
                        if(id== signUp.getId()){
                            if(signUp.getBalance()>=withdraw){
                                System.out.println(withdraw+" Amount withdrawn");
                                signUp.setBalance(signUp.getBalance()-withdraw);
                                System.out.println("Balance amount : "+ signUp.getBalance());
                            }
                            else{
                                System.out.println("Insufficient Balance");
                                System.out.println("Balance amount available : "+ signUp.getBalance());
                            }
                        }
                    }
                }


                case 3->{
                    System.out.println("Enter the Deposit amount :");
                    int deposit = in.nextInt();
                    while(deposit<0) {
                        System.out.println("Enter the valid Deposit amount :");
                        deposit= in.nextInt();
                    }
                    for (SignUp signUp : list){
                        if(id== signUp.getId()){
                            System.out.println(deposit+" Amount deposited");
                            signUp.setBalance(deposit+signUp.getBalance());
                            System.out.println("Balance amount : "+ signUp.getBalance());
                        }
                    }
                }

                case 4-> method();

                case 5-> System.exit(0);
            }
        }
    }
}
