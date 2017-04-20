package com.meng.demo2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.id;

/**
 * Created by Administrator on 2017/4/20.
 */

public class Fragment1 extends Fragment {

    private View v;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioGroup rg;
    private RadioGroup rg2;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;

    private boolean isRG1 = true;

    private int curSelectId;

    private RadioGroup.OnCheckedChangeListener rgCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

            isRG1 = true;
            switch (checkedId) {
                case R.id.rb1:
                    rb1.setTextColor(Color.RED);
                    rb2.setTextColor(Color.BLACK);
                    rb3.setTextColor(Color.BLACK);
                    break;
                case R.id.rb2:
                    rb2.setTextColor(Color.RED);
                    rb1.setTextColor(Color.BLACK);
                    rb3.setTextColor(Color.BLACK);
                    break;
                case R.id.rb3:
                    rb3.setTextColor(Color.RED);
                    rb1.setTextColor(Color.BLACK);
                    rb2.setTextColor(Color.BLACK);
                    break;
            }
//            switchRbAndFontColor(isRG1);
            curSelectId = rg2.getCheckedRadioButtonId();
        }
    };

    private RadioGroup.OnCheckedChangeListener rg2CheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

            isRG1 = false;
            switch (checkedId) {
                case R.id.rb4:
                    rb4.setTextColor(Color.RED);
                    rb5.setTextColor(Color.BLACK);
                    rb6.setTextColor(Color.BLACK);
                    break;
                case R.id.rb5:
                    rb5.setTextColor(Color.RED);
                    rb4.setTextColor(Color.BLACK);
                    rb6.setTextColor(Color.BLACK);
                    break;
                case R.id.rb6:
                    rb6.setTextColor(Color.RED);
                    rb4.setTextColor(Color.BLACK);
                    rb5.setTextColor(Color.BLACK);
                    break;
            }
//            switchRbAndFontColor(isRG1);
            curSelectId = rg.getCheckedRadioButtonId();
        }
    };

    private Button btn;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.custom_layout, null);
        mContext = getActivity();
        initUI();
        return v;
    }

    private void initUI() {
        rg = (RadioGroup) v.findViewById(R.id.rg);
        rb1 = (RadioButton) v.findViewById(R.id.rb1);
        rb2 = (RadioButton) v.findViewById(R.id.rb2);
        rb3 = (RadioButton) v.findViewById(R.id.rb3);

        rg2 = (RadioGroup) v.findViewById(R.id.rg2);
        rb4 = (RadioButton) v.findViewById(R.id.rb4);
        rb5 = (RadioButton) v.findViewById(R.id.rb5);
        rb6 = (RadioButton) v.findViewById(R.id.rb6);

        btn = (Button) v.findViewById(R.id.btn);

        rg.setOnCheckedChangeListener(rgCheckedChangeListener);
        rg2.setOnCheckedChangeListener(rg2CheckedChangeListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                if(isRG1){
                    RadioButton rb = getRbBtn(rg.getCheckedRadioButtonId());
                    if(rb != null){
                        s = rb.getText().toString();
                    }
                }else{
                    RadioButton rb = getRbBtn(rg2.getCheckedRadioButtonId());
                    if(rb != null){
                        s = rb.getText().toString();
                    }
                }
                Toast.makeText(mContext, "选中rb的内容是："+s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private RadioButton getRbBtn(int checkedRadioButtonId) {
        switch (checkedRadioButtonId){
            case R.id.rb1:
                return rb1;
            case R.id.rb2:
                return rb2;
            case R.id.rb3:
                return rb3;
            case R.id.rb4:
                return rb4;
            case R.id.rb5:
                return rb5;
            case R.id.rb6:
                return rb6;
        }
        return null;
    }

    private void switchRbAndFontColor(boolean isRG1) {
        if(isRG1){
            rb4.setTextColor(Color.BLACK);
            rb5.setTextColor(Color.BLACK);
            rb6.setTextColor(Color.BLACK);
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
        }else{
            rb1.setTextColor(Color.BLACK);
            rb2.setTextColor(Color.BLACK);
            rb3.setTextColor(Color.BLACK);
            rb4.setChecked(false);
            rb5.setChecked(false);
            rb6.setChecked(false);
        }
    }
}
