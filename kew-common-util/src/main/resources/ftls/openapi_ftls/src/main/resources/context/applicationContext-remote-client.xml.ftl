<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
        http://www.springframework.org/schema/mvc
		http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/tx
		http://www.springframework.org/schema/tx/spring-tx.xsd
		http://www.springframework.org/schema/aop
		http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 客户端Hessian代理工厂Bean -->
    <!--<bean id="messageScheduingService" class="org.springframework.remoting.caucho.HessianProxyFactoryBean">-->
    <!-- 请求代理Servlet路径 -->
    <!--<property name="serviceUrl">-->
    <!--<value>http://localhost:8080/kew-${c.groupId}-innerapi/messageScheduingService.hs</value>  -->
    <!--</property>  -->
    <!-- 接口定义 -->
    <!--<property name="serviceInterface">  -->
    <!--    <value>com.kew.${c.groupId}.service.MessageScheduingService</value>  -->
    <!--</property>  -->
    <!--</bean>-->

</beans>
