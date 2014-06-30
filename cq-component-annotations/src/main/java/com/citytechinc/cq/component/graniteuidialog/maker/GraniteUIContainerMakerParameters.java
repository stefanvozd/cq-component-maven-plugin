/**
 *    Copyright 2013 CITYTECH, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
