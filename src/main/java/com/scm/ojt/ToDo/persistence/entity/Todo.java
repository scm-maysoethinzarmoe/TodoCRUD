package com.scm.ojt.ToDo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.scm.ojt.ToDo.bl.dto.TodoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>Todo Class</h2>
 * <p>
 * Process for Displaying Todo
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {

    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * <h2>title</h2>
     * <p>
     * title
     * </p>
     */
    @Column(name = "title")
    private String title;

    /**
     * <h2>description</h2>
     * <p>
     * description
     * </p>
     */
    @Column(name = "description")
    private String description;

    /**
     * <h2>doneStatus</h2>
     * <p>
     * doneStatus
     * </p>
     */
    @Column(name = "doneStatus")
    private String doneStatus = "0";

    /**
     * <h2>Constructor for Todo</h2>
     * <p>
     * Constructor for Todo
     * </p>
     * 
     * @param todoDTO
     */
    public Todo(TodoDTO todoDTO) {
        this.id = todoDTO.getId();
        this.title = todoDTO.getTitle();
        this.description = todoDTO.getDescription();
        this.doneStatus = todoDTO.getDoneStatus();
    }
}
