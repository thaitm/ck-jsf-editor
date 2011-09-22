/*
 * ck-jsf-editor is a JSF2 component for ckEditor (see http://ckeditor.com)
 *     Copyright (C) 2011  Bill Reh
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.google.code.ckJsfEditor;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     Used by the {@link Config} object, BasicStyle represents a css rule set to be used by the editor.
 * </p>
 *
 * <p>
 *     The BasicStyle object represents a css rule set like this:<br/>
 * </p>
 * <p>
 *     <code>
 *         BasicStyle style = new BasicStyle("span", "color", "#aed0ea");
 *     </code>
 * </p>
 *
 * <p>
 *     represents:
 * </p>
 * <p>
 *     <code>
 *         span {<br/>
 *             &nbsp&nbsp;&nbsp;&nbsp;color: "#aed0ea";<br/>
 *         }
 *     </code>
 * </p>
 *
 * @author Bill Reh
*/
public class BasicStyle {
    private String element;
    private Map<String,String> rules = new HashMap<String, String>();

    public BasicStyle() {
    }

    /**
     * Creates a BasicStyle object representing a css rule set.
     *
     * @param element The element to apply the rule to.
     * @param styleProperty The style property.
     * @param value The property value.
     */
    public BasicStyle(String element, String styleProperty, String value) {
        this.element = element;
        this.rules.put(styleProperty, value);
    }

    /**
     * Creates a BasicStyle object representing a css rule set with multiple rules.
     *
     * @param element The element to apply the rules to.
     * @param rules The rules to apply stored in a Map as styleProperty/value pairs.
     */
    public BasicStyle(String element, Map<String, String> rules) {
        this.element = element;
        this.rules.putAll(rules);
    }

    /**
     * Returns the element name.
     *
     * @return The element name.
     */
    public String getElement() {
        return element;
    }

    /**
     * Sets the element name.
     *
     * @param element The element name.
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * Gets the list of rules as a Map of styleProperty/Value pairs.
     *
     * @return The list of rules as a Map of styleProperty/Value pairs.
     */
    public Map<String, String> getRules() {
        return rules;
    }
}
