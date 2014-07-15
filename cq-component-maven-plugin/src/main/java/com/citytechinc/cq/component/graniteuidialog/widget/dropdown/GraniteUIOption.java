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

import com.citytechinc.cq.component.dialog.AbstractDialogElement;
import com.citytechinc.cq.component.dialog.DialogElementParameters;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;

public class GraniteUIOption extends AbstractDialogElement implements GraniteUIElement {

    private final String title;
    private final String value;
    private final String text;
    private final Boolean disabled;
    private final Boolean selected;

    public GraniteUIOption(GraniteUIOptionParameters parameters) {
        super(parameters);

        this.title = parameters.getTitle();
        this.value = parameters.getValue();
        this.text = parameters.getText();
        this.disabled = parameters.getDisabled();
        this.selected = parameters.getSelected();
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public Boolean getSelected() {
        return selected;
    }

}
