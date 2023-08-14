package br.com.andreytondo.sidebar.model;

import br.com.andreytondo.sidebar.model.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sidebar {

    private String appName;
    private String appVersion;
    private List<Item> itens;
}
