package com.my.assignment.core.task.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.assignment.app.rest.api.data.assignment.AssignmentData;
import com.my.assignment.app.rest.api.data.assignment.AssignmentFactory;
import com.my.assignment.core.exception.EntityNotFoundException;
import com.my.assignment.core.task.service.AssignmentService;
import com.my.assignment.domain.data.assignment.Assignment;
import com.my.assignment.integration.data.dao.assignment.AssignmentRepository;

/**
 * Default implementation of {@link AssignmentService}.
 *
 * @author satheesh.arunachalam
 */
@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {

  @Autowired
  private AssignmentRepository assignmentRepository;
  @Autowired
  private AssignmentFactory assignmentFactory;

  @Override
  public List<AssignmentData> findAll() {
    return ((List<Assignment>) assignmentRepository.findAll()).stream().map(AssignmentData::new).collect(Collectors.toList());
  }

  @Override
  public AssignmentData save(AssignmentData assignmentData) {
    return new AssignmentData(assignmentRepository.save(assignmentFactory.create(assignmentData)));

  }

  @Override
  public Assignment update(AssignmentData assignment) {
    return null;// .;
  }

  @Override
  public void delete(AssignmentData assignment) {
    assignmentRepository.delete(findAssignment(assignment.getId()));
  }

  @Override
  public AssignmentData getById(String uuid) {
    return new AssignmentData(findAssignment(uuid));
  }

  private Assignment findAssignment(String uuid) {
    return assignmentRepository.findById(uuid).orElseThrow(EntityNotFoundException::new);
  }

}
