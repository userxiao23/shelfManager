package com.jspi.crowd.service.impl;

import com.jspi.crowd.mapper.AdminMapper;
import com.jspi.crowd.service.api.AdminService;
import entity.Admin;
import entity.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     : wz
 * @ ClassName  : AdminServiceImpl
 * @ Date       ：Created in 2020/3/18 22:50
 * @ Description：
 * @ Modified By：
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public void saveAdmin(Admin admin) {

        adminMapper.insert(admin);
        throw new RuntimeException();
    }

    public Admin getAdminById(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public void removeAdminById(int id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());

    }

}
