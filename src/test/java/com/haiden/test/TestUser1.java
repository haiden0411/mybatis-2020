package com.haiden.test;
import com.haiden.bean.User;
import com.haiden.mapper.UserMapper;
import com.haiden.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUser1
{
    SqlSession session = null;
    UserMapper mapper = null;
    @Before
    public void init(){
       session = MyBatisUtils.getSession();
       mapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testSearch(){
        List<User> users = mapper.getUsers();
        users.forEach(System.out::println);
    }


    @After
    public void destory(){
        MyBatisUtils.closeSession(session);
    }

}
