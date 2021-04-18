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
package com.my.assignment.app.framework.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.my.assignment.core.exception.EntityNotFoundException;

/**
 * Spring controller advice that handles the error and exceptions from application and creates meaning ful message as rest response.
 *
 * @author satheesh.arunachalam
 */
@ControllerAdvice
public class RestApiErrorHandler extends ResponseEntityExceptionHandler {

  /**
   * Handles the exception when an {@link EntityNotFoundException} and creates a response message with proper message and http status code as 404.
   *
   * @param ex exception of type EntityNotFoundException.
   * @param request of type WebRequest
   * @return ResponseEntity with http response code and message.
   */
  @ExceptionHandler(value = EntityNotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
    String bodyOfResponse = "Resource not found for given data.";
    // TODO body of response can be a nice dto with more fields like message, error severity
    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }
}
