package com.ufcg.psoft.mercadofacil;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link MercadofacilApplication}.
 */
public class MercadofacilApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'mercadofacilApplication'.
   */
  public static BeanDefinition getMercadofacilApplicationBeanDefinition() {
    Class<?> beanType = MercadofacilApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(MercadofacilApplication.class);
    beanDefinition.setInstanceSupplier(MercadofacilApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
