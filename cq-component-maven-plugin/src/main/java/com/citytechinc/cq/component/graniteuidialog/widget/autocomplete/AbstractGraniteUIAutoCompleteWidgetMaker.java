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

import com.citytechinc.cq.component.graniteuidialog.GraniteUIResourceTypedElementParameters;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;

public abstract class AbstractGraniteUIAutoCompleteWidgetMaker extends AbstractGraniteUIWidgetMaker {

    public AbstractGraniteUIAutoCompleteWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    protected GraniteUIAutoCompleteDataSource getDataSourceForField() {
        GraniteUIResourceTypedElementParameters dataSourceParameters = new GraniteUIResourceTypedElementParameters();

        dataSourceParameters.setResourceType(getDataSourceResourceType());

        return new GraniteUIAutoCompleteDataSource(dataSourceParameters);
    }

    protected abstract String getDataSourceResourceType();

    protected GraniteUIAutoCompleteValues getValuesForField() {
        GraniteUIResourceTypedElementParameters valuesParameters = new GraniteUIResourceTypedElementParameters();

        valuesParameters.setResourceType(getValuesResourceType());

        return new GraniteUIAutoCompleteValues(valuesParameters);
    }

    protected abstract String getValuesResourceType();

    protected GraniteUIAutoCompleteOptions getOptionsForField() {
        GraniteUIResourceTypedElementParameters optionsParameters = new GraniteUIResourceTypedElementParameters();

        optionsParameters.setResourceType(getOptionsResourceType());

        return new GraniteUIAutoCompleteOptions(optionsParameters);
    }

    protected abstract String getOptionsResourceType();

}
