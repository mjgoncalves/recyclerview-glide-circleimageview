package com.example.marcelo.recyclerview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    ArrayList<String> mImageNames = new ArrayList<>();
    ArrayList<String> mImages = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> mImageNames, ArrayList<String> mImages) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // método que cria o layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, parent, false);
        //
        ViewHolder holder = new ViewHolder(view);
        return holder;

        // esse método recicla o viewholder, ele apenas coloca os itens onde eles
        // devem ficar. A estrutura é sempre a mesma para toda recyclerview.
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // esse é o método que varia dependendo do resultado que queremos
        // é o método mais importante
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(context) // pega o contexto
                .asBitmap() // informa que a gente quer o res com bitmap
                .load(mImages.get(position)) // informa de onde a imagem virá...
                .into(holder.image); // e para onde ela vai.
        holder.imageName.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + mImageNames.get(position));
                Toast.makeText(context, mImageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.circleimage);
            imageName = itemView.findViewById(R.id.imageName);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
