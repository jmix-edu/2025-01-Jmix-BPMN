package com.company.jmixbpmdemo.view.servicetasksstartform;


import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.OutputVariable;
import io.jmix.bpmflowui.processform.annotation.ProcessForm;
import io.jmix.bpmflowui.processform.annotation.ProcessVariable;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outputVariables = {
        @OutputVariable(name = "greeting", type = String.class),
        @OutputVariable(name = "message", type = String.class),
        @OutputVariable(name = "numberOfUsers", type = Long.class)
})
@Route(value = "service-tasks-start-form", layout = MainView.class)
@ViewController(id = "ServiceTasksStartForm")
@ViewDescriptor(path = "service-tasks-start-form.xml")
public class ServiceTasksStartForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;
    @ProcessVariable(name = "greeting")
    @ViewComponent
    private TypedTextField<String> greetingField;
    @ProcessVariable(name = "message")
    @ViewComponent
    private TypedTextField<String> messageField;
    @ProcessVariable(name = "numberOfUsers")
    @ViewComponent
    private TypedTextField<Long> numberOfUsersField;

    @Subscribe(id = "startProcessBtn", subject = "clickListener")
    protected void onStartProcessBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.processStarting()
                .saveInjectedProcessVariables()
                .start();
        closeWithDefaultAction();
    }
}