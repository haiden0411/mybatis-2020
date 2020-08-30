package com.haiden.mapper;
import com.haiden.bean.User;

import java.util.List;
/**
 * Author：胡灯
 * Date：2020-08-29 22:11
 * Description：<描述>
 */
public interface UserMapper
{
    public List<User> getUsers();
    public Integer addUser(User user);
    public List<User> getUserByNameAndsex(User user);
    public List<User> getUserByNameAndsex1(User user);
    public List<User> getUserByNameAndsex2(User user);
    public Integer saveBatch(List<User> users);
}
