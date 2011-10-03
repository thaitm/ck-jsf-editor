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
 *
 * @param resource The resource to translate into a url.
 */
CKEDITOR_GETURL = function( resource ) {
    var i;
    var theResource;
    var jsfResource = resource;
    if ( jsfResource.indexOf(':/') == -1 && jsfResource.indexOf( '/' ) !== 0 ) {
        jsfResource = CKEDITOR_BASEPATH + '/javax.faces.resource';
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
        i = resource.lastIndexOf('/');
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

    if(CKEDITOR.instances[editorElement] != null) {
        var ed = CKEDITOR.instances[editorElement];
        ed.destroy();
    }

    if(config)
        editor = CKEDITOR.replace(editorElement, config);
    else
        editor = CKEDITOR.replace(editorElement);

    editor.on('key', function(e) {
        window.setTimeout(function() { _this.updateElement(); }, 50);
    });
}

/**
 * @return true if the editor contents have been changes since being loaded
 */
CKEditor.prototype.dirty = function() {
    return this.getEditor().checkDirty();
};

/**
 * resets the dirty flag
 */
CKEditor.prototype.resetDirty = function() {
    this.getEditor().resetDirty();
};

/**
 *
 * @param width The width to set the editor to as an integer or css size value.
 * @param height The height to set the editor to as an integer or css size value.
 * @param isContentHeight {boolean} Optional argument indicating that the provided height is to be applied to the
 * editor contents space, not to the entire editor interface. Defaults to false.
 * @param resizeInner {boolean} Optional argument indicating that the first inner interface element must receive
 * the size, not the outer element. The default theme defines the interface inside a pair of span
 * elements (<span><span>...</span></span>). By default the first span element receives the sizes. If this parameter
 * is set to true, the second span is sized instead.
 */
CKEditor.prototype.resize = function(width, height, isContentHeight, resizeInner) {
    this.getEditor().resize(width, height, isContentHeight, resizeInner);
};

/**
 * @return The currently highlighted text
 */
CKEditor.prototype.getSelection = function() {
    return this.getEditor().getSelection();
};

/**
 * @return The contents of the editor.
 */
CKEditor.prototype.getContents = function() {
    return this.getEditor().getData();
};

/**
 * Sets the contents of the editor.
 *
 * @param data {String} HTML code to replace the current content in the editor.
 * @param callback {Function} Optional function to be called after the setData is completed.
 * @param internal {boolean} Optional argument indication whether to suppress any event firing when copying data
 * internally inside the editor.
 */
CKEditor.prototype.setContents = function(data, callback, internal) {
    this.getEditor().setData(data, callback, internal);
    this.updateElement();
};

/**
 * Inserts the html at the cursor in the editor.
 *
 * @param html {String} The html to insert.
 */
CKEditor.prototype.insertHtml = function(html) {
    this.getEditor().insertHtml(html);
};

/**
 * Inserts the text at the cursor in the editor.
 *
 * @param text {String} The html to insert.
 */
CKEditor.prototype.insertText = function(text) {
    this.getEditor().insertText(text);
};

/**
 * Switches the editor to source view.
 */
CKEditor.prototype.sourceView = function() {
    this.getEditor().setMode('source');
};

/**
 * Switches the editor to wysiwyg view.
 */
CKEditor.prototype.wysiwygView = function() {
    this.getEditor().setMode('wysiwyg');
};

/**
 * Inserts a new CKEDITOR.dom.element into the editor at the cursor.
 *
 * @param element {CKEDITOR.dom.element} The element to insert.
 */
CKEditor.prototype.insertElement = function(element) {
    return this.getEditor().insertElement(element);
};

/**
 * Synchronizes the data from the editor into the textarea element it's replacing.
 */
CKEditor.prototype.updateElement = function() {
    this.getEditor().updateElement();
};

CKEditor.prototype.disableSaveButton = function() {
    var save_cmd = this.getEditor().getCommand('save');
    if(save_cmd == null) {
        CKEDITOR.plugins.registered['Save']= {
            init : function( editor ) {
                var command = editor.addCommand( 'save',
                    {
                        modes : { wysiwyg:1, source:1 },
                        exec : function( editor ) {
                            clientId = editor.element.getId();
                        }
                    });
                command.disable();
                editor.ui.addButton( 'save',{label : 'Save',command : 'save'});
            }
        };
    } else {
        save_cmd.disable();
    }
};
