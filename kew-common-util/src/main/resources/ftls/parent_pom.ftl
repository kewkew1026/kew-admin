<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.kew.admin</groupId>
        <artifactId>kew-deploy</artifactId>
        <version>0.1</version>
    </parent>

    <groupId>com.kew.${c.groupId}</groupId>
    <artifactId>kew-${c.groupId}-parent</artifactId>
    <version>0.1</version>
    <packaging>pom</packaging>
    <name>${c.escape}{project.artifactId} v${c.escape}{project.version}</name>

    <modules>
        <module>kew-${c.groupId}-common</module>
        <module>kew-${c.groupId}-api</module>
        <module>kew-${c.groupId}-basic</module>
        <module>kew-${c.groupId}-core</module>
        <module>kew-${c.groupId}-innerapi</module>
        <module>kew-${c.groupId}-openapi</module>
        <module>kew-${c.groupId}-mps</module>
        <module>kew-${c.groupId}-website</module>
        <module>kew-${c.groupId}-boss</module>
        <module>kew-${c.groupId}-cms</module>

    </modules>

    <properties>
        <junit.version>4.12</junit.version>
        <springframework.version>4.1.8.RELEASE</springframework.version>
        <alibaba.version>1.2.6</alibaba.version>
        <commons.dbcp.version>1.4</commons.dbcp.version>
        <mybatis-spring.version>1.2.3</mybatis-spring.version>
        <mybatis.version>3.3.0</mybatis.version>
        <mysql.connector.version>5.1.34</mysql.connector.version>
        <hessain.version>4.0.38</hessain.version>
        <commons.fileupload.version>3.1</commons.fileupload.version>
        <kew.${c.groupId}.version>0.1</kew.${c.groupId}.version>
        <kew.common.util.version>0.1</kew.common.util.version>
    </properties>

    <dependencyManagement>
        <dependencies>

            <dependency>
                <groupId>com.kew.${c.groupId}</groupId>
                <artifactId>kew-${c.groupId}-common</artifactId>
                <version>${c.escape}{kew.${c.groupId}.version}</version>
            </dependency>
            <dependency>
                <groupId>com.kew.${c.groupId}</groupId>
                <artifactId>kew-${c.groupId}-api</artifactId>
                <version>${c.escape}{kew.${c.groupId}.version}</version>
            </dependency>
            <dependency>
                <groupId>com.kew.${c.groupId}</groupId>
                <artifactId>kew-${c.groupId}-basic</artifactId>
                <version>${c.escape}{kew.${c.groupId}.version}</version>
            </dependency>
            <dependency>
                <groupId>com.kew.${c.groupId}</groupId>
                <artifactId>kew-${c.groupId}-core</artifactId>
                <version>${c.escape}{kew.${c.groupId}.version}</version>
            </dependency>

            <dependency>
                <groupId>com.kew.admin</groupId>
                <artifactId>kew-common-util</artifactId>
            <#noparse>
                <version>${kew.common.util.version}</version>
            </#noparse>
            </dependency>

            <dependency>
                <groupId>com.kew.admin</groupId>
                <artifactId>kew-common-lang</artifactId>
            <#noparse>
                <version>${kew.common.util.version}</version>
            </#noparse>
            </dependency>


            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <#noparse>
                    <version>${junit.version}</version>
                </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-core</artifactId>
                <#noparse>
                    <version>${springframework.version}</version>
                 </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-expression</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-beans</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-aop</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context-support</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
        <#--事务管理-->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-tx</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jdbc</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-orm</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
        <#--几乎总是一个 plain old Java object，或简写为 POJO-->
        <#-- Java 对象（几乎总是一个 plain old Java object，或简写为 POJO）和 XML 文档之间来回转换-->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-oxm</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-web</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-webmvc</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-test</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
        <#--提供activemq-->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jms</artifactId>
            <#noparse>
                <version>${springframework.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
            <#noparse>
                <version>${mysql.connector.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis</artifactId>
            <#noparse>
                <version>${mybatis.version}</version>
            </#noparse>
            </dependency>
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis-spring</artifactId>
            <#noparse>
                <version>${mybatis-spring.version}</version>
            </#noparse>
            </dependency>
        <#--tomcat 连接池-->
            <dependency>
                <groupId>commons-dbcp</groupId>
                <artifactId>commons-dbcp</artifactId>
            <#noparse>
                <version>${commons.dbcp.version}</version>
            </#noparse>
            </dependency>

            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
            <#noparse>
                <version>${alibaba.version}</version>
            </#noparse>
            </dependency>

            <#--hessian 接口-->
            <dependency>
                <groupId>com.caucho</groupId>
                <artifactId>hessian</artifactId>
                <#noparse>
                    <version>${hessian.version}</version>
                </#noparse>
            </dependency>
            <#--多文件上传-->
            <dependency>
                <groupId>commons-fileupload</groupId>
                <artifactId>commons-fileupload</artifactId>
            <#noparse>
                <version>${commons.fileupload.version}</version>
            </#noparse>
            </dependency>

        </dependencies>
    </dependencyManagement>
</project>