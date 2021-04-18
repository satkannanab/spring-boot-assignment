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
package com.my.assignment.app.rest.api.data;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.validation.constraints.Null;

import com.my.assignment.domain.data.BaseEntity;

/**
 * Manages entity data thats common to all resources.
 *
 * @author satheesh.arunachalam
 */
public class BaseData implements Serializable {

  private static final long serialVersionUID = 4654666707737766296L;

  @Null
  private String id;
  @Null
  private ZonedDateTime createdTimeStamp;

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  public BaseData(AbstractBuilder<? extends AbstractBuilder<?>> builder) {
    this.id = builder.id;
  }

  public BaseData(BaseEntity baseEntity) {
    this.id = baseEntity.getUuid();
    this.createdTimeStamp = baseEntity.getCreatedTimeStamp();
  }

  public abstract static class AbstractBuilder<B extends AbstractBuilder<B>> {
    private String id;

    protected AbstractBuilder() {
      // Builder should only be constructed via the parent class or subclass
    }

    protected <E extends BaseEntity> AbstractBuilder(E entity) {
      id = entity.getUuid();
    }

    public B id(String id) {
      this.id = id;
      return (B) this;
    }

    protected abstract BaseData build();

  }

}
