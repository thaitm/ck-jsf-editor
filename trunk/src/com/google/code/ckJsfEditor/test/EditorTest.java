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

package com.google.code.ckJsfEditor.test;

import com.google.code.ckJsfEditor.Config;
import com.google.code.ckJsfEditor.Toolbar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * User: billreh
 * Date: 9/20/11
 * Time: 8:20 PM
 */
@ManagedBean
@SessionScoped
public class EditorTest {
    private Config config;
    private String editorContents;
    private String input;
    private transient UIComponent binding;

    public EditorTest() {
        config = new Config().toolbar(Toolbar.TOOLBAR_FULL).customConfig("");
    }

    public void save() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("saving.  value is: " + getEditorContents()));
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getEditorContents() {
        return editorContents;
    }

    public void setEditorContents(String editorContents) {
        this.editorContents = editorContents;
    }

    public UIComponent getBinding() {
        return binding;
    }

    public void setBinding(UIComponent binding) {
        this.binding = binding;
    }
}
