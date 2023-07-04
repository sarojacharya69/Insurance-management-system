package com.pms.admin.dao;

import com.pms.model.PolicyDetails;

import java.util.List;

public interface PolicyDetailsDAO {
    void addPolicy();

    List<PolicyDetails> viewPolicy();

    PolicyDetails viewPolicy(int pid);

    void updatePolicy(int pid);

    void deletePolicy(int pid);

    void addCategory();

    List<PolicyDetails> viewCategory();

    void updateCategory(int pid);

    void deleteCategory(int pid);

    void addSubCategory();

    List<PolicyDetails> viewSubCategory();

    void updateSubCategory(int pid);

    void deleteSubCategory(int pid);


}
