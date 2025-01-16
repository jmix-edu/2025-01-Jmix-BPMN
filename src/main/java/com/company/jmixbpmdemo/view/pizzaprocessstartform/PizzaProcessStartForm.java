package com.company.jmixbpmdemo.view.pizzaprocessstartform;


import com.company.jmixbpmdemo.entity.User;
import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.OutputVariable;
import io.jmix.bpmflowui.processform.annotation.ProcessForm;
import io.jmix.bpmflowui.processform.annotation.ProcessVariable;
import io.jmix.flowui.component.combobox.EntityComboBox;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outputVariables = {
        @OutputVariable(name = "pizzaEater", type = User.class),
        @OutputVariable(name = "message", type = String.class)
})
@Route(value = "pizza-process-start-form", layout = MainView.class)
@ViewController(id = "PizzaProcessStartForm")
@ViewDescriptor(path = "pizza-process-start-form.xml")
public class PizzaProcessStartForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;
    @ProcessVariable(name = "pizzaEater")
    @ViewComponent
    private EntityComboBox<User> pizzaEaterField;
    @ProcessVariable(name = "message")
    @ViewComponent
    private TypedTextField<String> messageField;

    @Subscribe(id = "startProcessBtn", subject = "clickListener")
    protected void onStartProcessBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.processStarting()
                .saveInjectedProcessVariables()
                .start();
        closeWithDefaultAction();
    }
}