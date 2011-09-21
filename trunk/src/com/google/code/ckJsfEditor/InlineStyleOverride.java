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

import java.util.Map;

/**
* User: billreh
* Date: 9/17/11
* Time: 5:01 PM
*/
public class InlineStyleOverride extends InlineStyle {
    private String override;

    public InlineStyleOverride() {
        super();
    }

    public InlineStyleOverride(String element, String attribute, String value, String override) {
        super(element, attribute, value);
        this.override = override;
    }

    public InlineStyleOverride(String element, Map<String, String> attributes, String override) {
        super(element, attributes);
        this.override = override;
    }

    public String getOverride() {
        return override;
    }

    public void setOverride(String override) {
        this.override = override;
    }
}
