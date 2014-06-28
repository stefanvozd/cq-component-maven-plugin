package com.citytechinc.cq.component.annotations.config;

import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIContainerMaker;

import java.lang.annotation.Annotation;

public @interface GraniteUIContainer {

    Class<? extends Annotation> annotationClass();

    /**
     * The class responsible for making instances of the annotated Layout Class.
     */
    Class<? extends AbstractGraniteUIContainerMaker> makerClass();

    /**
     * The sling:resourceType which will be rendered to the Dialog for a field populated by a
     * Dialog Layout of this type.
     */
    String resourceType();

}
