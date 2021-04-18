/*
 * Copyright (c) 2021 by Eyefreight BV (www.eyefreight.com). All rights reserved.
 *
 * This software is provided by the copyright holder and contributors "as is" and any express or implied warranties, including, but
 * not limited to, the implied warranties of merchantability and fitness for a particular purpose are disclaimed. In no event shall
 * Eyefreight BV or contributors be liable for any direct, indirect, incidental, special, exemplary, or consequential damages
 * (including, but not limited to, procurement of substitute goods or services; * loss of use, data, or profits; or business
 * interruption) however caused and on any theory of liability, whether in contract, strict liability, or tort (including
 * negligence or otherwise) arising in any way out of the use of this software, even if advised of the possibility of such damage.
 */
package com.my.assignment.core.task.service;

import java.util.List;

import com.my.assignment.app.rest.api.data.assignment.AssignmentData;
import com.my.assignment.core.exception.EntityNotFoundException;
import com.my.assignment.domain.data.assignment.Assignment;

/**
 * Service to handle {@link Assignment}.
 *
 * @author satheesh.arunachalam
 */
public interface AssignmentService {

  /**
   * Finds all the assignment data.
   *
   * @return list of AssignmentData.
   */
  List<AssignmentData> findAll();

  /**
   * Creates a new Assignment.
   *
   * @param assignment entity to be persisted.
   * @return updated assignment data.
   */
  AssignmentData save(AssignmentData assignment);

  /**
   * Updates the given Assignment.
   *
   * @param assignment to be updated.
   * @return updated assignment data.
   */
  Assignment update(AssignmentData assignment);

  /**
   * Deletes given Assignment.
   *
   * @param assignment entity to be deleted.
   */
  void delete(AssignmentData assignment);

  /**
   * Finds the Assignment by uuid.
   *
   * @param uuid to found the assignment entity.
   * @return assignment data if found.
   * @throws EntityNotFoundException if entity not found for given uuid.
   */
  AssignmentData getById(String uuid);

}
