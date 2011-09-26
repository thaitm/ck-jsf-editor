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
import javax.faces.context.FacesContext;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * User: billreh
 * Date: 9/25/11
 * Time: 11:26 PM
 */
@FacesRenderer(componentFamily = "javax.faves.Output", rendererType = "StyleResource")
public class StyleResourceRenderer extends Renderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String requestUrl = request.getRequestURL().toString();
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String basePath = requestUrl.replace(requestUri, contextPath);
        context.getResponseWriter().write(
                "<script type=\"text/javascript\"> var CKEDITOR_BASEPATH=\"" + basePath + "\"; </script>");
        context.getResponseWriter().flush();
    }
}
