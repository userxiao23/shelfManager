package com.jspi.crowd.test;

import com.jspi.crowd.mapper.AdminMapper;
import com.jspi.crowd.service.api.AdminService;
import com.jspi.crowd.service.impl.AdminServiceImpl;
import entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author     : wz
 * @ ClassName  : CrowdTest
 * @ Date       ：Created in 2020/3/18 18:09
 * @ Description：
 * @ Modified By：
 **/
/*在类上标记必要的注解，Spring整合Junit-------IOC容器有的，test可以进行装配*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
    @Test
    public void testSaveAdmin(){
        Admin admin = new Admin(null, "MrLiu", "111111", "刘备", "123@qq.com", null);
        int insert = adminMapper.insert(admin);
        System.out.println("受影响的行数:"+insert);
    }
    @Test
    public void testLogger(){
        /*首先获取Logger,参数为当前类*/
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);
        /*设置日志级别*/
        logger.debug("This is a debug!!!!!!");
        logger.debug("This is a debug!!!!!!");
        logger.debug("This is a debug!!!!!!");
        logger.info("info!!!!!");
        logger.info("info!!!!!");
        logger.info("info!!!!!");
        logger.warn("warn!!!!!");
        logger.warn("warn!!!!!");
        logger.warn("warn!!!!!");
        logger.warn("warn!!!!!");
        logger.error("error!!!");
        logger.error("error!!!");
        logger.error("error!!!");
        logger.error("error!!!");
    }
    @Test
    public void testService(){

        Admin admin = new Admin(null, "小绿", "222222", "关羽", "xiaolu@qq.com", null);
        adminService.saveAdmin(admin);
    }
    @Test
    public void testGetAdminByIdService(){
        Admin admin = adminService.getAdminById(1);
        System.out.println(admin);
    }
    @Test
    public void testRemoveAdminByIdService(){
            adminService.removeAdminById(11);

    }

}
