package be.ucll.taskmanager.service;

import be.ucll.taskmanager.domain.SubTask;
import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.SubTaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<TaskDTO> getTasks();

    void addTask(TaskDTO task);


    Task getTaskById(UUID id);

    void addSubtask(UUID mainTaskId, SubTaskDTO subtaskDTO);

    List<SubTask> getSubTasks(UUID id);

    void editTask(UUID id, TaskDTO task);

    TaskDTO getTaskDTOById(UUID id);

}
