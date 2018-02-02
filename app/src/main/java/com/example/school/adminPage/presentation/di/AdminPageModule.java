package com.example.school.adminPage.presentation.di;

import com.example.school.adminPage.presentation.IPresenterAdminPage;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiecy on 2017/12/20.
 */
@Module
public class AdminPageModule {

    private IPresenterAdminPage.View mView;

    public AdminPageModule(IPresenterAdminPage.View view){
        mView = view;
    }

    @Provides
    IPresenterAdminPage.View provideAdminPageView(){
        return mView;
    }
}
