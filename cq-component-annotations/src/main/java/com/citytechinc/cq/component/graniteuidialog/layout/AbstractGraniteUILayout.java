package com.citytechinc.cq.component.graniteuidialog.layout;

import com.citytechinc.cq.component.graniteuidialog.AbstractGraniteUIResourceTypedElement;

public class AbstractGraniteUILayout extends AbstractGraniteUIResourceTypedElement implements GraniteUILayout {

    public AbstractGraniteUILayout(GraniteUILayoutParameters parameters) {
        super(parameters);
    }

    @Override
    public String getFieldName() {
        return "layout";
    }

}
