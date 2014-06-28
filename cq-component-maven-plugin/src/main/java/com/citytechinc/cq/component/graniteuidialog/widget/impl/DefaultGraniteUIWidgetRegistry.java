package com.citytechinc.cq.component.graniteuidialog.widget.impl;

import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetRegistry;
import com.citytechinc.cq.component.maven.util.ComponentMojoUtil;
import com.citytechinc.cq.component.maven.util.LogSingleton;
import com.citytechinc.cq.component.util.GraniteUIWidgetConfigHolder;
import com.citytechinc.cq.component.util.WidgetConfigHolder;
import javassist.ClassPool;
import javassist.NotFoundException;
import org.reflections.Reflections;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultGraniteUIWidgetRegistry implements GraniteUIWidgetRegistry {

    private final Map<Class<?>, GraniteUIWidgetConfigHolder> annotationToWidgetConfigMap;

    public DefaultGraniteUIWidgetRegistry(ClassPool classPool, ClassLoader classLoader, Reflections reflections)
            throws MalformedURLException, ClassNotFoundException, NotFoundException {

        LogSingleton LOG = LogSingleton.getInstance();

        List<GraniteUIWidgetConfigHolder> widgetConfigs = ComponentMojoUtil.getAllGraniteUIWidgetAnnotations(classPool, classLoader,
                reflections);

        LOG.debug(widgetConfigs.size() + " Granite UI Widget Configurations found");

        this.annotationToWidgetConfigMap = new HashMap<Class<?>, GraniteUIWidgetConfigHolder>();

        for (GraniteUIWidgetConfigHolder curConfig : widgetConfigs) {
            LOG.debug("Granite UI Widget Config -- " + curConfig.getWidgetClass() + " : " + curConfig.getMakerClass() + " : "
                    + curConfig.getAnnotationClass() + " : " + curConfig.getResourceType());
            if (curConfig.getAnnotationClass() != null) {
                this.annotationToWidgetConfigMap.put(curConfig.getAnnotationClass(), curConfig);
            }
        }

    }


    @Override
    public GraniteUIWidgetConfigHolder getWidgetForAnnotation(Class<?> annotation) {
        return annotationToWidgetConfigMap.get(annotation);
    }

    @Override
    public Set<Class<?>> getRegisteredAnnotations() {
        return annotationToWidgetConfigMap.keySet();
    }

}
