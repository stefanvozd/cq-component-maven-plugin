package com.citytechinc.cq.component.graniteuidialog.container.impl;

import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainerRegistry;
import com.citytechinc.cq.component.maven.util.ComponentMojoUtil;
import com.citytechinc.cq.component.maven.util.LogSingleton;
import com.citytechinc.cq.component.util.GraniteUIContainerConfigHolder;
import javassist.ClassPool;
import javassist.NotFoundException;
import org.reflections.Reflections;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultGraniteUIContainerRegistry implements GraniteUIContainerRegistry {

    private final Map<Class<?>, GraniteUIContainerConfigHolder> annotationToContainerConfigMap;

    public DefaultGraniteUIContainerRegistry(ClassPool classPool, ClassLoader classLoader, Reflections reflections) throws MalformedURLException, NotFoundException, ClassNotFoundException {

        LogSingleton LOG = LogSingleton.getInstance();

        List<GraniteUIContainerConfigHolder> containerConfigs = ComponentMojoUtil.getAllGraniteUIContainerAnnotations(classPool, classLoader, reflections);

        LOG.debug(containerConfigs.size() + " Granite UI Widget Configurations found");

        this.annotationToContainerConfigMap = new HashMap<Class<?>, GraniteUIContainerConfigHolder>();

        for (GraniteUIContainerConfigHolder curConfig : containerConfigs) {
            LOG.debug("Granite UI Container Config -- " + curConfig.getContainerClass() + " : " + curConfig.getMakerClass() + " : "
                    + curConfig.getAnnotationClass() + " : " + curConfig.getResourceType());
            if (curConfig.getAnnotationClass() != null) {
                this.annotationToContainerConfigMap.put(curConfig.getAnnotationClass(), curConfig);
            }
        }

    }

    @Override
    public GraniteUIContainerConfigHolder getContainerForAnnotation(Class<?> annotation) {
        return annotationToContainerConfigMap.get(annotation);
    }

    @Override
    public Set<Class<?>> getRegisteredAnnotations() {
        return annotationToContainerConfigMap.keySet();
    }

}
