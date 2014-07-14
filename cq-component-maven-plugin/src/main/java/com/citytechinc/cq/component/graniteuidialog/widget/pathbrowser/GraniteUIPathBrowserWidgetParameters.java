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

import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetParameters;

public class GraniteUIPathBrowserWidgetParameters extends GraniteUIWidgetParameters {

    private boolean disabled;
    private String rootPath;
    private String optionLoader;
    private String optionLoaderRoot;
    private String optionValueReader;
    private String optionTitleReader;
    private String emptyText;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getOptionLoader() {
        return optionLoader;
    }

    public void setOptionLoader(String optionLoader) {
        this.optionLoader = optionLoader;
    }

    public String getOptionLoaderRoot() {
        return optionLoaderRoot;
    }

    public void setOptionLoaderRoot(String optionLoaderRoot) {
        this.optionLoaderRoot = optionLoaderRoot;
    }

    public String getOptionValueReader() {
        return optionValueReader;
    }

    public void setOptionValueReader(String optionValueReader) {
        this.optionValueReader = optionValueReader;
    }

    public String getOptionTitleReader() {
        return optionTitleReader;
    }

    public void setOptionTitleReader(String optionTitleReader) {
        this.optionTitleReader = optionTitleReader;
    }

    @Override
    public String getResourceType() {
        return GraniteUIPathBrowserWidget.RESOURCE_TYPE;
    }

    @Override
    public void setResourceType(String resourceType) {
        throw new UnsupportedOperationException("resource type is Static for PathBrowser Widget");
    }

    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }
}
