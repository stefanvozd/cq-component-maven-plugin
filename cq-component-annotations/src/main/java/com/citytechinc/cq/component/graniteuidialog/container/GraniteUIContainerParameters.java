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
package com.citytechinc.cq.component.graniteuidialog.container;

import com.citytechinc.cq.component.graniteuidialog.items.GraniteUIItems;
import com.citytechinc.cq.component.graniteuidialog.layout.GraniteUILayout;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIResourceTypedElementParameters;
import com.citytechinc.cq.component.util.Constants;
import org.codehaus.plexus.util.StringUtils;

public class GraniteUIContainerParameters extends GraniteUIResourceTypedElementParameters {

    private GraniteUILayout layout;
    private GraniteUIItems items;

    public GraniteUILayout getLayout() {
        return layout;
    }

    public void setLayout(GraniteUILayout graniteUILayoutElement) {
        this.layout = graniteUILayoutElement;
    }


    public GraniteUIItems getItems() {
        return items;
    }

    public void setItems(GraniteUIItems items) {
        this.items = items;
    }

    @Override
    public String getPrimaryType() {
        if (StringUtils.isEmpty(primaryType)) {
            return Constants.NT_UNSTRUCTURED;
        }
        return primaryType;
    }

    @Override
    public String getResourceType() {
        if (StringUtils.isBlank(super.getResourceType())) {
            return GraniteUIContainer.DEFAULT_RESOURCE_TYPE;
        }
        return super.getResourceType();
    }

}
