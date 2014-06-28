package com.citytechinc.cq.component.graniteuidialog;

import com.citytechinc.cq.component.graniteuidialog.widget.AbstractGraniteUIWidget;
import com.citytechinc.cq.component.util.Constants;
import com.citytechinc.cq.component.xml.NameSpacedAttribute;

public class GraniteUIDialog extends AbstractGraniteUIWidget {

    public static final String RESOURCE_TYPE = "cq/gui/components/authoring/dialog";

    private final NameSpacedAttribute<String> title;
    private final String fileName;

    /**
     * The constructor for the abstract Widget sets a number of properties
     * common to all widget types.
     *
     * @param parameters
     */
    public GraniteUIDialog(GraniteUIDialogParameters parameters) {
        super(parameters);

        this.title = new NameSpacedAttribute<String>(Constants.JCR_NS_URI, Constants.JCR_NS_PREFIX, parameters.getTitle());
        this.fileName = parameters.getFileName();

    }

    public NameSpacedAttribute<String> getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName + ".xml";
    }
}
