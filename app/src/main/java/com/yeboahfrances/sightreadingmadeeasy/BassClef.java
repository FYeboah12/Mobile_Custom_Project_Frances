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

public class BassClef extends Fragment implements AdapterView.OnItemSelectedListener{
    private final int[] notes = {R.drawable.bass_staff__16_,R.drawable.bass_staff__15_,R.drawable.bass_staff__14_,R.drawable.bass_staff__13_,R.drawable.bass_staff__12_,R.drawable.bass_staff__11_,R.drawable.bass_staff,R.drawable.bass_staff__forgot_,R.drawable.bass_staff__2_,R.drawable.bass_staff__3_,R.drawable.bass_staff__4_,R.drawable.bass_staff__5_,R.drawable.bass_staff__6_,R.drawable.bass_staff__7_,R.drawable.bass_staff__8_,R.drawable.bass_staff__9_,R.drawable.bass_staff__10_,R.drawable.bass_staff__18_,R.drawable.bass_staff__19_,R.drawable.bass_staff__20_,R.drawable.bass_staff__21_,R.drawable.bass_staff__22_,R.drawable.bass_staff__23_,R.drawable.bass_staff__24_};
    private final String[] note_names = {"F","G","A","B","C","D","E","F","G","A","B","C","D","E","F","G","A","B","C","D","E","F","G","A","B"};
    int count = 1;
    boolean play = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //use view.getContext() instead of this
        View view = inflater.inflate(R.layout.fragment_bass_clef, container, false);
        ImageView imgs = view.findViewById(R.id.note_imgs);
        imgs.setImageDrawable(getResources().getDrawable(notes[0]));
        Button next = view.findViewById(R.id.next);
        Button submit = view.findViewById(R.id.submit);
        EditText editText = view.findViewById(R.id.answer);
        TextView response = view.findViewById(R.id.correct);
        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.note);
        Spinner dropdown = view.findViewById(R.id.inst_dropdown);
        String[] instruments = new String[]{"Piano","Tuba","Trombone"};
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

        //audio format: bass-inst-A, bass-inst-B, bass-inst-C

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(view != null) {
            MediaPlayer pianoA = MediaPlayer.create(view.getContext(), R.raw.bass_piano_a);
            MediaPlayer pianoB = MediaPlayer.create(view.getContext(), R.raw.bass_piano_b);
            MediaPlayer pianoC = MediaPlayer.create(view.getContext(), R.raw.bass_piano_c);
            MediaPlayer pianoD = MediaPlayer.create(view.getContext(), R.raw.bass_piano_d);
            MediaPlayer pianoE = MediaPlayer.create(view.getContext(), R.raw.bass_piano_e);
            MediaPlayer pianoF = MediaPlayer.create(view.getContext(), R.raw.bass_piano_f);
            MediaPlayer pianoG = MediaPlayer.create(view.getContext(), R.raw.bass_piano_g);
            MediaPlayer tubaA = MediaPlayer.create(view.getContext(), R.raw.bass_tuba_a);
            MediaPlayer tubaB = MediaPlayer.create(view.getContext(), R.raw.bass_tuba_b);
            MediaPlayer tubaC = MediaPlayer.create(view.getContext(), R.raw.bass_tuba_c);
            MediaPlayer tubaD = MediaPlayer.create(view.getContext(), R.raw.bass_tuba_d);
            MediaPlayer tubaE = MediaPlayer.create(view.getContext(), R.raw.bass_tuba_e);
            MediaPlayer tubaF = MediaPlayer.create(view.getContext(), R.raw.bass_tuba_f);
            MediaPlayer tubaG = MediaPlayer.create(view.getContext(), R.raw.bass_tuba_g);
            MediaPlayer celloA = MediaPlayer.create(view.getContext(), R.raw.bass_cello_a);
            MediaPlayer celloB = MediaPlayer.create(view.getContext(), R.raw.bass_cello_b);
            MediaPlayer celloC = MediaPlayer.create(view.getContext(), R.raw.bass_cello_c);
            MediaPlayer celloD = MediaPlayer.create(view.getContext(), R.raw.bass_cello_d);
            MediaPlayer celloE = MediaPlayer.create(view.getContext(), R.raw.bass_cello_e);
            MediaPlayer celloF = MediaPlayer.create(view.getContext(), R.raw.bass_cello_f);
            MediaPlayer celloG = MediaPlayer.create(view.getContext(), R.raw.bass_cello_g);
            if (play) {
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
                            tubaA.start();
                        if (note_names[count].equals("B"))
                            tubaB.start();
                        if (note_names[count].equals("C"))
                            tubaC.start();
                        if (note_names[count].equals("D"))
                            tubaD.start();
                        if (note_names[count].equals("E"))
                            tubaE.start();
                        if (note_names[count].equals("F"))
                            tubaF.start();
                        if (note_names[count].equals("G"))
                            tubaG.start();
                        break;
                    case 2:
                        if (note_names[count].equals("A"))
                            celloA.start();
                        if (note_names[count].equals("B"))
                            celloB.start();
                        if (note_names[count].equals("C"))
                            celloC.start();
                        if (note_names[count].equals("D"))
                            celloD.start();
                        if (note_names[count].equals("E"))
                            celloE.start();
                        if (note_names[count].equals("F"))
                            celloF.start();
                        if (note_names[count].equals("G"))
                            celloG.start();
                        break;

                }

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
