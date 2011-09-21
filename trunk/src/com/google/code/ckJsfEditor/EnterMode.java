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
* User: billreh
* Date: 9/17/11
* Time: 4:58 PM
*/
public enum EnterMode {
    CKEDITOR_ENTER_P(1),
    CKEDITOR_ENTER_BR(2),
    CKEDITOR_ENTER_DIV(3);

    private int val;

    private EnterMode(int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }
}
