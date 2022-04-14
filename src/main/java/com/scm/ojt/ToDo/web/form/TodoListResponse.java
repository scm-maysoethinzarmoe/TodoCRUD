package com.scm.ojt.ToDo.web.form;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.scm.ojt.ToDo.bl.dto.TodoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>TodoResponse Class</h2>
 * <p>
 * Process for Displaying TodoResponse
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoListResponse extends CommonResponse {

    /**
     * <h2>todoList</h2>
     * <p>
     * todoList
     * </p>
     */
    private List<TodoDTO> todoList;

    /**
     * <h2>count</h2>
     * <p>
     * count
     * </p>
     */
    private int count;

    /**
     * <h2>Constructor for TodoResponse</h2>
     * <p>
     * Constructor for TodoResponse
     * </p>
     * 
     * @param responseCode
     * @param responseDescription
     */
    public TodoListResponse(Integer responseCode, String responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.timeStamp = Date.from(Instant.now());
    }
}
