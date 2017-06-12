package com.zxxk.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zxxk.domain.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;



/**
 * @Description:
 * @Author:		传智播客 java学院	陈子枢
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年11月15日
 */
public class TestMybatis {
	private SqlSessionFactory factory;
	
	@Before	//最先执行，初始化SessionFactory
	public void init() throws IOException{
		//String resource = "sqlMapConfig.xml";
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test	//查询所有
	public void testFindAll() throws IOException{
		SqlSession session = factory.openSession();
		
		//如何访问mapper中的方法呢？  规则：命名空间+.+id
		List<Person> personList = session.selectList("com.zxxk.domain.PersonMapper.find");
		System.out.println(personList.size());
		for(Person p : personList){
			System.out.println(p);
		}
	}
	
	@Test	//查询一条
	public void testGet(){
		SqlSession session = factory.openSession();
		Person p = session.selectOne("cn.itcast.mapper.PersonMapper.get", 1);
		System.out.println(p);
	}
	
	@Test	//新增
	public void testInsert(){
		SqlSession session = factory.openSession();
		Person p = new Person();
		//p.setId(4);
		p.setName("hellen");
		p.setAge(16);

		
		session.insert("cn.itcast.mapper.PersonMapper.insert", p);
		session.commit();			//提交事务
		
		System.out.println("insert finished.");
	}
	
	@Test	//修改
	public void testUpdate(){
		SqlSession session = factory.openSession();
		Person p = new Person();
		//p.setId(4);
		//p.setName("hellen2");
		p.setAge(18);
		//p.setRemark("beijing");
		
		session.update("cn.itcast.mapper.PersonMapper.update", p);
		session.commit();
	}
	
	@Test	//删除一条
	public void testDeleteById(){
		SqlSession session = factory.openSession();
		
		session.delete("cn.itcast.mapper.PersonMapper.deleteById", 4);
		session.commit();
	}
	
	@Test	//删除多条-数组
	public void testDeleteByArray(){
		SqlSession session = factory.openSession();
		int[] ids = {4,6};
		session.delete("cn.itcast.mapper.PersonMapper.deleteArray", ids);
		session.commit();
	}
	
	@Test	//删除多条-LIST
	public void testDeleteByList(){
		SqlSession session = factory.openSession();
		List<Integer> _list = new ArrayList<Integer>();
		_list.add(4);
		_list.add(6);
		
		session.delete("cn.itcast.mapper.PersonMapper.deleteList", _list);
		session.commit();
	}
	
	@Test	//删除多条 MAP
	public void testDeleteByMap(){
		SqlSession session = factory.openSession();
		Map<String,Object> paraMap = new HashMap<String,Object>();
		int[] ids = {4,6};
		paraMap.put("ids", ids);
		
		session.delete("cn.itcast.mapper.PersonMapper.deleteMap", paraMap);
		session.commit();
	}
	
}
