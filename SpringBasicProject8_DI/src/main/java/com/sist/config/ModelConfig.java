package com.sist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration // �޸��Ҵ��� �Ѵ�
//<context:component-scan base-package="com.sist.model"/>
@ComponentScan(basePackages = "com.sist.model")
public class ModelConfig {
// xml�� �ƴ� �ڹٷ� �ڵ��� ���!! ������̼��� ����Ѵ�
}
