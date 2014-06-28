package com.citytechinc.cq.component.graniteuidialog.container.impl.fixedcolumns;

import com.citytechinc.cq.component.annotations.config.GraniteUIContainer;
import com.citytechinc.cq.component.annotations.layouts.FixedColumns;
import com.citytechinc.cq.component.graniteuidialog.layout.AbstractGraniteUILayout;

@GraniteUIContainer(annotationClass = FixedColumns.class, makerClass = FixedColumnsContainerMaker.class, resourceType = FixedColumnsContainer.RESOURCE_TYPE)
public class FixedColumnsContainer extends AbstractGraniteUILayout {

    public static final String RESOURCE_TYPE = "granite/ui/components/foundation/layouts/fixedcolumns";

    private final boolean margin;

    public FixedColumnsContainer(FixedColumnsContainerParameters parameters) {
        super(parameters);

        this.margin = parameters.isMargin();
    }

    public boolean isMargin() {
        return margin;
    }

}
