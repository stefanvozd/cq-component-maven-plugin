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
package com.citytechinc.cq.component.graniteuidialog.factory;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIDialog;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIDialogParameters;
import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainerRegistry;
import com.citytechinc.cq.component.graniteuidialog.exception.GraniteUIDialogCreationException;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMakerParameters;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetRegistry;
import javassist.*;


public class GraniteUIDialogFactory {

    public static GraniteUIDialog make(
            CtClass componentClass,
            GraniteUIWidgetRegistry widgetRegistry,
            GraniteUIContainerRegistry containerRegistry,
            ClassLoader classLoader,
            ClassPool classPool) throws GraniteUIDialogCreationException {

        try {
            Component componentAnnotation = (Component) componentClass.getAnnotation(Component.class);

            //Get dialog title
            String dialogTitle = componentAnnotation.value();

            // Load the true class
            Class<?> trueComponentClass = classLoader.loadClass(componentClass.getName());

            //Build the container - the container handles building its contents
            GraniteUIContainer container = GraniteUIContainerFactory.make(
                    new GraniteUIContainerMakerParameters(componentClass, trueComponentClass, classLoader, classPool, widgetRegistry, containerRegistry, null)
            );

            //Set the produced layout as the content of the dialog
            GraniteUIDialogParameters dialogParameters = new GraniteUIDialogParameters();
            dialogParameters.setTitle(dialogTitle);
            dialogParameters.setFileName(componentAnnotation.graniteFileName());
            dialogParameters.setContainer(container);

            return new GraniteUIDialog(dialogParameters);

        } catch (ClassNotFoundException e) {
            throw new GraniteUIDialogCreationException("Class not found exception attempting to create dialog for component class " + componentClass.toString(), e);
        }

    }

}
