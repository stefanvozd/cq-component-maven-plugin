package com.citytechinc.cq.component.graniteuidialog.container.impl.fixedcolumns;

import com.citytechinc.cq.component.annotations.layouts.FixedColumns;
import com.citytechinc.cq.component.graniteuidialog.layout.GraniteUILayout;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIContainerMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMakerParameters;

public class FixedColumnsContainerMaker extends AbstractGraniteUIContainerMaker {

    public FixedColumnsContainerMaker(GraniteUIContainerMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public GraniteUILayout make() {

        FixedColumnsContainerParameters fixedColumnsLayoutParameters = new FixedColumnsContainerParameters();

        if (parameters.hasAnnotation(FixedColumns.class)) {
            FixedColumns fixedColumnsAnnotation = parameters.getAnnotation(FixedColumns.class);

            fixedColumnsLayoutParameters.setMargin(fixedColumnsAnnotation.margin());
        }
        else {
            fixedColumnsLayoutParameters.setMargin(true);
        }

        return new FixedColumnsContainer(fixedColumnsLayoutParameters);

    }

}
