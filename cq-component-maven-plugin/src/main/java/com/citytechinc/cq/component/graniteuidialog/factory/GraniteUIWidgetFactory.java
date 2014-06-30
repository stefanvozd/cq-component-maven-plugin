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

import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.exception.GraniteUIDialogCreationException;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import com.citytechinc.cq.component.graniteuidialog.maker.impl.GraniteUIDefaultWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.widget.textfield.GraniteUITextFieldWidget;
import com.citytechinc.cq.component.util.GraniteUIWidgetConfigHolder;
import org.codehaus.plexus.util.StringUtils;

public class GraniteUIWidgetFactory {

    public static GraniteUIElement make(GraniteUIWidgetMakerParameters parameters, int rankingCeiling) throws GraniteUIDialogCreationException {

        //get widget maker for the field identified in the parameters
        GraniteUIWidgetMakerContext widgetMakerContext = getWidgetMakerForField(parameters, rankingCeiling);

        //explicitly set the resource type of the field - this accomodates the simple widget which can be used for many of the simple widget types
        parameters.setResourceType(widgetMakerContext.getResourceType());

        try {
            //instantiate the widget maker
            GraniteUIWidgetMaker widgetMaker = widgetMakerContext.getWidgetMaker().getConstructor(GraniteUIWidgetMakerParameters.class).newInstance(parameters);

            //run the maker's make method
            return widgetMaker.make();

        } catch (Exception e) {
            throw new GraniteUIDialogCreationException("Exception encountered attempting to instantiate widget maker " + widgetMakerContext.getWidgetMaker().toString(), e);
        }

    }

    private static GraniteUIWidgetMakerContext getWidgetMakerForField(GraniteUIWidgetMakerParameters parameters, int rankingCeiling) throws GraniteUIDialogCreationException {

        GraniteUIWidgetConfigHolder widgetConfigHolder = getWidgetConfig(parameters, rankingCeiling);

        if (widgetConfigHolder != null && widgetConfigHolder.hasMakerClass()) {
            return new GraniteUIWidgetMakerContext(widgetConfigHolder.getMakerClass(), widgetConfigHolder.getResourceType());
        }

        if (widgetConfigHolder != null && widgetConfigHolder.hasResourceType()) {
            return new GraniteUIWidgetMakerContext(GraniteUIDefaultWidgetMaker.class, widgetConfigHolder.getResourceType());
        }

        String resourceType = getResourceTypeForField(parameters);

        if (StringUtils.isBlank(resourceType)) {
            throw new GraniteUIDialogCreationException("Resource Type could not be determined for field " + parameters.getCtMember().toString() + " of class " + parameters.getContainingClass().toString());
        }

        return new GraniteUIWidgetMakerContext(GraniteUIDefaultWidgetMaker.class, resourceType);

    }

    private static String getResourceTypeForField(GraniteUIWidgetMakerParameters parameters) {
        //TODO: Write this method
        return GraniteUITextFieldWidget.RESOURCE_TYPE;
    }

    private static GraniteUIWidgetConfigHolder getWidgetConfig(GraniteUIWidgetMakerParameters parameters, int rankingCeiling) {

        GraniteUIWidgetConfigHolder widgetConfigHolder = null;

        for (Class<?> currentRegisteredAnnotation : parameters.getWidgetRegistry().getRegisteredAnnotations()) {
            if (parameters.getCtMember().hasAnnotation(currentRegisteredAnnotation)) {
                GraniteUIWidgetConfigHolder currentCandidateConfig = parameters.getWidgetRegistry().getWidgetForAnnotation(currentRegisteredAnnotation);
                if (rankingCeiling < 0 || currentCandidateConfig.getRanking() < rankingCeiling) {
                    if (widgetConfigHolder == null || currentCandidateConfig.getRanking() > widgetConfigHolder.getRanking()) {
                        widgetConfigHolder = currentCandidateConfig;
                    }
                }
            }
        }

        return widgetConfigHolder;

    }

    public static class GraniteUIWidgetMakerContext {

        private final Class<? extends GraniteUIWidgetMaker> widgetMaker;
        private final String resourceType;

        public GraniteUIWidgetMakerContext(Class<? extends GraniteUIWidgetMaker> widgetMaker, String resourceType) {
            this.widgetMaker = widgetMaker;
            this.resourceType = resourceType;
        }

        public Class<? extends GraniteUIWidgetMaker> getWidgetMaker() {
            return widgetMaker;
        }

        public String getResourceType() {
            return resourceType;
        }

    }
}
