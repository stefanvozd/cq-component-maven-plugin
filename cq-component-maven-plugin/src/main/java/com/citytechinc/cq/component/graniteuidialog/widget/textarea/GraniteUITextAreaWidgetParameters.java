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


import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetParameters;

public class GraniteUITextAreaWidgetParameters extends GraniteUIWidgetParameters  {

    private boolean disabled;
    private String emptyText;
    private Long rows;
    private Long cols;

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }

    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) {
        this.rows = rows;
    }

    public Long getCols() {
        return cols;
    }

    public void setCols(Long cols) {
        this.cols = cols;
    }

    @Override
    public String getResourceType() {
        return GraniteUITextAreaWidget.RESOURCE_TYPE;
    }

    @Override
    public void setResourceType(String resourceType) {
        throw new UnsupportedOperationException("resource type is Static for PathBrowser Widget");
    }

}
