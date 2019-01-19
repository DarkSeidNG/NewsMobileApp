package com.tvcnews.app.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tvcnews.app.R;
import com.tvcnews.app.util.GetDeviceMetrics;

/**
 * The type Contact us.
 */
public class ContactUs extends DialogFragment {

    /**
     * The Name.
     */
    EditText name, /**
     * The Email.
     */
    email, /**
     * The Msg.
     */
    msg;
    /**
     * The Cancel.
     */
    Button cancel, /**
     * The Send.
     */
    send;
    /**
     * The Msg cont.
     */
    LinearLayout msgCont;
    /**
     * The Msg sent.
     */
    TextView msgSent;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = (EditText) view.findViewById(R.id.name);
        email = (EditText) view.findViewById(R.id.email);
        msg = (EditText) view.findViewById(R.id.message);

        cancel = (Button)view.findViewById(R.id.cancel);
        send = (Button)view.findViewById(R.id.send);

        msgCont = (LinearLayout)view.findViewById(R.id.msgCont);
        msgSent = (TextView)view.findViewById(R.id.msgSentText);

        cancel.setOnClickListener(mBtnClickListener);
        send.setOnClickListener(mBtnClickListener);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_contact_us, container, false);
    }

    private View.OnClickListener mBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cancel:
                    dismiss();
                    break;
                case R.id.send:
                    SendMessageToSupport();
                    break;
            }
        }
    };

    private void SendMessageToSupport(){
        //we'll send the data to a web handler here
        msgCont.setVisibility(View.GONE);
        msgSent.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStart(){
        super.onStart();
        Dialog dialog = getDialog();
        if(dialog!=null){
            WindowManager.LayoutParams param = dialog.getWindow().getAttributes();
            param.width = (int)(new GetDeviceMetrics(getActivity()).getMetrics().widthPixels*0.86);
            dialog.getWindow().setAttributes(param);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        }
    }
}
