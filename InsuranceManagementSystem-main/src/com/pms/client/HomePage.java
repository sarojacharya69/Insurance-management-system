package com.pms.client;

import com.pms.admin.dao.Impl.UserDAOImpl;
import com.pms.client.Customer.Home;
import com.pms.client.Customer.Registration;
import com.pms.client.Customer.UserDashBoard;
import com.pms.client.admin.Admin;


import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {

        UserDAOImpl userDAO = new UserDAOImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================");
            System.out.println("                1)Home                                 ");
            System.out.println("                2)SignIn                               ");
            System.out.println("                3)SignOut                               ");
            System.out.println("                4)exit                                  ");
            System.out.println("========================================================");
            System.out.print("Enter the choice=");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Home.customermenu();
                    break;
                case 2:
                    System.out.println("Are you Admin user type Yes or No?=");
                    String userOpt = sc.next();
                    if (userOpt.equalsIgnoreCase("yes")) {
                        System.out.print("Enter AdminUser ");
                        String adminUser = sc.next();
                        System.out.print("Enter AdminPassword ");
                        String password = sc.next();
                        if (userDAO.AuthonticationAdmin(adminUser, password) != false)
                            System.out.println("Insurance Management System Admin User :" + adminUser);
                        Admin.adminPage();
                    } else {
                        System.out.print("Enter UserEmail ");
                        String useremail = sc.next();
                        System.out.print("Enter  User Password ");
                        String password = sc.next();
                        if (userDAO.AuthenticationEmailandPassword(useremail, password) != false)
                            System.out.println("Insurance Management System  User Login :" + useremail);
                        UserDashBoard.UserDashBoardmenu();
                    }
                    break;

                case 3:
                    Registration.CustomerClientmenu();
                    break;
                case 4:
                    System.out.println("*******************Thanks For Using Apps****************");
                    System.exit(0);

                default:
                    System.out.println("Enter 1 to 4 ");
            }

        }
    }
}






