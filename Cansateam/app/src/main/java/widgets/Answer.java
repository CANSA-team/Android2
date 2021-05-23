package widgets;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

import com.example.project.R;

public class Answer extends LinearLayout {
    private ImageView ansNum1;
    private ImageView ansNum2;
    private ImageView ansNum3;
    private ImageView ansNum4;
    private ViewGroup playerlayout;
    private OnClickListener onClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.isSelected()) {
                v.setSelected(false);
            } else {
                v.setSelected(true);
                int count = playerlayout.getChildCount();
                for (int i = 0; i < count; i++) {
                    if (playerlayout.getChildAt(i).getId() != v.getId()) {
                        playerlayout.getChildAt(i).setSelected(false);
                    }
                }
            }
        };
    };

    public Answer(Context context) {
        super(context);
        initialzation();
    }

    public Answer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialzation();
    }

    public Answer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialzation();
    }

    // initialzation of the control
    private void initialzation() {
        inflate(getContext(), R.layout.answer, this);
        playerlayout = (ViewGroup) getChildAt(0);
        // Get data
        ansNum1 = playerlayout.findViewById(R.id.answer_num_1);
        ansNum2 = playerlayout.findViewById(R.id.answer_num_2);
        ansNum3 = playerlayout.findViewById(R.id.answer_num_3);
        ansNum4 = playerlayout.findViewById(R.id.answer_num_4);

        // Set Event
        ansNum1.setOnClickListener(onClick);
        ansNum2.setOnClickListener(onClick);
        ansNum3.setOnClickListener(onClick);
        ansNum4.setOnClickListener(onClick);

    }

}

