package com.citytechinc.cq.component.graniteuidialog.items;

import com.citytechinc.cq.component.graniteuidialog.GraniteUIElement;
import com.citytechinc.cq.component.xml.XmlElementParameters;

import java.util.List;

public class GraniteUIItemsParameters extends XmlElementParameters {

    private List<GraniteUIElement> items;

    public List<GraniteUIElement> getItems;

    public void setItems(List<GraniteUIElement> items) {
        this.items = items;
    }

}
