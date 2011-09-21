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

/**
 * We need to override this in the global namespace before instantiating the editor instance.
 * @param resource
 */
CKEDITOR_GETURL = function( resource ) {
    var i;
    var theResource;
    var jsfResource = resource;
    if ( jsfResource.indexOf(':/') == -1 && jsfResource.indexOf( '/' ) !== 0 ) {
        jsfResource = this.basePath + 'javax.faces.resource';
        i = resource.lastIndexOf('/')
        theResource = resource.substring(i);
        var thePath = resource.substring(0, i);
        if(theResource.charAt(0) != '/')
            jsfResource = jsfResource + '/';
        jsfResource = jsfResource + theResource + '.jsf?ln=com/google/code/ckJsfEditor/ckeditor-3.6.2';
        if(thePath != null && thePath.length != 0) {
            if(thePath.charAt(0) == '/')
                jsfResource = jsfResource + thePath;
            else
                jsfResource = jsfResource + '/' + thePath;
        }
        jsfResource = jsfResource + '/';
    } else if(!jsfResource.match('/$')) {
        i = resource.lastIndexOf('/')
        theResource = resource.substring(i + 1);
        jsfResource = jsfResource.substring(0, i);
        jsfResource = jsfResource.replace(".jsf", theResource + ".jsf");
    }

    if(resource != null && resource.match('resource/...*jsf.ln=com/google')) {
        while(resource.match('/$'))
            resource = resource.substring(0, resource.length - 1);
        return resource;
    }

    while(jsfResource.match('/$') && resource != null && !resource.match('/$'))
        jsfResource = jsfResource.substring(0, jsfResource.length - 1);

    return jsfResource;
};

/**
 * Creates a new CKEditor instance.
 *
 * @param editorElement The element to replace with the editor.  This argument is required.
 * @param config Optional CKEDITOR.config object used to configure the editor.
 */
function CKEditor(editorElement, config) {
    var _this = this;
    var editor;

    /** The id of the element the editor replaces.  */
    this.editorElement = editorElement;
    /** The CKEDITOR.config used for this editor. */
    this.config = config;

    /**
     * @return The CKEDITOR.editor instance.
     */
    this.getEditor = function() {
        return editor;
    };

    if(editorElement == null)
        return;

    window.onload = function() {
        if(config)
            editor = CKEDITOR.replace(editorElement, config);
        else
            editor = CKEDITOR.replace(editorElement);

        editor.on('key', function(e) {
            window.setTimeout(function() { _this.updateElement(); }, 50);
        });
    }
}

CKEditor.prototype.dirty = function() {
    return this.getEditor().checkDirty();
};

CKEditor.prototype.resetDirty = function() {
    this.getEditor().resetDirty();
};

CKEditor.prototype.resize = function(width, height, isContentHeight, resizeInner) {
    this.getEditor().resize(width, height, isContentHeight, resizeInner);
};

CKEditor.prototype.getSelection = function() {
    return this.getEditor().getSelection();
};

CKEditor.prototype.getContents = function() {
    return this.getEditor().getData();
};

CKEditor.prototype.setContents = function(data, callback, internal) {
    this.getEditor().setData(data, callback, internal);
    this.updateElement();
};

CKEditor.prototype.insertHtml = function(html) {
    this.getEditor().insertHtml(html);
};

CKEditor.prototype.insertText = function(text) {
    this.getEditor().insertText(text);
};

CKEditor.prototype.sourceView = function() {
    this.getEditor().setMode('source');
};

CKEditor.prototype.wysiwygView = function() {
    this.getEditor().setMode('wysiwyg');
};

CKEditor.prototype.insertElement = function(element) {
    return this.getEditor().insertElement(element);
};

CKEditor.prototype.updateElement = function() {
    this.getEditor().updateElement();
};
