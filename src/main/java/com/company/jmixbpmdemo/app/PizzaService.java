package com.company.jmixbpmdemo.app;

import com.company.jmixbpmdemo.entity.PizzaItem;
import io.jmix.core.UnconstrainedDataManager;
import org.springframework.stereotype.Component;

@Component(value = "pizzaService")
public class PizzaService  {

    private final UnconstrainedDataManager unconstrainedDataManager;

    public PizzaService(UnconstrainedDataManager unconstrainedDataManager) {
        this.unconstrainedDataManager = unconstrainedDataManager;
    }

    public long changePrice(PizzaItem pizzaItem, long newPrice) {
        long oldPrice = pizzaItem.getPrice();
        pizzaItem.setPrice(newPrice);

        unconstrainedDataManager.save(pizzaItem);
        return oldPrice;
    }



}