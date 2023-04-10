package com.ufcg.psoft.mercadofacil.service;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProdutoAlterarServiceImpl}.
 */
public class ProdutoAlterarServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'produtoAlterarServiceImpl'.
   */
  public static BeanDefinition getProdutoAlterarServiceImplBeanDefinition() {
    Class<?> beanType = ProdutoAlterarServiceImpl.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<ProdutoAlterarServiceImpl> instanceSupplier = InstanceSupplier.using(ProdutoAlterarServiceImpl::new);
    instanceSupplier = instanceSupplier.andThen(ProdutoAlterarServiceImpl__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
