<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:jee="http://www.springframework.org/schema/jee" xmlns:tx="http://www.springframework.org/schema/tx" xmlns:util="http://www.springframework.org/schema/util"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd
	http://www.springframework.org/schema/jee
	http://www.springframework.org/schema/jee/spring-jee.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/util
	http://www.springframework.org/schema/util/spring-util.xsd"
       default-lazy-init="true">

    <description>Shiro Configuration</description>

    <!-- Shiro's main business-tier object for web-enabled applications -->
    <bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
        <property name="realm" ref="shiroDbRealm" />
        <property name="cacheManager" ref="cacheManager" />
    </bean>

    <!-- 項目自定义Realm -->
    <bean id="shiroDbRealm" class="com.kew.system.shiro.ShiroDbRealm" />

    <bean class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
        <property name="staticMethod" value="org.apache.shiro.SecurityUtils.setSecurityManager"/>
        <property name="arguments" ref="securityManager"/>
    </bean>

    <!-- Shiro Filter -->
    <bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
        <property name="securityManager" ref="securityManager" />
        <property name="loginUrl" value="/user/login" />
        <property name="successUrl" value="/user/list" />
        <property name="unauthorizedUrl" value="/user/unauthorized" />
        <property name="filters">
            <util:map>
                <entry key="urlf">
                    <bean class="com.kew.system.shiro.ShiroUrlFilter"/>
                </entry>
            </util:map>
        </property>
        <property name="filterChainDefinitions">
            <value>
                /resources/** = anon
                /eprint/common/** = anon
                /res_black/** = anon
                /image.action = anon
                /eprint/area/** = anon
                / = anon
                /user/login = anon
                /user/auth = anon
                /user/unauthorized = anon
                /index = authc
                /index/top = authc
                /index/left = authc
                /index/main = authc
                /index/bottom = authc
                /** = urlf
            </value>
        </property>
    </bean>

    <bean id="cacheManager" class="org.apache.shiro.cache.MemoryConstrainedCacheManager" />

    <bean id="lifecycleBeanPostProcessor" class="org.apache.shiro.spring.LifecycleBeanPostProcessor" />

</beans>