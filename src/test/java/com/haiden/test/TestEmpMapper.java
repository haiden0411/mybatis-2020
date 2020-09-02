package com.haiden.test;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haiden.bean.Employee;
import com.haiden.mapper.EmployeeMapper;
import com.haiden.utils.MyBatisPlusUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CheckedOutputStream;
/**
 * Author：胡灯
 * Date：2020-09-01 21:00
 * Description：<描述>
 */
public class TestEmpMapper
{

    SqlSession session = null;
    EmployeeMapper em = null;
    @Before
    public void init(){
        session = MyBatisPlusUtils.getSession();
        em = session.getMapper(EmployeeMapper.class);
    }

    @Test
    public void testAdd(){
        //Employee employee = new Employee("xiaoli", "zhangsi@163.com", "男", 18);
        for (int i = 0; i < 20; i++)
        {
            Employee employee = new Employee("小胡"+i, i+"xiaohu@163.com", "男", 18+i);
            em.insert(employee);
        }
    }

    @Test
    public void testUpdate(){
        //Employee employee = new Employee(1, "gree", "tom@163.com", "女", 22);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setGender("1");
        //employee.setAge(20);
        em.updateById(employee);
    }

    @Test
    public void testSelectById(){
        Employee employee = em.selectById(2);
        System.out.println(employee);
    }

    @Test
    public void testSelectSome(){
        List<Integer> ids = new ArrayList<>();
        ids.add(4);
        ids.add(7);
        List<Employee> employees = em.selectBatchIds(ids);
        employees.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",35);
        List<Employee> employees = em.selectByMap(map);
        employees.forEach(System.out::println);
    }


    @Test
    public void testDeleteById(){
        int count = em.deleteById(1);
        System.out.println(count);
    }

    @Test
    public void testDeleByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("last_name","Jerry");
        map.put("email","jerry@163.com");
        int count = em.deleteByMap(map);
        System.out.println(count);
    }

    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(23, 24, 25);
        int count = em.deleteBatchIds(ids);
        System.out.println(count);
    }

    @Test
    public void testQuery1(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",20);
        queryWrapper.eq("gender","男");
        List<Employee> employees = em.selectList(queryWrapper);
        employees.forEach(System.out::println);
    }

    @Test
    public void testQuery2(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",20);
        queryWrapper.or();
        queryWrapper.eq("gender","1");
        List<Employee> employees = em.selectList(queryWrapper);
        employees.forEach(System.out::println);

    }

    @Test
    public void testBetweenAdn(){
        List<Employee> employees = em.selectList(new QueryWrapper<Employee>().between("age", 18, 23));
        employees.forEach(System.out::println);
    }

    @Test
    public void testOrder(){
        List<Employee> employees = em.selectList(new QueryWrapper<Employee>().between("age", 18, 40).lt("id", 10).orderByDesc("id"));
        employees.forEach(System.out::println);

    }

    @Test
    public void testOrder1(){
        List<Employee> employees = em.selectList(new QueryWrapper<Employee>().between("age", 18, 40).lt("id", 12).orderByDesc("id").orderByDesc("age"));
        employees.forEach(System.out::println);
    }

    @Test
    public void testOrder3(){
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        qw.between("age",18,20);
        qw.or();
        qw.eq("gender",1);
        qw.orderByAsc("age");
        List<Employee> employees =em.selectList(qw);
        employees.forEach(System.out::println);

    }

    @Test
    public void testLike1(){
        List<Employee> employees = em.selectList(new QueryWrapper<Employee>().like("last_name", "小"));
        employees.forEach(System.out::println);
    }

    @Test
    public void testLikeRight(){
        //List<Employee> employees = em.selectList(new QueryWrapper<Employee>().likeRight("last_name", "小"));
        List<Employee> employees = em.selectList(new QueryWrapper<Employee>().likeLeft("last_name", "6"));
        employees.forEach(System.out::println);
    }

    @Test
    public void testNotNull(){
        List<Employee> employees = em.selectList(new QueryWrapper<Employee>().gt("age", 15).isNotNull("last_name"));
        employees.forEach(System.out::println);
    }

    @Test
    public void testCount(){
        Integer count = em.selectCount(new QueryWrapper<Employee>().like("last_name", "6"));
        System.out.println(count);
    }

    @Test
    public void testJihe(){
        List<Map<String, Object>> maps = em.selectMaps(new QueryWrapper<Employee>().select("max(age)", "min(age)"));
        maps.forEach(System.out::println);
    }

    @Test
    public void testGroupBy(){
        List<Map<String, Object>> mapList = em.selectMaps(new QueryWrapper<Employee>().select("max(age)", "min(age)").groupBy("gender"));
        mapList.forEach(System.out::println);
    }

    @Test
    public void testPage(){
       QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age",10,50);
        IPage<Employee> pager = em.selectPage(new Page<Employee>(2, 5), queryWrapper);
        List<Employee> records = pager.getRecords();
        records.forEach(System.out::println);
        System.out.println("page count:"+pager.getPages());
        System.out.println("page total:"+pager.getTotal());
        System.out.println("page current:"+pager.getCurrent());

    }

    public static void closeSession(SqlSession session){
        if(session!=null){
            session.close();
        }
    }


}
