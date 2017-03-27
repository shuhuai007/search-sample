package com.thoughtworks.spike;

import com.thoughtworks.spike.domain.DevCloudProperties;
import com.thoughtworks.spike.web.HelloController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTest {

    private MockMvc mvc;

    @Autowired
    private DevCloudProperties devCloudProperties;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }


    @Test
    public void test1() throws Exception {
        Assert.assertEquals("DevCloud", devCloudProperties.getName());
        Assert.assertEquals("DevCloud is a project of HuaWei", devCloudProperties.getDesc());
        Assert.assertEquals("90days", devCloudProperties.getDuration());
        Assert.assertEquals("In-Office", devCloudProperties.getWorkPattern());

        Assert.assertEquals("Local", devCloudProperties.getDeployLocation());
    }

}
