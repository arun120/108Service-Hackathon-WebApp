/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Home
 */
public class LatLan {
    
    public String lat;
    public String lon;

    public LatLan() {
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
   

    public LatLan(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }
    
    public static final  Integer HEX_LEN=2500;
    //Chennai
    public static final  LatLan REF_LOC1=new LatLan("13.0827", "80.2707");
    public static final  LatLan REF_LOC2=new LatLan("13.082084", "80.296702");
    
    
    public static Double getDistance(LatLan loc1,LatLan loc2){
        Double Rlat1=Math.toRadians(Double.valueOf(loc1.lat));
        Double Rlon1=Math.toRadians(Double.valueOf(loc1.lon));
         Double Rlat2=Math.toRadians(Double.valueOf(loc2.lat));
        Double Rlon2=Math.toRadians(Double.valueOf(loc2.lon));
        
        Double  R = 6371e3;
        Double  Δφ = (Rlat2-Rlat1);
        Double Δλ = (Rlon2-Rlon1);

        Double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
        Math.cos(Rlat1) * Math.cos(Rlat2) *
        Math.sin(Δλ/2) * Math.sin(Δλ/2);
    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    Double d = R * c;
        return d;
    }
    
    public static Double getAngle(LatLan loc){
        
        Double a=getDistance(REF_LOC1,REF_LOC2 );
        Double b=getDistance(loc, REF_LOC1);
        Double c=getDistance(REF_LOC2, loc);
                
                Double d=Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/(2*a*b));
        
       d= Math.toDegrees(d);
       if(Double.valueOf(loc.lat)<Double.valueOf(REF_LOC1.lat))
           d+=180;
       
       return d;
    }
    
    
    public static String getRegionCode(LatLan loc){
        
           double dist=getDistance(loc, REF_LOC1);
         
       //   System.out.println("Distance :"+dist);
          double angle=getAngle(loc);
      //    System.out.println("Angle :"+angle);
          
          long RingNo=(long) Math.ceil(dist/HEX_LEN);
          
        //  System.out.println("Ring No :"+RingNo);
          if(RingNo%2==1)
          RingNo-=1;//Initial Ring half dist
          
          RingNo/=2;
          RingNo+=1;
       //   System.out.println("Final Ring No :"+RingNo);
          
          double Cells=(RingNo-1)*6;
         // System.out.println("Cells  :"+Cells);
          double start=(RingNo-2)*6;
          start+=1;
        //  System.out.println("Start No :"+start);
          double DegperCell=360/Cells;
         // System.out.println("DegperCell :"+DegperCell);
         
          long RegionCode=(long)(start+(angle/(DegperCell)));
          
         if(RegionCode<0)
             RegionCode=0;
       
       return String.valueOf(RegionCode);
    }
    
     public static Set<Long> getAdjacentCells(Set<Long> RegionCode){
     Set<Long> adj=new TreeSet<>();
     for(Long rc:RegionCode){
     adj.addAll(getAdjacentCells(rc));
     }
     return adj;
     }
    
     public static Set<Long> getAdjacentCells(Long RegionCode){
         Set<Long> adj=new TreeSet<>();
         //Same Layer
         adj.add(new Long(RegionCode-1));
         adj.add(new Long(RegionCode+1));
         
         if(RegionCode==0 )
         {
             adj.add(new Long(1));
             adj.add(new Long(2));
             adj.add(new Long(3));
             adj.add(new Long(4));
             adj.add(new Long(5));
             adj.add(new Long(6));
         }
         
         long cur_ring=(long) Math.floor((RegionCode/6));
         cur_ring+=1;
         double Cells=cur_ring*6;
         double start=(cur_ring-1)*6;
         start+=1;
         double DegperCell=360/Cells;
         double angle=(RegionCode-start)*DegperCell;
         
         //BottomLayer
        start=(cur_ring-2)*6;
        start+=1; 
          DegperCell=360/(cur_ring-1)*6;
          adj.add(new Long((long)(start+(angle/(DegperCell)))));
          angle+=DegperCell;
          adj.add(new Long((long)(start+(angle/(DegperCell)))));
          angle-=2*DegperCell;
          adj.add(new Long((long)(start+(angle/(DegperCell)))));
          
          angle+=DegperCell;//Reset Angle
          
          //Top Layer
        start=(cur_ring+1)*6;
        start+=1; 
          DegperCell=360/(cur_ring)*6;
          adj.add(new Long((long)(start+(angle/(DegperCell)))));
          angle+=DegperCell;
          adj.add(new Long((long)(start+(angle/(DegperCell)))));
          angle-=2*DegperCell;
          adj.add(new Long((long)(start+(angle/(DegperCell)))));
          
     return adj;
     }
}
