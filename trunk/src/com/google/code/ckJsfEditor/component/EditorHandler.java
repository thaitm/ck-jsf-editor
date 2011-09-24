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

import com.sun.faces.facelets.tag.MethodRule;

import javax.faces.event.ValueChangeEvent;
import javax.faces.view.facelets.ComponentConfig;
import javax.faces.view.facelets.ComponentHandler;
import javax.faces.view.facelets.MetaRuleset;

/**
 * User: billreh
 * Date: 9/23/11
 * Time: 4:27 AM
 */
public class EditorHandler extends ComponentHandler {
    public EditorHandler(ComponentConfig config) {
        super(config);
    }

    @Override
    protected MetaRuleset createMetaRuleset(Class type) {
        MetaRuleset metaRuleset = super.createMetaRuleset(type);

        metaRuleset.addRule(new MethodRule("saveMethod", null, new Class[]{SaveEvent.class}));
        metaRuleset.addRule(new MethodRule("changeListener", null, new Class[]{ValueChangeEvent.class}));

        return metaRuleset;
    }
}
