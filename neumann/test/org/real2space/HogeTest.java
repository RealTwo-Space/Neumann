package org.real2space;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sryosuke on 2016/10/09.
 */
public class HogeTest {
    private Hoge hoge;
    @Before
    public void setUp() throws Exception {
        System.out.println ("setup");
        hoge = new Hoge ("created Hoge instance");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println ("tear down");
    }

    @Test
    public void show() throws Exception {
        System.out.println ("invoked show");
        hoge.show();
    }

}