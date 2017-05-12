<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.kew.${c.groupId}</groupId>
        <artifactId>kew-${c.groupId}-parent</artifactId>
        <version>0.1</version>
    </parent>
    <artifactId>kew-${c.groupId}-website</artifactId>
    <packaging>war</packaging>
    <name>${c.escape}{project.artifactId} v${c.escape}{project.version}</name>

    <dependencies>
        <!-- ssm001 -->

        <!-- shiro -->
        <dependency>
            <artifactId>shiro-freemarker-tags</artifactId>
            <groupId>com.jagregory</groupId>
            <version>0.1-SNAPSHOT</version>
        </dependency>
        <!-- shiro -->
        <!-- shiro -->
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
    </dependencies>
    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*</include>
                </includes>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <encoding>utf-8</encoding>
                    <target>1.8</target>
                    <source>1.8</source>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>2.4</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                        <configuration>
                            <archive>
                                <manifest>
                                    <addClasspath>true</addClasspath>
                                </manifest>
                            </archive>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.1.1</version>
                <configuration>
                    <overlays>
                        <overlay>
                            <groupId>com.kew.admin</groupId>
                            <artifactId>kew-common-website-web</artifactId>
                        </overlay>
                    </overlays>
                    <dependentWarExcludes>
                        WEB-INF/lib
                    </dependentWarExcludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>