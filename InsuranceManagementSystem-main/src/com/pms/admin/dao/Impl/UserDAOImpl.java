package com.pms.admin.dao.Impl;

import com.pms.admin.dao.UserDAO;
import com.pms.model.UserList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserDAOImpl implements UserDAO {
    Scanner sc = new Scanner(System.in);
     static List<UserList> addUser = new LinkedList<>();
      static List<UserList> activeUserList = new LinkedList<>();
     static  List<UserList> policyRequestList = new LinkedList<>();
     static List<UserList> cancelUser = new LinkedList<>();

    @Override
    public void addCustomer() {
        int k=1;
        while(k==1){
        System.out.print("Enter User ID =");
        int uid = sc.nextInt();
        System.out.print("Enter User Name=");
        String uname = sc.next();
        System.out.print("Enter User Address=");
        String add = sc.next();
        System.out.print("Enter User Phone=");
        long phone = sc.nextLong();
        System.out.print("Enter email=");
        String email = sc.next();
        System.out.print("Enter Password =");
        String psw = sc.next();
        UserList user = new UserList(uid, uname, add, phone, email, psw);
        addUser.add(user);//add user data to addUser linked-list
        System.out.println(" Registration successful");
            System.out.println("Do you want register more member 1 for Yes / 2 for No=");
            k=sc.nextInt();}
    }


    @Override
    public List<UserList> viewAllUserInfo() {

        return addUser;
    }


    @Override
    public boolean AuthenticationEmailandPassword(String email, String password) {
        int k = 0;
        for (UserList pro : addUser) {

            if ((pro.getEmail().equals(email)) && (pro.getPassword().equals(password))) {
                k++;
                return true;
            } else if
            ((pro.getEmail().equals(email)) || (pro.getPassword().equals(password)))
                System.out.println("You Enter wrong User name  or password");
            k++;
            return false;

        }
        if (k == 0)
            System.out.println("User not found");

        return false;
    }


    @Override
    public String getPassword(String email) {
        int k = 0;
        for (UserList pro : addUser) {
            if ((pro.getEmail().equals(email))) {
                String getpsw = pro.getPassword();
                k++;
                return getpsw;
            }

        }
        if (k == 0)
            System.out.println("User not Exit");

        return null;

    }


    @Override
    public List<UserList> PolicyRequest(String email, int policyID) {

        for (UserList pro : addUser) {
            if (pro.getEmail().equals(email)) {
                int id = pro.getUid();
                String name = pro.getUname();
                String address = pro.getAddress();
                long phone = pro.getPhone();
                String mail = pro.getEmail();
                String ss = "Requested";
                UserList RequestUser = new UserList(id, policyID, name, address, phone, mail, ss);
                policyRequestList.add(RequestUser);

            }
        }
        return policyRequestList;
    }


    public void PolicyRequestList() {

        for (UserList aa : policyRequestList) {
            System.out.println("User ID: " + aa.getUid());
            System.out.println("Policy ID: " + aa.getPolicyID());
            System.out.println("User Name: " + aa.getUname());
            System.out.println("User Address: " + aa.getAddress());
            System.out.println("User Phone: " + aa.getPhone());
            System.out.println("User Email: " + aa.getEmail());
            System.out.println("Status: " + aa.getStatus());
            System.out.println("----------------------");
        }
    }

    @Override
    public List<UserList> policyActivate(String email, int policyID) {
        int k = 0;
        for (UserList pro : policyRequestList) {
            if (pro.getEmail().equals(email) && (pro.getPolicyID() == policyID)) {
                int id = pro.getUid();
                String name = pro.getUname();
                String address = pro.getAddress();
                long phone = pro.getPhone();
                String mail = pro.getEmail();
                UserList ActiveUser = new UserList(id, policyID, name, address, phone, mail, "Active");
                activeUserList.add(ActiveUser);
                k++;  //this block code create active user list
                return activeUserList;
            }}


               if (k == 0)
               System.out.println("User not Exit");
               return null;
               }

    public void policyActiveUserList() {

        for (UserList pAUL : activeUserList) {
            System.out.println("User ID: " + pAUL.getUid());
            System.out.println("Policy ID: " + pAUL.getPolicyID());
            System.out.println("User Name: " + pAUL.getUname());
            System.out.println("User Address: " + pAUL.getAddress());
            System.out.println("User Phone: " + pAUL.getPhone());
            System.out.println("User Email: " + pAUL.getEmail());
            System.out.println("Status: " + pAUL.getStatus());
            System.out.println("----------------------");
        }
    }

    public void policyHold(int userID) {
        int k = 0;
        for (UserList au : activeUserList) {
            if (au.getUid() == userID) {
                System.out.println("User ID: " + au.getUid());
                System.out.println("Policy ID: " + au.getPolicyID());
                System.out.println("User Name: " + au.getUname());
                System.out.println("User Address: " + au.getAddress());
                System.out.println("User Phone: " + au.getPhone());
                System.out.println("User Email: " + au.getEmail());
                System.out.println("Status: " + au.getStatus());
                System.out.println("----------------------");
                k++;
            }
        }
        if (k == 0)
            System.out.println("not Exit");
    }


    public boolean AuthonticationAdmin(String email, String password) {

        if (UserList.Aemail.equals(email) && (UserList.Apassword.equals(password))) {
            return true;

            } else if (UserList.Aemail.equals(email) || (UserList.Apassword.equals(password))) {
            System.out.println("You Enter wrong Admin email or password");
            return false;
            } else
            System.out.println("You Enter invalid  admin email and password");
        return false;
            }

    @Override
    public List<UserList> PolicyCancel(String email, int policyID) {
        int k = 0;
        for (UserList pro : activeUserList) {
            if (pro.getEmail().equals(email) && (pro.getPolicyID() == policyID)) {

                int id = pro.getUid();
                String name = pro.getUname();
                String address = pro.getAddress();
                long phone = pro.getPhone();
                String mail = pro.getEmail();
                String ca = "Cancel";
                UserList cUser = new UserList(id, policyID, name, address, phone, mail, ca);
                cancelUser.add(cUser);
                activeUserList.remove(pro);
                k++;
                return cancelUser;
               }}


                if (k == 0)
               System.out.println("User not Exit");
               return null;
    }

    public void policyCancelUserList() {

        for (UserList au : cancelUser) {
            System.out.println("User ID: " + au.getUid());
            System.out.println("Policy ID: " + au.getPolicyID());
            System.out.println("User Name: " + au.getUname());
            System.out.println("User Address: " + au.getAddress());
            System.out.println("User Phone: " + au.getPhone());
            System.out.println("User Email: " + au.getEmail());
            System.out.println("Status: " + au.getStatus());
            System.out.println("----------------------");

        }
    }
}
