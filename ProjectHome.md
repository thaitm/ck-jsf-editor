A JSF 2.0 component for [ckeditor](http://ckeditor.com).

I've been looking for a good jsf editor component that I really like for ages, and the ones I've run across don't really compare to the nicer javascript editors out there and require using and entire component library, so I decided to write a standalone component for ckeditor.

Using the component should be as easy as dropping the jar file into your WEB-INF/lib directory and importing the tag's namespace in your page:

```
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ck="http://code.google.com/ck-jsf-editor">
...
<h:body>
  <h:form>
    <ck:editor uiColor="aed0ea"/>
  </h:form>
</h:body>
```

![http://ck-jsf-editor.googlecode.com/svn/wiki/images/ckeditor_image2.png](http://ck-jsf-editor.googlecode.com/svn/wiki/images/ckeditor_image2.png)