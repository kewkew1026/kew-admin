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


    <!--@Service, @Mapper -->

    <context:component-scan base-package="com.kew.*.service;" />

    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="${c.escape}{MySQL.jdbc.driver}" />
        <property name="url" value="${c.escape}{MySQL.${c.groupId}.jdbc.url}" />
        <property name="username" value="${c.escape}{MySQL.${c.groupId}.jdbc.username}" />
        <property name="password" value="${c.escape}{MySQL.${c.groupId}.jdbc.password}" />

        <property name="initialSize" value="${c.escape}{MySQL.${c.groupId}.dbcp.initialSize}" />
        <property name="maxIdle" value="${c.escape}{MySQL.${c.groupId}.dbcp.maxIdle}" />
        <property name="maxActive" value="${c.escape}{MySQL.${c.groupId}.dbcp.maxActive}" />
        <property name="defaultAutoCommit" value="false" />
    </bean>

    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>

    <tx:annotation-driven transaction-manager="transactionManager"/>

    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="configLocation" value="classpath:mybatis-config.xml" />
    </bean>

    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.kew.*.mapper;" />
    </bean>

</beans>
