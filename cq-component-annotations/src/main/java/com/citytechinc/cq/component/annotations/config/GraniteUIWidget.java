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
package com.citytechinc.cq.component.annotations.config;

import com.citytechinc.cq.component.dialog.maker.AbstractWidgetMaker;
import com.citytechinc.cq.component.graniteuidialog.maker.AbstractGraniteUIWidgetMaker;

import java.lang.annotation.Annotation;

public @interface GraniteUIWidget {

    /**
     * <p>
     * The stacked annotation which will be used to indicate that a field is to
     * be populated by a Dialog Widget of this type. This would be the
     * annotation <em>stacked</em> under the
     * {@link com.citytechinc.cq.component.annotations.DialogField DialogField}
     * annotation on a given Component field.
     * </p>
     * <p>
     * The annotationClass list may be left empty in which case the Widget ties
     * together an xtype and WidgetMaker directly. The annotationClass list may
     * <em>not</em> contain more than one Annotation class.
     * </p>
     */
    Class<? extends Annotation> annotationClass();

    /**
     * The class responsible for making instances of the annotated Widget Class.
     */
    Class<? extends AbstractGraniteUIWidgetMaker> makerClass();

    /**
     * The sling:resourceType which will be rendered to the Dialog for a field populated by a
     * Dialog Widget of this type.
     */
    String resourceType();

    /**
     * Used in the rare cases where multiple annotations will be stacked under a
     * {@link com.citytechinc.cq.component.annotations.DialogField DialogField}
     * annotation. In such cases, ranking indicates which annotation will be
     * used in looking up an appropriate Widget type and Maker for the field in
     * question. A Widget with a higher ranking will take precedence over one
     * with a lower ranking. In the case of equal ranking values behavior can
     * not be guaranteed.
     */
    int ranking() default -1;

}
