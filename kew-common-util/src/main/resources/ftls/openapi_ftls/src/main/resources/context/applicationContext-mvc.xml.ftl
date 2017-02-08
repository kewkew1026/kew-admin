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

    <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="properties" ref="configProperties" />
    </bean>

    <bean id="configProperties" class="org.springframework.beans.factory.config.PropertiesFactoryBean">
        <property name="locations">
            <list>
                <value>file:/opt/kew/${c.groupId}/config/config-env.properties</value>
            </list>
        </property>
    </bean>

    <context:annotation-config />

    <bean id="fastJsonHttpMessageConverter" class="com.kew.${c.groupId}.fastjson.KewFastJsonHttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <!-- 避免IE出现下载JSON文件的情况 -->
                <value>text/html;charset=UTF-8</value>
            </list>
        </property>
        <property name="features">
            <array>
                <value>WriteDateUseDateFormat</value>
                <value>WriteNullNumberAsZero</value>
                <value>WriteSlashAsSpecial</value>
                <value>WriteNullBooleanAsFalse</value>
                <!--<value>PrettyFormat</value> -->
                <!--<value>WriteMapNullValue</value> -->
                <!--<value>WriteNullListAsEmpty</value> -->
            </array>
        </property>
    </bean>

    <!-- 启用spring mvc 注解-->
    <mvc:annotation-driven content-negotiation-manager="contentNegotiationManager">
        <mvc:message-converters register-defaults="false">
            <ref bean="fastJsonHttpMessageConverter"/>
        </mvc:message-converters>
    </mvc:annotation-driven>

    <context:component-scan base-package="com.kew.*.service,com.kew.*.*.service,com.kew.*.directive"/>

    <context:component-scan base-package="com.kew.*.controller,com.kew.*.*.controller">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller" />
    </context:component-scan>

    <mvc:resources mapping="/res_black/**" location="/res_black/" />
    <mvc:resources mapping="/resources/**" location="/resources/" />
    <mvc:resources mapping="/res/**" location="/res/" />

    <bean id="freeMarkerViewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
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
        <property name="allowSessionOverride" value="true"/>
        <property name="allowRequestOverride" value="true"/>
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
            </props>
        </property>
        <property name="freemarkerVariables">
            <map>
                <entry key="setStatic" value-ref="setStaticDirective" />
            </map>
        </property>
    </bean>

    <bean id="contentNegotiationManager" class="org.springframework.web.accept.ContentNegotiationManagerFactoryBean">
        <property name="favorPathExtension" value="true" />
        <property name="ignoreAcceptHeader" value="false" />
        <property name="mediaTypes" >
            <value>
                json=application/json
                xml=application/xml
            </value>
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
                <ref bean="freeMarkerViewResolver"/>
                <ref bean="jspViewResolver"/>
                <bean class="org.springframework.web.servlet.view.BeanNameViewResolver" />
                <!-- 				<bean id="viewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver"> -->
                <!-- 					<property name="cache" value="true" /> -->
                <!-- 					<property name="prefix" value="/WEB-INF/views/" /> -->
                <!-- 					<property name="suffix" value=".ftl" /> -->
                <!-- 					<property name="contentType" value="text/html;charset=UTF-8"></property> -->
                <!-- 					<property name="requestContextAttribute" value="request" /> -->
                <!-- 					<property name="exposeSpringMacroHelpers" value="true" /> -->
                <!-- 					<property name="exposeRequestAttributes" value="true" /> -->
                <!-- 					<property name="exposeSessionAttributes" value="true" /> -->
                <!-- 				</bean> -->
            </list>
        </property>
        <property name="defaultContentType" value="text/html" />
    </bean>

    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
        <property name="prefix" value="/WEB-INF/views/" />
        <property name="suffix" value=".jsp" />
        <property name="order" value="2" />
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

    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />

</beans>