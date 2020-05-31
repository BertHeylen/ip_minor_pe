package be.ucll.taskmanager.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TaskDTO {
    @Id
    private UUID id;

    @NotBlank(message = "{error.blank}")
    @NotEmpty(message = "{error.manditory}")
    private String title;

    @NotBlank(message = "{error.blank}")
    @NotEmpty(message = "{error.manditory}")
    private String desc;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "{error.manditory}")
    @Future(message = "{error.future}")
    private LocalDateTime date;

    private List<SubTaskDTO> subTasks;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<SubTaskDTO> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTaskDTO> subTasks) {
        this.subTasks = subTasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
