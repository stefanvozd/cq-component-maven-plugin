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
                    + curConfig.getAnnotationClass());
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
