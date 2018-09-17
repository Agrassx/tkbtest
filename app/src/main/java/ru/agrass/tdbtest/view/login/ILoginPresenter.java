package ru.agrass.tdbtest.view.login;

import ru.agrass.tdbtest.view.base.IPresenter;

public interface ILoginPresenter<V extends LoginView> extends IPresenter<V> {

    void logIn(String login, String password);
    void checkSMSCode(String code);

}
