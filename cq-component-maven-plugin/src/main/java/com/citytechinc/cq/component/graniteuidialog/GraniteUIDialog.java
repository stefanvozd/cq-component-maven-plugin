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
package com.citytechinc.cq.component.graniteuidialog;

import com.citytechinc.cq.component.graniteuidialog.widget.AbstractGraniteUIWidget;
import com.citytechinc.cq.component.util.Constants;
import com.citytechinc.cq.component.xml.NameSpacedAttribute;

import java.util.ArrayList;
import java.util.List;

public class GraniteUIDialog extends AbstractGraniteUIWidget {

    public static final String RESOURCE_TYPE = "cq/gui/components/authoring/dialog";

    private final NameSpacedAttribute<String> title;
    private final String fileName;

    /**
     * The constructor for the abstract Widget sets a number of properties
     * common to all widget types.
     *
     * @param parameters
     */
    public GraniteUIDialog(GraniteUIDialogParameters parameters) {
        super(parameters);

        this.title = new NameSpacedAttribute<String>(Constants.JCR_NS_URI, Constants.JCR_NS_PREFIX, parameters.getTitle());
        this.fileName = parameters.getFileName();

        List<GraniteUIElement> myContainedElements = new ArrayList<GraniteUIElement>();
        myContainedElements.add(parameters.getContainer());

        containedElements = myContainedElements;

    }

    public NameSpacedAttribute<String> getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName + ".xml";
    }
}
