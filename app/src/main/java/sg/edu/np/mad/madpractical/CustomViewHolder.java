package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView txtTitle;
    TextView txtDesc;
    ImageView img;
    public CustomViewHolder(View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.recyclerName);
        txtDesc = itemView.findViewById(R.id.recyclerDesc);
        img = itemView.findViewById(R.id.img_profile);
    }
}
