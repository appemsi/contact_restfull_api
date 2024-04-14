package ma.emsi.contact_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ContactModel> list_contact;

    public ContactAdapter(Context context, ArrayList<ContactModel> list_contact) {
        this.context = context;
        this.list_contact = list_contact;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return list_contact.size();
    }
    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
     ContactModel cm=list_contact.get(position);
        holder.name.setText(cm.getName());
        holder.phone.setText(cm.getPhone());
        Uri uri=Uri.parse(cm.getImage());
        holder.profil.setImageURI(uri);
        // ajouter ce code
        holder.call.setOnClickListener(e->{
            ((MainActivity)context).makeCall(cm.getPhone());
        });}




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone;

        ImageView profil,call;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.card_name);
            phone =itemView.findViewById(R.id.card_phone);
            profil =itemView.findViewById(R.id.card_image);
            call =itemView.findViewById(R.id.card_call);
        }
    }
}
