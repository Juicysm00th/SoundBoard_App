package com.example.soundboardapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PresetButtonFragment extends Fragment {
    MediaPlayer player;
    Sound[] presetSounds;
    private ScrollView presetScrollView;
    private TableLayout layout;
    private List<TableRow> rowList;
    private Context context;
    public PresetButtonFragment() {
    }
//TODO 1. create a array of the Sound class 2. create for loop to populate fragment with preset buttons
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preset_button, container, false);
        context = view.getContext();
        layout = (TableLayout) view.findViewById(R.id.fragment_layout);
        presetScrollView = (ScrollView) view.findViewById(R.id.preset_scroll_view);
        rowList = new ArrayList<>();
        player = new MediaPlayer();
        fillPresets();
        return view;
    }

    private void fillPresets() {
        presetSounds = new Sound[SoundDB.sound_names.length];
        for(int i = 0; i < presetSounds.length - 1; i++)
        {
            /*if(i % 4 == 0)
            {
                TableRow row = new TableRow(context);
                rowList.add(row);
                row.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
                layout.addView(row);
            }*/
           final Sound preset = new Sound(SoundDB.sound_names[i],SoundDB.sound_file[i]);
           presetSounds[i] = preset;
            Button button = new Button(context);
            //button.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            button.setText(presetSounds[i].getSoundName());
            /*int pos = 0;
            for(int j; j < presetSounds[i].getSoundName().length();j++)
            {
                if(j % 10 == 0){
                    presetSounds[i].getSoundName().charAt(j)
                }
            }
             */
            button.setBackgroundResource(R.drawable.soundboardbuttons);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    player.stop();
                    player = MediaPlayer.create(context, preset.getSoundFile() );
                    player.start();
                }
            });
            //rowList.get(i/4).addView(button);
            layout.addView(button);
        }
    }
}