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

import com.citytechinc.cq.component.annotations.config.GraniteUIWidget;
import com.citytechinc.cq.component.annotations.widgets.TagInputField;
import com.citytechinc.cq.component.graniteuidialog.widget.autocomplete.GraniteUIAutoCompleteWidget;

@GraniteUIWidget(annotationClass = TagInputField.class, makerClass = GraniteUITagsWidgetMaker.class, resourceType = GraniteUIAutoCompleteWidget.RESOURCE_TYPE)
public class GraniteUITagsWidget extends GraniteUIAutoCompleteWidget {

    public static final String DATASOURCE = "cq/gui/components/common/datasources/tags";

    private final Boolean disabled;
    private final String emptyText;
    private final Boolean multiple;

    public GraniteUITagsWidget(GraniteUITagsWidgetParameters parameters) {

        super(parameters);

        disabled = parameters.isDisabled();
        emptyText = parameters.getEmptyText();
        multiple = parameters.isMultiple();

    }

    public Boolean getDisabled() {
        return disabled;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public Boolean getMultiple() {
        return multiple;
    }

}
