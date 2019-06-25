package fi.aldowaldo.childminder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.aldowaldo.childminder.model.ChildSchedule;
import fi.aldowaldo.childminder.service.ChildScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ChildScheduleController.class)
public class ChildScheduleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ChildScheduleService childScheduleService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addSchedule() throws Exception {

        ChildSchedule childSchedule = new ChildSchedule();

        mvc.perform(post("/schedule/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL)
                .content(objectMapper.writeValueAsString(childSchedule)))
                .andExpect(status().isOk());

        verify(childScheduleService, times(1)).addSchedule(childSchedule);
    }

    @Test
    public void addSchduleForManyDays() throws Exception {

        ChildSchedule childSchedule = new ChildSchedule();
        List<ChildSchedule> scheduleList = Arrays.asList(childSchedule);

        mvc.perform(post("/schedule/add/many")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL)
                .content(objectMapper.writeValueAsString(scheduleList)))
                .andExpect(status().isOk());

        verify(childScheduleService, times(1)).addSchduleForManyDays(scheduleList);
    }

    @Test
    public void removeSchedule() throws Exception {

        mvc.perform(delete("/schedule/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(childScheduleService, times(1)).removeSchedule(1l);
    }
}
