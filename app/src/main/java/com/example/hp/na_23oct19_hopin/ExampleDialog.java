package com.example.hp.na_23oct19_hopin;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.na_23oct19_hopin.R;

public class ExampleDialog extends AppCompatDialogFragment {
    private Spinner from;
    private Spinner to;
    //private ExampleDialogListener listener;
 //   String fromdest, todest;
    //public String fromdest,todest;
    float firstdest, lastdest;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_destination, null);

        builder.setView(view)
                .setTitle("Pick Your Destination")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                fromdest=adapterView.getItemAtPosition(i).toString();
                                Toast.makeText(adapterView.getContext(),"from:"+fromdest,Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                todest=adapterView.getItemAtPosition(i).toString();

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                       // Toast.makeText(getActivity(),"From: "+fromdest,Toast.LENGTH_SHORT).show();

                        //Toast.makeText(getActivity(),"To : "+todest,Toast.LENGTH_SHORT).show();
                        listener.applyTexts(fromdest,todest);

                    }
                });



       from = view.findViewById(R.id.from);
        to= view.findViewById(R.id.to);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.getActivity(), R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        from.setAdapter(adapter);
       to.setAdapter(adapter);

        return builder.create();
    }
        @Override
        public void onAttach(Context context) {
            super.onAttach(context);

            try {
                listener = (ExampleDialogListener) context;
            } catch (ClassCastException e) {
                throw new ClassCastException(context.toString() +
                        "must implement ExampleDialogListener");
            }
        }

        public interface ExampleDialogListener {
            void applyTexts(String fromdest, String todest);
        }*/
        return null;
    }
}

