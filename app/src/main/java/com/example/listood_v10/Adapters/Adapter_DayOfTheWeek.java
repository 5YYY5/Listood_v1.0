package com.example.listood_v10.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listood_v10.R;

import java.util.List;

public class Adapter_DayOfTheWeek extends RecyclerView.Adapter<Adapter_DayOfTheWeek.ViewHolder>{

    public final LayoutInflater inflater;
    public final List<Day_Of_The_Week> days;

    public Adapter_DayOfTheWeek(Context context, List<Day_Of_The_Week> days) {
        this.days = days;
        this.inflater = LayoutInflater.from(context);
    }


    //создание viewholder
    //inflater позволяет переводить java-объекты из xml
    //возвращает объект ViewHolder, который будет хранить данные по одному объекту Days.
    @Override
    public Adapter_DayOfTheWeek.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.adapter_dayoftheweek_layout, parent, false);
        return new ViewHolder(view);


    }

    //поставление новых значений
    //выполняет привязку объекта ViewHolder к объекту Days по определенной позиции.
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(Adapter_DayOfTheWeek.ViewHolder holder, int position) {
        Day_Of_The_Week day = days.get(position);
        holder.timeView.setText(day.getTime());
        holder.taskView.setText(day.getTask());
        holder.itemView.setBackgroundColor(R.color.blue4);
    }

    //возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return days.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView timeView, taskView;

        ViewHolder(View view){
            super(view);
            timeView = view.findViewById(R.id.time_adapterday);
            taskView = view.findViewById(R.id.task_adapterday);

            //нажатие на элемент recyclerview
            view.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {
                    view.setBackgroundColor(R.color.blue4_80);
                }
            });
        }
    }

}
