package com.rongzi.citys.modules.service.impl;

import com.rongzi.CitysApp;
import com.rongzi.citys.modules.model.Clt_base;
import com.rongzi.citys.modules.service.Clt_BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CitysApp.class)
public class Clt_BaseServiceImplTest {

    @Autowired
    Clt_BaseService clt_baseService;

    @Test
    public void findClt_baseByCityTag() {

        List<Clt_base> dataSourceBEIJING = clt_baseService.findClt_baseByCityTag("dataSourceCHENGDU");



        for (Clt_base clt_base : dataSourceBEIJING) {

            System.out.println(clt_base);
        }


    }
}