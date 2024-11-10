package com.popcorn.controller;

import com.google.gson.Gson;
import jakarta.servlet.http.Cookie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class RootControllerTest {
    private static final String ROOT_URL = "/api/v1/roots";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson jsonHelper;

    @Test
    void testRootSubAPI() throws Exception {
        mockMvc.perform(
                post(ROOT_URL+"/sub/{id}", "101")
                        .header("Authorization","Basic dXNlcm5hbWU6cGFzc3dvcmQ=")
                        .contentType("application/json")
                        .content(jsonHelper.toJson(Map.of("name", "John Doe")))
                        .param("q", "how to create a variable in java")
                        .cookie(new Cookie("JSESSIONID", "415A4AC178C59DACE0B2C9CA727CDD84"))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("Content-Type"))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andReturn();
    }
}