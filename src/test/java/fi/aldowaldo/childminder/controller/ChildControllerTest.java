package fi.aldowaldo.childminder.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import fi.aldowaldo.childminder.model.Child;
import fi.aldowaldo.childminder.service.ChildService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ChildController.class)
public class ChildControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ChildService childService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addChild() throws Exception {
        Child child = new Child();

        mvc.perform(post("/child/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL)
                .content(objectMapper.writeValueAsString(child)))
                .andExpect(status().isOk());

        verify(childService, times(1)).addChild(child);
    }

    @Test
    public void getAllChildren() throws Exception {

        mvc.perform(get("/child/all")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(childService, times(1)).getAllChildren();
    }

    @Test
    public void getAllPresentChildren() throws Exception {

        mvc.perform(get("/child/all/present")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(childService, times(1)).getAllPresentChildren();
    }

    @Test
    public void getAllChildrenForTheDay() throws Exception {

        mvc.perform(get("/child/all/2017-05-19")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(childService, times(1)).getAllChildrenForTheDay("2017-05-19");
    }

    @Test
    public void removeChild() throws Exception {

        mvc.perform(delete("/child/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(childService, times(1)).removeChild(1l);
    }
}
