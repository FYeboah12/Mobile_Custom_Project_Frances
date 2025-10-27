package com.yeboahfrances.sightreadingmadeeasy;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.Vibrator;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class TrebleClef extends Fragment {
    private int[] notes = {R.drawable.treble_staff,R.drawable.treble_staff__2_,R.drawable.treble_staff__3_,R.drawable.treble_staff__4_,R.drawable.treble_staff__5_,R.drawable.treble_staff__6_,R.drawable.treble_staff__7_,R.drawable.treble_staff__8_,R.drawable.treble_staff__9_,R.drawable.treble_staff__10_,R.drawable.treble_staff__11_};
    private String[] note_names = {"D","E","F","G","A","B","C","D","E","F","G"};
    int count = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //use view.getContext() instead of this
        View view = inflater.inflate(R.layout.fragment_treble_clef, container, false);
        ImageView imgs = view.findViewById(R.id.note_imgs);
        imgs.setImageDrawable(getResources().getDrawable(notes[0]));
        Button next = view.findViewById(R.id.next);
        Button submit = view.findViewById(R.id.submit);
        EditText editText = view.findViewById(R.id.answer);
        TextView response = view.findViewById(R.id.correct);
        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.note);
        Spinner dropdown = view.findViewById(R.id.inst_dropdown);
        String[] instruments = new String[]{"Piano","Clarinet","Bass Clarinet", "Trumpet", "Saxophone", "Violin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, instruments);
        dropdown.setAdapter(adapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                String answer = editText.getText().toString();
                if(answer.toUpperCase().equals(note_names[count-1])) {
                    response.setText("✨✨Correct!✨✨");
                    response.setTextSize(20);
                    response.setTextColor(getResources().getColor(R.color.correct));
                    mediaPlayer.start(); // this plays piano; get all the notes
                    //show instrument
                }
                else{
                    response.setText("Incorrect!");
                    response.setTextSize(20);
                    response.setTextColor(getResources().getColor(R.color.incorrect));
                    view.performHapticFeedback(HapticFeedbackConstants.REJECT);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count >= notes.length) count %= notes.length;
                Drawable d = getResources().getDrawable(notes[count]);
                imgs.setImageDrawable(d);
                count++;
            }
        }); //IT WORKS LESGO just change the size

        // dropdown.setOnItemSelectedListener(view.getContext());

        return view;
    }

}
