package com.weizhe.kobuy.constraint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.fragment.app.Fragment;

import com.weizhe.kobuy.R;

public class FlowFragment extends Fragment {

    private RadioGroup wrapModeRG;
    private Flow flow;

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
}
