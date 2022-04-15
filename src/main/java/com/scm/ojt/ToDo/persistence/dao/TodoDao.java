package com.scm.ojt.ToDo.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    public static final String SELECT_TODO_BY_SEARCH = "SELECT t "
                                                     + "FROM Todo t "
                                                     + "WHERE "
                                                     + "("
                                                     + "(lower(t.title) LIKE lower(concat('%', :searchValue  ,'%'))) OR "
                                                     + "(lower(t.description) LIKE lower(concat('%', :searchValue  ,'%'))) "
                                                     + ")";

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

    /**
     * <h2>findTodoBySearchValue</h2>
     * <p>
     * 
     * </p>
     *
     * @param searchValue
     * @return List<Todo>
     */
    @Query(SELECT_TODO_BY_SEARCH)
    public List<Todo> findTodoBySearchValue(@Param("searchValue") String searchValue);
}
