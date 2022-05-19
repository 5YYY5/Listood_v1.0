package com.example.listood_v10.MainScreen_Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.listood_v10.R;

public class Fragment4 extends Fragment {

    Button btthem, btacc, btinstr, btsett1, btsett2;
    View rootview;
    //================================================
    private final int IDD_THEM = 0;
    private final int IDD_ACC = 1;
    private final int IDD_INSTR = 2;
    private final int IDD_SETT1 = 3;
    private final int IDD_SETT2 = 4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_4, container, false);
        //Объявляю кнопки навигационной панели======================================================
        btthem = rootview.findViewById(R.id.btthem);
        btacc = rootview.findViewById(R.id.btacc);
        btinstr = rootview.findViewById(R.id.btinstr);
        btsett1 = rootview.findViewById(R.id.btsett1);
        btsett2 = rootview.findViewById(R.id.btsett2);
        //Устанавливаю кликеры для кнопок===========================================================
        btthem.setOnClickListener(this::onClick);
        btacc.setOnClickListener(this::onClick);
        btinstr.setOnClickListener(this::onClick);
        btsett1.setOnClickListener(this::onClick);
        btsett2.setOnClickListener(this::onClick);
        //==========================================================================================
        return rootview;
    }

    public void onClick(View v) {
        Dialog dialog;
        switch (v.getId()) {
            case R.id.btthem:
                Toast.makeText(getContext(), "Темы", Toast.LENGTH_SHORT).show();
                dialog= onCreateDialog(IDD_THEM);
                break;
            case R.id.btacc:
                Toast.makeText(getContext(), "Аккаунт", Toast.LENGTH_SHORT).show();
                dialog= onCreateDialog(IDD_ACC);
                break;
            case R.id.btinstr:
                Toast.makeText(getContext(), "Инструкция", Toast.LENGTH_SHORT).show();
                dialog=onCreateDialog(IDD_INSTR);
                break;
            case R.id.btsett1:
                Toast.makeText(getContext(), "Настройка 1", Toast.LENGTH_SHORT).show();
                dialog= onCreateDialog(IDD_SETT1);
                break;
            case R.id.btsett2:
                Toast.makeText(getContext(), "Настройка 2", Toast.LENGTH_SHORT).show();
                dialog= onCreateDialog(IDD_SETT2);
                break;
            default:
                dialog=null;
                break;
        }
        dialog.show();
    }


    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDD_THEM:
                final String[] mChooseThems = { "Cиний", "Красный", "Тёмный" };
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Выберите тему")
                        .setCancelable(false)
                        // добавляем одну кнопку для закрытия диалога
                        .setNeutralButton("Назад",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        // добавляем переключатели
                        .setSingleChoiceItems(mChooseThems, -1, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int item) {
                                        Toast.makeText(getContext(), "Выбрана тема: " + mChooseThems[item], Toast.LENGTH_SHORT).show();
                                    }
                                });
                return builder.create();
            case IDD_ACC:

            case IDD_INSTR:
                builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Инструкция")
                        .setCancelable(false)
                        .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                return builder.create();
            case IDD_SETT1:
                final String[] checklanguage = { "Язык 1", "Язык 2", "Язык 3" };
                builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false)
                        // добавляем одну кнопку для закрытия диалога
                        .setNeutralButton("Назад", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        // добавляем переключатели
                        .setSingleChoiceItems(checklanguage, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                Toast.makeText(getContext(), "Выбранный язык: " + checklanguage[item], Toast.LENGTH_SHORT).show();
                            }
                        });
                return builder.create();
            case IDD_SETT2:
                boolean[] mCheckedItems = new boolean[]{false, false, false};
                final String[] checkSett = { "Настройка 1", "Настройка 2", "Настройка 3" };
                builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false)
                        .setMultiChoiceItems(checkSett, mCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        mCheckedItems[which] = isChecked;
                                    }
                                })
                        // Добавляем кнопки
                        .setPositiveButton("Готово", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        StringBuilder state = new StringBuilder();
                                        for (int i = 0; i < checkSett.length; i++) {
                                            state.append("" + checkSett[i]);
                                            if (mCheckedItems[i])
                                                state.append(" выбран\n");
                                            else
                                                state.append(" не выбран\n");
                                        }
                                        Toast.makeText(getContext(), state.toString(), Toast.LENGTH_LONG).show();
                                    }
                                })
                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                return builder.create();
            default:
                return null;
        }
    }

}