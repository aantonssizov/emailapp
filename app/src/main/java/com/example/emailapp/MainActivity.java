package com.example.emailapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmailAdapter.EmailItemClicked {
    private static final String EMAIL_ITEM = "email_item";
    private List<EmailItem> data = generateData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load our Recycler View
        RecyclerView ribbonOfEmailsRv = findViewById(R.id.ribbon_of_emails_rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ribbonOfEmailsRv.setLayoutManager(layoutManager);

        RecyclerView.Adapter ribbonOfEmailsAdapter = new EmailAdapter(this, data, this);
        ribbonOfEmailsRv.setAdapter(ribbonOfEmailsAdapter);

        FloatingActionButton createMessageFab = findViewById(R.id.create_message_fab);
        createMessageFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateMessageActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<EmailItem> generateData() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("https://diylogodesigns.com/wp-content/uploads/2016/04/Microsoft-Logo-icon-png-Transparent-Background-768x768.png", "Microsoft", "Your free trial has ended", "Your free trial has ended! You must to buy pro version.", "Feb 13"));
        list.add(new EmailItem("https://images.vexels.com/media/users/3/129234/isolated/preview/73970c892d748c7507db8e10d71535b0-apple-logo-icon-by-vexels.png", "Apple", "You need to upgrade your iphone", "You need to upgrade your iphone, just install new ios 12.1.8", "Jan 4"));
        list.add(new EmailItem("https://cdn.macrumors.com/article-new/2017/02/google_logo1600-250x250.jpg", "Google", "Do you want to watch your usage statics?", "Do you want to watch your usage statics? We was collected your usage statics for last month.", "Dec 23"));
        list.add(new EmailItem("https://www.morphosys.com/sites/default/files/images/teaser/twitter-front-new.png", "Twitter", "New post in \"Cooking masters\".", "New post in \"Cooking masters\". How to cook an apple pie.", "Nov 17"));
        list.add(new EmailItem("https://image.spreadshirtmedia.com/image-server/v1/mp/products/T812A231MPA3140PT17X98Y45D1011817582S20/views/1,width=800,height=800,appearanceId=39,backgroundColor=F2F2F2,modelId=115,crop=detail,version=1543820067/white-logo-transparent-background-men-s-premium-t-shirt.jpg", "Joe Smith", "Meeting", "Hi. Can we meet in saturday?", "Feb 15"));
        list.add(new EmailItem("https://nalacat.com/wp-content/uploads/2016/03/cat.png", "Cat store", "Sale of feed", "Tomorrow, we started sale of feed. So lets quickly to buy ou feed.", "Oct 1"));
        list.add(new EmailItem("https://cdn.pixabay.com/photo/2012/04/23/16/18/maple-leaf-38777_960_720.png", "Canada", "Salaries", "Today we was improve salaries for all by 200 canadian dollars.", "Aug 3"));
        list.add(new EmailItem("https://cdn3.iconfinder.com/data/icons/line/36/plane-512.png", "Travel company", "You was won the travel to Spain.", "You was won the travel to Spain. Tell us about details", "Feb 7"));
        list.add(new EmailItem("https://www.freepnglogos.com/uploads/car-logo-clip-art-4.png", "Car", "Update your auto system!", "Update your auto system! We was published new auto version 2.6.4!", "Oct 17"));
        return list;
    }

    @Override
    public void ItemClickedCallback(int itemPosition) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EMAIL_ITEM, data.get(itemPosition));
        startActivity(intent);
    }
}
