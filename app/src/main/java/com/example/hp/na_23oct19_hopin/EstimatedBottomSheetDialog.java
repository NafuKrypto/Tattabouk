package com.example.hp.na_23oct19_hopin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.InterfaceAddress;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class EstimatedBottomSheetDialog extends BottomSheetDialogFragment {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
private  BottomSheetListener mListener;
    String fromDist,toDist;
    TextView estimatedfair,estimateddistance;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View v=inflater.inflate(R.layout.estimated_bottom_sheet,container,false);
         estimatedfair=v.findViewById(R.id.estimatedFair);
         estimateddistance=v.findViewById(R.id.estimatedDistance);
         //longitude declaration

        point HouseBuilding=new point("HouseBuilding",23.874520, 90.400564);
        point Rajlakshmi=new point("Rajlakshmi",23.863764, 90.400072);
        point Jasimuddin=new point("Jasimuddin",23.860855, 90.400297);
        point Airport=new point("Airport",23.851610, 90.407670);
        point Kawla=new point("Kawla",23.845795, 90.412461);
        point Khilkhet=new point("Khilkhet",23.829972, 90.419818);
        point  NSU=new point("NSU",23.816099, 90.426565);
        point IUB=new point("IUB",23.816162, 90.427498);
        point AIUB=new point("AIUB",23.819354, 90.427431);

        point Mirpur1=new point("Mirpur1",23.874520, 90.400564);
        point Choitali=new point("Choitali",23.863764, 90.400072);
        point ZooRoadBusStop=new point("ZooRoadBusStop",23.860855, 90.400297);
        point JanataHousing=new point("JanataHousing",23.874520, 90.400564);
        point ChoitaliBusStand=new point("ChoitaliBusStand",23.863764, 90.400072);
        point Mirpur2Busstop=new point(" Mirpur2Busstop",23.860855, 90.400297);
        point Mirpur10=new point("Mirpur10",23.874520, 90.400564);
        point Mirpur11=new point("Mirpur11",23.863764, 90.400072);
        point PurobiBusStand=new point("PurobiBusStand",23.860855, 90.400297);
        point KalshiBusStop=new point("KalshiBusStop",23.874520, 90.400564);
        point PallabiBusStand=new point(" PallabiBusStand",23.863764, 90.400072);
        point Kalshi=new point("Jasimuddin",23.860855, 90.400297);
        point MatiKataRoadKalshi=new point("HouseBuilding",23.874520, 90.400564);
        point EcbChottorBusStand=new point("Rajlakshmi",23.863764, 90.400072);
        point Shewra=new point("Jasimuddin",23.860855, 90.400297);



        ArrayList<point> Route1 = new ArrayList<>();
        Route1.add(HouseBuilding);
        Route1.add(Rajlakshmi);
        Route1.add(Jasimuddin);
        Route1.add(Airport);
        Route1.add(Kawla);
        Route1.add(Khilkhet);
        Route1.add(NSU);
        Route1.add(IUB);
        Route1.add(AIUB);
       // Route1.add(r10);
      //  Route1.add(r11);
       // Route1.add(r12);




        try{
            fromDist= this.getArguments().getString("from");
              toDist=this.getArguments().getString("to");
        }catch (Exception e){

        }

        //Toast.makeText(getActivity(), toDist, Toast.LENGTH_LONG).show();
       //Toast.makeText(getActivity(),"to: "+toDist,Toast.LENGTH_SHORT).show();
         //estimateddistance.setText(fromDist);
         //estimatedfair.setText(toDist);
        Double dist = routedistance(fromDist,toDist, Route1);
//Toast.makeText(getActivity(),"Distance :"+distance,Toast.LENGTH_SHORT).show();
        Double time =  (dist*60/25);
        //tDistance.setText(distance+" KM");
        //tTime.setText(time + " m");
        //tFair.setText((40+distance*10+time*10)+" Tk");
         estimateddistance.setText(df2.format(dist));
      //estimateddistance.setText(""+fromDist);
        return v;
        }
    static Double routedistance(String StartRoutename,String EndRoutename, ArrayList<point> array) {
        int f=0;
        Double sum =0.0;
        for(int i =0; i<array.size()-1;i++) {
            point p = array.get(i);
            point p1 = array.get(i+1);
            if(EndRoutename==p.Name) {
                break;
            }
            if(StartRoutename==p.Name) {
                f=1;
            }
            if(f==1) {

                sum =Distance(p,p1)+sum;
            }
        }
        return sum;
    }



    public interface BottomSheetListener{
        void onBottomClicked(String text);
    }
    public void onAttach(Context context){
        super.onAttach(context);
        try {
            mListener = (BottomSheetListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    +"Error");
        }
    }

    static Double Distance (point obj1, point obj2) {
        final int R = 6371; // Radious of the earth
        Double lat1 = obj1.getlatitude();
        Double lon1 = obj1.getlongitude() ;
        Double lat2 = obj2.getlatitude() ;
        Double lon2 = obj2.getlongitude() ;
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
        return distance;
    }

    private static Double toRad(Double value) {

        return value * Math.PI / 180;

    }


}
