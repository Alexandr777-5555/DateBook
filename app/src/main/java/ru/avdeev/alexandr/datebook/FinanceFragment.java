package ru.avdeev.alexandr.datebook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/*

класс FinanceFragment будет отображать финсансы доходы/расходы

 */
public class FinanceFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.finance_fragment, container, false);

        return view;
    }
}