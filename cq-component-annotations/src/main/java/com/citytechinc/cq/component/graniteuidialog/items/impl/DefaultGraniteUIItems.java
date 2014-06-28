package com.citytechinc.cq.component.graniteuidialog.items.impl;

import com.citytechinc.cq.component.graniteuidialog.items.GraniteUIItems;
import com.citytechinc.cq.component.graniteuidialog.items.GraniteUIItemsParameters;
import com.citytechinc.cq.component.xml.AbstractXmlElement;

public class DefaultGraniteUIItems extends AbstractXmlElement implements GraniteUIItems {

    public DefaultGraniteUIItems(GraniteUIItemsParameters parameters) {
        super(parameters);

        containedElements = parameters.getItems;
    }

    @Override
    public String getFieldName() {
        return "items";
    }

}
