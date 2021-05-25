package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity{
    static ArrayList<User> userList;
    RecyclerView recyclerView;
    DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        dbHandler.deleteDatabase(this);
        for (int i = 0; i < 20; i++){
            User newUser = new User();
            newUser.setName("Name " + (new Random().nextInt() & Integer.MAX_VALUE));
            newUser.setDescription("Description " + (new Random().nextInt() & Integer.MAX_VALUE));
            newUser.setFollowed(new Random().nextBoolean());
            newUser.setId(i);
            dbHandler.addUser(newUser);
        }
        userList = dbHandler.getUsers();
        recyclerView = findViewById(R.id.rv);
        CustomAdaptor customAdaptor = new CustomAdaptor(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(customAdaptor);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}