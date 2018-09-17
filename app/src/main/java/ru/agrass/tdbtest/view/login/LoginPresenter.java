package ru.agrass.tdbtest.view.login;

import android.util.Log;

import com.google.gson.Gson;

import io.reactivex.disposables.Disposable;
import ru.agrass.tdbtest.model.network.reponses.base.BaseResponse;
import ru.agrass.tdbtest.model.network.reponses.base.Types;
import ru.agrass.tdbtest.model.network.requsts.TKBRequest;
import ru.agrass.tdbtest.model.network.socket.RxWebSocket;
import ru.agrass.tdbtest.view.base.BasePresenter;

public class LoginPresenter<V extends  LoginView> extends BasePresenter<V> implements ILoginPresenter<V> {

    private static final String TAG = LoginPresenter.class.getSimpleName();
    private Disposable onTextMessageDisposable;
    private RxWebSocket socket;

    public LoginPresenter() {
        socket = new RxWebSocket();
        socket.connect();
        onTextMessageDisposable = socket.onTextMessage()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(socketMessageEvent -> {
                    if(socketMessageEvent.isText()) {
                        messageHandler(socketMessageEvent.getText());
                        return;
                    }
                    Log.e(TAG, "Server answer isn't text");
                });
        getCompositeDisposable().add(onTextMessageDisposable);
    }

    @Override
    public void messageHandler(String message) {
        Log.d(TAG, "Message: " + message);

        if (message == null) {
            Log.e(TAG, "Message null");
            return;
        }
        
        BaseResponse baseResponse = new Gson().fromJson(message, BaseResponse.class);

        if (baseResponse == null || baseResponse.getType() == null) {
            Log.e(TAG, "Bad response: " + message);
            return;
        }

        switch (baseResponse.getType()) {
            case Types.Auth_Operation: {
                checkAuth(baseResponse);
                break;
            }
            case Types.Confirm_Operation: {
                confirmOperation(baseResponse);
                break;
            }
            case Types.RequireAction: {
                requireAction(baseResponse);
                break;
            }
        }
    }

    private void checkAuth(BaseResponse baseResponse) {
        if (baseResponse.getPayload().getSecurityToken() != null) {
            sendSMSCode();
            return;
        }
        getView().showMessage("Invalid password!");
    }

    private void sendSMSCode() {
        socket.sendMessage(TKBRequest.getSendSMSRequest())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe();
        getView().showSMSDialog();
    }

    private void confirmOperation(BaseResponse response) {
        if (response.getPayload().isResultOk()) {
            getView().redirect();
            return;
        }

        if (response.getPayload().isResultCancel()) {
            getView().showMessage("Invalid Code!");
        }

    }

    private void requireAction(BaseResponse baseResponse) {
        if (baseResponse.getPayload().getActionType().equals(Types.ProofBySMS)) {
            sendSMSCode();
            return;
        }
        getView().showMessage("Some error");
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        socket.close()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe();
        getCompositeDisposable().clear();
    }

    @Override
    public void logIn(String login, String password) {
        Log.d(TAG, "Send LoginRequest");
        socket.sendMessage(TKBRequest.getLoginRequest())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe();
    }

    @Override
    public void checkSMSCode(String code) {
        socket.sendMessage(TKBRequest.getCheckSMSCodeRequest())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe();
    }
}
