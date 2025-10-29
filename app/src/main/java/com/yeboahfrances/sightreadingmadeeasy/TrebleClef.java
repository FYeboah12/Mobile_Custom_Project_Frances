package com.yeboahfrances.sightreadingmadeeasy;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

public class TrebleClef extends Fragment implements AdapterView.OnItemSelectedListener{
    private final int[] notes = {R.drawable.treble_staff_o1,R.drawable.treble_staff_o2,R.drawable.treble_staff_o3,R.drawable.treble_staff_o4,R.drawable.treble_staff_o5,R.drawable.treble_staff_o6,R.drawable.treble_staff,R.drawable.treble_staff__2_,R.drawable.treble_staff__3_,R.drawable.treble_staff__4_,R.drawable.treble_staff__5_,R.drawable.treble_staff__6_,R.drawable.treble_staff__7_,R.drawable.treble_staff__8_,R.drawable.treble_staff__9_,R.drawable.treble_staff__10_,R.drawable.treble_staff__11_,R.drawable.treble_staff_o7,R.drawable.treble_staff_o8,R.drawable.treble_staff_o9,R.drawable.treble_staff_o10,R.drawable.treble_staff_o11,R.drawable.treble_staff_o12,R.drawable.treble_staff_o13,};
    private final String[] note_names = {"E","F","G","A","B","C","D","E","F","G","A","B","C","D","E","F","G","A","B","C","D","E","F","G"};
    int count = 1;
    boolean play = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //use view.getContext() instead of this
        View view = inflater.inflate(R.layout.fragment_treble_clef, container, false);
        MediaPlayer pianoA = MediaPlayer.create(view.getContext(), R.raw.treb_piano_a);
        MediaPlayer pianoB = MediaPlayer.create(view.getContext(), R.raw.treb_piano_b);
        MediaPlayer pianoC = MediaPlayer.create(view.getContext(), R.raw.treb_piano_c);
        MediaPlayer pianoD = MediaPlayer.create(view.getContext(), R.raw.treb_piano_d);
        MediaPlayer pianoE = MediaPlayer.create(view.getContext(), R.raw.treb_piano_e);
        MediaPlayer pianoF = MediaPlayer.create(view.getContext(), R.raw.treb_piano_f);
        MediaPlayer pianoG = MediaPlayer.create(view.getContext(), R.raw.treb_piano_g);
        ImageView imgs = view.findViewById(R.id.note_imgs);
        imgs.setImageDrawable(getResources().getDrawable(notes[0]));
        Button next = view.findViewById(R.id.next);
        Button submit = view.findViewById(R.id.submit);
        EditText editText = view.findViewById(R.id.answer);
        TextView response = view.findViewById(R.id.correct);
        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.note);
        Spinner dropdown = view.findViewById(R.id.inst_dropdown);
        String[] instruments = new String[]{"Piano","Clarinet","Violin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, instruments);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
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

        //audio format: treble-inst-A, treble-inst-B, treble-inst-C

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view != null){
        MediaPlayer pianoA = MediaPlayer.create(view.getContext(), R.raw.treb_piano_a);
        MediaPlayer pianoB = MediaPlayer.create(view.getContext(), R.raw.treb_piano_b);
        MediaPlayer pianoC = MediaPlayer.create(view.getContext(), R.raw.treb_piano_c);
        MediaPlayer pianoD = MediaPlayer.create(view.getContext(), R.raw.treb_piano_d);
        MediaPlayer pianoE = MediaPlayer.create(view.getContext(), R.raw.treb_piano_e);
        MediaPlayer pianoF = MediaPlayer.create(view.getContext(), R.raw.treb_piano_f);
        MediaPlayer pianoG = MediaPlayer.create(view.getContext(), R.raw.treb_piano_g);
        MediaPlayer bassClarinetA = MediaPlayer.create(view.getContext(), R.raw.treb_bc_a);
        MediaPlayer bassClarinetB = MediaPlayer.create(view.getContext(), R.raw.treb_bc_b);
        MediaPlayer bassClarinetC = MediaPlayer.create(view.getContext(), R.raw.treb_bc_c);
        MediaPlayer bassClarinetD = MediaPlayer.create(view.getContext(), R.raw.treb_bc_d);
        MediaPlayer bassClarinetE = MediaPlayer.create(view.getContext(), R.raw.treb_bc_e);
        MediaPlayer bassClarinetF = MediaPlayer.create(view.getContext(), R.raw.treb_bc_f);
        MediaPlayer bassClarinetG = MediaPlayer.create(view.getContext(), R.raw.treb_bc_g);
        MediaPlayer violinA = MediaPlayer.create(view.getContext(), R.raw.treb_v_a);
        MediaPlayer violinB = MediaPlayer.create(view.getContext(), R.raw.treb_v_b);
        MediaPlayer violinC = MediaPlayer.create(view.getContext(), R.raw.treb_v_c);
        MediaPlayer violinD = MediaPlayer.create(view.getContext(), R.raw.treb_v_d);
        MediaPlayer violinE = MediaPlayer.create(view.getContext(), R.raw.treb_v_e);
        MediaPlayer violinF = MediaPlayer.create(view.getContext(), R.raw.treb_v_f);
        MediaPlayer violinG = MediaPlayer.create(view.getContext(), R.raw.treb_v_g);
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
                    if (note_names[count].equals("A"))
                        bassClarinetA.start();
                    if (note_names[count].equals("B"))
                        bassClarinetB.start();
                    if (note_names[count].equals("C"))
                        bassClarinetC.start();
                    if (note_names[count].equals("D"))
                        bassClarinetD.start();
                    if (note_names[count].equals("E"))
                        bassClarinetE.start();
                    if (note_names[count].equals("F"))
                        bassClarinetF.start();
                    if (note_names[count].equals("G"))
                        bassClarinetG.start();
                    break;
                case 2:
                    if (note_names[count].equals("A"))
                        violinA.start();
                    if (note_names[count].equals("B"))
                        violinB.start();
                    if (note_names[count].equals("C"))
                        violinC.start();
                    if (note_names[count].equals("D"))
                        violinD.start();
                    if (note_names[count].equals("E"))
                        violinE.start();
                    if (note_names[count].equals("F"))
                        violinF.start();
                    if (note_names[count].equals("G"))
                        violinG.start();
                    break;

                }

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
