package com.citytechinc.cq.component.graniteuidialog.container;

import com.citytechinc.cq.component.util.GraniteUIContainerConfigHolder;

import java.util.Set;

public interface GraniteUIContainerRegistry {

    public GraniteUIContainerConfigHolder getContainerForAnnotation(Class<?> annotation);

    public Set<Class<?>> getRegisteredAnnotations();

}
