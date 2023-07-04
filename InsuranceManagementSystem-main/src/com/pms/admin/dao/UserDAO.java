package com.pms.admin.dao;

import com.pms.client.admin.Admin;
import com.pms.model.UserList;

import java.util.List;

public interface UserDAO {
    public void addCustomer();

    public List<UserList> viewAllUserInfo();

    public boolean AuthenticationEmailandPassword(String email, String password);

    String getPassword(String Username);

    public List<UserList> policyActivate(String email, int policyID);

    public List<UserList> PolicyRequest(String email, int policyID);

    public List<UserList> PolicyCancel(String email, int policyID);

    public boolean AuthonticationAdmin(String email, String password);


}
