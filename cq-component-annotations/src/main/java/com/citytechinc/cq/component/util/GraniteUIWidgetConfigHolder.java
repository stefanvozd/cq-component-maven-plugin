package com.citytechinc.cq.component.util;

import com.citytechinc.cq.component.dialog.maker.WidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.widget.AbstractGraniteUIWidget;

public class GraniteUIWidgetConfigHolder {

    private final Class<?> annotationClass;
    private final Class<? extends AbstractGraniteUIWidget> widgetClass;
    private final Class<? extends WidgetMaker> makerClass;
    private final String resourceType;
    private final int ranking;

    /**
     *
     * @param annotationClass
     * @param widgetClass
     * @param makerClass
     * @param resourceType
     * @param ranking
     */
    public GraniteUIWidgetConfigHolder(Class<?> annotationClass, Class<? extends AbstractGraniteUIWidget> widgetClass,
                              Class<? extends WidgetMaker> makerClass, String resourceType, int ranking) {
        this.annotationClass = annotationClass;
        this.widgetClass = widgetClass;
        this.makerClass = makerClass;
        this.resourceType = resourceType;
        this.ranking = ranking;
    }

    public Class<?> getAnnotationClass() {
        return annotationClass;
    }

    public Class<? extends AbstractGraniteUIWidget> getWidgetClass() {
        return widgetClass;
    }

    public Class<? extends WidgetMaker> getMakerClass() {
        return makerClass;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getRanking() {
        return ranking;
    }

    public boolean hasMakerClass() {
        return makerClass != null;
    }

    public boolean hasResourceType() {
        return resourceType != null;
    }

}
