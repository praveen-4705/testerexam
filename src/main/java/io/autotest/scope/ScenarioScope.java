package io.autotest.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ScenarioScope implements Scope {
	private final ThreadLocal<Map<String, Object>> testScope = new NamedThreadLocal<Map<String, Object>>(
			ScenarioScope.class.getName()) {
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}
	};

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map<String, Object> scope = this.testScope.get();
		Object object = scope.get(name);
		if (object == null) {
			object = objectFactory.getObject();
			scope.put(name, object);
		}
		return object;
	}

	@Override
	public Object remove(String name) {
		Map<String, Object> scope = this.testScope.get();
		return scope.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return Thread.currentThread().getName();
	}

	public void clear() {
		Map<String, Object> scope = this.testScope.get();
		scope.clear();
	}
}
