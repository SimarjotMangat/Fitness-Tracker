package com.example.fitness_tracker;

import android.widget.ImageView;

public class bicep {
    String heading;
    String body;
    int id;
    int btn_id;

    bicep(String head,String body,int id,int btn_id)
    {
        this.heading=head;
        this.body=body;
        this.id=id;
        this.btn_id=btn_id;


    }
    public String getHeading()
    {
        return heading;
    }
    public String getBody()
    {
        return body;
    }

    public int getId() {
        return id;
    }
    public int get_btn()
    {
        return btn_id;
    }
}
