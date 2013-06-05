package com.citytechinc.cq.component.dialog.widget.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.ClassPool;
import javassist.NotFoundException;

import org.reflections.Reflections;

import com.citytechinc.cq.component.dialog.widget.WidgetRegistry;
import com.citytechinc.cq.component.maven.util.ComponentMojoUtil;
import com.citytechinc.cq.component.maven.util.LogSingleton;
import com.citytechinc.cq.component.maven.util.WidgetConfigHolder;

public class WidgetRegistryImpl implements WidgetRegistry {

	private final List<WidgetConfigHolder> widgetConfigs;
	private final Map<Class<?>, WidgetConfigHolder> annotationToWidgetConfigMap;

	public WidgetRegistryImpl(ClassPool classPool, ClassLoader classLoader, Reflections reflections) throws MalformedURLException, ClassNotFoundException, NotFoundException {

		LogSingleton LOG = LogSingleton.getInstance();

		this.widgetConfigs = ComponentMojoUtil.getAllWidgetAnnotations(classPool, classLoader, reflections);

		LOG.debug(widgetConfigs.size() + " Widget Configurations found");

		this.annotationToWidgetConfigMap = new HashMap<Class<?>, WidgetConfigHolder>();

		for(WidgetConfigHolder curConfig : this.widgetConfigs) {
			LOG.debug("Widget Config -- " + curConfig.getWidgetClass() + " : " + curConfig.getMakerClass() + " : " + curConfig.getAnnotationClass() + " : " + curConfig.getXtype());
			if (curConfig.getAnnotationClass() != null) {
				this.annotationToWidgetConfigMap.put(curConfig.getAnnotationClass(), curConfig);
			}
		}

	}

	public WidgetConfigHolder getWidgetForAnnotation(Class<?> annotation) {
		return this.annotationToWidgetConfigMap.get(annotation);
	}

	public Set<Class<?>> getRegisteredAnnotations() {
		return this.annotationToWidgetConfigMap.keySet();
	}


}
