package com.citytechinc.cq.component.graniteuidialog;

import com.citytechinc.cq.component.graniteuidialog.container.GraniteUIContainer;
import com.citytechinc.cq.component.graniteuidialog.widget.GraniteUIWidgetParameters;

public class GraniteUIDialogParameters extends GraniteUIWidgetParameters {

    private static final String DEFAULT_TITLE = "Dialog";
    private static final String DEFAULT_FILE_NAME = "_cq_dialog";

    private String title;
    private String fileName;
    private GraniteUIContainer container;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getResourceType() {
        return GraniteUIDialog.RESOURCE_TYPE;
    }

    @Override
    public void setResourceType(String resourceType) {
        throw new UnsupportedOperationException("sling:resourceType is Static for Dialog");
    }

    public GraniteUIContainer getContainer() {
        return container;
    }

    public void setContainer(GraniteUIContainer container) {
        this.container = container;
    }
}
