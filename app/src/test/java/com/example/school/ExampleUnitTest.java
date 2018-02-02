package com.example.school;

import com.example.school.adminPage.data.repository.IRepositoryImpl;
import com.example.school.adminPage.data.repository.RepositoryInterface;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public String updateCheck(int id, String name, int teacher,String message) {
//         name="q";teacher=1;id=1;
//        RepositoryInterface repositoryInterface=new IRepositoryImpl() ;
//        if (id==0||name==null||teacher==0){
//            message="请输入完整信息！";
//        }else {
//            repositoryInterface.update(id,name,teacher);
//            message="修改成功！";
//        }
//        return message;
//    }

}