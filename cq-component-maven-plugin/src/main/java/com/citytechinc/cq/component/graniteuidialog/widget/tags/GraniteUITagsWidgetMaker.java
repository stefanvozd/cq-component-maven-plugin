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
package com.citytechinc.cq.component.graniteuidialog.widget.tags;

import com.citytechinc.cq.component.annotations.widgets.TagInputField;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import com.citytechinc.cq.component.graniteuidialog.widget.autocomplete.AbstractGraniteUIAutoCompleteWidgetMaker;
import com.citytechinc.cq.component.xml.XmlElement;
import org.codehaus.plexus.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GraniteUITagsWidgetMaker extends AbstractGraniteUIAutoCompleteWidgetMaker {

    private String valuesResourceType;
    private String optionsResourceType;

    public GraniteUITagsWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    protected String getDataSourceResourceType() {
        return GraniteUITagsWidget.DATASOURCE;
    }

    @Override
    protected String getValuesResourceType() {
        return valuesResourceType;
    }

    @Override
    protected String getOptionsResourceType() {
        return optionsResourceType;
    }

    @Override
    public GraniteUIElement make() throws ClassNotFoundException {

        TagInputField tagInputField = getAnnotation(TagInputField.class);
        GraniteUITagsWidgetParameters widgetParameters = new GraniteUITagsWidgetParameters();

        valuesResourceType = getValuesResourceTypeForField(tagInputField);
        optionsResourceType = getOptionsResourceTypeForField(tagInputField);

        widgetParameters.setName(getNameForField());
        widgetParameters.setFieldName(getFieldNameForField());
        widgetParameters.setFieldLabel(getFieldLabelForField());
        widgetParameters.setFieldDescription(getFieldDescriptionForField());
        widgetParameters.setRequired(!getIsRequiredForField());
        widgetParameters.setAdditionalProperties(getAdditionalPropertiesForField());
        widgetParameters.setDefaultValue(getDefaultValueForField());
        widgetParameters.setListeners(getListeners());

        widgetParameters.setDisabled(getDisabledForField(tagInputField));
        widgetParameters.setEmptyText(getEmptyTextForField(tagInputField));
        widgetParameters.setMultiple(getMultipleForField(tagInputField));
        widgetParameters.setTitle(getTitleForField(tagInputField));

        List<XmlElement> containedElements = new ArrayList<XmlElement>();
        containedElements.add(getDataSourceForField());
        containedElements.add(getOptionsForField());
        containedElements.add(getValuesForField());

        widgetParameters.setContainedElements(containedElements);

        return new GraniteUITagsWidget(widgetParameters);

    }

    public String getValuesResourceTypeForField(TagInputField tagInputField) {
        if (tagInputField != null) {
            return tagInputField.values();
        }

        return TagInputField.VALUES_DEFAULT;
    }

    public String getOptionsResourceTypeForField(TagInputField tagInputField) {
        if (tagInputField != null) {
            return tagInputField.options();
        }

        return TagInputField.OPTIONS_DEFAULT;
    }

    public Boolean getDisabledForField(TagInputField tagInputField) {
        if (tagInputField != null) {
            return tagInputField.disabled();
        }

        return null;
    }

    public String getEmptyTextForField(TagInputField tagInputField) {
        if (tagInputField != null && StringUtils.isNotBlank(tagInputField.emptyText())) {
            return tagInputField.emptyText();
        }

        return null;
    }

    public Boolean getMultipleForField(TagInputField tagInputField) {
        if (tagInputField != null) {
            return tagInputField.multiple();
        }

        return null;
    }

    public String getTitleForField(TagInputField tagInputField) {
        if (tagInputField != null) {
            return tagInputField.title();
        }

        return null;
    }

}
