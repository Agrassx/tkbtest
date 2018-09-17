package ru.agrass.tdbtest.view.login.smsdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import butterknife.Unbinder;
import ru.agrass.tdbtest.R;



public class SMSDialog extends DialogFragment {

    private Unbinder unbinder;
    private OnSMSConformListener listener;

    @BindView(R.id.editTextNumber1)
    EditText number1;

    @BindView(R.id.editTextNumber2)
    EditText number2;

    @BindView(R.id.editTextNumber3)
    EditText number3;

    @BindView(R.id.editTextNumber4)
    EditText number4;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_sms_conform, null))
                .setPositiveButton(R.string.dialog_ok, (dialog, id) -> {
                    if (listener != null) {
                        listener.conformSMSCode(
                                number1.getText().toString()
                                + number2.getText().toString()
                                + number3.getText().toString()
                                + number4.getText().toString()
                        );
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, (dialog, id) -> SMSDialog.this.getDialog().cancel());
        return builder.create();
    }

    public void setListener(OnSMSConformListener listener) {
        this.listener = listener;
    }

    @Override
    public void onStart() {
        super.onStart();
        unbinder = ButterKnife.bind(this, getDialog());
        number1.requestFocus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @OnTextChanged(R.id.editTextNumber1)
    void onNumber1Changed(CharSequence text) {
        number2.requestFocus();
    }

    @OnTextChanged(R.id.editTextNumber2)
    void onNumber2Changed(CharSequence text) {
        number3.requestFocus();
    }

    @OnTextChanged(R.id.editTextNumber3)
    void onNumber3Changed(CharSequence text) {
        number4.requestFocus();
    }
}
