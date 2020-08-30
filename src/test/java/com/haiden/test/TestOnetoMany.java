package com.haiden.test;
import com.haiden.bean.Classes;
import com.haiden.mapper.ClassesMapper;
import com.haiden.mapper.UserMapper;
import com.haiden.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
/**
 * Author：胡灯
 * Date：2020-08-30 10:48
 * Description：<描述>
 */
public class TestOnetoMany
{
    SqlSession session = null;
    ClassesMapper mapper = null;
    @Before
    public void init(){
        session = MyBatisUtils.getSession();
        mapper = session.getMapper(ClassesMapper.class);
    }

    @Test
    public void testGetClasses(){
        List<Classes> classes = mapper.getClasses();
        classes.forEach(System.out::println);
    }

    @Test
    public void testGetClassesByid(){
        Classes classes = mapper.getClassById(2);
        System.out.println(classes);
    }

    @After
    public void destory(){
        MyBatisUtils.closeSession(session);
    }

}
