package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User selectedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler dbHandler = new DBHandler(this);
        Button follow_button = findViewById(R.id.btnFollow);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtDesc = findViewById(R.id.txtDescription);
        Intent receivedIntent = getIntent();
        selectedUser = dbHandler.getUsers().get(receivedIntent.getIntExtra("id", 0));
        txtName.setText(selectedUser.getName());
        txtDesc.setText(selectedUser.getDescription());
        if (selectedUser.isFollowed()){
            follow_button.setText("UNFOLLOW");
        }
        else{
            follow_button.setText("FOLLOW");
        }
        follow_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedUser.isFollowed()){
                    follow_button.setText("FOLLOW");
                    selectedUser.setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                    dbHandler.updateUser(selectedUser);
                }
                else{
                    follow_button.setText("UNFOLLOW");
                    selectedUser.setFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                    dbHandler.updateUser(selectedUser);
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("ReturnResult", selectedUser);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}