CKJsfEditor is a JSF 2 component for CKEditor (see http://ckeditor.com).  Usage should be simple.  Include the
ck-jsf-editor.jar file in your WEB-INF/lib directory and do include it in your jsf pages as below:

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ck="http://code.google.com/ck-jsf-editor"
      xml:lang="en" lang="en">


now you can use the tag in your page like so:

<ck:editor id="ckEd" value="#{editorTest.editorContents}" width="800px" widgetVar="eduardo" uiColor="#aed0ea"/>


As it is an input component, it must be included in an <h:form> tag.

For more detailed information please see the wiki at: http://code.google.com/p/ck-jsf-editor/w/list

For more information on the project, latest releases, and to report issues, please go to:
http://code.google.com/p/ck-jsf-editor/


This project uses the ckeditor project (http://ckeditor.com), and also the google-gson project
(http://code.google.com/p/google-gson/).  Many thanks to those developers.  Please see their respective licences,
included in this archive as gson-LICENSE and ckeditor-LICENSE.html.  Some changes were made to ckeditor in order
to make it work with jsf resource loading.  These are noted in the included source files, and in ckeditor-CHANGES.txt.

This project is licensed under the Lesser GNU Public License, Version 3.  Please see LICENSE.txt for more information.
