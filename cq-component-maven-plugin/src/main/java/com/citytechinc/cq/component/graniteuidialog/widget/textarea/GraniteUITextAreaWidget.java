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

import com.citytechinc.cq.component.annotations.config.GraniteUIWidget;
import com.citytechinc.cq.component.annotations.widgets.TextArea;
import com.citytechinc.cq.component.graniteuidialog.widget.AbstractGraniteUIWidget;

@GraniteUIWidget(annotationClass = TextArea.class, makerClass = GraniteUITextAreaWidgetMaker.class, resourceType = GraniteUITextAreaWidget.RESOURCE_TYPE)
public class GraniteUITextAreaWidget extends AbstractGraniteUIWidget {

    public static final String RESOURCE_TYPE = "granite/ui/components/foundation/form/textarea";

    private final boolean disabled;
    private final String emptyText;
    private final Long rows;
    private final Long cols;

    public GraniteUITextAreaWidget(GraniteUITextAreaWidgetParameters parameters) {
        super(parameters);

        this.disabled = parameters.isDisabled();
        this.emptyText = parameters.getEmptyText();
        this.rows = parameters.getRows();
        this.cols = parameters.getCols();

    }

    public boolean isDisabled() {
        return disabled;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public Long getRows() {
        return rows;
    }

    public Long getCols() {
        return cols;
    }

}
