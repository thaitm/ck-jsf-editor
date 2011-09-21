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
 * Time: 5:29 PM
 */
public enum ToolbarItem {
    SEPARATOR("-"),
    BREAK("/"),
    SOURCE("Source"),
    SAVE("Save"),
    NEW_PAGE("NewPage"),
    DOC_PROPS("DocProps"),
    PREVIEW("Preview"),
    PRINT("Print"),
    TEMPLATES("Templates"),
    CUT("Cut"),
    COPY("Copy"),
    PASTE("Paste"),
    PASTE_TEXT("PasteText"),
    PASTE_FROM_WORD("PasteFromWord"),
    UNDO("Undo"),
    REDO("Redo"),
    FIND("Find"),
    REPLACE("Replace"),
    SELECT_ALL("SelectAll"),
    SPELL_CHECKER("SpellChecker"),
    SCAYT("Scayt"),
    FORM("Form"),
    CHECKBOX("Checkbox"),
    RADIO("Radio"),
    TEXT_FIELD("TextField"),
    TEXTAREA("Textarea"),
    SELECT("Select"),
    BUTTON("Button"),
    IMAGE_BUTTON("ImageButton"),
    HIDDEN_FIELD("HiddenField"),
    BOLD("Bold"),
    ITALIC("Italic"),
    UNDERLINE("Underline"),
    STRIKE("Strike"),
    SUBSCRIPT("Subscript"),
    SUPERSCRIPT("Superscript"),
    REMOVE_FORMAT("RemoveFormat"),
    NUMBERED_LIST("NumberedList"),
    BULLETED_LIST("BulletedList"),
    OUTDENT("Outdent"),
    INDENT("Indent"),
    BLOCKQUOTE("Blockquote"),
    CREATE_DIV("CreateDiv"),
    JUSTIFY_LEFT("JustifyLeft"),
    JUSTIFY_CENTER("JustifyCenter"),
    JUSTIFY_RIGHT("JustifyRight"),
    JUSTIFY_BLOCK("JustifyBlock"),
    BIDI_LTR("BidiLtr"),
    BIDI_RTL("BidiRtl"),
    LINK("Link"),
    UNLINK("Unlink"),
    ANCHOR("Anchor"),
    IMAGE("Image"),
    FLASH("Flash"),
    TABLE("Table"),
    HORIZONTAL_RULE("HorizontalRule"),
    SMILEY("Smiley"),
    SPECIAL_CHAR("SpecialChar"),
    PAGE_BREAK("PageBreak"),
    IFRAME("Iframe"),
    STYLES("Styles"),
    FORMAT("Format"),
    FONT("Font"),
    FONT_SIZE("FontSize"),
    TEXT_COLOR("TextColor"),
    BG_COLOR("BGColor"),
    MAXIMIZE("Maximize"),
    SHOW_BLOCKS("ShowBlocks"),
    ABOUT("About");

    private String val;

    private ToolbarItem(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
