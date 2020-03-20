package com.jspi.crowd.service.api;

import entity.Admin;

import java.util.List;

public interface AdminService {

    void saveAdmin(Admin admin);

    Admin getAdminById(int id);

    void removeAdminById(int id);

    List<Admin> getAll();
}
