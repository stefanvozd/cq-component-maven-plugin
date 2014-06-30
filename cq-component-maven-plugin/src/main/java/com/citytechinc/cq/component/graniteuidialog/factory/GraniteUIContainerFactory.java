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
package com.citytechinc.cq.component.graniteuidialog.factory;

import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.container.impl.fixedcolumns.FixedColumnsContainerMaker;
import com.citytechinc.cq.component.graniteuidialog.exception.GraniteUIDialogCreationException;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMakerParameters;
import com.citytechinc.cq.component.util.GraniteUIContainerConfigHolder;

public class GraniteUIContainerFactory {

    private GraniteUIContainerFactory() {}

    public static GraniteUIContainer make(GraniteUIContainerMakerParameters parameters) throws GraniteUIDialogCreationException {

        Class<? extends GraniteUIContainerMaker> containerMakerClass = determineContainerMaker(parameters);

        try {
            GraniteUIContainerMaker containerMaker = containerMakerClass.getConstructor(GraniteUIContainerMakerParameters.class).newInstance(parameters);

            return containerMaker.make();
        } catch (Exception e) {
            throw new GraniteUIDialogCreationException("Exception encountered attempting to instantiate maker " + containerMakerClass.toString(), e);
        }
    }

    private static Class<? extends GraniteUIContainerMaker> determineContainerMaker(GraniteUIContainerMakerParameters parameters) {

        GraniteUIContainerConfigHolder containerConfigHolder = determineContainerConfiguration(parameters);

        if (containerConfigHolder != null && containerConfigHolder.hasMakerClass()) {
            return containerConfigHolder.getMakerClass();
        }

        return FixedColumnsContainerMaker.class;

    }

    private static GraniteUIContainerConfigHolder determineContainerConfiguration(GraniteUIContainerMakerParameters parameters) {
        for (Class<?> currentRegisteredAnnotation : parameters.getContainerRegistry().getRegisteredAnnotations()) {
            if (parameters.getCtClass().hasAnnotation(currentRegisteredAnnotation)) {
                return parameters.getContainerRegistry().getContainerForAnnotation(currentRegisteredAnnotation);
            }
        }

        return null;
    }

}
