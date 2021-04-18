
package com.my.assignment.domain.data.assignment;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.my.assignment.domain.data.BaseEntity;

/**
 * Assignment is an entity that represents a collection of task that needs to be implemented in a certain duration.
 *
 * @author satheesh.arunachalam
 */
@Entity(name = "as.assignment")
@Table(name = "assignment")
public class Assignment extends BaseEntity {

  private static final long serialVersionUID = -3974399124249186132L;

  @NotNull
  @Size(min = 3, max = 30)
  private String name;

  @NotNull
  private ZonedDateTime startDateTime;

  @Null
  private ZonedDateTime endDateTime;

  @Null
  @Size(min = 0, max = 25)
  private int numberOfTasks;

  public Assignment(Builder builder) {
    this.name = builder.name;
    this.startDateTime = builder.startDateTime;
    this.endDateTime = builder.endDateTime;
    this.numberOfTasks = builder.numberOfTasks;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
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

  /**
   * @return the numberOfTasks
   */
  public int getNumberOfTasks() {
    return numberOfTasks;
  }

  // TODO add toString

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to create Assignment entity.
   *
   * @author satheesh.arunachalam
   */
  public static final class Builder {

    private String name;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private int numberOfTasks;

    private Builder() {
      // create builder using builder method.
    }

    public Builder numberOfTasks(int numberOfTasks) {
      this.numberOfTasks = numberOfTasks;
      return this;
    }

    public Builder endDateTime(ZonedDateTime endDateTime) {
      this.endDateTime = endDateTime;
      return this;
    }

    public Builder startDateTime(ZonedDateTime startDateTime) {
      this.startDateTime = startDateTime;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Assignment build() {
      return new Assignment(this);
    }

  }

}
