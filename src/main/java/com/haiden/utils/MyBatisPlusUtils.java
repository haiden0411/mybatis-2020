package com.haiden.utils;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
/**
 * @author bruceliu
 * @create 2019-09-02 15:37
 * @description 获取sesison和关闭session的工具类
 */
public class MyBatisPlusUtils
{

    /**
     * 01-获取SqlSession
     * @return
     */
    public static SqlSession getSession(){
        SqlSession session=null;
        InputStream inputStream=null;
        try {
            //配置文件的路径
            String resource = "mybatis-config.xml";
            //加载配置文件，得到一个输入流
            inputStream = Resources.getResourceAsStream(resource);
            //获取MyBatis的Session工厂
            SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
            //通过session工厂获取到一个session (此session非Servlet中Session，这个Session表示MyBatis框架和数据库的会话信息)
            //获取到session就表示MyBatis连接上数据库啦！！类似于JDBC中 Connection对象
            session = sqlSessionFactory.openSession(true);//自动提交事务
            //调用session的查询集合方法
            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 02-关闭SqlSession
     * @param session
     */
    public static void closeSession(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}
