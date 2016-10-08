package org.real2space;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class HogeTest {
    private Hoge hoge;
    @Before
    public void setUp() throws Exception {
        System.out.println ("setup");
        hoge = new Hoge ("Hoge's method - show -");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println ("tear down");
    }

    @Test
    public void show() throws Exception {
        hoge.show();
    }

}