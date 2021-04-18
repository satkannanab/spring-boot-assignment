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
package com.my.assignment.core.exception;

/**
 * Defines an exception of type RuntimeException and that will be thrown if an entity is not found in the database.
 *
 * @author satheesh.arunachalam
 */
public class EntityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -5301323488354148492L;

  public EntityNotFoundException() {
    super("Entity not found.");
  }

}
