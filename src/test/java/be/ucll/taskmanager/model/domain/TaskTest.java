package be.ucll.taskmanager.model.domain;

import be.ucll.taskmanager.domain.SubTask;
import be.ucll.taskmanager.domain.Task;

import be.ucll.taskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskTest {
    private TaskService taskService;
    private Task task = new Task();

    @Test
    public void testCreateTask() {
        // setup
        Task task = new Task("title", "description", LocalDateTime.of(2020, 3, 21, 10, 10));

        // checks
        assertEquals("title", task.getTitle());
        assertEquals("description", task.getDesc());
        assertEquals(LocalDateTime.of(2020, 3, 21, 10, 10), task.getDate());
    }


    @Test
    public void testSetTitle() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setTitle("title");

        // checks
        assertEquals("title", task.getTitle());
    }

    @Test
    public void testGetTitle() {
        // setup
        Task task = new Task();
        task.setTitle("title");

        // method to be tested
        String title = task.getTitle();

        // checks
        assertEquals("title", title);
    }

    @Test
    public void testSetDescription() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setDesc("descriptionset");

        // checks
        assertEquals("descriptionset", task.getDesc());
    }

    @Test
    public void testGetDescription() {
        // setup
        Task task = new Task();
        task.setDesc("description");

        // method to be tested
        String desc = task.getDesc();

        // checks
        assertEquals("description", desc);
    }

    @Test
    public void testSetDueDate() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setDate(LocalDateTime.of(2021, 03, 21, 10, 10));

        // checks
        assertEquals(LocalDateTime.of(2021, 03, 21, 10, 10), task.getDate());
    }

    @Test
    public void testGetDueDate() {
        // setup
        Task task = new Task();
        task.setDate(LocalDateTime.of(2020, 03, 21, 10, 10));

        // method to be tested
        LocalDateTime dueDate = task.getDate();

        // checks
        assertEquals(LocalDateTime.of(2020, 03, 21, 10, 10), dueDate);
    }

    @Test
    public void testGetAndSetId() {
        //setup
        UUID id = UUID.randomUUID();

        //method to test
        task.setId(id);
        UUID result = task.getId();

        //checks
        assertNotNull(result);
        assertEquals(id, result);
    }

    @Test
    public void testSetSubTasks() {
        // setup
        Task task = new Task();
        List<SubTask> subTasks = new ArrayList<SubTask>();
        SubTask subTask = new SubTask();
        subTask.setTitle("title");
        subTask.setDescription("description");
        subTasks.add(subTask);

        // method to be tested
        task.setSubTasks(subTasks);

        // checks
        assertNotNull(task.getSubtasks());
        assertFalse(task.getSubtasks().size() == 0);
        assertEquals(subTask, task.getSubtasks().get(0));
    }

    @Test
    public void testGetSubTasks() {
        // setup
        Task task = new Task();
        List<SubTask> subTasks = new ArrayList<SubTask>();
        SubTask subTask = new SubTask();
        subTask.setTitle("title");
        subTask.setDescription("description");
        subTasks.add(subTask);
        task.setSubTasks(subTasks);

        // method to be tested
        List<SubTask> subtasks = task.getSubtasks();
        ;

        // checks
        assertNotNull(subtasks);
        assertFalse(subtasks.size() == 0);
        assertEquals(subTask, subtasks.get(0));
    }

    @Test
    public void testAddSubTask() {
        // setup
        // setup
        Task task = new Task();
        List<SubTask> subTasks = new ArrayList<SubTask>();
        SubTask subTask = new SubTask();
        subTask.setTitle("title");
        subTask.setDescription("description");
        subTasks.add(subTask);

        // method to be tested
        task.setSubTasks(subTasks);

        // checks
        assertNotNull(task.getSubtasks());
        assertFalse(task.getSubtasks().size() == 0);
        assertEquals(subTask, task.getSubtasks().get(0));
        assertEquals("title", task.getSubtasks().get(0).getTitle());
        assertEquals("description", task.getSubtasks().get(0).getDescription());
    }
}