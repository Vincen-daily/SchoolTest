package com.example.school;

import android.os.UserManager;

import com.example.school.dao.Parent;
import com.example.school.dao.Student;
import com.example.school.dao.Teacher;

import org.junit.Test;
import org.litepal.crud.DataSupport;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2018/01/08.
 */

public class Login {

    @Test
    public void testLogin() throws Exception {
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);  //<==

        loginPresenter.login("xiaochuang", "xiaochuang password");

        Mockito.verify(mockUserManager).performLogin("xiaochuang", "xiaochuang password");
    }

}
