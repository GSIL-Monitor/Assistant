package com.rongzi.datasource.service.impl;

import com.rongzi.DataSourceApp;
import com.rongzi.dataSource.model.CltBase;
import com.rongzi.dataSource.service.CtlBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataSourceApp.class)
public class CtlBaseServiceImplTest {


    @Autowired
    CtlBaseService ctlBaseService;

    @Test
    public void findCltBaseAll() {


        List<CltBase> beijing = ctlBaseService.findCltBaseAll("chengdu");


        for (CltBase cltBase : beijing) {


            System.out.println(cltBase);
        }

    }
}