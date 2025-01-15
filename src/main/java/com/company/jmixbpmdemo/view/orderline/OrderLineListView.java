package com.company.jmixbpmdemo.view.orderline;

import com.company.jmixbpmdemo.entity.OrderLine;
import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "orderLines", layout = MainView.class)
@ViewController(id = "OrderLine.list")
@ViewDescriptor(path = "order-line-list-view.xml")
@LookupComponent("orderLinesDataGrid")
@DialogMode(width = "64em")
public class OrderLineListView extends StandardListView<OrderLine> {
}