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

class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> {
    Context context;


    String[] arrayFirstName = {"BukaLapak", "Tokopedia", "blibli", "Traveloka", "Gojek"};
    int[] arrayFirstImage = {R.drawable.bukalapak, R.drawable.tokopediaa, R.drawable.bliblii, R.drawable.traveloka, R.drawable.gojek};
    String[] arrayEmailStartup = {"bukalapak@gmail.com", "tokopedia@gmail.com", "blibli@gmail.com", "traveloka@gmail.com", "gojek@gmail.com"};
    int[] arrayPhoneStartup = {121434, 213324, 546768, 846564, 259485};
    String[] arrayWebStartup = {"https://www.bukalapak.com", "https://www.tokopedia.com", "https://www.blibli.com", "https://www.traveloka.com", "https://www.go-jek.com/"};


    public FirstAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.tampilan_first,viewGroup,false );
        return new FirstViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull FirstViewHolder firstViewHolder, final int i) {
firstViewHolder.tvFirst.setText( arrayFirstName[i] );
firstViewHolder.imgFirst.setImageResource( arrayFirstImage[i] );
firstViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent( context,DetailActivity.class );
        intent.putExtra( "position",i );
        intent.putExtra( "name",arrayFirstName[i] );
        intent.putExtra( "image",arrayFirstImage[i] );
        intent.putExtra( "services",arrayEmailStartup[i] );
        intent.putExtra( "phone",arrayPhoneStartup[i] );
        intent.putExtra( "web",arrayWebStartup[i] );
        context.startActivity( intent );
    }
} );
    }

    @Override
    public int getItemCount() {
        return arrayFirstImage.length;
    }

    public class FirstViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirst;
        ImageView imgFirst;

        public FirstViewHolder(@NonNull View itemView) {
            super( itemView );

            tvFirst = itemView.findViewById( R.id.tv_first );
            imgFirst = itemView.findViewById( R.id.img_first );
        }
    }
}
