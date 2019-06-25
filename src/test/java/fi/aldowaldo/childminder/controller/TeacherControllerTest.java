package fi.aldowaldo.childminder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.aldowaldo.childminder.dto.AssignChildGroupToTeacherDto;
import fi.aldowaldo.childminder.model.Teacher;
import fi.aldowaldo.childminder.service.TeacherService;
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

@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TeacherService teacherService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addTeacher() throws Exception {
        Teacher teacher = new Teacher();

        mvc.perform(post("/teacher/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL)
                .content(objectMapper.writeValueAsString(teacher)))
                .andExpect(status().isOk());

        verify(teacherService, times(1)).addTeacher(teacher);
    }

    @Test
    public void getAllTeachers() throws Exception {

        mvc.perform(get("/teacher/all")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(teacherService, times(1)).getAllTeachers();
    }

    @Test
    public void getTeachersChildren() throws Exception {

        mvc.perform(get("/teacher/1/children")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(teacherService, times(1)).getTeachersChildren(1l);
    }

    @Test
    public void removeTeacher() throws Exception {

        mvc.perform(delete("/teacher/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(teacherService, times(1)).removeTeacher(1l);
    }

    @Test
    public void assignAGroup() throws Exception {

        AssignChildGroupToTeacherDto dto = new AssignChildGroupToTeacherDto();

        mvc.perform(post("/teacher/assign")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        verify(teacherService, times(1)).assignAGroup(dto);
    }
}
