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
* User: billreh
* Date: 9/17/11
* Time: 5:00 PM
*/
public class InlineStyle {
    private String element;
    private Map<String,String> attributes = new HashMap<String, String>();

    public InlineStyle() {
    }

    public InlineStyle(String element, String attribute, String value) {
        this.element = element;
        attributes.put(attribute, value);
    }
    public InlineStyle(String element, Map<String, String> attributes) {
        this.element = element;
        this.attributes = attributes;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
