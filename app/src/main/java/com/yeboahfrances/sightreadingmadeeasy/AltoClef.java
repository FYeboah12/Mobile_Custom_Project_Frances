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

public class AltoClef extends Fragment implements AdapterView.OnItemSelectedListener{
    private final int[] notes = {R.drawable.alto_staff,R.drawable.alto_staff__2_,R.drawable.alto_staff__3_,R.drawable.alto_staff__4_,R.drawable.alto_staff__5_,R.drawable.alto_staff__6_,R.drawable.alto_staff__7_,R.drawable.alto_staff__8_,R.drawable.alto_staff__9_,R.drawable.alto_staff__10_,R.drawable.alto_staff__11_};
    private final String[] note_names = {"E","F","G","A","B","C","D","E","F","G","A","B","C","D","E","F","G","A","B","C","D","E","F","G"};
    int count = 1;
    boolean play = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //use view.getContext() instead of this
        View view = inflater.inflate(R.layout.fragment_alto_clef, container, false);
        ImageView imgs = view.findViewById(R.id.note_imgs);
        imgs.setImageDrawable(getResources().getDrawable(notes[0]));
        Button next = view.findViewById(R.id.next);
        Button submit = view.findViewById(R.id.submit);
        EditText editText = view.findViewById(R.id.answer);
        TextView response = view.findViewById(R.id.correct);
        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.note);
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
                    mediaPlayer.start(); // this plays piano; get all the notes
                    //show instrument

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        MediaPlayer n1 = MediaPlayer.create(view.getContext(), R.raw.note);
        MediaPlayer n2 = MediaPlayer.create(view.getContext(), R.raw.note2);
        MediaPlayer n3 = MediaPlayer.create(view.getContext(), R.raw.note3);
        //switch within a switch, use notes[count] or make a new field "currentNote" and play
        MediaPlayer pianoA = MediaPlayer.create(view.getContext(), R.raw.treb_piano_a);
        MediaPlayer pianoB = MediaPlayer.create(view.getContext(), R.raw.treb_piano_b);
        MediaPlayer pianoC = MediaPlayer.create(view.getContext(), R.raw.treb_piano_c);
        MediaPlayer pianoD = MediaPlayer.create(view.getContext(), R.raw.treb_piano_d);
        MediaPlayer pianoE = MediaPlayer.create(view.getContext(), R.raw.treb_piano_e);
        MediaPlayer pianoF = MediaPlayer.create(view.getContext(), R.raw.treb_piano_f);
        MediaPlayer pianoG = MediaPlayer.create(view.getContext(), R.raw.treb_piano_g);
        MediaPlayer clarinetA;
        MediaPlayer clarinetB;
        MediaPlayer clarinetC;
        MediaPlayer clarinetD;
        MediaPlayer clarinetE;
        MediaPlayer clarinetF;
        MediaPlayer clarinetG;
        MediaPlayer violinA;
        MediaPlayer violinB;
        MediaPlayer violinC;
        MediaPlayer violinD;
        MediaPlayer violinE;
        MediaPlayer violinF;
        MediaPlayer violinG;
        if(play) {
            switch (position) {
                case 0:
                    if (note_names[count].equals("A"))
                        pianoA.start();
                    if (note_names[count].equals("B"))
                        pianoB.start();
                    if (note_names[count].equals("C"))
                        pianoC.start();
                    if (note_names[count].equals("D"))
                        pianoD.start();
                    if (note_names[count].equals("E"))
                        pianoE.start();
                    if (note_names[count].equals("F"))
                        pianoF.start();
                    if (note_names[count].equals("G"))
                        pianoG.start();
                case 1:
                    n2.start();
                    break;
                case 2:
                    n3.start();
                    break;

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
