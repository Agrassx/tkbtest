package ru.agrass.tdbtest.view.login;

import ru.agrass.tdbtest.view.base.IView;

public interface LoginView extends IView {

    void showProgressBar();

    void closeProgressBar();

    void redirect();

    void showSMSDialog();
}
