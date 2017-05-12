log4j.rootLogger=DEBUG,console,DEBUG,WARN,ERROR

log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%d{yyyy-MM-dd HH:mm:ss}] %p %l %m%n

log4j.appender.debug=org.apache.log4j.DailyRollingFileAppender
log4j.appender.debug.Threshold=DEBUG
log4j.appender.debug.ImmediateFlush=true
log4j.appender.debug.Append=true
#log4j.appender.debug.MaxFileSize=10MB
#log4j.appender.debug.MaxBackupIndex=50
log4j.appender.debug.file=/opt/logs/applogs/${c.groupId}/${c.groupId}/boss/debug/debug.log
log4j.appender.debug.DatePattern = '.'yyyy-MM-dd
log4j.appender.debug.layout=org.apache.log4j.PatternLayout
log4j.appender.debug.layout.ConversionPattern=[%-5p] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t][%x] %C{8}@(%F:%L):%m%n

log4j.appender.info=org.apache.log4j.DailyRollingFileAppender
log4j.appender.info.Threshold=INFO
log4j.appender.info.ImmediateFlush=true
log4j.appender.info.Append=true
#log4j.appender.info.MaxFileSize=10MB
#log4j.appender.info.MaxBackupIndex=50
log4j.appender.info.file=/opt/logs/applogs/${c.groupId}/${c.groupId}/boss/info/info.log
log4j.appender.info.DatePattern = '.'yyyy-MM-dd
log4j.appender.info.layout=org.apache.log4j.PatternLayout
log4j.appender.info.layout.ConversionPattern=[%-5p] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t][%x] %C{8}@(%F:%L):%m%n

log4j.appender.warn=org.apache.log4j.DailyRollingFileAppender
log4j.appender.warn.Threshold=WARN
log4j.appender.warn.ImmediateFlush=true
log4j.appender.warn.Append=true
#log4j.appender.warn.MaxFileSize=5MB
#log4j.appender.warn.MaxBackupIndex=50
#log4j.appender.warn.file=/opt/logs/applogs/${c.groupId}/${c.groupId}/boss/warn/warn.log
log4j.appender.warn.file=/opt/logs/applogs/${c.groupId}/${c.groupId}/boss/warn/warn.log
log4j.appender.warn.DatePattern = '.'yyyy-MM-dd
log4j.appender.warn.layout=org.apache.log4j.PatternLayout
log4j.appender.warn.layout.ConversionPattern=[%-5p] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t][%x] %C{8}@(%F:%L):%m%n

log4j.appender.error=org.apache.log4j.DailyRollingFileAppender
log4j.appender.error.Threshold=ERROR
log4j.appender.error.ImmediateFlush=true
log4j.appender.error.Append=true
#log4j.appender.error.MaxFileSize=5MB
#log4j.appender.error.MaxBackupIndex=50
log4j.appender.error.file=/opt/logs/applogs/${c.groupId}/${c.groupId}/boss/error/error.log
log4j.appender.error.DatePattern = '.'yyyy-MM-dd
log4j.appender.error.layout=org.apache.log4j.PatternLayout
log4j.appender.error.layout.ConversionPattern=[%-5p] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t][%x] %C{8}@(%F:%L):%m%n


# Control logging for other open source packages
# Changing the log level to DEBUG when debug
log4j.logger.org.springframework=debug
# Changing the log level to DEBUG will display SQL Hibernate generated
log4j.logger.org.hibernate=WARN
log4j.logger.org.hibernate.SQL=INFO
log4j.logger.org.hibernate.cache=ERROR
log4j.logger.net.sf.ehcache=ERROR

log4j.logger.com.ibatis= debug
log4j.logger.com.ibatis.common.jdbc.SimpleDataSource= debug
log4j.logger.com.ibatis.common.jdbc.ScriptRunner= debug
log4j.logger.com.ibatis.common.jdbc.SQL= debug
log4j.logger.com.ibatis.sqlmap.engine.impl.SqlMapClientDelegate= debug
log4j.logger.java.sql.Connection= debug
log4j.logger.java.sql.Statement= debug
log4j.logger.java.sql.PreparedStatement= debug

