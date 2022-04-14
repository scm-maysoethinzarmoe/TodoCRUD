package com.scm.ojt.ToDo.bl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.ojt.ToDo.bl.dto.TodoDTO;
import com.scm.ojt.ToDo.bl.service.ToDoService;
import com.scm.ojt.ToDo.persistence.dao.TodoDao;
import com.scm.ojt.ToDo.persistence.entity.Todo;

/**
 * <h2>ToDoServiceImpl Class</h2>
 * <p>
 * Process for Displaying ToDoServiceImpl
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
@Service
public class ToDoServiceImpl implements ToDoService {

    /**
     * <h2>todoDao</h2>
     * <p>
     * todoDao
     * </p>
     */
    @Autowired
    private TodoDao todoDao;

    /**
     * <h2>doGetToDoList</h2>
     * <p>
     * Get to do list
     * </p>
     *
     * @param searchValue
     * @return List<TodoDTO>
     */
    @Override
    public List<TodoDTO> doGetToDoList(String searchValue) {
        List<Todo> todoList = new ArrayList<Todo>();
        if (searchValue != null && searchValue != "") {
            todoList = this.todoDao.findTodoBySearchValue(searchValue);
        } else {
            todoList = this.todoDao.findAll();
        }
        List<TodoDTO> todoDtoList = new ArrayList<TodoDTO>();
        for (Todo todo : todoList) {
            TodoDTO todoDto = new TodoDTO(todo);
            todoDtoList.add(todoDto);
        }
        return todoDtoList;
    }

    /**
     * <h2>doSaveToDo</h2>
     * <p>
     * Do save todo
     * </p>
     *
     * @param todoDto
     * @return TodoDTO
     */
    @Override
    public TodoDTO doSaveToDo(TodoDTO todoDto) {
        Todo todo = new Todo(todoDto);
        return new TodoDTO(this.todoDao.save(todo));
    }

    /**
     * <h2>doGetValidationMsgForSave</h2>
     * <p>
     * Get validation message for save
     * </p>
     *
     * @param todo
     * @return List<String>
     */
    @Override
    public List<String> doGetValidationMsgForSave(TodoDTO todo) {
        List<String> validationMsg = new ArrayList<String>();
        if (todo.getId() > 0) {
            validationMsg.add("Id must not be given for save");
        }
        if (todo.getTitle() == null || todo.getTitle() == "") {
            validationMsg.add("Title is a required field");
        }
        if (todo.getDescription() == null || todo.getDescription() == "") {
            validationMsg.add("Description is a required field");
        }
        return validationMsg;
    }

    /**
     * <h2>doGetToDoById</h2>
     * <p>
     * Get todo by id
     * </p>
     *
     * @param id
     * @return TodoDTO
     */
    @Override
    public TodoDTO doGetToDoById(long id) {
        Optional<Todo> todo = this.todoDao.findById(id);
        if (!todo.isEmpty()) {
            return new TodoDTO(todo.get());
        }
        return null;
    }

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
    @Override
    public List<String> doGetValidationMsgForEdit(TodoDTO todo) {
        List<String> validationMsg = new ArrayList<String>();
        if (todo.getTitle() == null || todo.getTitle() == "") {
            validationMsg.add("Title is a required field");
        }
        if (todo.getDescription() == null || todo.getDescription() == "") {
            validationMsg.add("Description is a required field");
        }
        if (todo.getDoneStatus() != null && !todo.getDoneStatus().equals("1") && !todo.getDoneStatus().equals("0")) {
            validationMsg.add("Done status must be 1 or 0");
        }
        return validationMsg;
    }

    /**
     * <h2>doGetDoneToDoList</h2>
     * <p>
     * Get done todo list
     * </p>
     *
     * @param doneStatus
     * @return List<TodoDTO>
     */
    @Override
    public List<TodoDTO> doGetDoneToDoList(String doneStatus) {
        List<Todo> doneTodoList = this.todoDao.findByDoneStatus(doneStatus);
        List<TodoDTO> doneTodoDtoList = new ArrayList<TodoDTO>();
        for (Todo todo : doneTodoList) {
            TodoDTO todoDto = new TodoDTO(todo);
            doneTodoDtoList.add(todoDto);
        }
        return doneTodoDtoList;
    }

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
    @Override
    public TodoDTO doEditToDo(TodoDTO todoDto, long id) {
        Todo todo = this.todoDao.findById(id).get();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDoneStatus(todoDto.getDoneStatus());
        return new TodoDTO(this.todoDao.save(todo));
    }

    /**
     * <h2>doDeleteToDo</h2>
     * <p>
     * Delete todo
     * </p>
     *
     * @param id
     * @return void
     */
    @Override
    public void doDeleteToDo(long id) {
        this.todoDao.deleteById(id);
    }
}
