package com.jcs.goboax.aulavirtual.controller;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.After;
import org.junit.Before;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml",
                                   "InMemoryDbTestBase-contex.xml"})
@ActiveProfiles(profiles = "test")
public class InMemoryDbTestBase
{
    // &: get the actual factory, not the object it produced
//    @Resource(name = "&sessionFactory")
//    private LocalSessionFactoryBean sf;

    @Resource
    private DataSource dataSource;

    private Connection conn;

    @Before
    public void setup() throws Exception
    {
        conn = dataSource.getConnection();
    }

    @After
    public void teardown() throws Exception
    {
        // see http://hsqldb.org/doc/guide/running-chapt.html#rgc_closing_db
        if (null != conn)
        {
            conn.createStatement().execute("SHUTDOWN");
            conn.close();
            conn = null;
        }
    }
}
