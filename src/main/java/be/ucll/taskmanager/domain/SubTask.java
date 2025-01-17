package be.ucll.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private UUID id;

    @NotEmpty(message = "{error.manditory}")
    @NotBlank(message = "{error.blank}")
    private String title;
    @NotEmpty(message = "{error.manditory}")
    @NotBlank(message = "{error.blank}")
    private String description;

    public SubTask(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public SubTask() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
