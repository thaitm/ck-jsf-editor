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

import java.util.Collections;
import java.util.List;
import java.util.Vector;

import static com.google.code.ckJsfEditor.ToolbarItem.*;
import static com.google.code.ckJsfEditor.ToolbarButtonGroup.*;


/**
 * @author Bill Reh
 */
public class Toolbar {
    public static final Toolbar TOOLBAR_FULL = new Toolbar(
            DOCUMENT,
            CLIPBOARD,
            FORMS,
            BASIC_STYLES,
            PARAGRAPH,
            LINKS,
            INSERT,
            ToolbarButtonGroup.STYLES,
            COLORS,
            TOOLS
    );
    public static final Toolbar TOOLBAR_BASIC = new Toolbar(
            new ToolbarButtonGroup()
                    .item(BOLD)
                    .item(ITALIC)
                    .item(SEPARATOR)
                    .item(NUMBERED_LIST)
                    .item(BULLETED_LIST)
                    .item(SEPARATOR)
                    .item(LINK)
                    .item(UNLINK)
                    .item(SEPARATOR)
                    .item(ABOUT)
    );

    private List<ToolbarButtonGroup> toolbarButtonGroups = new Vector<ToolbarButtonGroup>();

    public Toolbar() {
    }

    public Toolbar(ToolbarButtonGroup... groups) {
        Collections.addAll(toolbarButtonGroups, groups);
    }

    public Toolbar(List<ToolbarButtonGroup> toolbarButtonGroups) {
        this.toolbarButtonGroups.addAll(toolbarButtonGroups);
    }

    public Toolbar(List<ToolbarButtonGroup> toolbarButtonGroups, ToolbarButtonGroup... moreGroups) {
        this.toolbarButtonGroups.addAll(toolbarButtonGroups);
        Collections.addAll(this.toolbarButtonGroups, moreGroups);
    }

    public List<ToolbarButtonGroup> getToolbarButtonGroups() {
        return toolbarButtonGroups;
    }

    public void addToolbarButtonGroup(ToolbarButtonGroup toolbarButtonGroup) {
        toolbarButtonGroups.add(toolbarButtonGroup);
    }

    public void removeToolbarButtonGroup(ToolbarButtonGroup toolbarButtonGroup) {
        toolbarButtonGroups.remove(toolbarButtonGroup);
    }

    public void removeToolbarButtonGroup(String name) {
        ToolbarButtonGroup toRemove = null;
        for(ToolbarButtonGroup group : toolbarButtonGroups) {
            if(group.getName().equals(name)) {
                toRemove = group;
                break;
            }
        }

        if(toRemove != null)
            toolbarButtonGroups.remove(toRemove);
    }

    public Toolbar removeItem(ToolbarItem item) {
        for(ToolbarButtonGroup group : toolbarButtonGroups) {
            group.remove(item);
        }
        return this;
    }
}
