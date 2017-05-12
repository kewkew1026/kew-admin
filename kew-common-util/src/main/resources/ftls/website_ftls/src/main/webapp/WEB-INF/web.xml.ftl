<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    version="3.0" metadata-complete="false">
	<context-param>
		<param-name>contextConfigLocation</param-name> 
		<param-value>
			classpath:/context/applicationContext-resources.xml
			classpath:/context/applicationContext-shiro.xml
			classpath:/context/applicationContext-mvc.xml
		</param-value>
	</context-param>

   <context-param>
        <param-name>log4jConfigLocation</param-name>
        <param-value>classpath:log4j.properties</param-value>
    </context-param> 
    

    <context-param>
        <param-name>log4jRefreshInterval</param-name>
        <param-value>1</param-value>
    </context-param>
    
    <context-param>
	    <param-name>webAppRootKey</param-name>
	    <param-value>${c.groupId}-website</param-value>
	</context-param>
    
  <!-- 验证码 -->
  <servlet>
    <servlet-name>validateCode</servlet-name>
  		<servlet-class>com.kew.website.image.ImageServlet</servlet-class>
  </servlet>
  <servlet-mapping>
	  <servlet-name>validateCode</servlet-name>
	  <url-pattern>/image.action</url-pattern>
  </servlet-mapping>
    
     
    <filter>
        <filter-name>shiroFilter</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        <init-param>
            <param-name>targetFilterLifecycle</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
      
    
    <filter>
        <filter-name>SetEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    
    <filter-mapping>
        <filter-name>SetEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    
      
    <filter-mapping>
        <filter-name>shiroFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    
    
    <!-- SpringMVC -->
    <servlet>
		<servlet-name>springMVC</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>
				classpath*:/context/applicationContext-mvc.xml
			</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>springMVC</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
	
	<!--filter映射-->

    <listener>
        <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
    </listener>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <listener>
		<listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
	</listener>

    <session-config>
        <session-timeout>30</session-timeout>
    </session-config>
	
	<error-page>
		<exception-type>java.lang.Throwable</exception-type>
		<location>/WEB-INF/error/500.jsp</location> 
	</error-page>
    <error-page>
        <error-code>500</error-code>
        <location>/WEB-INF/error/500.jsp</location>
    </error-page>
       <error-page>
        <error-code>602</error-code>
        <location>/WEB-INF/error/602.jsp</location>
    </error-page>
    <mime-mapping>
       <extension>js</extension>
       <mime-type>text/javascript</mime-type>
    </mime-mapping>
    <mime-mapping>
       <extension>jpg</extension>
       <mime-type>image/jpeg</mime-type>
    </mime-mapping>
    <mime-mapping>
       <extension>png</extension>
       <mime-type>image/png</mime-type>
    </mime-mapping>
</web-app>
