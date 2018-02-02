package com.example.school.adminPage.presentation.di;

import com.example.school.adminPage.presentation.view.AdminPageActivity;

import dagger.Component;

/**
 * Created by xiecy on 2017/12/20.
 */
@Component(modules = AdminPageModule.class)
public interface AdminPageComponent {

    void inject(AdminPageActivity activity);
}
