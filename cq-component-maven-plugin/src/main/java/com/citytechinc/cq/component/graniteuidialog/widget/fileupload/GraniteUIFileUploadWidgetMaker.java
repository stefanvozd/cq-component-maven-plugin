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
package com.citytechinc.cq.component.graniteuidialog.widget.fileupload;

import com.citytechinc.cq.component.annotations.widgets.Html5SmartFile;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import org.codehaus.plexus.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class GraniteUIFileUploadWidgetMaker extends AbstractGraniteUIWidgetMaker {

    public GraniteUIFileUploadWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public GraniteUIElement make() throws ClassNotFoundException {

        Html5SmartFile smartFile = getAnnotation(Html5SmartFile.class);
        GraniteUIFileUploadWidgetParameters widgetParameters = new GraniteUIFileUploadWidgetParameters();

        widgetParameters.setName(getNameForField());
        widgetParameters.setFieldName(getFieldNameForField());
        widgetParameters.setFieldLabel(getFieldLabelForField());
        widgetParameters.setFieldDescription(getFieldDescriptionForField());
        widgetParameters.setRequired(!getIsRequiredForField());
        widgetParameters.setAdditionalProperties(getAdditionalPropertiesForField());
        widgetParameters.setDefaultValue(getDefaultValueForField());
        widgetParameters.setListeners(getListeners());

        widgetParameters.setTitle(getTitleForField(smartFile));
        widgetParameters.setText(getTextForField(smartFile));
        widgetParameters.setIcon(getIconForField(smartFile));
        widgetParameters.setVariant(getVariantForField(smartFile));
        widgetParameters.setMultiple(getMultipleForField(smartFile));
        widgetParameters.setDisabled(getDisabledForField(smartFile));
        widgetParameters.setPlaceholder(getPlaceholderForField(smartFile));
        widgetParameters.setEmptyText(getEmptyTextForField(smartFile));
        widgetParameters.setFileNameParameter(getFileNameParameterForField(smartFile));
        widgetParameters.setUploadUrl(getUploadUrlForField(smartFile));
        widgetParameters.setUploadUrlBuilder(getUploadUrlBuilderForField(smartFile));
        widgetParameters.setSizeLimit(getSizeLimitForField(smartFile));
        widgetParameters.setAutoStart(getAutoStartForField(smartFile));
        widgetParameters.setUseHTML5(getUseHTML5ForField(smartFile));
        widgetParameters.setDropZone(getDropZoneForField(smartFile));
        widgetParameters.setMimeTypes(getMimeTypesForField(smartFile));

        return new GraniteUIFileUploadWidget(widgetParameters);

    }

    public String getTitleForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.title())) {
            return annotation.title();
        }

        return null;
    }

    public String getTextForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.text())) {
            return annotation.text();
        }

        return null;
    }

    public String getIconForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.icon())) {
            return annotation.icon();
        }

        return null;
    }

    public List<String> getVariantForField(Html5SmartFile annotation) {
        if (annotation != null && annotation.variant().length > 0) {
            return Arrays.asList(annotation.variant());
        }

        return null;
    }

    public boolean getMultipleForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.multiple();
        }

        return false;
    }

    public boolean getDisabledForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.disabled();
        }

        return false;
    }

    public String getPlaceholderForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.placeholder())) {
            return annotation.placeholder();
        }

        return null;
    }

    public String getEmptyTextForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.emptyText())) {
            return annotation.emptyText();
        }

        return null;
    }

    public String getFileNameParameterForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.fileNameParameter())) {
            return annotation.fileNameParameter();
        }

        return null;
    }

    public String getUploadUrlForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.uploadUrl())) {
            return annotation.uploadUrl();
        }

        return null;
    }

    public String getUploadUrlBuilderForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.uploadUrlBuilder())) {
            return annotation.uploadUrlBuilder();
        }

        return null;
    }

    public Long getSizeLimitForField(Html5SmartFile annotation) {
        if (annotation != null && annotation.sizeLimit() > 0) {
            return new Long(annotation.sizeLimit());
        }

        return null;
    }

    public boolean getAutoStartForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.autoStart();
        }

        return false;
    }

    public boolean getUseHTML5ForField(Html5SmartFile annotation) {
        if (annotation != null) {
            return annotation.useHTML5();
        }

        return true;
    }

    public String getDropZoneForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.dropZone())) {
            return annotation.dropZone();
        }

        return null;
    }

    public List<String> getMimeTypesForField(Html5SmartFile annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.mimeTypes())) {
            return Arrays.asList(annotation.mimeTypes().split(","));
        }

        return null;
    }

}
