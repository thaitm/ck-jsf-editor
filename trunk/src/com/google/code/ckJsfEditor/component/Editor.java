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

import javax.el.MethodExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.FacesEvent;
import javax.faces.event.ValueChangeEvent;

/**
 * User: billreh
 * Date: 9/17/11
 * Time: 10:24 PM
 */
@FacesComponent(value = "Editor")
@ResourceDependencies({
        @ResourceDependency(library="com/google/code/ckJsfEditor", name="editor.js", target = "head"),
        @ResourceDependency(library="com/google/code/ckJsfEditor/ckeditor-3.6.2", name="ckeditor_source.js", target = "head")
})
public class Editor extends HtmlInputTextarea {
    protected enum PropertyKeys {
        widgetVar,
        height,
        width,
        uiColor,
        theme,
        contentCss,
        extraPlugins,
        skin,
        toolbar,
        config,
        saveMethod,
        changeListener,
        ajax,
        render
    }


    @Override
    public void queueEvent(FacesEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String eventName = context.getExternalContext().getRequestParameterMap().get("javax.faces.partial.event");

        if("save".equals(eventName)) {
            Editor editor = (Editor) event.getComponent();
            super.queueEvent(new SaveEvent(event.getComponent(), editor.getValue().toString()));
        } else {
            super.queueEvent(event);
        }
    }

    @Override
    public void broadcast(FacesEvent event) throws AbortProcessingException {
        super.broadcast(event);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        MethodExpression ajaxMethod = getSaveMethod();
        MethodExpression submitMethod = getChangeListener();

        if(ajaxMethod != null && event instanceof SaveEvent) { // ajax
            ajaxMethod.invoke(facesContext.getELContext(), new Object[]{((SaveEvent) event)});
            FacesContext.getCurrentInstance().renderResponse();
        } else if(submitMethod != null) { // form submit
            submitMethod.invoke(facesContext.getELContext(), new Object[] {((ValueChangeEvent) event)});
            FacesContext.getCurrentInstance().renderResponse();
        }
    }

    public String resolveWidgetVar() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String widgetVar = (String) getAttributes().get("widgetVar");

        if(widgetVar != null)
            return widgetVar;
        else
            return "widget_" + getClientId(facesContext).replaceAll("-|" + UINamingContainer.getSeparatorChar(facesContext), "_");
    }

    public String getWidgetVar() {
        return (String) getStateHelper().eval(PropertyKeys.widgetVar, null);
    }

    public void setWidgetVar(String widgetVar) {
        getStateHelper().put(PropertyKeys.widgetVar, widgetVar);
    }

    public String getHeight() {
        return (String) getStateHelper().eval(PropertyKeys.height, null);
    }

    public void setHeight(String height) {
        getStateHelper().put(PropertyKeys.height, height);
    }

    public String getWidth() {
        return (String) getStateHelper().eval(PropertyKeys.width, null);
    }

    public void setWidth(String width) {
        getStateHelper().put(PropertyKeys.width, width);
    }

    public String getUiColor() {
        return (String) getStateHelper().eval(PropertyKeys.uiColor, null);
    }

    public void setUiColor(String uiColor) {
        getStateHelper().put(PropertyKeys.uiColor, uiColor);
    }

    public String getTheme() {
        return (String) getStateHelper().eval(PropertyKeys.theme, null);
    }

    public void setTheme(String theme) {
        getStateHelper().put(PropertyKeys.theme, theme);
    }

    public String getContentCss() {
        return (String) getStateHelper().eval(PropertyKeys.contentCss, null);
    }

    public void setContentCss(String contentCss) {
        getStateHelper().put(PropertyKeys.contentCss, contentCss);
    }

    public String getExtraPlugins() {
        return (String) getStateHelper().eval(PropertyKeys.extraPlugins, null);
    }

    public void setExtraPlugins(String extraPlugins) {
        getStateHelper().put(PropertyKeys.extraPlugins, extraPlugins);
    }

    public String getSkin() {
        return (String) getStateHelper().eval(PropertyKeys.skin, null);
    }

    public void setSkin(String skin) {
        getStateHelper().put(PropertyKeys.skin, skin);
    }

    public Object getToolbar() {
        return getStateHelper().eval(PropertyKeys.toolbar, null);
    }

    public void setToolbar(Object toolbar) {
        getStateHelper().put(PropertyKeys.toolbar, toolbar);
    }

    public Config getConfig() {
        return (Config) getStateHelper().eval(PropertyKeys.config, null);
    }

    public void setConfig(Config config) {
        getStateHelper().put(PropertyKeys.config, config);
    }

    public MethodExpression getChangeListener() {
        return (MethodExpression) getStateHelper().eval(PropertyKeys.changeListener, null);
    }

    public void setChangeListener(MethodExpression changeListener) {
        getStateHelper().put(PropertyKeys.changeListener, changeListener);
    }

    public MethodExpression getSaveMethod() {
        return (MethodExpression) getStateHelper().eval(PropertyKeys.saveMethod, null);
    }

    public void setSaveMethod(MethodExpression saveMethod) {
        getStateHelper().put(PropertyKeys.saveMethod, saveMethod);
    }

    public boolean isAjax() {
        return (Boolean) getStateHelper().eval(PropertyKeys.ajax, true);
    }

    public void setAjax(boolean ajax) {
        getStateHelper().put(PropertyKeys.ajax, ajax);
    }

    public String getRender() {
        return (String) getStateHelper().eval(PropertyKeys.render, null);
    }

    public void setRender(String render) {
        getStateHelper().put(PropertyKeys.render, render);
    }
}
