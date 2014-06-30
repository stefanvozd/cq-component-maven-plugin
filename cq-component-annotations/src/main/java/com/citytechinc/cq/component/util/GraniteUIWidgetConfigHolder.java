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
package com.citytechinc.cq.component.util;

import com.citytechinc.cq.component.dialog.maker.WidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.widget.AbstractGraniteUIWidget;

public class GraniteUIWidgetConfigHolder {

    private final Class<?> annotationClass;
    private final Class<? extends AbstractGraniteUIWidget> widgetClass;
    private final Class<? extends GraniteUIWidgetMaker> makerClass;
    private final String resourceType;
    private final int ranking;

    /**
     *
     * @param annotationClass
     * @param widgetClass
     * @param makerClass
     * @param resourceType
     * @param ranking
     */
    public GraniteUIWidgetConfigHolder(Class<?> annotationClass, Class<? extends AbstractGraniteUIWidget> widgetClass,
                              Class<? extends GraniteUIWidgetMaker> makerClass, String resourceType, int ranking) {
        this.annotationClass = annotationClass;
        this.widgetClass = widgetClass;
        this.makerClass = makerClass;
        this.resourceType = resourceType;
        this.ranking = ranking;
    }

    public Class<?> getAnnotationClass() {
        return annotationClass;
    }

    public Class<? extends AbstractGraniteUIWidget> getWidgetClass() {
        return widgetClass;
    }

    public Class<? extends GraniteUIWidgetMaker> getMakerClass() {
        return makerClass;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getRanking() {
        return ranking;
    }

    public boolean hasMakerClass() {
        return makerClass != null;
    }

    public boolean hasResourceType() {
        return resourceType != null;
    }

}
