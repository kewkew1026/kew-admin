<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:jee="http://www.springframework.org/schema/jee" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
           http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
           http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
           http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <bean id="configProperties" class="org.springframework.beans.factory.config.PropertiesFactoryBean">
        <property name="locations">
            <list>
                <value>file:/opt/kew/public/config/db.properties</value>
                <value>file:/opt/kew/${c.groupId}/config/config-env.properties</value>
            </list>
        </property>
    </bean>

    <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="properties" ref="configProperties" />
    </bean>

    <!-- log4j配置 -->
    <bean id="log4jInitialization" class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
        <property name="targetClass" value="org.springframework.util.Log4jConfigurer" />
        <property name="targetMethod" value="initLogging" />
        <property name="arguments">
            <list>
                <value>file:/opt/kew/${c.groupId}/config/log4j.xml</value>
            </list>
        </property>
    </bean>

</beans>