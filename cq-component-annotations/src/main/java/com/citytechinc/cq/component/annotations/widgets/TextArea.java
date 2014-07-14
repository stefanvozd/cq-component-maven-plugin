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

/**
 * Represents a Widget of type CQ.Ext.form.TextArea
 *
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface TextArea {

    /**
     * For use with Granite UI Only - Indicates that the rendered field should be disabled
     *
     * @return boolean
     */
    boolean disabled() default false;

    /**
     * For use with Granite UI Only - The placeholder text which should be rendered when this field is empty
     *
     * @return String
     */
    public String emptyText() default "";

    /**
     * For use with Granite UI Only - The rows to be presented in the text area
     *
     * @return long
     */
    public long rows() default -1;

    /**
     * For use with Granite UI only - the cols to be presented in the text area
     *
     * @return long
     */
    public long cols() default -1;

}
