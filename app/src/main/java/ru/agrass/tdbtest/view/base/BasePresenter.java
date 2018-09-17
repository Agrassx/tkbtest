package ru.agrass.tdbtest.view.base;


import io.reactivex.disposables.CompositeDisposable;
import ru.agrass.tdbtest.model.network.socket.WebSocketClient;
import ru.agrass.tdbtest.util.rx.AppSchedulerProvider;
import ru.agrass.tdbtest.util.rx.SchedulerProvider;

public abstract class BasePresenter<V extends IView> implements IPresenter<V> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final SchedulerProvider schedulerProvider = new AppSchedulerProvider();
    private final WebSocketClient client = new WebSocketClient();
    private V view;

    protected BasePresenter() { }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    protected SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    protected WebSocketClient getNetworkClient() {
        return client;
    }

    public V getView() {
        return view;
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
        this.compositeDisposable.dispose();
    }

}
