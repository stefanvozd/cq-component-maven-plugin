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
package com.citytechinc.cq.component.graniteuidialog.maker.impl;

import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.impl.GraniteUISimpleWidget;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetParameters;
import java.util.Map;

public class GraniteUIDefaultWidgetMaker extends AbstractGraniteUIWidgetMaker {

    public GraniteUIDefaultWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public GraniteUIElement make() {

        String name = getNameForField();
        String fieldName = getFieldNameForField();
        String fieldLabel = getFieldLabelForField();
        String fieldDescription = getFieldDescriptionForField();
        Boolean isRequired = getIsRequiredForField();
        Map<String, String> additionalProperties = getAdditionalPropertiesForField();
        String defaultValue = getDefaultValueForField();

        GraniteUIWidgetParameters widgetParameters = new GraniteUIWidgetParameters();
        widgetParameters.setResourceType(parameters.getResourceType());
        widgetParameters.setName(name);
        widgetParameters.setFieldName(fieldName);
        widgetParameters.setFieldLabel(fieldLabel);
        widgetParameters.setFieldDescription(fieldDescription);
        widgetParameters.setAllowBlank(!isRequired);
        widgetParameters.setAdditionalProperties(additionalProperties);
        widgetParameters.setDefaultValue(defaultValue);
        widgetParameters.setListeners(getListeners());

        return new GraniteUISimpleWidget(widgetParameters);

    }

}
