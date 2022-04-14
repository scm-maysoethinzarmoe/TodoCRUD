package com.scm.ojt.ToDo.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.ojt.ToDo.persistence.entity.Todo;

/**
 * <h2>TodoDao Class</h2>
 * <p>
 * Process for Displaying TodoDao
 * </p>
 * 
 * @author MaySoeThinzarMoe
 *
 */
public interface TodoDao extends JpaRepository<Todo, Long> {

    /**
     * <h2>findByDoneStatus</h2>
     * <p>
     * Find by done status
     * </p>
     *
     * @param doneStatue
     * @return List<Todo>
     */
    public List<Todo> findByDoneStatus(String doneStatue);
}
