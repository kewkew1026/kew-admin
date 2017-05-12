<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.kew.${c.groupId}</groupId>
        <artifactId>kew-${c.groupId}-parent</artifactId>
        <version>0.1</version>
    </parent>
    <artifactId>kew-${c.groupId}-core</artifactId>
    <packaging>jar</packaging>
    <name>${c.escape}{project.artifactId} v${c.escape}{project.version}</name>

    <dependencies>
        <dependency>
            <groupId>com.kew.${c.groupId}</groupId>
            <artifactId>kew-${c.groupId}-basic</artifactId>
        </dependency>
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
                <scope>provided</scope>
            </dependency>
            <dependency>
                <groupId>javax.servlet.jsp</groupId>
                <artifactId>jsp-api</artifactId>
                <scope>provided</scope>
            </dependency>
            <dependency>
                <groupId>org.freemarker</groupId>
                <artifactId>freemarker</artifactId>
            </dependency>
            <dependency>
                <groupId>org.im4java</groupId>
                <artifactId>im4java</artifactId>
            </dependency>
    </dependencies>
</project>