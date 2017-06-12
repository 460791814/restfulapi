package com.zxxk.service;

import com.zxxk.domain.Person;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
public  class PersonService {

    public void GetAll(){
        // 获取SqlSession对象
        SqlSession session = MyBatisUtil.getSqlSession();
        // 查询全部对象
        List<Person> list = session.selectList("com.zxxk.mapper.PersonMapper.findall");
        System.out.println(list.size());
        //关闭SqlSession对象
        MyBatisUtil.closeSqlSession(session);

    }
}
