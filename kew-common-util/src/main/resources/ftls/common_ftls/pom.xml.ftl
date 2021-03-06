<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.kew.${c.groupId}</groupId>
        <artifactId>kew-${c.groupId}-parent</artifactId>
        <version>0.1</version>
    </parent>
    <artifactId>kew-${c.groupId}-common</artifactId>
    <packaging>jar</packaging>
    <name>${c.escape}{project.artifactId} v${c.escape}{project.version}</name>
    <dependencies>
        <dependency>
            <groupId>com.kew.admin</groupId>
            <artifactId>kew-common-util</artifactId>
        </dependency>

        <dependency>
            <groupId>com.kew.admin</groupId>
            <artifactId>kew-common-lang</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
        </dependency>
    </dependencies>
</project>