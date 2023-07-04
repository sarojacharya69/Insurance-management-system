package com.pms.admin.dao.Impl;

import com.pms.model.PolicyDetails;

import java.util.LinkedList;
import java.util.List;

public class CategoryDAOImpl extends PolicyDAOImpl {
    @Override

    public void addCategory() {

        int k = 1;
        while (k == 1) {
            System.out.println("Enter Category ID =");
            int cid = sc.nextInt();
            System.out.println("Enter Category =");
            String cname = sc.next();
            System.out.println("Enter description =");
            String ds = sc.next();
            PolicyDetails cat = new PolicyDetails(cid, cname, ds);
            addCategory.add(cat);
            System.out.println("Category add successfully");
            System.out.println("Do you want add more Category 1 for Yes / 2 for No=");
            int i = sc.nextInt();
            k = i;
        }
        System.out.println(addCategory);
        System.out.println("\n");
    }


    @Override
    public List<PolicyDetails> viewCategory() {

        return addCategory;
    }

    @Override
    public void updateCategory(int ccid) {
        int k = 0;
        for (PolicyDetails pro : addCategory) {
            if (pro.getCatagoryid() == ccid) {
                System.out.println("Do you want modify 1)Name 2)Description ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Category name=");
                        String pname = sc.next();
                        pro.setCatagoryname(pname);
                        System.out.println("Category is Update");
                        break;
                    case 2:
                        System.out.print("Enter Description=");
                        String add = sc.next();
                        pro.setDescription(add);
                        System.out.println("Description Update");
                        break;
                    default:
                        System.out.println(" please Choose 1 to 2");
                }
                ++k;
            }
        }
        if (k == 0) {
            System.out.println(" Given record not exit");
        }
    }


    @Override
    public void deleteCategory(int cid) {
        int k = 0;
        for (PolicyDetails pro : addCategory) {
            if (pro.getCatagoryid() == cid)
                addCategory.remove(pro);
            System.out.println("Category Deleted successfully");

            k++;
            break;
        }
        if (k == 0)
            System.out.println(" Given ID is not exit");

    }
}
