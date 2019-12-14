package softagi.e.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import softagi.e.recyclerview.Models.UserModel;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    List<UserModel> userModels;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initRecyclerView();
        initDB();
    }

    private void initDB()
    {
        userModels = new ArrayList<>();

        userModels.add(new UserModel("Abdullah", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("osama", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("yahia", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("joe", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("moustafa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("alaa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("alaa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("alaa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("alaa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("alaa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("alaa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("alaa", "01115342559", "cairo, nasr city"));
        userModels.add(new UserModel("moustafa", "01115342559", "cairo, nasr city"));
    }

    private void initRecyclerView()
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initViews()
    {
        recyclerView = findViewById(R.id.recycler);
    }

    public void loadData(View view)
    {
        userAdapter adapter = new userAdapter(userModels);
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(userModels.size() - 1);
    }

    public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder>
    {
        List<UserModel> userModels;

        userAdapter(List<UserModel> userModels)
        {
            this.userModels = userModels;
        }

        @NonNull
        @Override
        public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.user_item, parent, false);
            return new userViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull userViewHolder holder, int position)
        {
            UserModel userModel = userModels.get(position);

            String name = userModel.getName();
            String mobile = userModel.getMobile();
            String address = userModel.getAddress();

            holder.name.setText(name);
            holder.mobile.setText(mobile);
            holder.address.setText(address);

            if (userModels.size() - 1 == position)
            {
                holder.vv.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount()
        {
            return userModels.size();
        }

        class userViewHolder extends RecyclerView.ViewHolder
        {
            TextView name,mobile,address;
            View vv;

            userViewHolder(@NonNull View itemView)
            {
                super(itemView);

                name = itemView.findViewById(R.id.name_text);
                mobile = itemView.findViewById(R.id.mobile_text);
                address = itemView.findViewById(R.id.address_text);
                vv = itemView.findViewById(R.id.view_text);
            }
        }
    }
}
