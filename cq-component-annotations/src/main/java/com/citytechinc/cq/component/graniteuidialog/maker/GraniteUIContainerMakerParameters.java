package com.citytechinc.cq.component.graniteuidialog.maker;

import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainerRegistry;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetRegistry;
import javassist.ClassPool;
import javassist.CtClass;

public class GraniteUIContainerMakerParameters {

    private CtClass ctClass;
    private Class<?> containingClass;
    private ClassLoader classLoader;
    private ClassPool classPool;
    private GraniteUIWidgetRegistry widgetRegistry;
    private GraniteUIContainerRegistry containerRegistry;
    private String containerNamePrefix;


    public GraniteUIContainerMakerParameters(CtClass ctClass, Class<?> containingClass, ClassLoader classLoader, ClassPool classPool, GraniteUIWidgetRegistry widgetRegistry, GraniteUIContainerRegistry containerRegistry, String containerNamePrefix) {
        this.ctClass = ctClass;
        this.containingClass = containingClass;
        this.classLoader = classLoader;
        this.classPool = classPool;
        this.widgetRegistry = widgetRegistry;
        this.containerRegistry = containerRegistry;
        this.containerNamePrefix = containerNamePrefix;
    }

    public CtClass getCtClass() {
        return ctClass;
    }

    public Class<?> getContainingClass() {
        return containingClass;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public ClassPool getClassPool() {
        return classPool;
    }

    public GraniteUIWidgetRegistry getWidgetRegistry() {
        return widgetRegistry;
    }

    public String getContainerNamePrefix() {
        return containerNamePrefix;
    }

    public GraniteUIContainerRegistry getContainerRegistry() {
        return containerRegistry;
    }
}
