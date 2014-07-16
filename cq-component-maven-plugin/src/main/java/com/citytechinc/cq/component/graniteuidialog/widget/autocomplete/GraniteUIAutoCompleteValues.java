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
package com.citytechinc.cq.component.graniteuidialog.widget.autocomplete;

import com.citytechinc.cq.component.graniteuidialog.AbstractGraniteUIResourceTypedElement;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIResourceTypedElementParameters;
import com.citytechinc.cq.component.util.Constants;
import com.citytechinc.cq.component.xml.NameSpacedAttribute;
import com.citytechinc.cq.component.xml.XmlElement;

import java.util.List;
import java.util.Map;

public class GraniteUIAutoCompleteValues extends AbstractGraniteUIResourceTypedElement implements GraniteUIElement {

    public static final String FIELD_NAME = "values";

    public GraniteUIAutoCompleteValues(GraniteUIResourceTypedElementParameters parameters) {
        super(parameters);
    }

    @Override
    public NameSpacedAttribute<String> getPrimaryType() {
        return new NameSpacedAttribute<String>(Constants.JCR_NS_URI, Constants.JCR_NS_PREFIX, Constants.NT_UNSTRUCTURED);
    }

    @Override
    public String getNameSpace() {
        return null;
    }

    @Override
    public String getFieldName() {
        return FIELD_NAME;
    }

    @Override
    public Map<String, ?> getAdditionalProperties() {
        return null;
    }

    @Override
    public List<? extends XmlElement> getContainedElements() {
        return null;
    }

}
