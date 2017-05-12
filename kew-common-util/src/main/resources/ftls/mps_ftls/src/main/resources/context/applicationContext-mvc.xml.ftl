<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="
        http://www.springframework.org/schema/mvc
		http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd
        http://www.springframework.org/schema/tx
		http://www.springframework.org/schema/tx/spring-tx-3.2.xsd
		http://www.springframework.org/schema/aop
		http://www.springframework.org/schema/aop/spring-aop-3.2.xsd
        http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
        http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context-3.2.xsd">

	<context:component-scan base-package="com.kew.*.controller" />

	<mvc:annotation-driven />

	<mvc:resources mapping="/resources/**" location="/resources/" />
	
	<bean id="viewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
		<property name="order" value="1" />
		<property name="suffix" value=".ftl" />
		<property name="contentType" value="text/html;charset=UTF-8"></property>
		<property name="viewClass">
			<value>org.springframework.web.servlet.view.freemarker.FreeMarkerView</value>
		</property>
		<property name="requestContextAttribute" value="request" />
		<property name="exposeSpringMacroHelpers" value="true" />
		<property name="exposeRequestAttributes" value="true" />
		<property name="exposeSessionAttributes" value="true" />
	</bean>

	<bean id="freemarkerConfig" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
		<property name="templateLoaderPath" value="/WEB-INF/views/" />
		<property name="freemarkerSettings">
			<props>
				<prop key="template_update_delay">0</prop>
				<prop key="default_encoding">UTF-8</prop>
				<prop key="number_format">0.##########</prop>
				<prop key="datetime_format">yyyy-MM-dd HH:mm:ss</prop>
				<prop key="classic_compatible">true</prop>
				<prop key="template_exception_handler">ignore</prop>
				<prop key="tag_syntax">auto_detect</prop>
			</props>
		</property>
		<property name="freemarkerVariables">
			<map>
				<entry key="button" value-ref="buttonDirective" />
				<entry key="pagination" value-ref="paginationDirective" />
			</map>
		</property>
	</bean>

	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
		<property name="mediaTypes">
			<map>
				<entry key="html" value="text/html" />
				<entry key="json" value="application/json" />
			</map>
		</property>
		<property name="favorParameter" value="true" />
		<property name="viewResolvers">
			<list>
				<bean class="org.springframework.web.servlet.view.BeanNameViewResolver" />
				<bean class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
					<property name="cache" value="true" />
					<property name="prefix" value="/WEB-INF/views/" />
					<property name="suffix" value=".ftl" />
					<property name="contentType" value="text/html;charset=UTF-8"></property>
					<property name="requestContextAttribute" value="request" />
					<property name="exposeSpringMacroHelpers" value="true" />
					<property name="exposeRequestAttributes" value="true" />
					<property name="exposeSessionAttributes" value="true" />
				</bean>
			</list>
		</property>
		<property name="defaultContentType" value="text/html" />
	</bean>
	
	<mvc:annotation-driven>
		<mvc:message-converters>
			<bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
				<property name="supportedMediaTypes">
					<list>
						<value>text/html;charset=UTF-8</value>
					</list>
				</property>
			</bean>
		</mvc:message-converters>
	</mvc:annotation-driven>

	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />
</beans>