package com.customer.manager.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.customer.manager.CustomermanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@SpringBootTest(classes = CustomermanagerApplication.class)
public class CustomerControllerTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeClass
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        mockMvc.perform(get("/api/customers")).andExpect(status().isOk());
    }

    @Test
    public void testGetCustomerById() throws Exception {
        mockMvc.perform(get("/api/customers/1")).andExpect(status().isOk());
    }

    @Test
    public void testDeleteCustomerById() throws Exception {
        mockMvc.perform(delete("/api/customers/1")).andExpect(status().isOk());
    }

}