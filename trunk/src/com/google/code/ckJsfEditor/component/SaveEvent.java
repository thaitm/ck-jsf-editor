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

package com.google.code.ckJsfEditor.component;

import javax.faces.component.UIComponent;
import javax.faces.event.FacesEvent;
import javax.faces.event.FacesListener;

/**
 * User: billreh
 * Date: 9/23/11
 * Time: 4:29 AM
 */
public class SaveEvent extends FacesEvent {
    private String editorData;

    public SaveEvent(UIComponent component, String editorData) {
        super(component);
        this.editorData = editorData;
    }

    @Override
    public boolean isAppropriateListener(FacesListener facesListener) {
        return false;
    }

    @Override
    public void processListener(FacesListener facesListener) {
        throw new UnsupportedOperationException("Unsupported");
    }

    public String getEditorData() {
        return editorData;
    }
}
