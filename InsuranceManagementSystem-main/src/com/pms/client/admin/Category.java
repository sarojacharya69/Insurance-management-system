package com.pms.client.admin;


import com.pms.admin.dao.Impl.CategoryDAOImpl;
import com.pms.admin.dao.Impl.PolicyDAOImpl;
import com.pms.model.PolicyDetails;


import java.util.Scanner;

public class Category {


    static CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    public static void categoryDetails() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================   ");
            System.out.println("                1)AddCategory                            ");
            System.out.println("                2)ViewCategory                           ");
            System.out.println("                3)UpdateCategory                         ");
            System.out.println("                4)Delete                                 ");
            System.out.println("                5)BackAdminPage                                  ");
            System.out.println("======================================================== ");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    categoryDAO.addCategory();
                    break;
                case 2:
                    for (PolicyDetails category : categoryDAO.viewCategory()) {
                        System.out.println("Category ID: " + category.getCatagoryid());
                        System.out.println("Category Name: " + category.getCatagoryname());
                        System.out.println("Description: " + category.getDescription());
                        System.out.println("----------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter Category Id to update =");
                    int pid = sc.nextInt();
                    categoryDAO.updateCategory(pid);
                    break;
                case 4:
                    System.out.print("Enter Category Id to delete =");
                    int did = sc.nextInt();
                    categoryDAO.deleteCategory(did);
                    break;
                case 5:
                    Admin.adminPage();
                    break;
                default:
                    System.out.println("Choose 1 to 11 Between");

            }
        }
    }

}




