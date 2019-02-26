package com.example.intent_1_mubs;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondViewHolder> {
    Context context;

    String[] arraySecondName = {"GORIDE", "GOCAR", "GOFOOD", "GOSEND", "GOBOX", "GOTIX"};
    int[] arraySecondImage = {R.drawable.goride, R.drawable.gocar, R.drawable.gofood, R.drawable.gosend, R.drawable.gobox, R.drawable.gotix};
    String[] arrayEmailServices = {"goride@gmail.com","gocar@gmail.com","gofood@gmail.com","gosend@gmail.com","gobox@gmail.com","gotix@gmail.com"};
    int[] arrayPhoneServices = {32984, 78432, 90456, 80567, 25361, 76234};
    String[] arrayWebServices = {"https://www.go-jek.com/go-ride/", "https://www.go-jek.com/go-car/", "https://www.go-jek.com/go-food/", "https://www.go-jek.com/go-send/", "https://www.go-jek.com/go-box/", "https://www.go-jek.com/go-tix/"};


    public SecondAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SecondViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.tampilan_second, viewGroup, false );
        return new SecondViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull SecondViewHolder secondViewHolder, final int i) {
        secondViewHolder.tvSecond.setText( arraySecondName[i] );
        secondViewHolder.imgSecond.setImageResource( arraySecondImage[i] );
        secondViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context, DetailActivity.class );
                intent.putExtra( "name", arraySecondName[i] );
                intent.putExtra( "image",arraySecondImage[i] );
                intent.putExtra( "services",arrayEmailServices[i] );
                intent.putExtra( "phone",arrayPhoneServices[i] );
                intent.putExtra( "web",arrayWebServices[i] );
                context.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return arraySecondImage.length;
    }

    public class SecondViewHolder extends RecyclerView.ViewHolder {
        TextView tvSecond;
        ImageView imgSecond;

        public SecondViewHolder(@NonNull View itemView) {
            super( itemView );

            tvSecond = itemView.findViewById( R.id.tv_second );
            imgSecond = itemView.findViewById( R.id.img_second );
        }
    }
}
