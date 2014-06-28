package com.citytechinc.cq.component.graniteuidialog.maker.impl;

import com.citytechinc.cq.component.dialog.DialogElement;
import com.citytechinc.cq.component.dialog.exception.InvalidComponentFieldException;
import com.citytechinc.cq.component.dialog.impl.SimpleWidget;
import com.citytechinc.cq.component.dialog.maker.AbstractWidgetMaker;
import com.citytechinc.cq.component.dialog.maker.WidgetMakerParameters;
import com.citytechinc.cq.component.dialog.widget.WidgetParameters;
import com.citytechinc.cq.component.graniteuidialog.impl.GraniteUISimpleWidget;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetParameters;
import javassist.CannotCompileException;
import javassist.NotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class GraniteUIDefaultWidgetMaker extends AbstractGraniteUIWidgetMaker {

    public GraniteUIDefaultWidgetMaker(GraniteUIWidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public DialogElement make() throws InvalidComponentFieldException, NotFoundException, ClassNotFoundException, SecurityException, CannotCompileException, NoSuchFieldException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {

        String name = getNameForField();
        String fieldName = getFieldNameForField();
        String fieldLabel = getFieldLabelForField();
        String fieldDescription = getFieldDescriptionForField();
        Boolean isRequired = getIsRequiredForField();
        Map<String, String> additionalProperties = getAdditionalPropertiesForField();
        String defaultValue = getDefaultValueForField();
        boolean hideLabel = getHideLabelForField();

        GraniteUIWidgetParameters widgetParameters = new GraniteUIWidgetParameters();
        widgetParameters.setResourceType(parameters.getResourceType());
        widgetParameters.setName(name);
        widgetParameters.setFieldName(fieldName);
        widgetParameters.setFieldLabel(fieldLabel);
        widgetParameters.setFieldDescription(fieldDescription);
        widgetParameters.setAllowBlank(!isRequired);
        widgetParameters.setAdditionalProperties(additionalProperties);
        widgetParameters.setDefaultValue(defaultValue);
        widgetParameters.setListeners(getListeners());

        return new GraniteUISimpleWidget(widgetParameters);

    }

}
