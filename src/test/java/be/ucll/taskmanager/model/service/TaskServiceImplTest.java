package be.ucll.taskmanager.model.service;

import be.ucll.taskmanager.dto.SubTaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.service.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
public class TaskServiceImplTest {

    @Autowired
    private TaskServiceImpl taskService;
    @Transactional
    @BeforeEach
    public void setUp() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("title");
        taskDTO.setDesc("description");
        taskDTO.setDate(LocalDateTime.of(2021, 3, 21, 10, 10));
        taskDTO.setSubTasks(new ArrayList<SubTaskDTO>());
        taskService.addTask(taskDTO);
    }

    @Transactional
    @Test
    public void testGetSubtaken() {
        SubTaskDTO SubTaskDTO = new SubTaskDTO();
        SubTaskDTO.setTitle("subtasktitle");
        SubTaskDTO.setDescription("subtaskdescription");
        SubTaskDTO.setId(taskService.getTasks().get(0).getId());
        taskService.addSubtask(taskService.getTasks().get(0).getId(),SubTaskDTO);

        assertEquals(taskService.getSubTasks(taskService.getTasks().get(0).getId()).size(), 1);
        taskService.addSubtask(taskService.getTasks().get(0).getId(),SubTaskDTO);
        assertEquals(taskService.getSubTasks(taskService.getTasks().get(0).getId()).size(), 2);
    }

    @Transactional
    @Test
    public void testGetTasks() {
        // setup see @BeforeEach

        // method to be tested
        List<TaskDTO> tasks = taskService.getTasks();

        // checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        TaskDTO task = tasks.get(0);
        assertNotNull(task);
        assertEquals("title", task.getTitle());
        assertEquals("description", task.getDesc());
        assertEquals(LocalDateTime.of(2021, 3, 21, 10, 10),task.getDate());

    }



    @Test
    public void testEditTask() {
        TaskDTO TaskDTO = new TaskDTO();
        TaskDTO.setId(taskService.getTasks().get(0).getId());
        TaskDTO.setDesc("editdescription");
        TaskDTO.setTitle("edittitle");
        TaskDTO.setDate(LocalDateTime.of(2021,3,22,10,10));
        taskService.editTask(taskService.getTasks().get(0).getId(),TaskDTO);
        assertEquals(taskService.getTasks().get(0).getTitle(), TaskDTO.getTitle());
        assertEquals(taskService.getTasks().get(0).getId(), TaskDTO.getId());
        assertEquals(taskService.getTasks().get(0).getDesc(), TaskDTO.getDesc());
        assertEquals(taskService.getTasks().get(0).getDate(), TaskDTO.getDate());
    }
}
