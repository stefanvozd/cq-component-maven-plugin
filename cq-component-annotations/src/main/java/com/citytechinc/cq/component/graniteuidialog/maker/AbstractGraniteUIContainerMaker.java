package com.citytechinc.cq.component.graniteuidialog.maker;

public abstract class AbstractGraniteUIContainerMaker implements GraniteUIContainerMaker {

    protected final GraniteUIContainerMakerParameters parameters;

    public AbstractGraniteUIContainerMaker(GraniteUIContainerMakerParameters parameters) {
        this.parameters = parameters;
    }
}
