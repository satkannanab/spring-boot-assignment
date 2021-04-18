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
package com.my.assignment.domain.data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Base class holds fields that are common to all entity items.
 *
 * @author satheesh.arunachalam
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = -1257830701879913611L;

  @Id
  @NotNull
  @Column(name = "uuid", length = 50, nullable = false, unique = true)
  private String uuid = getUuid();

  private transient UUID uuidObject;

  @NotNull
  @Column(name = "created_timestamp", nullable = false, updatable = false)
  private ZonedDateTime createdTimeStamp = ZonedDateTime.now();

  /**
   * @return the uuid
   */
  public String getUuid() {
    if (uuid == null) {
      uuid = getUuidObject().toString();
    }
    return uuid;
  }

  /**
   * @return the uuidObject
   */
  public UUID getUuidObject() {
    if (uuidObject == null) {
      uuidObject = UUID.randomUUID();
    }
    return uuidObject;
  }

  /**
   * @param uuidObject the uuidObject to set
   */
  public void setUuidObject(UUID uuidObject) {
    this.uuidObject = uuidObject;
  }

  /**
   * @param uuid the uuid to set
   */
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * @param createdTimeStamp the createdTimeStamp to set
   */
  public void setCreatedTimeStamp(ZonedDateTime createdTimeStamp) {
    this.createdTimeStamp = createdTimeStamp;
  }

  /**
   * @return the createdTimeStamp
   */
  public ZonedDateTime getCreatedTimeStamp() {
    return createdTimeStamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof BaseEntity))
      return false;
    BaseEntity entity = (BaseEntity) o;
    return getUuid() != null && Objects.equals(getUuid(), entity.getUuid());
  }

  @Override
  public int hashCode() {
    return getUuid().hashCode();
  }

}
