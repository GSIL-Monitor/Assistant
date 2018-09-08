package com.rongzi.assistant.common.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CityDataSource {

    String name() default "";

}
