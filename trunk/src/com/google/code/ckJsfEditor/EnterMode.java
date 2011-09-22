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

/**
 * Used by the {@link Config} object, EnterMode represents how content separated by a blank line will be html
 * encoded inside the editor.  The default is paragraph mode ({@link #CKEDITOR_ENTER_P}).
 *
 * @author Bill Reh
 */
public enum EnterMode {
    /** Paragraph mode.  Content separated by newline is enclosed in a &lt;p&gt;&lt;/p&gt; tag). */
    CKEDITOR_ENTER_P(1),
    /** Break mode.  Content separated by newline is separated by a &lt;br/&gt; tag). */
    CKEDITOR_ENTER_BR(2),
    /** Div mode.  Content separated by newline is enclosed in a &lt;div&gt;&lt;/div&gt; tag). */
    CKEDITOR_ENTER_DIV(3);

    private int val;

    private EnterMode(int val) {
        this.val = val;
    }

    /**
     * Gets the numerical value that represents this EnterMode in the generated CKEDITOR.config file.
     *
     * @return The int representing this EnterMode.
     */
    public int getValue() {
        return val;
    }
}
