package br.com.andreytondo.sidebar.process;

import br.com.andreytondo.sidebar.model.Sidebar;

public interface ISidebarInterceptor {

    void intercept(Sidebar sidebar, String packagePath);
}
