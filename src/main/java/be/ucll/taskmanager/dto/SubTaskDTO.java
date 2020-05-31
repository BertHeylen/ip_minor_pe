package be.ucll.taskmanager.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

public class SubTaskDTO {
    @Id
    private UUID id;
    @NotEmpty(message = "{error.manditory}")
    @NotBlank(message = "{error.blank}")
    private String title;
    @NotEmpty(message = "{error.manditory}")
    @NotBlank(message = "{error.blank}")
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
