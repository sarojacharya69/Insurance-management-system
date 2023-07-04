package com.pms.client.Customer;

import com.pms.admin.dao.Impl.PolicyDAOImpl;
import com.pms.admin.dao.Impl.UserDAOImpl;
import com.pms.client.HomePage;
import com.pms.model.PolicyDetails;

import java.util.Scanner;

import static com.pms.client.Customer.Home.categoryDAO;
import static com.pms.client.Customer.Home.subCategoryDAO;

public class UserDashBoard {
    static PolicyDAOImpl policyDAOc = new PolicyDAOImpl();
    static UserDAOImpl userDAO = new UserDAOImpl();

    public static void UserDashBoardmenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====================================================");
            System.out.println("                1)View Category                     ");
            System.out.println("                2)View SubCategory                  ");
            System.out.println("                3)view Policy                       ");
            System.out.println("                4)Request Policy                     ");
            System.out.println("                5)Policy Hold                       ");
            System.out.println("                6)BackHomePage                             ");
            System.out.println("=====================================================");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (PolicyDetails category : categoryDAO.viewCategory()) {
                        System.out.println("Category ID: " + category.getCatagoryid());
                        System.out.println("Category Name: " + category.getCatagoryname());
                        System.out.println("Description: " + category.getDescription());
                        System.out.println("----------------------");
                    }
                    break;

                case 2:
                    for (PolicyDetails scategory : subCategoryDAO.viewSubCategory()) {
                        System.out.println("SubCategory ID: " + scategory.getSubcategoryid());
                        System.out.println("SubCategory Name: " + scategory.getSubCatagoryname());
                        System.out.println("Description: " + scategory.getDescription());
                        System.out.println("----------------------");
                    }
                    break;

                case 3:

                    for (PolicyDetails policy : policyDAOc.viewPolicy()) {
                        System.out.println("Policy ID: " + policy.getPolicyid());
                        System.out.println("Category: " + policy.getCatagoryname());
                        System.out.println("SubCategory: " + policy.getSubCatagoryname());
                        System.out.println("Policy Name: " + policy.getPolicName());
                        System.out.println("Amount Assured: " + policy.getSumAssured());
                        System.out.println("Premium: " + policy.getPremium());
                        System.out.println("Description: " + policy.getDescription());
                        System.out.println("----------------------");
                    }
                    break;


                case 4:

                    System.out.print("Enter user email");
                    String eemail = sc.next();
                    System.out.print("Enter user password");
                    String ppsw = sc.next();
                    if (userDAO.AuthenticationEmailandPassword(eemail, ppsw) != false) {
                        System.out.print("Enter Policy Id =");
                        int id = sc.nextInt();
                        userDAO.PolicyRequest(eemail, id);
                        System.out.println("Request Successfully");
                    } else
                        System.out.println("Register First");
                    break;
                case 5:
                    System.out.print("Enter your Id=");
                    int id = sc.nextInt();
                    userDAO.policyHold(id);
                    break;

                case 6:
                    HomePage.main(null);
                    break;
                default:
                    System.out.println("Choose 1 to 6 Between");

            }
        }
    }

}


