package com.citytechinc.cq.component.util;

import com.citytechinc.cq.component.graniteuidialog.container.AbstractGraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMaker;

public class GraniteUIContainerConfigHolder {

    private final Class<?> annotationClass;
    private final Class<? extends AbstractGraniteUIContainer> containerClass;
    private final Class<? extends GraniteUIContainerMaker> makerClass;
    private final String resourceType;

    public GraniteUIContainerConfigHolder(
            Class<?> annotationClass,
            Class<? extends AbstractGraniteUIContainer> containerClass,
            Class<? extends GraniteUIContainerMaker> makerClass,
            String resourceType) {
        this.annotationClass = annotationClass;
        this.containerClass = containerClass;
        this.makerClass = makerClass;
        this.resourceType = resourceType;
    }

    public Class<?> getAnnotationClass() {
        return annotationClass;
    }

    public Class<? extends AbstractGraniteUIContainer> getContainerClass() {
        return containerClass;
    }

    public Class<? extends GraniteUIContainerMaker> getMakerClass() {
        return makerClass;
    }

    public String getResourceType() {
        return resourceType;
    }

    public boolean hasMakerClass() {
        return makerClass != null;
    }

    public boolean hasResourceType() {
        return resourceType != null;
    }

}
