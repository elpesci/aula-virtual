package com.jcs.goboax.aulavirtual.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class HomeControllerTest extends InMemoryDbTestBase
{
    private MockMvc mockMvc;

    @InjectMocks
    private HomeController homeController;

    @Before
    public void setup() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void simple() throws Exception
    {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("cursos"));
    }
}
