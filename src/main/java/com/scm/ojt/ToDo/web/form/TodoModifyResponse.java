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
 * <h2>TodoSaveResponse Class</h2>
 * <p>
 * Process for Displaying TodoSaveResponse
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoModifyResponse extends CommonResponse {

    /**
     * <h2>todoDto</h2>
     * <p>
     * todoDto
     * </p>
     */
    private TodoDTO todoDto;

    /**
     * <h2>validationMessage</h2>
     * <p>
     * validationMessage
     * </p>
     */
    private List<String> validationMessage;

    /**
     * <h2>Constructor for TodoResponse</h2>
     * <p>
     * Constructor for TodoResponse
     * </p>
     * 
     * @param responseCode
     * @param responseDescription
     */
    public TodoModifyResponse(Integer responseCode, String responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.timeStamp = Date.from(Instant.now());
    }
}
