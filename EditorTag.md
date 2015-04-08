# Editor #

The editor tag provides a JSF component for ckeditor.

## Info ##
| Tag | **editor** |
|:----|:-----------|
| Component Class | **[com.google.code.ckJsfEditor.component.Editor](http://ck-jsf-editor.googlecode.com/svn/wiki/javadoc/com/google/code/ckJsfEditor/component/Editor.html)** |
| Renderer Class | **[com.google.code.ckJsfEditor.component.EditorRenderer](http://ck-jsf-editor.googlecode.com/svn/wiki/javadoc/com/google/code/ckJsfEditor/component/EditorRenderer.html)** |
| Handler Class | **[com.google.code.ckJsfEditor.component.EditorHandler](http://ck-jsf-editor.googlecode.com/svn/wiki/javadoc/com/google/code/ckJsfEditor/component/EditorHandler.html)** |

## Attributes ##
| **Name** | **Default** | **Type** | **Description** |
|:---------|:------------|:---------|:----------------|
| id | null | String | Unique component identifier. |
| rendered | true | boolean | Whether or not to render the component on the page. |
| binding | null | UIComponent | An EL expression that maps to a UIComponent object in a backing bean. |
| style | null | String | Inline css style for the component container. |
| styleClass | null | String | Css style class name for the component container. |
| readonly | false | boolean | Whether to make the editor readonly. |
| value | null | String | The value of the text/html in the editor component, generally mapped to a backing bean property. |
| immediate | false | boolean | Whether or not process validations logic is executed at apply request values phase for this component. |
| required | false | boolean | Whether input in this component is required on submission. |
| requiredMessage | null | String | Message to display when the required field validation fails. |
| validator | null | MethodExpression | A method expression referring to a validation method with the signature with the signature `void methodName(FacesContext facesContext, UIComponent uiComponent, Object newValue)`. |
| validatorMessage | null | String | Message to display when validation fails. |
| height | null | String | The desired height for the component, either as a number or a number with a css length unit (px, ex, em, in, pt, pc, mm, cm).  Bare numbers are interpreted as px. |
| width | null | String | The desired width for the component, either as a number or a number with a css length unit (px, ex, em, in, pt, pc, mm, cm).  Bare numbers are interpreted as px. |
| uiColor | null | String | The color to use for the overall theme of the editor's ui, ie #aed0ea |
| config | null | [Config](http://ck-jsf-editor.googlecode.com/svn/wiki/javadoc/com/google/code/ckJsfEditor/Config.html) | An EL expression referring to a [Config](http://ck-jsf-editor.googlecode.com/svn/wiki/javadoc/com/google/code/ckJsfEditor/Config.html) object in your backing bean.  Used to configure the editor at initialization time. |
| toolbar | null | Object | Either the string "basic" for the basic toolbar, "full" for the full toolbar, or an EL reference to a [Toolbar](http://ck-jsf-editor.googlecode.com/svn/wiki/javadoc/com/google/code/ckJsfEditor/Toolbar.html) object in your backing bean. |
| lang | null | String | The language for the editor to use. |
| cssContents | null | String | A comma separated list of css files to use in the content section of the editor |
| widgetVar | null | String | The name to use for the javascript widget which holds the editor instance |
| saveMethod | null | MethodExpression | A method with the signature void methodName([SaveEvent](http://ck-jsf-editor.googlecode.com/svn/wiki/javadoc/com/google/code/ckJsfEditor/component/SaveEvent.html)) that will be fired as an ajax submit when the save button in the editor is clicked. |
| render | null | String | a comma or space separated list of client ids to update after receiving the ajax response from the saveMethod call |
| ajax | true | boolean | Set to false to do a form submit when the save button is pressed in the editor |