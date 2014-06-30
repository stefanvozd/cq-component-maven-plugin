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
package com.citytechinc.cq.component.graniteuidialog.container.impl.fixedcolumns;

import com.citytechinc.cq.component.annotations.config.GraniteUIContainer;
import com.citytechinc.cq.component.annotations.layouts.FixedColumns;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.container.AbstractGraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.layout.AbstractGraniteUILayout;

import java.util.ArrayList;
import java.util.List;

@GraniteUIContainer(annotationClass = FixedColumns.class, makerClass = FixedColumnsContainerMaker.class)
public class FixedColumnsContainer extends AbstractGraniteUIContainer {

    public FixedColumnsContainer(FixedColumnsContainerParameters parameters) {
        super(parameters);

        List<GraniteUIElement> myContainedItems = new ArrayList<GraniteUIElement>();

        myContainedItems.add(parameters.getLayout());
        myContainedItems.add(parameters.getItems());

        containedElements = myContainedItems;

    }

}
