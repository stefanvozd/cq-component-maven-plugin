/**
 *    Copyright 2013 CITYTECH, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.citytechinc.cq.component.graniteuidialog.container.impl.fixedcolumns;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.layouts.FixedColumns;
import com.citytechinc.cq.component.dialog.exception.InvalidComponentFieldException;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainerParameters;
import com.citytechinc.cq.component.graniteuidialog.container.impl.DefaultGraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.exception.GraniteUIDialogCreationException;
import com.citytechinc.cq.component.graniteuidialog.factory.GraniteUIWidgetFactory;
import com.citytechinc.cq.component.graniteuidialog.items.GraniteUIItems;
import com.citytechinc.cq.component.graniteuidialog.items.GraniteUIItemsParameters;
import com.citytechinc.cq.component.graniteuidialog.items.impl.DefaultGraniteUIItems;
import com.citytechinc.cq.component.graniteuidialog.layout.GraniteUILayout;
import com.citytechinc.cq.component.graniteuidialog.layout.impl.fixedcolumns.FixedColumnsLayout;
import com.citytechinc.cq.component.graniteuidialog.layout.impl.fixedcolumns.FixedColumnsLayoutParameters;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIContainerMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMakerParameters;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIWidgetMakerParameters;
import com.citytechinc.cq.component.maven.util.ComponentMojoUtil;
import com.citytechinc.cq.component.maven.util.LogSingleton;
import javassist.CtMember;
import javassist.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FixedColumnsContainerMaker extends AbstractGraniteUIContainerMaker {

    public FixedColumnsContainerMaker(GraniteUIContainerMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public GraniteUIContainer make() throws GraniteUIDialogCreationException {

        LogSingleton.getInstance().debug("Creating FixedColumnsContainer for class " + parameters.getCtClass().toString());

        FixedColumnsContainerParameters containerParameters = new FixedColumnsContainerParameters();

        try {
            containerParameters.setItems(createItems());
        } catch (Exception e) {
            throw new GraniteUIDialogCreationException("Exception encountered in building items for the FixedColumnsContainer for class " + parameters.getCtClass().toString(), e);
        }

        try {
            containerParameters.setLayout(createLayout());
        } catch (ClassNotFoundException e) {
            throw new GraniteUIDialogCreationException("Exception encountered in creating the layout for the FixedColumnsContainer for class " + parameters.getCtClass().toString(), e);
        }

        return new FixedColumnsContainer(containerParameters);


    }

    private FixedColumnsLayoutParameters createLayoutParametersForAnnotation(FixedColumns fixedColumnsAnnotation) {

        FixedColumnsLayoutParameters parameters = new FixedColumnsLayoutParameters();

        //This defaulting is necessary here, because the Fixed Columns Container is the default and as such an annotation might not be present for it
        if (fixedColumnsAnnotation != null) {
            parameters.setMargin(fixedColumnsAnnotation.margin());
        }
        else {
            parameters.setMargin(true);
        }

        return parameters;

    }

    private GraniteUIItems createItems() throws NotFoundException, ClassNotFoundException, InvalidComponentFieldException, GraniteUIDialogCreationException {

        List<GraniteUIElement> items = new ArrayList<GraniteUIElement>();

        //Collect the members of the current class
        List<CtMember> fieldsAndMethods = new ArrayList<CtMember>();
        fieldsAndMethods.addAll(ComponentMojoUtil.collectFields(parameters.getCtClass()));
        fieldsAndMethods.addAll(ComponentMojoUtil.collectMethods(parameters.getCtClass()));

        //Use the widget factory to build up a GraniteUIElement for each
        for (CtMember currentMember : fieldsAndMethods) {
            if (currentMember.hasAnnotation(DialogField.class)) {
                GraniteUIWidgetMakerParameters graniteUIWidgetMakerParameters = new GraniteUIWidgetMakerParameters(
                        (DialogField) currentMember.getAnnotation(DialogField.class),
                        currentMember,
                        parameters.getContainingClass(),
                        parameters.getClassLoader(),
                        parameters.getClassPool(),
                        parameters.getWidgetRegistry(),
                        parameters.getContainerRegistry(),
                        null,
                        true);

                items.add(GraniteUIWidgetFactory.make(graniteUIWidgetMakerParameters, -1));
            }
        }

        LogSingleton.getInstance().debug(items.size() + " items found for class " + parameters.getCtClass().toString());

        //Create items

        //Create the inner container
        GraniteUIContainerParameters innerContainerParameters = new GraniteUIContainerParameters();
        innerContainerParameters.setFieldName("column");

        //Add the dialog fields to the inner container
        GraniteUIItemsParameters innerItemsParameters = new GraniteUIItemsParameters();
        innerItemsParameters.setItems(items);

        innerContainerParameters.setItems(new DefaultGraniteUIItems(innerItemsParameters));

        //Create the outer items set
        GraniteUIItemsParameters itemsParameters = new GraniteUIItemsParameters();
        List<GraniteUIElement> itemsList = new ArrayList<GraniteUIElement>();
        itemsList.add(new DefaultGraniteUIContainer(innerContainerParameters));
        itemsParameters.setItems(itemsList);

        //Produce the outer items
        return new DefaultGraniteUIItems(itemsParameters);

    }

    private GraniteUILayout createLayout() throws ClassNotFoundException {

        FixedColumns fixedColumnsAnnotation = (FixedColumns) parameters.getCtClass().getAnnotation(FixedColumns.class);

        FixedColumnsLayoutParameters layoutParameters = createLayoutParametersForAnnotation(fixedColumnsAnnotation);

        return new FixedColumnsLayout(layoutParameters);

    }


}
