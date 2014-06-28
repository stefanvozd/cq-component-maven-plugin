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

            /*
             * Get dialog title
             */
            String dialogTitle = componentAnnotation.value();

            // Load the true class
            Class<?> trueComponentClass = classLoader.loadClass(componentClass.getName());

            //Build the container
            GraniteUIContainer container = GraniteUIContainerFactory.make(
                    new GraniteUIContainerMakerParameters(componentClass, trueComponentClass, classLoader, classPool, widgetRegistry, containerRegistry, null)
            );

            //Tie the container to the contained elements

            //Set the produced layout as the content of the dialog
            GraniteUIDialogParameters dialogParameters = new GraniteUIDialogParameters();
            dialogParameters.setTitle(dialogTitle);
            dialogParameters.setFileName(componentAnnotation.fileName());
            dialogParameters.setContainer(container);

            return new GraniteUIDialog(dialogParameters);

        } catch (ClassNotFoundException e) {
            throw new GraniteUIDialogCreationException("Class not found exception attempting to create dialog for component class " + componentClass.toString(), e);
        }
        //OLD
        /*
		 * Iterate through all fields establishing proper widgets for each
		 *
        for (CtMember member : fieldsAndMethods) {

            DialogField dialogProperty = (DialogField) member.getAnnotation(DialogField.class);

            if (dialogProperty != null) {

                GraniteUIWidgetMakerParameters parameters = new GraniteUIWidgetMakerParameters(dialogProperty, member,
                        trueComponentClass, classLoader, classPool, widgetRegistry, null, true);

                DialogElement builtFieldWidget = WidgetFactory.make(parameters, -1);

                builtFieldWidget.setRanking(dialogProperty.ranking());

                int tabIndex = dialogProperty.tab();

                if (tabIndex < 1 || tabIndex > tabsList.size()) {
                    throw new InvalidComponentFieldException("Invalid tab index " + tabIndex + " for field "
                            + dialogProperty.fieldName());
                }

                tabsList.get(tabIndex - 1).addElement(builtFieldWidget);

            }
        }
        */
    }

}
