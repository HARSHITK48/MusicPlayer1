package com.example.musicchalaye;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private Context context;
    private List<Songs> list;

    public SongAdapter(Context context, List<Songs> list) {
        this.context = context;
        this.list = list;


    }

    MediaPlayer mediaPlayer = new MediaPlayer();
    Uri myUri;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Songs song = list.get(position);
        holder.textArtist.setText(song.getArtists());
        holder.textName.setText(song.getSong());

        Glide.with(context)
                .load(song.getCoverimage()).override(300, 200)
                .into(holder.imageView);
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.playButton.getText().toString().equals("PLAY")) {
                    try {
                        //change play button text
                        holder.playButton.setText("STOP");

                        myUri = Uri.parse(song.getUrl());
                        mediaPlayer.reset();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.setDataSource(context.getApplicationContext(), myUri);
                        mediaPlayer.prepare();
                        mediaPlayer.start();

                    } catch (Exception e) {
                        Log.d("DebugK", "Nakkan Error ");
                        e.printStackTrace();
                    }
                } else {
                    mediaPlayer.pause();

                    //change text to play
                    holder.playButton.setText("PLAY");
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textUrl, textArtist, textCover;
        public AppCompatButton playButton;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.song_name);

            textArtist = itemView.findViewById(R.id.song_artist);

            playButton = itemView.findViewById(R.id.play_button);
            imageView=itemView.findViewById(R.id.song_image);
        }
    }
}
