package com.company.jmixbpmdemo.view.pizzaitem;

import com.company.jmixbpmdemo.entity.PizzaItem;
import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "pizzaItems", layout = MainView.class)
@ViewController(id = "PizzaItem.list")
@ViewDescriptor(path = "pizza-item-list-view.xml")
@LookupComponent("pizzaItemsDataGrid")
@DialogMode(width = "64em")
public class PizzaItemListView extends StandardListView<PizzaItem> {
}