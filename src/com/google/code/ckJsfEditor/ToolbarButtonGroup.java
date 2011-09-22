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


import java.util.List;
import java.util.Vector;
import static com.google.code.ckJsfEditor.ToolbarItem.*;

/**
 * <p>
 *     {@link ToolbarItem}s are grouped into ToolbarButtonGroups, which are then put into the toolbar.
 *     Each ToolbarButtonGroup object has a name and a list of ToolbarItems in it.
 * </p>
 *
 * <p>
 *     The ToolbarButtonGroup is populated with ToolbarItems via method chaining with the {@link #item(ToolbarItem)}
 *     method.  For example, the {@link #DOCUMENT} ToolbarButtonGroup is created like this:
 * </p>
 * <p>
 *     <code>
 *         public static final ToolbarButtonGroup DOCUMENT = new ToolbarButtonGroup("document")<br/>
 *              <span style="margin-left: 80px;">.item(SOURCE)</span><br/>
 *              <span style="margin-left: 80px;">.item(SEPARATOR)</span><br/>
 *              <span style="margin-left: 80px;">.item(SAVE)</span><br/>
 *              <span style="margin-left: 80px;">.item(NEW_PAGE)</span><br/>
 *              <span style="margin-left: 80px;">.item(DOC_PROPS)</span><br/>
 *              <span style="margin-left: 80px;">.item(PREVIEW)</span><br/>
 *              <span style="margin-left: 80px;">.item(PRINT)</span><br/>
 *              <span style="margin-left: 80px;">.item(SEPARATOR)</span><br/>
 *              <span style="margin-left: 80px;">.item(TEMPLATES);</span>
 *     </code>
 * </p>
 *
 *
 * @author Bill Reh
 */
public class ToolbarButtonGroup {
    public static final ToolbarButtonGroup DOCUMENT = new ToolbarButtonGroup("document")
            .item(SOURCE)
            .item(SEPARATOR)
            .item(SAVE)
            .item(NEW_PAGE)
            .item(DOC_PROPS)
            .item(PREVIEW)
            .item(PRINT)
            .item(SEPARATOR)
            .item(TEMPLATES);
    public static final ToolbarButtonGroup CLIPBOARD = new ToolbarButtonGroup("clipboard")
            .item(CUT)
            .item(COPY)
            .item(PASTE)
            .item(PASTE_TEXT)
            .item(PASTE_FROM_WORD)
            .item(SEPARATOR)
            .item(UNDO)
            .item(REDO);
    public static final ToolbarButtonGroup EDITING = new ToolbarButtonGroup("editing")
            .item(FIND)
            .item(REPLACE)
            .item(SEPARATOR)
            .item(SELECT_ALL)
            .item(SEPARATOR)
            .item(SPELL_CHECKER)
            .item(SCAYT);
    public static final ToolbarButtonGroup FORMS = new ToolbarButtonGroup("forms")
            .item(FORM)
            .item(CHECKBOX)
            .item(RADIO)
            .item(TEXT_FIELD)
            .item(TEXTAREA)
            .item(SELECT)
            .item(BUTTON)
            .item(IMAGE_BUTTON)
            .item(HIDDEN_FIELD)
            .item(BREAK);
    public static final ToolbarButtonGroup BASIC_STYLES = new ToolbarButtonGroup("basictyles")
            .item(BOLD)
            .item(ITALIC)
            .item(UNDERLINE)
            .item(STRIKE)
            .item(SUBSCRIPT)
            .item(SUPERSCRIPT)
            .item(SEPARATOR)
            .item(REMOVE_FORMAT);
    public static final ToolbarButtonGroup PARAGRAPH = new ToolbarButtonGroup("paragraph")
            .item(NUMBERED_LIST)
            .item(BULLETED_LIST)
            .item(SEPARATOR)
            .item(OUTDENT)
            .item(INDENT)
            .item(SEPARATOR)
            .item(BLOCKQUOTE)
            .item(CREATE_DIV)
            .item(SEPARATOR)
            .item(JUSTIFY_LEFT)
            .item(JUSTIFY_CENTER)
            .item(JUSTIFY_RIGHT)
            .item(JUSTIFY_BLOCK)
            .item(SEPARATOR)
            .item(BIDI_LTR)
            .item(BIDI_RTL);
    public static final ToolbarButtonGroup LINKS = new ToolbarButtonGroup("links")
            .item(LINK)
            .item(UNLINK)
            .item(ANCHOR);
    public static final ToolbarButtonGroup INSERT = new ToolbarButtonGroup("insert")
            .item(IMAGE)
            .item(FLASH)
            .item(TABLE)
            .item(HORIZONTAL_RULE)
            .item(SMILEY)
            .item(SPECIAL_CHAR)
            .item(PAGE_BREAK)
            .item(IFRAME)
            .item(BREAK);
    public static final ToolbarButtonGroup STYLES = new ToolbarButtonGroup("styles")
            .item(ToolbarItem.STYLES)
            .item(FORMAT)
            .item(FONT)
            .item(FONT_SIZE);
    public static final ToolbarButtonGroup COLORS = new ToolbarButtonGroup("colors")
            .item(TEXT_COLOR)
            .item(BG_COLOR);
    public static final ToolbarButtonGroup TOOLS = new ToolbarButtonGroup("tools")
            .item(MAXIMIZE)
            .item(SHOW_BLOCKS)
            .item(SEPARATOR)
            .item(ABOUT);

    private String name;
    private List<String> items = new Vector<String>();

    public ToolbarButtonGroup() {
    }

    public ToolbarButtonGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItems() {
        return items;
    }

    public ToolbarButtonGroup item(ToolbarItem item) {
        items.add(item.toString());
        return this;
    }

    public ToolbarButtonGroup remove(ToolbarItem item) {
        items.remove(item.toString());
        return this;
    }
}
