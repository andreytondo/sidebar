# Sidebar View

## Setting up

You must create a class that implements the ISidebarInterceptor interface to pass the "packagePath" to the sidebar
generator. Optionally you can pass the app name and app version to the sidebar:
```java
@RequestScoped
public class SidebarInterceptor implements ISidebarInterceptor {

    @Override
    public void intercept(Sidebar sidebar, String packagePath) {
        sidebar.setAppName("Kanby");
        sidebar.setAppVersion("1.0");
        packagePath = "br.com.andreytondo.kanban.resource";
    }
}
```
## Getting started

Import the package and use the @SidebarView annotation
```java
@Path("/api/v1/board")
@SidebarView(description = "Board", icon = "pi pi-home")
public class BoardResource {}
```

It will get the path from the javax.ws.rs.Path annotation and return the full object in JSON format.
To access the object, make a HTTP GET request to the following URL:
> my.api/v1/sidebar

```JSON
{
  "appName": "Kanby",
  "appVersion": "1.0",
  "itens": [
    {
      "description": "Board",
      "icon": "pi pi-home",
      "route": "/api/v1/board"
    }
  ]
}
```