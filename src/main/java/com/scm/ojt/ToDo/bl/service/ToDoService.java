package com.scm.ojt.ToDo.bl.service;

import java.util.List;

import com.scm.ojt.ToDo.bl.dto.TodoDTO;

/**
 * <h2>ToDoService Class</h2>
 * <p>
 * Process for Displaying ToDoService
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
public interface ToDoService {

    /**
     * <h2>doSaveToDo</h2>
     * <p>
     * Do save todo
     * </p>
     *
     * @param todo
     * @return TodoDTO
     */
    public TodoDTO doSaveToDo(TodoDTO todo);

    /**
     * <h2>doGetToDoList</h2>
     * <p>
     * Get to do list
     * </p>
     *
     * @return List<TodoDTO>
     */
    public List<TodoDTO> doGetToDoList();

    /**
     * <h2>doGetValidationMsgForSave</h2>
     * <p>
     * Get validation message for save
     * </p>
     *
     * @param todo
     * @return List<String>
     */
    public List<String> doGetValidationMsgForSave(TodoDTO todo);

    /**
     * <h2>doGetToDoById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return TodoDTO
     */
    public TodoDTO doGetToDoById(long id);

    /**
     * <h2>doGetValidationMsgForEdit</h2>
     * <p>
     * Get validation msg for edit
     * </p>
     *
     * @param todo
     * @param id
     * @return List<String>
     */
    public List<String> doGetValidationMsgForEdit(TodoDTO todo);

    /**
     * <h2>doGetDoneToDoList</h2>
     * <p>
     * Get done todo list
     * </p>
     *
     * @return List<TodoDTO>
     */
    public List<TodoDTO> doGetDoneToDoList();

    /**
     * <h2>doEditToDo</h2>
     * <p>
     * Edit todo
     * </p>
     *
     * @param todoDto
     * @param id
     * @return TodoDTO
     */
    public TodoDTO doEditToDo(TodoDTO todoDto, long id);

    /**
     * <h2>doDeleteToDo</h2>
     * <p>
     * Delete todo
     * </p>
     *
     * @param id
     * @return void
     */
    public void doDeleteToDo(long id);
}
