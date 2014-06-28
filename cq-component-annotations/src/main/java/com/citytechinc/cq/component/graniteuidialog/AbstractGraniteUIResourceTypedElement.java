package com.citytechinc.cq.component.graniteuidialog;

import com.citytechinc.cq.component.util.Constants;
import com.citytechinc.cq.component.xml.AbstractXmlElement;
import com.citytechinc.cq.component.xml.NameSpacedAttribute;

public abstract class AbstractGraniteUIResourceTypedElement extends AbstractXmlElement implements GraniteUIResourceTypedElement {

    private final NameSpacedAttribute<String> resourceType;

    public AbstractGraniteUIResourceTypedElement(GraniteUIResourceTypedElementParameters parameters) {
        super(parameters);

        this.resourceType = new NameSpacedAttribute<String>(Constants.SLING_NS_URI, Constants.SLING_NS_PREFIX, parameters.getResourceType());
    }

    public NameSpacedAttribute<String> getResourceType() {
        return resourceType;
    }

}
