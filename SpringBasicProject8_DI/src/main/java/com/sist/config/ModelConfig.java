package com.sist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration // 메모리할당을 한다
//<context:component-scan base-package="com.sist.model"/>
@ComponentScan(basePackages = "com.sist.model")
public class ModelConfig {
// xml이 아닌 자바로 코딩한 경우!! 어노테이션을 사용한다
}
