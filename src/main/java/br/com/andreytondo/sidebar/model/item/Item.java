package br.com.andreytondo.sidebar.model.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String description;
    private String icon;
    private String route;
}
