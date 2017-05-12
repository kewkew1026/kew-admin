package com.kew.page;

import com.kew.utils.ReflectUtil;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class DiclectStatementHandlerInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler statement = (RoutingStatementHandler) invocation.getTarget();
		PreparedStatementHandler handler = (PreparedStatementHandler) ReflectUtil.getClassField(statement, "delegate");
		RowBounds rowBounds = (RowBounds) ReflectUtil.getSuperClassField(handler, "rowBounds");
		if (rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			BoundSql boundSql = statement.getBoundSql();
			String sql = boundSql.getSql();
			sql = getLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit()-rowBounds.getOffset());
			ReflectUtil.setClassField(boundSql, "sql", sql);
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
	
	public String getLimitString(String sql, int offset, int limit) {

		sql = sql.trim();
		
		StringBuffer pagingSelect = new StringBuffer( sql.length()+100 );
		if (offset >= 0) {
			pagingSelect.append("select * from (  ");
		}
		
		pagingSelect.append(sql);
		if (offset >= 0) {
			pagingSelect.append(" ) as a limit " + offset + " , " + limit);
		}
		
		return pagingSelect.toString();
	}
}