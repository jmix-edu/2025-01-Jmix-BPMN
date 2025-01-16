package com.company.jmixbpmdemo.view.selectpizzaform;


import com.company.jmixbpmdemo.entity.PizzaItem;
import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.*;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outcomes = {
        @Outcome(id = "selected"),
        @Outcome(id = "not_hungry")
}, outputVariables = {
        @OutputVariable(name = "message", type = String.class),
        @OutputVariable(name = "pizzaItem", type = PizzaItem.class),
        @OutputVariable(name = "specialRequirements", type = String.class)
})
@Route(value = "select-pizza-form", layout = MainView.class)
@ViewController(id = "SelectPizzaForm")
@ViewDescriptor(path = "select-pizza-form.xml")
public class SelectPizzaForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;

    @ProcessVariable(name = "message")
    @ViewComponent
    private TypedTextField<String> messageField;

    @ProcessVariable(name = "pizzaItem")
    @ViewComponent
    private EntityPicker<PizzaItem> pizzaItemField;

    @ProcessVariable(name = "specialRequirements")
    @ViewComponent
    private TypedTextField<String> specialRequirementsField;

    @Subscribe(id = "selectedBtn", subject = "clickListener")
    protected void onSelectedBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("selected")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }

    @Subscribe(id = "not_hungryBtn", subject = "clickListener")
    protected void onNot_hungryBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("not_hungry")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }
}