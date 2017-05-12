package com.kew.page;

import com.kew.utils.ReflectUtil;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.Properties;

@Intercepts({ @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class DiclectResultSetHandlerInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		DefaultResultSetHandler resultSet = (DefaultResultSetHandler) invocation.getTarget();
		RowBounds rowBounds = (RowBounds) ReflectUtil.getClassField(resultSet, "rowBounds");
		if (rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			ReflectUtil.setClassField(resultSet, "rowBounds", new RowBounds());
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}