package com.citytechinc.cq.component.graniteuidialog.widget;

import com.citytechinc.cq.component.dialog.AbstractDialogElement;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetParameters;
import com.citytechinc.cq.component.util.Constants;
import com.citytechinc.cq.component.xml.NameSpacedAttribute;

public class AbstractGraniteUIWidget extends AbstractDialogElement {

    private final NameSpacedAttribute<String> resourceType;
    private final String fieldLabel;
    private final String fieldDescription;
    private final boolean allowBlank;
    private final String defaultValue;
    private String name;


    /**
     * The constructor for the abstract Widget sets a number of properties
     * common to all widget types.
     *
     * @param parameters
     */
    public AbstractGraniteUIWidget(GraniteUIWidgetParameters parameters) {
        super(parameters);
        this.resourceType = new NameSpacedAttribute<String>(Constants.SLING_NS_URI, Constants.SLING_NS_PREFIX, parameters.getResourceType());
        this.fieldLabel = parameters.getFieldLabel();
        this.fieldDescription = parameters.getFieldDescription();
        this.allowBlank = parameters.isAllowBlank();
        this.defaultValue = parameters.getDefaultValue();
        this.name = parameters.getName();
    }

    /**
     *
     * @return resource type of the Widget
     */
    public NameSpacedAttribute<String> getResourceType() {
        return resourceType;
    }

    /**
     *
     * @return name of the Widget
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return field label to be applied to the rendered Widget
     */
    public String getFieldLabel() {
        return fieldLabel;
    }

    /**
     *
     * @return field description to be applied to the rendered Widget
     */
    public String getFieldDescription() {
        return fieldDescription;
    }

    /**
     *
     * @return Indication of whether the Widget may be left blank in an
     *         authoring Dialog
     */
    public boolean isAllowBlank() {
        return allowBlank;
    }

    /**
     *
     * @return Default value of the Widget input
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
