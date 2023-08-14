package br.com.andreytondo.sidebar.process;

import br.com.andreytondo.sidebar.annotation.SidebarView;
import br.com.andreytondo.sidebar.model.Sidebar;
import br.com.andreytondo.sidebar.model.item.Item;
import org.reflections.Reflections;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Set;

@RequestScoped
public class SidebarGenerator {

    @Inject
    @Any
    ISidebarInterceptor interceptor;

    public Sidebar getSidebar() {
        Sidebar sidebar = new Sidebar();
        String packagePath = "";
        interceptor.intercept(sidebar, packagePath);
        sidebar.setItens(new ArrayList<>());

        Reflections reflections = new Reflections(packagePath);
        Set<Class<?>> views = reflections.getTypesAnnotatedWith(SidebarView.class);

        for (Class<?> view : views) {
            SidebarView annotation = view.getAnnotation(SidebarView.class);
            Path path = view.getAnnotation(Path.class);
            addItens(sidebar, annotation, path);
        }

        return sidebar;
    }

    private void addItens(Sidebar sidebar, SidebarView annotation, Path path) {
        sidebar.getItens().add(new Item(
                annotation.description(),
                annotation.icon(),
                path.value()
        ));
    }

}
