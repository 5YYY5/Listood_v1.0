package com.example.listood_v10.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listood_v10.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Reminders extends RecyclerView.Adapter<Adapter_Reminders.ViewHolder>{

    public final LayoutInflater inflater;
    public final List<Reminders> reminders;

    public Adapter_Reminders(Context context, ArrayList<Reminders> reminders) {
        this.reminders = reminders;
        this.inflater = LayoutInflater.from(context);
    }


    //создание viewholder
    //inflater позволяет переводить java-объекты из xml
    //возвращает объект ViewHolder, который будет хранить данные по одному объекту Days.
    @Override
    public Adapter_Reminders.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.adapter_reminders_layout, parent, false);
        return new ViewHolder(view);


    }

    //поставление новых значений
    //выполняет привязку объекта ViewHolder к объекту Days по определенной позиции.
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(Adapter_Reminders.ViewHolder holder, int position) {
        Reminders reminder = reminders.get(position);
        holder.reminderView.setText(reminder.getReminder());
//        holder.itemView.setBackgroundColor(R.color.blue4);
    }

    //возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return reminders.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView reminderView;

        ViewHolder(View view){
            super(view);
            reminderView = view.findViewById(R.id.tasks_adapterrem);
            //нажатие на элемент recyclerview
            view.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {

//                    view.setBackgroundColor(R.color.blue4_80);
                }
            });
        }
    }

}
