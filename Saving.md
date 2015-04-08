# Introduction #

The editor component supports several variants of saving.  You can do it normally like you would in a textarea component and simply have a commandButton (ajax or no) to submit the component/editor.  Alternatively, you can hook the save up to the save button in the editor.


# Details #

## To save outside the component: ##
```
...
<messages id="messages"/>

<ck:editor id="theEditor" value="#{bean.editorContents}"/>

<h:commandButton value="Save" action="#{bean.someAction}"/>
<!-- or -->
<h:commandButton value="Save" action="#{bean.someAction}">
    <f:ajax execute="theEditor" render="messages"/>
</h:commadButton>
...
```
```
@ManagedBean
@RequestScoped
public class Bean {
    private String editorContents.

    ... getter and setter

    public String someAction() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("saved: " + getEditorContents()));
    }
}
```

## To do an ajax save from the save button: ##
```
...
<messages id="messages"/>

<ck:editor value="#{bean.editorContents}" saveMethod="#{bean.saveContents}" update="messages"/>
...
```
```
@ManagedBean
@RequestScoped
public class Bean {
    private String editorContents.

    ... getter and setter

    public String saveContents(SaveEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("saved: " + event.getEditorData()));
        // note that editorContents is also updated at this point
    }
}
```

## To do a form submit when the save button is clicked: ##
```
...
<messages id="messages"/>

<ck:editor value="#{bean.editorContents}" ajax="false"/>
...
```


## Fire a change listener on a form submit when the save button is clicked: ##
```
...
<messages id="messages"/>

<ck:editor value="#{bean.editorContents}" ajax="false" changeListener="#{bean.saveListener}"/>
...
```
```
@ManagedBean
@RequestScoped
public class Bean {
    private String editorContents.

    ... getter and setter

    public String saveListener(ValueChangeEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("old content: " + event.getOldValue()));
        facesContext.addMessage(null, new FacesMessage("new content: " + event.getNewValue()));
        // note that editorContents is also updated at this point
    }
}
```