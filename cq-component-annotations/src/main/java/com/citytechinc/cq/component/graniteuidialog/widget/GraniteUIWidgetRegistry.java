package com.citytechinc.cq.component.graniteuidialog.widget;

import com.citytechinc.cq.component.util.GraniteUIWidgetConfigHolder;

import java.util.Set;

public interface GraniteUIWidgetRegistry {

    /**
     *
     * @param annotation
     * @return The Widget Configuration associated with the specified annotation
     */
    public GraniteUIWidgetConfigHolder getWidgetForAnnotation(Class<?> annotation);

    /**
     *
     * @return A set of all known Widget annotations
     */
    public Set<Class<?>> getRegisteredAnnotations();


}
