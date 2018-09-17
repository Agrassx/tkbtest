package ru.agrass.tdbtest.view.base;

public interface IPresenter<V extends IView> {

    void messageHandler(String message);

    void onAttach(V view);

    void onDetach();

    void resume();

    void pause();

    void destroy();

}
