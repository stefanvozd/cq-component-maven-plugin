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
package com.citytechinc.cq.component.graniteuidialog.widget.textarea;

import com.citytechinc.cq.component.annotations.widgets.TextArea;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import org.codehaus.plexus.util.StringUtils;

public class GraniteUITextAreaWidgetMaker extends AbstractGraniteUIWidgetMaker {

    public GraniteUITextAreaWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public GraniteUIElement make() throws ClassNotFoundException {

        TextArea textArea = getAnnotation(TextArea.class);
        GraniteUITextAreaWidgetParameters widgetParameters = new GraniteUITextAreaWidgetParameters();

        widgetParameters.setName(getNameForField());
        widgetParameters.setFieldName(getFieldNameForField());
        widgetParameters.setFieldLabel(getFieldLabelForField());
        widgetParameters.setFieldDescription(getFieldDescriptionForField());
        widgetParameters.setRequired(!getIsRequiredForField());
        widgetParameters.setAdditionalProperties(getAdditionalPropertiesForField());
        widgetParameters.setDefaultValue(getDefaultValueForField());
        widgetParameters.setListeners(getListeners());

        widgetParameters.setDisabled(getDisabledForField(textArea));
        widgetParameters.setEmptyText(getEmptyTextForField(textArea));
        widgetParameters.setRows(getRowsForField(textArea));
        widgetParameters.setCols(getColsForField(textArea));

        return new GraniteUITextAreaWidget(widgetParameters);

    }

    protected boolean getDisabledForField(TextArea annotation) {
        if (annotation != null) {
            return annotation.disabled();
        }

        return false;
    }

    protected String getEmptyTextForField(TextArea annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.emptyText())) {
            return annotation.emptyText();
        }

        return null;
    }

    protected Long getRowsForField(TextArea annotation) {
        if (annotation != null && annotation.rows() != -1) {
            return annotation.rows();
        }

        return null;
    }

    protected Long getColsForField(TextArea annotation) {
        if (annotation != null && annotation.cols() != -1) {
            return annotation.cols();
        }

        return null;
    }

}
