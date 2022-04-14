package com.scm.ojt.ToDo.bl.dto;

import com.scm.ojt.ToDo.persistence.entity.Todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>TodoDTO Class</h2>
 * <p>
 * Process for Displaying TodoDTO
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    private long id;

    /**
     * <h2>title</h2>
     * <p>
     * title
     * </p>
     */
    private String title;

    /**
     * <h2>description</h2>
     * <p>
     * description
     * </p>
     */
    private String description;

    /**
     * <h2>doneStatus</h2>
     * <p>
     * doneStatus
     * </p>
     */
    private String doneStatus;

    /**
     * <h2>Constructor for TodoDTO</h2>
     * <p>
     * Constructor for TodoDTO
     * </p>
     * 
     * @param todo
     */
    public TodoDTO(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.doneStatus = todo.getDoneStatus();
    }
}
