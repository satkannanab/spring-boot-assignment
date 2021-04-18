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
package com.my.assignment.app.rest.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.my.assignment.app.framework.config.RestApiConfiguration;
import com.my.assignment.core.config.DataPersistenceConfiguration;

/**
 * Holds the configurations to set up an integration test.
 *
 * @author satheesh.arunachalam
 */
@ContextConfiguration(classes = {RestApiConfiguration.class, DataPersistenceConfiguration.class})
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AbstractResourceControllerIntegrationTest {

  private EntityManager em;
  @Autowired
  private EntityManagerFactory entityManagerFactory;
  @Autowired
  protected MockMvc mockMvc;

  @Before
  public void setupClass() {
    em = entityManagerFactory.createEntityManager();
  }

  protected EntityManager getEntityManager() {
    return em;
  }

}
