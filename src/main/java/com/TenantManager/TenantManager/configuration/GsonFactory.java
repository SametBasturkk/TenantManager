package com.TenantManager.TenantManager.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonFactory {

  @Bean
  public Gson gson() {
    return new Gson();
  }
}
