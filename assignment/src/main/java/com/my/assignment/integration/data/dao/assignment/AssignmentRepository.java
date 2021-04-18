
package com.my.assignment.integration.data.dao.assignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.my.assignment.domain.data.assignment.Assignment;

/**
 * Dao handles the Assignment entity.
 *
 * @author satheesh.arunachalam
 */
@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, String> {

}
