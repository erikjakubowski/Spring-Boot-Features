package com.spring.dbstarter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * there are times when we want to provide the configuration classes,
 * but require consumers of the starter library to explicitly enable such a configuration,
 * rather than relying on Spring Boot to decide automatically if it should be included or not.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//import dbcount runner
@Import(DbCountAutoConfig.class)
@Documented
public @interface EnableDbCount {

}
