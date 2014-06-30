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

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.dialog.exception.InvalidComponentFieldException;
import com.citytechinc.cq.component.dialog.widget.WidgetRegistry;
import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainerRegistry;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetRegistry;
import javassist.ClassPool;
import javassist.CtMember;
import javassist.NotFoundException;

public class GraniteUIWidgetMakerParameters {

    private DialogField annotation;
    private CtMember ctMember;
    private Class<?> containingClass;
    private ClassLoader classLoader;
    private ClassPool classPool;
    private GraniteUIWidgetRegistry widgetRegistry;
    private GraniteUIContainerRegistry containerRegistry;
    private String resourceType;
    private boolean useDotSlashInName;

    /**
     *
     * @param annotation
     * @param ctMember
     * @param containingClass
     * @param classLoader
     * @param classPool
     * @param widgetRegistry
     * @param resourceType
     * @param useDotSlashInName
     * @throws com.citytechinc.cq.component.dialog.exception.InvalidComponentFieldException
     * @throws javassist.NotFoundException
     */
    public GraniteUIWidgetMakerParameters(
            DialogField annotation,
            CtMember ctMember,
            Class<?> containingClass,
            ClassLoader classLoader,
            ClassPool classPool,
            GraniteUIWidgetRegistry widgetRegistry,
            GraniteUIContainerRegistry containerRegistry,
            String resourceType,
            boolean useDotSlashInName) throws InvalidComponentFieldException, NotFoundException {

        this.annotation = annotation;
        this.ctMember = ctMember;
        this.containingClass = containingClass;
        this.classLoader = classLoader;
        this.classPool = classPool;
        this.widgetRegistry = widgetRegistry;
        this.containerRegistry = containerRegistry;
        this.resourceType = resourceType;
        this.useDotSlashInName = useDotSlashInName;
    }

    /**
     *
     * @return The DialogField annotation associated with the Widget
     */
    public DialogField getAnnotation() {
        return annotation;
    }

    /**
     *
     * @param annotation
     */
    public void setAnnotation(DialogField annotation) {
        this.annotation = annotation;
    }

    /**
     *
     * @return The CtMember representing the Widget
     */
    public CtMember getCtMember() {
        return ctMember;
    }

    /**
     *
     * @param ctMember
     */
    public void setCtMember(CtMember ctMember) {
        this.ctMember = ctMember;
    }

    /**
     *
     * @return The Containing Class of the Widget
     */
    public Class<?> getContainingClass() {
        return containingClass;
    }

    /**
     *
     * @param containingClass
     */
    public void setContainingClass(Class<?> containingClass) {
        this.containingClass = containingClass;
    }

    /**
     *
     * @return The ClassLoader used by the maker
     */
    public ClassLoader getClassLoader() {
        return classLoader;
    }

    /**
     *
     * @param classLoader
     */
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     *
     * @return The ClassPool used by the maker
     */
    public ClassPool getClassPool() {
        return classPool;
    }

    /**
     *
     * @param classPool
     */
    public void setClassPool(ClassPool classPool) {
        this.classPool = classPool;
    }

    /**
     *
     * @return The WidgetRegistry used by the maker for widget lookup
     */
    public GraniteUIWidgetRegistry getWidgetRegistry() {
        return widgetRegistry;
    }

    /**
     *
     * @param widgetRegistry
     */
    public void setWidgetRegistry(GraniteUIWidgetRegistry widgetRegistry) {
        this.widgetRegistry = widgetRegistry;
    }

    /**
     *
     * @return The Widget's resourceType parameter
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     *
     * @param resourceType
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     *
     * @return The useDotSlashInName parameter
     */
    public boolean isUseDotSlashInName() {
        return useDotSlashInName;
    }

    /**
     *
     * @param useDotSlashInName
     */
    public void setUseDotSlashInName(boolean useDotSlashInName) {
        this.useDotSlashInName = useDotSlashInName;
    }

    public GraniteUIContainerRegistry getContainerRegistry() {
        return containerRegistry;
    }

    public void setContainerRegistry(GraniteUIContainerRegistry containerRegistry) {
        this.containerRegistry = containerRegistry;
    }
}
