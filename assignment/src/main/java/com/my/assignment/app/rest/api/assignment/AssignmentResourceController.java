
package com.my.assignment.app.rest.api.assignment;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.assignment.app.rest.api.data.assignment.AssignmentData;
import com.my.assignment.core.task.service.AssignmentService;

/**
 * Rest resource controller that manages Assignment resource.
 *
 * @author satheesh.arunachalam
 */
@RestController
@RequestMapping(path = "/api/assignments")
public class AssignmentResourceController {

  @Autowired
  private AssignmentService assignmentService;

  /**
   * Fetches all the assignment data.
   *
   * @return list of AssignmentData with http status code as 200
   */
  @GetMapping("/")
  public ResponseEntity<List<AssignmentData>> getAssignments() {
    return new ResponseEntity<>(assignmentService.findAll(), HttpStatus.OK);
  }

  /**
   * Get assignment for a given uuid.
   *
   * @param uuid to find an Assignment.
   * @return AssignmentData with http status code as 200.
   */
  @GetMapping("/{uuid}")
  public ResponseEntity<AssignmentData> getAssignment(@PathVariable @NonNull String uuid) {
    return new ResponseEntity<>(assignmentService.getById(uuid), HttpStatus.OK);
  }

  /**
   * Creates a new assignment for given data.
   *
   * @param data of type AssignmentData to create a new Assignment.
   * @return new AssignmentData.
   */
  @PostMapping("/")
  public ResponseEntity<AssignmentData> createAssignment(@RequestAttribute @Valid AssignmentData data) {
    return new ResponseEntity<>(assignmentService.save(data), HttpStatus.OK);
  }

}
