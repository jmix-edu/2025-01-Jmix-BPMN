package com.company.jmixbpmdemo.view.pizzaitem;

import com.company.jmixbpmdemo.entity.PizzaItem;
import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "pizzaItems/:id", layout = MainView.class)
@ViewController(id = "PizzaItem.detail")
@ViewDescriptor(path = "pizza-item-detail-view.xml")
@EditedEntityContainer("pizzaItemDc")
public class PizzaItemDetailView extends StandardDetailView<PizzaItem> {
}