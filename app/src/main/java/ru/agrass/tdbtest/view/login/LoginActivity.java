package ru.agrass.tdbtest.view.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ru.agrass.tdbtest.R;
import ru.agrass.tdbtest.view.login.smsdialog.SMSDialog;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private Unbinder unbinder;
    private LoginPresenter<LoginView> presenter;

    @BindView(R.id.login_user_id)
    EditText loginEditText;
    @BindView(R.id.login_password)
    EditText passwordEditText;
    @BindView(R.id.login_sign_in_button)
    Button signInButton;
    @BindView(R.id.login_progress)
    ProgressBar progressBar;
    @BindView(R.id.loginView)
    LinearLayout loginView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        presenter = new LoginPresenter<>();
        presenter.onAttach(this);
        loginEditText.setText("best1");
        passwordEditText.setText("123456");
    }


    @OnClick(R.id.login_sign_in_button)
    void onLoginClick(View view) {
        presenter.logIn(loginEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
        unbinder.unbind();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void closeProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void redirect() {
        showMessage("Redirect");
    }

    @Override
    public void showSMSDialog() {
        SMSDialog smsDialog = new SMSDialog();
        smsDialog.setListener(this::checkSMSCode);
        smsDialog.show(getSupportFragmentManager(), SMSDialog.class.getSimpleName());
    }

    private void checkSMSCode(String code) {
        presenter.checkSMSCode(code);
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(loginView, message, Snackbar.LENGTH_SHORT).show();
    }
}
