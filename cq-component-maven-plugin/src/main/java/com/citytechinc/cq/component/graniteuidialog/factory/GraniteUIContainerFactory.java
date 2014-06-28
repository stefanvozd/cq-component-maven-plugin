package com.citytechinc.cq.component.graniteuidialog.factory;

import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainerParameters;
import com.citytechinc.cq.component.graniteuidialog.container.impl.fixedcolumns.FixedColumnsContainerMaker;
import com.citytechinc.cq.component.graniteuidialog.exception.GraniteUIDialogCreationException;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.GraniteUIContainerMakerParameters;
import com.citytechinc.cq.component.util.GraniteUIContainerConfigHolder;

public class GraniteUIContainerFactory {

    private GraniteUIContainerFactory() {}

    public static GraniteUIContainer make(GraniteUIContainerMakerParameters parameters) throws GraniteUIDialogCreationException {

        Class<? extends GraniteUIContainerMaker> containerMakerClass = determineContainerMaker(parameters);

        try {
            GraniteUIContainerMaker containerMaker = containerMakerClass.getConstructor(GraniteUIContainerParameters.class).newInstance(parameters);

            return containerMaker.make();
        } catch (Exception e) {
            throw new GraniteUIDialogCreationException("Exception encountered attempting to instantiate maker " + containerMakerClass.toString(), e);
        }
    }

    private static Class<? extends GraniteUIContainerMaker> determineContainerMaker(GraniteUIContainerMakerParameters parameters) {

        GraniteUIContainerConfigHolder containerConfigHolder = determineContainerConfiguration(parameters);

        if (containerConfigHolder != null && containerConfigHolder.hasMakerClass()) {
            return containerConfigHolder.getMakerClass();
        }

        return FixedColumnsContainerMaker.class;

    }

    private static GraniteUIContainerConfigHolder determineContainerConfiguration(GraniteUIContainerMakerParameters parameters) {
        for (Class<?> currentRegisteredAnnotation : parameters.getContainerRegistry().getRegisteredAnnotations()) {
            if (parameters.getCtClass().hasAnnotation(currentRegisteredAnnotation)) {
                return parameters.getContainerRegistry().getContainerForAnnotation(currentRegisteredAnnotation);
            }
        }

        return null;
    }

}
