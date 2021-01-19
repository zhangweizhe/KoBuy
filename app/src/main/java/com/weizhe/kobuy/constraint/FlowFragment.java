package com.weizhe.kobuy.constraint;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.internal.FlowLayout;
import com.weizhe.kobuy.R;

public class FlowFragment extends Fragment {

    private RadioGroup wrapModeRG;
    private Flow flow;
    private ConstraintLayout flowLayout;
    private EditText addTagET;
    private Button addTagBtn;
    private Button deleteTagBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flow, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wrapModeRG = view.findViewById(R.id.rg_wrap_mode);
        flow = view.findViewById(R.id.constraint_flow);
        flowLayout = view.findViewById(R.id.flow_layout);
        addTagET = view.findViewById(R.id.et_tag_content);
        addTagBtn = view.findViewById(R.id.btn_add_tag);
        deleteTagBtn = view.findViewById(R.id.btn_delete_tag);
        addTagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTag();
            }
        });
        addTagET.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && keycode == KeyEvent.KEYCODE_ENTER) {
                    addTag();
                    return true;
                }
                return false;
            }
        });
        deleteTagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeTag();
            }
        });
        wrapModeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_none:
                        // none 模式
                        flow.setWrapMode(Flow.WRAP_NONE);
                        break;
                    case R.id.rb_align:
                        // align 模式
                        flow.setWrapMode(Flow.WRAP_ALIGNED);
                        break;
                    case R.id.rb_chain:
                        // chain 模式
                        flow.setWrapMode(Flow.WRAP_CHAIN);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void addTag() {
        String tagContent = addTagET.getText().toString().trim();
        if (TextUtils.isEmpty(tagContent)) {
            return;
        }
        Button button = (Button) getLayoutInflater().inflate(R.layout.one_button, null);
        button.setText(tagContent);
        button.setId(View.generateViewId());

        flowLayout.addView(button);
        flow.addView(button);
    }

    private void removeTag() {
        View lastChild = flowLayout.getChildAt(flowLayout.getChildCount() - 1);
        if (lastChild == null) {
            return;
        }
        flowLayout.removeView(lastChild);
        flow.removeView(lastChild);
    }
}
