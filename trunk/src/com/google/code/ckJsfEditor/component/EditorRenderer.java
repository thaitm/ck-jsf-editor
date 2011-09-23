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

import com.google.code.ckJsfEditor.Config;
import com.google.code.ckJsfEditor.Toolbar;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import java.io.IOException;

/**
 * User: billreh
 * Date: 9/17/11
 * Time: 10:47 PM
 */
@FacesRenderer(componentFamily = "Editor", rendererType = "javax.faces.Input")
public class EditorRenderer extends Renderer {
    @Override
    public void decode(FacesContext context, UIComponent component) {
        Editor editor = (Editor) component;

        if(editor.isDisabled() || editor.isReadonly()) {
            return;
        }

        String clientId = editor.getClientId(context);
        String submittedValue = context.getExternalContext().getRequestParameterMap().get(clientId);

        editor.setSubmittedValue(submittedValue);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        Editor editor = (Editor) component;
        String clientId = editor.getClientId(context);

        responseWriter.startElement("textarea", component);
        responseWriter.writeAttribute("id", clientId, null);
        responseWriter.writeAttribute("name", clientId, null);
        if(editor.getValue() != null)
            responseWriter.write(editor.getValue().toString());
        responseWriter.endElement("textarea");

        encodeScript(context, editor);
    }

    protected void encodeScript(FacesContext context, Editor editor) throws IOException {
        Config config = editor.getConfig();
        ResponseWriter responseWriter = context.getResponseWriter();

        config = setConfigOptions(editor, config);

        responseWriter.startElement("script", editor);
		responseWriter.writeAttribute("type", "text/javascript", null);
        responseWriter.write("var " + editor.resolveWidgetVar() + " = new CKEditor('" + editor.getClientId() + "'");
        if(config != null)
            responseWriter.write(", " + config.toJson());
        responseWriter.write(");\n");

        if(editor.getSaveMethod() != null) {
            encodeSaveMethod(responseWriter, editor);
        } else if(editor.isAjax()) {
            responseWriter.write("editor.getCommand('save').disable();\n");
        }

        responseWriter.endElement("script");
    }

    public void encodeSaveMethod(ResponseWriter responseWriter, Editor editor) throws IOException {
        String toRender = getClientIdsToRender(FacesContext.getCurrentInstance(), editor);
        responseWriter.write("CKEDITOR.plugins.registered['save']= {\n" +
                "    init : function( editor ) {\n" +
                "        var command = editor.addCommand( 'save',\n" +
                "            {\n" +
                "                modes : { wysiwyg:1, source:1 },\n" +
                "                exec : function( editor ) {\n" +
                "                    clientId = editor.element.getId();\n");
        if(editor.getRender() != null && !editor.getRender().isEmpty()) {
                responseWriter.write("                    jsf.ajax.request(clientId, { type: 'save' }, { render: '" +
                        toRender +  "' } );\n");
        } else {
            responseWriter.write("                    jsf.ajax.request(clientId, { type: 'save' });\n");
        }
        responseWriter.write("                }\n" +
                "            }\n" +
                "        );\n" +
                "        editor.ui.addButton( 'Save',{label : 'Save',command : 'save'});\n" +
                "    }\n" +
                "}\n");
    }

    protected Config setConfigOptions(Editor editor, Config config) {
        if(config == null)
            config = new Config();

        if(editor.isReadonly())
            config.readOnly(true);

        if(editor.getHeight() != null && !editor.getHeight().isEmpty())
            config.height(editor.getHeight());

        if(editor.getWidth() != null && !editor.getWidth().isEmpty())
            config.width(editor.getWidth());

        if(editor.getUiColor() != null && !editor.getUiColor().isEmpty())
            config.uiColor(editor.getUiColor());

        if(editor.getTheme() != null && !editor.getTheme().isEmpty())
            config.theme(editor.getTheme());

        if(editor.getSkin() != null && !editor.getSkin().isEmpty())
            config.skin(editor.getSkin());

        if(editor.getExtraPlugins() != null && !editor.getExtraPlugins().isEmpty())
            config.extraPlugins(editor.getExtraPlugins());

        if(editor.getLang() != null && !editor.getLang().isEmpty())
            config.language(editor.getLang());

        if(editor.getContentCss() != null) {
            String[] contentsCss = editor.getContentCss().split(",");
            config.contentsCss(contentsCss);
        }

        if(editor.getToolbar() != null) {
            if(editor.getToolbar() instanceof String) {
                String toolbar = (String) editor.getToolbar();
                if(toolbar.equalsIgnoreCase("basic"))
                    config.toolbar(Toolbar.TOOLBAR_BASIC);
                else if(toolbar.equalsIgnoreCase("full"))
                    config.toolbar(Toolbar.TOOLBAR_FULL);
            } else {
                config.toolbar((Toolbar) editor.getToolbar());
            }
        }

        if(config.toJson().equals("{}"))
            return null;

        return config;
    }

    protected static UIComponent findParentForm(UIComponent component) {
        UIComponent parent = component.getParent();

        while(parent != null) {
            if(parent instanceof UIForm)
                return parent;

            parent = parent.getParent();
        }

        return null;
    }

    protected String getClientIdsToRender(FacesContext facesContext, Editor editor) {
        String rawList = editor.getRender();

        if(rawList == null)
            return null;

        StringBuilder buf = new StringBuilder();

        String[] ids = rawList.split("[,\\s]+");
        for(String id : ids) {
            id = id.trim();
            if(id.equals("@all") || id.equals("@none")) {
                buf.append(id);
            } else if(id.equals("@this")) {
                buf.append(editor.getClientId(facesContext));
            } else if(id.equals("@form")) {
                UIComponent form = findParentForm(editor);
                if(form == null)
                    throw new FacesException("Component " + editor.getClientId() + " must be enclosed in a form");
                buf.append(form.getClientId(facesContext));
            } else {
                UIComponent component = editor.findComponent(id);
                if(component != null)
                    buf.append(component.getClientId(facesContext));
            }
            buf.append(" ");
        }

        return buf.toString();
    }
}
