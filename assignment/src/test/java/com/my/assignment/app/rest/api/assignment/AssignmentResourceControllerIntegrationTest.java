
package com.my.assignment.app.rest.api.assignment;

import java.time.ZonedDateTime;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.my.assignment.app.rest.api.AbstractResourceControllerIntegrationTest;
import com.my.assignment.domain.data.assignment.Assignment;

/**
 * Integration test for {@link AssignmentResourceController}.
 *
 * @author satheesh.arunachalam
 */
@Transactional(transactionManager = "transactionManager")
public class AssignmentResourceControllerIntegrationTest extends AbstractResourceControllerIntegrationTest {

  @Test
  public void testGetAssignments() throws Exception {
    Assignment assignment = Assignment.builder().endDateTime(ZonedDateTime.now()).startDateTime(ZonedDateTime.now()).name("name-123").numberOfTasks(34).build();

    getEntityManager().persist(assignment);

    ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/assignments/").accept(MediaType.APPLICATION_JSON));
    System.err.println(result.andReturn().getResponse().getContentAsString());

    result.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
  }

}
