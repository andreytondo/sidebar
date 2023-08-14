package br.com.andreytondo.sidebar.model;

import br.com.andreytondo.sidebar.process.SidebarGenerator;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("v1/sidebar")
@Produces("application/json")
@Consumes("application/json")
public class SidebarService {

    @Inject
    SidebarGenerator sidebarGenerator;

    @GET
    public Sidebar getSidebar() {
        return sidebarGenerator.getSidebar();
    }
}
