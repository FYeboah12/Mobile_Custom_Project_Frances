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
import android.widget.AdapterView;
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

public class AltoClef extends Fragment{
    private final int[] notes = {R.drawable.alto_staff__16_,R.drawable.alto_staff__15_,R.drawable.alto_staff__14_,R.drawable.alto_staff__13_,R.drawable.alto_staff__12_,R.drawable.alto_staff,R.drawable.alto_staff__2_,R.drawable.alto_staff__3_,R.drawable.alto_staff__4_,R.drawable.alto_staff__5_,R.drawable.alto_staff__6_,R.drawable.alto_staff__7_,R.drawable.alto_staff__8_,R.drawable.alto_staff__9_,R.drawable.alto_staff__10_,R.drawable.alto_staff__11_,R.drawable.alto_staff__17_,R.drawable.alto_staff__18_,R.drawable.alto_staff__19_,R.drawable.alto_staff__20_,R.drawable.alto_staff__21_,R.drawable.bass_staff__22_};

    private final String[] note_names = {"G","A","B","C","D","E","F","G","A","B","C","D","E","F","G","A","B","C","D","E","F"};
    int count = 1;
    boolean play = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //use view.getContext() instead of this
        View view = inflater.inflate(R.layout.fragment_alto_clef, container, false);
        //if view is not null
        MediaPlayer violaA = MediaPlayer.create(view.getContext(), R.raw.alto_viola_a);
        MediaPlayer violaB = MediaPlayer.create(view.getContext(), R.raw.alto_viola_b);
        MediaPlayer violaC = MediaPlayer.create(view.getContext(), R.raw.alto_viola_c);
        MediaPlayer violaD = MediaPlayer.create(view.getContext(), R.raw.alto_viola_d);
        MediaPlayer violaE = MediaPlayer.create(view.getContext(), R.raw.alto_viola_e);
        MediaPlayer violaF = MediaPlayer.create(view.getContext(), R.raw.alto_viola_f);
        MediaPlayer violaG = MediaPlayer.create(view.getContext(), R.raw.alto_viola_g);
        ImageView imgs = view.findViewById(R.id.note_imgs);
        imgs.setImageDrawable(getResources().getDrawable(notes[0]));
        Button next = view.findViewById(R.id.next);
        Button submit = view.findViewById(R.id.submit);
        EditText editText = view.findViewById(R.id.answer);
        TextView response = view.findViewById(R.id.correct);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                String answer = editText.getText().toString();
                if(answer.toUpperCase().equals(note_names[count-1])) {
                    play = true;
                    response.setText("✨✨Correct!✨✨");
                    response.setTextSize(20);
                    response.setTextColor(getResources().getColor(R.color.correct));
                    if (note_names[count].equals("A"))
                        violaA.start();
                    if (note_names[count].equals("B"))
                        violaB.start();
                    if (note_names[count].equals("C"))
                        violaC.start();
                    if (note_names[count].equals("D"))
                        violaD.start();
                    if (note_names[count].equals("E"))
                        violaE.start();
                    if (note_names[count].equals("F"))
                        violaF.start();
                    if (note_names[count].equals("G"))
                        violaG.start();
                }
                else{
                    play = false;
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
                play = false;
                imgs.setImageDrawable(d);
                count++;
            }
        }); //everything works, change size in xml, add images, add all notes!

        //audio format: alto-inst-A, alto-inst-B, alto-inst-C

        return view;
    }
}
