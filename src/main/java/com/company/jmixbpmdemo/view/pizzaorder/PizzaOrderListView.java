package com.company.jmixbpmdemo.view.pizzaorder;

import com.company.jmixbpmdemo.entity.PizzaOrder;
import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "pizzaOrders", layout = MainView.class)
@ViewController(id = "PizzaOrder.list")
@ViewDescriptor(path = "pizza-order-list-view.xml")
@LookupComponent("pizzaOrdersDataGrid")
@DialogMode(width = "64em")
public class PizzaOrderListView extends StandardListView<PizzaOrder> {
}