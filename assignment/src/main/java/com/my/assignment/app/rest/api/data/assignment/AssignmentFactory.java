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
package com.my.assignment.app.rest.api.data.assignment;

import org.springframework.stereotype.Component;

import com.my.assignment.domain.data.assignment.Assignment;

/**
 * Creates {@link Assignment} by {@link AssignmentData}.
 *
 * @author satheesh.arunachalam
 */
@Component
public class AssignmentFactory {

  /**
   * Creates new Assignment entity from AssignmentData.
   *
   * @param assignmentData to create Assignment.
   * @return new instance of Assignment.
   */
  public Assignment create(AssignmentData assignmentData) {
    return Assignment.builder().name(assignmentData.getName()).endDateTime(assignmentData.getEndDateTime()).startDateTime(assignmentData.getStartDateTime())
        .numberOfTasks(assignmentData.getNumberOfTasks()).build();
  }

}
