package com.zxxk.controller;

import com.zxxk.domain.Person;
import com.zxxk.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * jersey2 +springmvc+mybatis
 * Created by Administrator on 2017/6/12.
 */
@Path("/api")
public class democontroller {
    /**
     GET（SELECT）：从服务器取出资源（一项或多项）。
     POST（CREATE）：在服务器新建一个资源。
     PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
     PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
     DELETE（DELETE）：从服务器删除资源。

     HEAD：获取资源的元数据。
     OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。

     GET /zoos：列出所有动物园
     POST /zoos：新建一个动物园
     GET /zoos/ID：获取某个指定动物园的信息
     PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
     PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
     DELETE /zoos/ID：删除某个动物园
     GET /zoos/ID/animals：列出某个指定动物园的所有动物
     DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物

     */

    //GET注解设置接受请求类型为GET
    //Produces表明发送出去的数据类型为text/plain
    // 与Produces对应的是@Consumes，表示接受的数据类型为text/plain
    @Produces("text/plain")
    @GET
    @Path("/hello")
    public String demo(){

        return "hello";
    }
    @GET
    @Path("/persons")
    public List<Person> GetAll()
    {
        PersonService service=new PersonService();
        service.GetAll();
        return null;
    }
    @GET
    @Path("/person/{id}")
    public  Person GetPersonByID(@PathParam("id")int id){

    return  null;

    }

}
