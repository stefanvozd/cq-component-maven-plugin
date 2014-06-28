package com.citytechinc.cq.component.graniteuidialog.container;

import com.citytechinc.cq.component.graniteuidialog.items.GraniteUIItems;
import com.citytechinc.cq.component.graniteuidialog.layout.GraniteUILayout;
import com.citytechinc.cq.component.graniteuidialog.GraniteUIResourceTypedElementParameters;

public class GraniteUIContainerParameters extends GraniteUIResourceTypedElementParameters {

    private GraniteUILayout layout;
    private GraniteUIItems items;

    public GraniteUILayout getLayout() {
        return layout;
    }

    public void setLayout(GraniteUILayout graniteUILayoutElement) {
        this.layout = graniteUILayoutElement;
    }


    public GraniteUIItems getItems() {
        return items;
    }

    public void setItems(GraniteUIItems items) {
        this.items = items;
    }
}
