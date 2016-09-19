package com.example.muhammadimran.newtodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Muhammad imran on 4/5/2016.
 */
public class MessageAdapter extends BaseAdapter implements ListAdapter {

    private List<Message> messages;
    private Context context;

    public MessageAdapter(List<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return messages.size();

    }

    @Override
    public Object getItem(int Pos) {
        return messages.get(Pos);


    }

    @Override
    public long getItemId(int Pos) {
        return messages.get(Pos).getId();

    }

    @Override
    public View getView(int Pos, View covertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview, null);

        TextView Tiltle = (TextView) view.findViewById(R.id.title);
        TextView Mails = (TextView) view.findViewById(R.id.messageList);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_View);

        final Message message = messages.get(Pos);
        String getTitle = message.getTitle();
        String getmails = message.getMail();


        int iconid = messages.get(Pos).isRead() ? R.drawable.btn_circle_pressed : R.drawable.btn_circle_disable_focused;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (message.isRead()) {
                    message.setRead(false);
                } else {
                    message.setRead(true);
                }
                notifyDataSetChanged();
            }

        });
        imageView.setImageResource(iconid);
        Tiltle.setText(getTitle);
        Mails.setText(getmails);
        return view;
    }
}
