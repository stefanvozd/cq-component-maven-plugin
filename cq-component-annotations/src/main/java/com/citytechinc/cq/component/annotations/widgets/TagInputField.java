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
package com.citytechinc.cq.component.annotations.widgets;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.citytechinc.cq.component.annotations.TagNameSpace;

/**
 * Represents a Widget of type CQ.tagging.TagInputField
 *
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface TagInputField {

    public static final String VALUES_DEFAULT = "granite/ui/components/foundation/form/autocomplete/tags";
    public static final String OPTIONS_DEFAULT = "granite/ui/components/foundation/form/autocomplete/list";

    /**
     * Whether to display tag titles instead of the pure tag IDs in the input field, autocompletion, tree or cloud view.
     *
     * @return boolean
     */
	boolean displayTitles() default true;

	/**
	 * A list of the tag namespaces that should be displayed and allowed. If empty, all available namespaces will be allowed.
	 *
	 * @return TagNameSpace[]
	 */
	TagNameSpace[] namespaces() default {};

    /**
     * Applicable to Granite UI dialogs only
     *
     * @return boolean
     */
    boolean disabled() default false;

    /**
     * Applicable to Granite UI dialogs only
     *
     * @return boolean
     */
    String emptyText() default "";

    /**
     * Applicable to Granite UI dialogs only
     *
     * Allow selection of multiple tags
     *
     * @return boolean
     */
    boolean multiple() default true;

    /**
     * Applicable to Granite UI dialogs only
     *
     * It's a title
     *
     * @return String
     */
    String title() default "";

    /**
     * Applicable to Granite UI dialogs only
     *
     * The Resource Type to attribute to the values configuration node of the Auto Complete widget rendered as a tag selector
     *
     * @return String
     */
    String values() default VALUES_DEFAULT;

    /**
     * Applicable to Granite UI dialogs only
     *
     * The Resource Type to attribute to the values configuration node of the Auto Complete widget rendered as a tag selector
     *
     * @return String
     */
    String options() default OPTIONS_DEFAULT;

}
