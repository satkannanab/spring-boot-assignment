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

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.my.assignment.app.rest.api.data.BaseData;
import com.my.assignment.domain.data.assignment.Assignment;

/**
 * Manages data resource of Assignment.
 *
 * @author satheesh.arunachalam
 */
public class AssignmentData extends BaseData {

  private static final long serialVersionUID = -152739692148509201L;

  @NotNull
  @Size(min = 3, max = 30)
  private String name;

  @NotNull
  private ZonedDateTime startDateTime;

  @Null
  private ZonedDateTime endDateTime;

  @Null
  @Size(min = 0, max = 25)
  @PositiveOrZero
  private int numberOfTasks;

  public AssignmentData(AssignmentData.Builder builder) {
    super(builder);
    this.name = builder.name;
    this.startDateTime = builder.startDateTime;
    this.endDateTime = builder.endDateTime;
    this.numberOfTasks = builder.numberOfTasks;
  }

  public AssignmentData(Assignment assignment) {
    super(assignment);
    this.name = assignment.getName();
    this.startDateTime = assignment.getStartDateTime();
    this.endDateTime = assignment.getEndDateTime();
    this.numberOfTasks = assignment.getNumberOfTasks();
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the numberOfTasks
   */
  public int getNumberOfTasks() {
    return numberOfTasks;
  }

  /**
   * @return the startDateTime
   */
  public ZonedDateTime getStartDateTime() {
    return startDateTime;
  }

  /**
   * @return the endDateTime
   */
  public ZonedDateTime getEndDateTime() {
    return endDateTime;
  }

  public static final class Builder extends AbstractBuilder<Builder> {

    private String name;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private int numberOfTasks;

    private Builder() {
      // constructor has to invoked using static builder method
    }

    @Override
    protected BaseData build() {
      return null;
    }

  }

}
