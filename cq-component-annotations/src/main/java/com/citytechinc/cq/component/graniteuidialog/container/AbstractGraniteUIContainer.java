package com.citytechinc.cq.component.graniteuidialog.container;

import com.citytechinc.cq.component.graniteuidialog.AbstractGraniteUIResourceTypedElement;

public class AbstractGraniteUIContainer extends AbstractGraniteUIResourceTypedElement implements GraniteUIContainer {

    public AbstractGraniteUIContainer(GraniteUIContainerParameters parameters) {
        super(parameters);

        containedElements.add(parameters.getLayout());
        containedElements.add(parameters.getItems());
    }

}
