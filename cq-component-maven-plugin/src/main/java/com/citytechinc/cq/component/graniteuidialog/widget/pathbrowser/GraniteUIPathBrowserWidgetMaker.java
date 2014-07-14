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
package com.citytechinc.cq.component.graniteuidialog.widget.pathbrowser;

import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import org.codehaus.plexus.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: paulmichelotti
 * Date: 7/10/14
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraniteUIPathBrowserWidgetMaker extends AbstractGraniteUIWidgetMaker {

    public GraniteUIPathBrowserWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public GraniteUIElement make() throws ClassNotFoundException {

        PathField pathField = getAnnotation(PathField.class);
        GraniteUIPathBrowserWidgetParameters widgetParameters = new GraniteUIPathBrowserWidgetParameters();

        widgetParameters.setName(getNameForField());
        widgetParameters.setFieldName(getFieldNameForField());
        widgetParameters.setFieldLabel(getFieldLabelForField());
        widgetParameters.setFieldDescription(getFieldDescriptionForField());
        widgetParameters.setRequired(!getIsRequiredForField());
        widgetParameters.setAdditionalProperties(getAdditionalPropertiesForField());
        widgetParameters.setDefaultValue(getDefaultValueForField());
        widgetParameters.setListeners(getListeners());

        return new GraniteUIPathBrowserWidget(widgetParameters);

    }

    protected String getRootPathForField(PathField annotation) {
        if (annotation != null) {
            return annotation.rootPath();
        }

        return PathField.ROOT_PATH_DEFAULT;
    }

    protected boolean getDisabledForField(PathField annotation) {
        //TODO: Implement
        return false;
    }

    protected String getOptionLoaderForField(PathField annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.optionLoader())) {
            return annotation.optionLoader();
        }

        return null;
    }

    protected String getOptionLoaderRootForField(PathField annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.optionLoaderRoot())) {
            return annotation.optionLoaderRoot();
        }

        return null;
    }

    protected String getOptionValueReaderForField(PathField annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.optionValueReader())) {
            return annotation.optionValueReader();
        }

        return null;
    }

    protected String getOptionTitleReaderForField(PathField annotation) {
        if (annotation != null && StringUtils.isNotBlank(annotation.optionTitleReader())) {
            return annotation.optionTitleReader();
        }

        return null;
    }

}
