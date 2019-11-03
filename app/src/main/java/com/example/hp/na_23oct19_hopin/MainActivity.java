package com.example.hp.na_23oct19_hopin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EstimatedBottomSheetDialog.BottomSheetListener  {
    private TextView textViewUsername;
    private TextView textViewPassword;
    Class fragmentClass = null;
 public String fromDestination,toDestination;
    private Fragment mFragment;


    //Notes notes_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       EditText mEditInit = (EditText) findViewById(R.id.search);
         
        mEditInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // getSupportFragmentManager().beginTransaction().replace(R.id.main, new Fragment1()).addToBackStack(null).commit();
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(MainActivity.this);
                View mView=getLayoutInflater().inflate(R.layout.dialog_destination,null);
                mBuilder.setTitle("Pick up Location");
                final Spinner fromspinner=(Spinner)mView.findViewById(R.id.from);
                final Spinner tospinner=(Spinner)mView.findViewById(R.id.to);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.planets_array));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                fromspinner.setAdapter(adapter);
                tospinner.setAdapter(adapter);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!fromspinner.getSelectedItem().toString().equalsIgnoreCase("")){
                //  Toast.makeText(MainActivity.this,fromspinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                           // dialogInterface.dismiss();
                            try {
                                //set time in mili
                                Thread.sleep(3000);

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            fromDestination=fromspinner.getSelectedItem().toString();
                        }

                        if(!tospinner.getSelectedItem().toString().equalsIgnoreCase("")){
                            //Toast.makeText(MainActivity.this,tospinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                            // dialogInterface.dismiss();
                            toDestination=tospinner.getSelectedItem().toString();

                        }

                        bottomSheetOpen();
                    }


                });
                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog=mBuilder.create();
                dialog.show();


            }
        });


            }

    private void bottomSheetOpen() {


        EstimatedBottomSheetDialog bottomSheet = new EstimatedBottomSheetDialog();
        Bundle data1 = new Bundle();
        Bundle data2=new Bundle();
        data1.putString("from",fromDestination);
        data2.putString("to", toDestination);
        bottomSheet.setArguments(data1);
        bottomSheet.setArguments(data2);
        bottomSheet.show(getSupportFragmentManager(), "HOP IN");


    }

    @Override
    public void onBottomClicked(String text) {

    }
}