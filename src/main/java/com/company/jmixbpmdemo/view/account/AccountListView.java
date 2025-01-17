package com.company.jmixbpmdemo.view.account;

import com.company.jmixbpmdemo.entity.Account;
import com.company.jmixbpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "accounts", layout = MainView.class)
@ViewController(id = "Account.list")
@ViewDescriptor(path = "account-list-view.xml")
@LookupComponent("accountsDataGrid")
@DialogMode(width = "64em")
public class AccountListView extends StandardListView<Account> {
}