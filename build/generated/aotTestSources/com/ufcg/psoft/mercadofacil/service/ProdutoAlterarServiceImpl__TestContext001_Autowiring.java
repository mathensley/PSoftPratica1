package com.ufcg.psoft.mercadofacil.service;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProdutoAlterarServiceImpl}.
 */
public class ProdutoAlterarServiceImpl__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProdutoAlterarServiceImpl apply(RegisteredBean registeredBean,
      ProdutoAlterarServiceImpl instance) {
    instance.produtoRepository = AutowiredFieldValueResolver.forRequiredField("produtoRepository").resolve(registeredBean);
    return instance;
  }
}
