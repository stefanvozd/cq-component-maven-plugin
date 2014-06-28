package com.citytechinc.cq.component.graniteuidialog.container.impl.fixedcolumns;

import com.citytechinc.cq.component.graniteuidialog.layout.GraniteUILayoutParameters;

public class FixedColumnsContainerParameters extends GraniteUILayoutParameters {

    private boolean margin;

    public boolean isMargin() {
        return margin;
    }

    public void setMargin(boolean margin) {
        this.margin = margin;
    }

    @Override
    public String getResourceType() {
        return FixedColumnsContainer.RESOURCE_TYPE;
    }

    @Override
    public void setResourceType(String resourceType) {
        throw new UnsupportedOperationException("resourceType is Static for FixedColumnsLayoutWidget");
    }

}
