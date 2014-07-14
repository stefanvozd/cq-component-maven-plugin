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

import com.citytechinc.cq.component.annotations.config.GraniteUIWidget;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.graniteuidialog.widget.AbstractGraniteUIWidget;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetParameters;

@GraniteUIWidget(annotationClass = PathField.class, makerClass = GraniteUIPathBrowserWidgetMaker.class, resourceType = GraniteUIPathBrowserWidget.RESOURCE_TYPE)
public class GraniteUIPathBrowserWidget extends AbstractGraniteUIWidget {

    public static final String RESOURCE_TYPE = "granite/ui/components/foundation/form/pathbrowser";

    private final boolean disabled;
    private final String emptyText;
    private final String rootPath;
    private final String optionLoader;
    private final String optionLoaderRoot;
    private final String optionValueReader;
    private final String optionTitleReader;

    public GraniteUIPathBrowserWidget(GraniteUIPathBrowserWidgetParameters parameters) {
        super(parameters);

        this.disabled = parameters.isDisabled();
        this.emptyText = parameters.getEmptyText();
        this.rootPath = parameters.getRootPath();
        this.optionLoader = parameters.getOptionLoader();
        this.optionLoaderRoot = parameters.getOptionLoaderRoot();
        this.optionValueReader = parameters.getOptionValueReader();
        this.optionTitleReader = parameters.getOptionTitleReader();

    }

    public boolean isDisabled() {
        return disabled;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public String getRootPath() {
        return rootPath;
    }

    public String getOptionLoader() {
        return optionLoader;
    }

    public String getOptionLoaderRoot() {
        return optionLoaderRoot;
    }

    public String getOptionValueReader() {
        return optionValueReader;
    }

    public String getOptionTitleReader() {
        return optionTitleReader;
    }
}
