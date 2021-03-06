package fi.aldowaldo.childminder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.aldowaldo.childminder.dto.ChildAndChildGroupDto;
import fi.aldowaldo.childminder.model.ChildGroup;
import fi.aldowaldo.childminder.service.ChildGroupService;
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

@WebMvcTest(ChildGroupController.class)
public class ChildGroupControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ChildGroupService childGroupService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addChildGroup() throws Exception {
        ChildGroup childGroup = new ChildGroup();

        mvc.perform(post("/childGroup/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL)
                .content(objectMapper.writeValueAsString(childGroup)))
                .andExpect(status().isOk());

        verify(childGroupService, times(1)).addChildGroup(childGroup);
    }

    @Test
    public void getAllChildGroups() throws Exception {

        mvc.perform(get("/childgroup/all")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(childGroupService, times(1)).getAllChildGroups();
    }

    @Test
    public void deleteChildGroup() throws Exception {

        mvc.perform(delete("/childgroup/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(childGroupService, times(1)).deleteChildGroup(1l);
    }

    @Test
    public void addChildToChildGroup() throws Exception {
        ChildAndChildGroupDto dto = new ChildAndChildGroupDto();

        mvc.perform(post("/childgroup/addchild")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        verify(childGroupService, times(1)).addChildToChildGroup(dto);
    }
}
