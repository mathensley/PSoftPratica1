package com.ufcg.psoft.mercadofacil.repository;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VolatilLoteRepository}.
 */
public class VolatilLoteRepository__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'volatilLoteRepository'.
   */
  public static BeanDefinition getVolatilLoteRepositoryBeanDefinition() {
    Class<?> beanType = VolatilLoteRepository.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(VolatilLoteRepository::new);
    return beanDefinition;
  }
}
