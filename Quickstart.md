# Introduction #

ck-jsf-editor provides a ckeditor JSF 2.0 component.  To use it you just need to include the jar file in your WEB-INF/lib directory, and import the tag namespace (`http://code.google.com/ck-jsf-editor`) in your html declaration.  As with any component, it must be enclosed in a form.


# Details #

Here's a step by step description of how to get up and going.
  1. Download the latest ck-jsf-editor.jar from http://code.google.com/p/ck-jsf-editor/downloads/list
  1. Copy the jar file to the WEB-INF/lib directory underneath your web root.  You may also need to point your IDE at the jar file so that it recognizes the tag and classes.
  1. Include the namespace in your html declaration like so, The `xmlns:ck="http://code.google.com/ck-jsf-editor"` line is the one that imports the tag.:
```
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ck="http://code.google.com/ck-jsf-editor"
      xml:lang="en" lang="en">
```
  1. Use the tag in your page!
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ck="http://code.google.com/ck-jsf-editor"
      xml:lang="en" lang="en">
<f:view contentType="text/html">
    <h:head>
        <title>CKEditor JSF Component Test</title>
    </h:head>
    <h:body>
        <h:form>
            <h:messages id="messages" />
            <ck:editor id="ckEd" value="#{editorTest.editorContents}" width="800px" uiColor="#aed0ea"/>
            <h:commandButton value="Reset" onclick="eduardo.setContents(''); return false;"/>
            <h:commandButton value="Save" actionListener="#{editorTest.save}">
                <f:ajax render="messages" execute="ckEd"/>
            </h:commandButton>
        </h:form>
    </h:body>
</f:view>
</html>
```
  1. Your page should look like this:
![http://ck-jsf-editor.googlecode.com/svn/wiki/images/ckeditor_image.png](http://ck-jsf-editor.googlecode.com/svn/wiki/images/ckeditor_image.png)