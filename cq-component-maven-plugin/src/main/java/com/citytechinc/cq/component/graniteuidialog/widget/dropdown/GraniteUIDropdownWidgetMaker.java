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
package com.citytechinc.cq.component.graniteuidialog.widget.dropdown;

import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;
import com.citytechinc.cq.component.dialog.DialogElement;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.items.GraniteUIItemsParameters;
import com.citytechinc.cq.component.graniteuidialog.items.impl.DefaultGraniteUIItems;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import com.citytechinc.cq.component.xml.XmlElement;
import org.codehaus.plexus.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GraniteUIDropdownWidgetMaker extends AbstractGraniteUIWidgetMaker {
    /**
     * Widget Makers will take, as input to their constructor, Widget parameters which
     * they can later use as they make their intended Widget.
     *
     * @param parameters
     */
    public GraniteUIDropdownWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public GraniteUIElement make() throws ClassNotFoundException {

        Selection selectionAnnotation = getAnnotation(Selection.class);
        GraniteUIDropdownWidgetParameters widgetParameters = new GraniteUIDropdownWidgetParameters();

        widgetParameters.setName(getNameForField());
        widgetParameters.setFieldName(getFieldNameForField());
        widgetParameters.setFieldLabel(getFieldLabelForField());
        widgetParameters.setFieldDescription(getFieldDescriptionForField());
        widgetParameters.setRequired(!getIsRequiredForField());
        widgetParameters.setAdditionalProperties(getAdditionalPropertiesForField());
        widgetParameters.setDefaultValue(getDefaultValueForField());
        widgetParameters.setListeners(getListeners());

        List<GraniteUIElement> options = buildSelectionOptionsForField(selectionAnnotation);

        widgetParameters.setType(getTypeForField(selectionAnnotation));
        widgetParameters.setDisabled(getIsDisabledForField(selectionAnnotation));
        widgetParameters.setEmptyText(getEmptyTextForField(selectionAnnotation));
        widgetParameters.setTranslateOptions(getTranslateOptionsForField(selectionAnnotation));

        GraniteUIItemsParameters itemsParameters = new GraniteUIItemsParameters();
        itemsParameters.setItems(options);
        List<XmlElement> items = new ArrayList<XmlElement>();
        items.add(new DefaultGraniteUIItems(itemsParameters));
        widgetParameters.setContainedElements(items);

        widgetParameters.setResourceType(GraniteUIDropdownWidget.RESOURCE_TYPE);

        return new GraniteUIDropdownWidget(widgetParameters);

    }

    private String getTypeForField(Selection annotation) {
        if (annotation != null) {
            if (annotation.multiple()) {
                return "multiple";
            }
        }

        return null;
    }

    private Boolean getIsDisabledForField(Selection annotation) {
        if (annotation != null) {
            return annotation.disabled();
        }

        return null;
    }

    private String getEmptyTextForField(Selection annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.emptyText())) {
            return annotation.emptyText();
        }

        return null;
    }

    private Boolean getTranslateOptionsForField(Selection annotation) {
        if (annotation != null) {
            return annotation.translateOptions();
        }

        return null;
    }

    private List<GraniteUIElement> buildSelectionOptionsForField(Selection annotation) {

        List<GraniteUIElement> options = new ArrayList<GraniteUIElement>();

        if (annotation != null && annotation.options().length > 0) {
            int optionNumber = 1;

            for (Option currentOption : annotation.options()) {

                GraniteUIOptionParameters currentParameters = new GraniteUIOptionParameters();

                if (StringUtils.isNotBlank(currentOption.text())) {
                    currentParameters.setText(currentOption.text());
                }
                if (StringUtils.isNotBlank(currentOption.value())) {
                    currentParameters.setValue(currentOption.value());
                }
                if (StringUtils.isNotBlank(currentOption.title())) {
                    currentParameters.setTitle(currentOption.title());
                }

                currentParameters.setFieldName("option" + optionNumber);

                options.add(new GraniteUIOption(currentParameters));

                optionNumber++;

            }
        }

        //TODO: Enum handling

        return options;

    }
}
