package com.scm.ojt.ToDo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.ojt.ToDo.bl.dto.TodoDTO;
import com.scm.ojt.ToDo.bl.service.ToDoService;
import com.scm.ojt.ToDo.web.form.TodoListResponse;
import com.scm.ojt.ToDo.web.form.TodoModifyResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoRestController {

    /**
     * <h2>todoService</h2>
     * <p>
     * todoService
     * </p>
     */
    @Autowired
    private ToDoService todoService;

    /**
     * <h2>saveTodo</h2>
     * <p>
     * 
     * </p>
     *
     * @param todo
     * @return ResponseEntity<?>
     */
    @PostMapping("/saveTodo")
    public ResponseEntity<?> saveTodo(@RequestBody TodoDTO todoDto) {
        List<String> validationMsg = this.todoService.doGetValidationMsgForSave(todoDto);
        if (validationMsg.size() > 0) {
            TodoModifyResponse response = new TodoModifyResponse(HttpStatus.BAD_REQUEST.value(), "Validation Error!");
            response.setValidationMessage(validationMsg);
            return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.BAD_REQUEST);
        }
        TodoDTO todo = this.todoService.doSaveToDo(todoDto);
        TodoModifyResponse response = new TodoModifyResponse(HttpStatus.CREATED.value(), "Saved todo successfully!");
        response.setTodoDto(todo);
        return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.CREATED);
    }

    /**
     * <h2>getToDoList</h2>
     * <p>
     * Get to do list
     * </p>
     * 
     * @param searchValue
     * @return ResponseEntity<?>
     */
    @GetMapping(value = "/todoList")
    public ResponseEntity<?> getToDoList(@RequestParam(required = false) String searchValue) {
        List<TodoDTO> todoList = this.todoService.doGetToDoList(searchValue);
        String message = "Get todo list successfully!";
        TodoListResponse response = new TodoListResponse(HttpStatus.OK.value(), message);
        response.setTodoList(todoList);
        response.setCount(todoList.size());
        return new ResponseEntity<TodoListResponse>(response, HttpStatus.OK);
    }

    /**
     * <h2>getToDoList</h2>
     * <p>
     * Get to do list
     * </p>
     *
     * @return ResponseEntity<?>
     */
    @GetMapping(value = "/todoDetail")
    public ResponseEntity<?> getToDoById(long id) {
        TodoDTO todoDto = this.todoService.doGetToDoById(id);
        if (todoDto == null) {
            TodoModifyResponse response = new TodoModifyResponse(HttpStatus.BAD_REQUEST.value(),
                    "Data does not exist!");
            return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.BAD_REQUEST);
        }
        TodoModifyResponse response = new TodoModifyResponse(HttpStatus.OK.value(), "Get todo successfully!");
        response.setTodoDto(todoDto);
        return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.OK);
    }

    /**
     * <h2>getDoneToDoList</h2>
     * <p>
     * Get done todo list
     * </p>
     * 
     * @param doneStatus
     * @return ResponseEntity<?>
     */
    @GetMapping(value = "/getTodoListByStatus")
    public ResponseEntity<?> getDoneToDoList(String doneStatus) {
        List<TodoDTO> todoList = this.todoService.doGetDoneToDoList(doneStatus);
        String message = "Get done todo list successfully!";
        TodoListResponse response = new TodoListResponse(HttpStatus.OK.value(), message);
        response.setTodoList(todoList);
        response.setCount(todoList.size());
        return new ResponseEntity<TodoListResponse>(response, HttpStatus.OK);
    }

    /**
     * <h2>editTodo</h2>
     * <p>
     * Edit to do
     * </p>
     *
     * @param todoDto
     * @return ResponseEntity<?>
     */
    @PutMapping("/editTodo")
    public ResponseEntity<?> editTodo(@RequestBody TodoDTO todoDto, long id) {
        TodoDTO oldTodo = this.todoService.doGetToDoById(id);
        if (oldTodo == null) {
            TodoModifyResponse response = new TodoModifyResponse(HttpStatus.BAD_REQUEST.value(),
                    "Data does not exist!");
            return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.BAD_REQUEST);
        }
        List<String> validationMsg = this.todoService.doGetValidationMsgForEdit(todoDto);
        if (validationMsg.size() > 0) {
            TodoModifyResponse response = new TodoModifyResponse(HttpStatus.BAD_REQUEST.value(), "Validation Error!");
            response.setValidationMessage(validationMsg);
            return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.BAD_REQUEST);
        }
        TodoDTO todo = this.todoService.doEditToDo(todoDto, id);
        TodoModifyResponse response = new TodoModifyResponse(HttpStatus.CREATED.value(), "Edited todo successfully!");
        response.setTodoDto(todo);
        return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.CREATED);
    }

    /**
     * <h2>doneEditTodo</h2>
     * <p>
     * Edit done status
     * </p>
     *
     * @param id
     * @return ResponseEntity<?>
     */
    @PutMapping("/doneEditTodo")
    public ResponseEntity<?> doneEditTodo(long id, String doneStatus) {
        TodoDTO oldTodo = this.todoService.doGetToDoById(id);
        if (oldTodo == null) {
            TodoModifyResponse response = new TodoModifyResponse(HttpStatus.BAD_REQUEST.value(),
                    "Data does not exist!");
            return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.BAD_REQUEST);
        }
        oldTodo.setDoneStatus(doneStatus);
        TodoDTO todo = this.todoService.doEditToDo(oldTodo, id);
        TodoModifyResponse response = new TodoModifyResponse(HttpStatus.CREATED.value(), "Edited done statue successfully!");
        response.setTodoDto(todo);
        return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.CREATED);
    }

    /**
     * <h2>deleteTodo</h2>
     * <p>
     * Delete todo
     * </p>
     *
     * @param id
     * @return ResponseEntity<?>
     */
    @DeleteMapping("/deleteTodo")
    public ResponseEntity<?> deleteTodo(long id) {
        TodoDTO oldTodo = this.todoService.doGetToDoById(id);
        if (oldTodo == null) {
            TodoModifyResponse response = new TodoModifyResponse(HttpStatus.BAD_REQUEST.value(),
                    "Data does not exist!");
            return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.BAD_REQUEST);
        }
        this.todoService.doDeleteToDo(id);
        TodoModifyResponse response = new TodoModifyResponse(HttpStatus.OK.value(), "Deleted todo successfully!");
        return new ResponseEntity<TodoModifyResponse>(response, HttpStatus.OK);
    }
}