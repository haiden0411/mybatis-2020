package com.haiden.mapper;
import com.haiden.bean.Classes;

import java.util.List;
/**
 * Author：胡灯
 * Date：2020-08-30 10:52
 * Description：<描述>
 */
public interface ClassesMapper
{
    public List<Classes> getClasses();

    public Classes getClassById(Integer cid);
}
