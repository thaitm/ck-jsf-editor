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
 * @author Bill Reh
*/
public class BasicStyle {
    private String element;
    private Map<String,String> styles = new HashMap<String, String>();

    public BasicStyle() {
    }

    public BasicStyle(String element, String style, String value) {
        this.element = element;
        this.styles.put(style, value);
    }

    public BasicStyle(String element, Map<String, String> styles) {
        this.element = element;
        this.styles.putAll(styles);
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Map<String, String> getStyles() {
        return styles;
    }
}
