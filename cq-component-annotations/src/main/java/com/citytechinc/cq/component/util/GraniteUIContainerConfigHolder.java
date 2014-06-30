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

import com.citytechinc.cq.component.graniteuidialog.container.AbstractGraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMaker;

public class GraniteUIContainerConfigHolder {

    private final Class<?> annotationClass;
    private final Class<? extends AbstractGraniteUIContainer> containerClass;
    private final Class<? extends GraniteUIContainerMaker> makerClass;

    public GraniteUIContainerConfigHolder(
            Class<?> annotationClass,
            Class<? extends AbstractGraniteUIContainer> containerClass,
            Class<? extends GraniteUIContainerMaker> makerClass) {
        this.annotationClass = annotationClass;
        this.containerClass = containerClass;
        this.makerClass = makerClass;
    }

    public Class<?> getAnnotationClass() {
        return annotationClass;
    }

    public Class<? extends AbstractGraniteUIContainer> getContainerClass() {
        return containerClass;
    }

    public Class<? extends GraniteUIContainerMaker> getMakerClass() {
        return makerClass;
    }

    public boolean hasMakerClass() {
        return makerClass != null;
    }

}
