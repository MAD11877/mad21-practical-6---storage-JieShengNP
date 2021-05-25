package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdaptor extends RecyclerView.Adapter<CustomViewHolder>{
    ArrayList<User> data;

    public CustomAdaptor(ArrayList<User> input){
        data = input;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;

        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.recyclerview2,
                    parent,
                    false
            );
        } else {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.recyclerview1,
                    parent,
                    false
            );
        }
        return new CustomViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(data.get(position).name.substring(data.get(position).name.length()-1));
    }

    public void onBindViewHolder(CustomViewHolder holder, int position) {
        User u = data.get(position);
        holder.txtTitle.setText(u.name);
        holder.txtDesc.setText(u.description);


        holder.img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(holder.img.getContext())
                        .setTitle("Profile")
                        .setMessage(u.name)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(holder.img.getContext(), MainActivity.class);
                                viewProfile.putExtra("id", position);
                                holder.img.getContext().startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();

            }
        });
    }

    public int getItemCount() {
        return data.size();
    }
}
