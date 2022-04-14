package com.scm.ojt.ToDo.web.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>CommonResponse Class</h2>
 * <p>
 * Process for Displaying CommonResponse
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

    /**
     * <h2>timeStamp</h2>
     * <p>
     * timeStamp
     * </p>
     */
    protected Date timeStamp;

    /**
     * <h2>responseCode</h2>
     * <p>
     * responseCode
     * </p>
     */
    protected Integer responseCode;

    /**
     * <h2>responseDescription</h2>
     * <p>
     * responseDescription
     * </p>
     */
    protected String responseDescription;

}
