package org.real2space.congraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * @created 2016/10/10
 */
public class MainTest {
    private Main test;
    @Before
    public void setUp() throws Exception {
        this.test = new Main();
        this.test.test();
        System.out.println ("congraph test");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test1() throws Exception {

    }

}