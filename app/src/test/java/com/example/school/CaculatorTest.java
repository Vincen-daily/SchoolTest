package com.example.school;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xiecy on 2018/01/08.
 */
public class CaculatorTest {
    Caculator caculator;
    @Before
    public void setUp() throws Exception {
        caculator = new Caculator();
    }

    @Test
    public void sum() throws Exception {
        assertEquals(7,caculator.sum(5,2),0);
    }

    @Test
    public void substract() throws Exception {
    }

    @Test
    public void divide() throws Exception {
    }

    @Test
    public void multiply() throws Exception {
    }

}