package com.example.school;

/**
 * Created by xiecy on 2017/12/13.
 */

public class Classes {
//    // 依赖类
//    private Boy boy;
//
//    public Classes(){
//        // 在当前对象中直接 new 出依赖类
//        boy = new Boy("li");
//    }
//
//    public void run(){
//        boy.run();
//    }
// 依赖类
private Boy boy;


    /**
     * 构造方法注入，通过构造方法传入该对象
     * @param boy
     */
    public Classes(Boy boy) {
        this.boy = boy;
    }


    public void run() {
        boy.run();
    }
}
