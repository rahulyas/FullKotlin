package com.example.fullkotlin.JavaExamples;

import java.util.ArrayList;

public class Scratch3 {
    static String str = "$GLGSV,3,1,10,81,63,034,51,82,53,272,51,80,52,292,,79,38,200,49*6A\n$GLGSV,3,2,10,65,24,046,42,66,16,105,47,73,15,334,46,88,14,062,46*61\n$GLGSV,3,3,10,83,11,253,,72,07,001,44*68\n$GPGSV,4,1,16,02,80,085,53,11,76,091,,12,61,180,51,25,58,284,52*79\n$GPGSV,4,2,16,20,42,142,50,06,33,056,47,29,28,280,47,05,19,166,47*7F\n$GPGSV,4,3,16,31,15,321,46,19,08,093,46,04,04,025,,09,03,055,*78\n$GPGSV,4,4,16,44,32,184,48,51,31,171,48,48,31,194,47,46,30,199,48*7E\n$GAGSV,3,1,09,34,72,231,53,30,65,251,53,36,51,059,51,02,36,170,49*62\n$GAGSV,3,2,09,27,25,314,47,15,19,236,47,04,08,037,46,09,04,085,*65\n$GAGSV,3,3,09,11,03,057,*50\n$GQGSV,1,1,01,02,08,309,37*4D\n$BDGSV,5,1,18,34,85,015,53,11,67,274,51,12,55,069,49,43,39,265,50*61";

    static String[] ArraysT;
    static String[] ArraysQ;
    static ArrayList<Integer> elevationL = new ArrayList<>();
    static ArrayList<Integer> azimuthL = new ArrayList<>();
    static int prnnumber1 = 0;
    public static void main(String[] args) {

        ArraysT=(str.split("\n"));
        System.out.println("arraySize"+ String.valueOf(ArraysT.length));

        for (int i = 0; i < ArraysT.length; i++) {
            String str1 = ArraysT[i];
            if(str1.contains("$GLGSV")){
                String[] spilitdata = str1.split(",");
                System.out.println("length"+ String.valueOf(spilitdata.length));
                for(int j = 4; j < spilitdata.length; j+=4) {
                    String prnnumber = str1.split(",")[j+0];
                    System.out.println("prnnumber:=" + prnnumber);

                    String elevation = str1.split(",")[j+1];
                    int elevation1 = Integer.parseInt(elevation);
                    elevationL.add(elevation1);
                    System.out.println("elevation:=" + elevation);
                    String azimuth = str1.split(",")[j+2];
                    System.out.println("azimuth:=" + azimuth);
                    int azimuth1 = Integer.parseInt(azimuth);
                    azimuthL.add(azimuth1);
                    String snr = str1.split(",")[j+3];
                    System.out.println("snr:=" + snr);

//                    System.out.println("elevationL:=" + elevationL);
//                    System.out.println("azimuthL:=" + azimuthL);

                }
            }else if(str1.contains("$GPGSV")) {
                String[] spilitdata = str1.split(",");
                System.out.println("length" + String.valueOf(spilitdata.length));
                for (int j = 4; j < spilitdata.length; j += 4) {
                    String prnnumber = str1.split(",")[j+0];
                    System.out.println("prnnumber:=" + prnnumber);

                    String elevation = str1.split(",")[j+1];
                    int elevation1 = Integer.parseInt(elevation);
                    elevationL.add(elevation1);
                    System.out.println("elevation:=" + elevation);
                    String azimuth = str1.split(",")[j+2];
                    System.out.println("azimuth:=" + azimuth);
                    int azimuth1 = Integer.parseInt(azimuth);
                    azimuthL.add(azimuth1);
                    String snr = str1.split(",")[j+3];
                    System.out.println("snr:=" + snr);

//                    System.out.println("elevationL:=" + elevationL);
//                    System.out.println("azimuthL:=" + azimuthL);

                }
            } else if(str1.contains("$GAGSV")) {
                String[] spilitdata = str1.split(",");
                System.out.println("length" + String.valueOf(spilitdata.length));
                for (int j = 4; j < spilitdata.length; j += 4) {
                    String prnnumber = str1.split(",")[j+0];
                    System.out.println("prnnumber:=" + prnnumber);

                    String elevation = str1.split(",")[j+1];
                    int elevation1 = Integer.parseInt(elevation);
                    elevationL.add(elevation1);
                    System.out.println("elevation:=" + elevation);
                    String azimuth = str1.split(",")[j+2];
                    System.out.println("azimuth:=" + azimuth);
                    int azimuth1 = Integer.parseInt(azimuth);
                    azimuthL.add(azimuth1);
                    String snr = str1.split(",")[j+3];
                    System.out.println("snr:=" + snr);

//                    System.out.println("elevationL:=" + elevationL);
//                    System.out.println("azimuthL:=" + azimuthL);

                }
            } else if(str1.contains("$GQGSV")) {
                String[] spilitdata = str1.split(",");
                System.out.println("length" + String.valueOf(spilitdata.length));
                for (int j = 4; j < spilitdata.length; j += 4) {
                    String prnnumber = str1.split(",")[j+0];
                    System.out.println("prnnumber:=" + prnnumber);

                    String elevation = str1.split(",")[j+1];
                    int elevation1 = Integer.parseInt(elevation);
                    elevationL.add(elevation1);
                    System.out.println("elevation:=" + elevation);
                    String azimuth = str1.split(",")[j+2];
                    System.out.println("azimuth:=" + azimuth);
                    int azimuth1 = Integer.parseInt(azimuth);
                    azimuthL.add(azimuth1);
                    String snr = str1.split(",")[j+3];
                    System.out.println("snr:=" + snr);

//                    System.out.println("elevationL:=" + elevationL);
//                    System.out.println("azimuthL:=" + azimuthL);

                }
            } else if(str1.contains("$BDGSV")) {
                String[] spilitdata = str1.split(",");
                System.out.println("length" + String.valueOf(spilitdata.length));
                for (int j = 4; j < spilitdata.length; j += 4) {
                    String prnnumber = str1.split(",")[j+0];
                    System.out.println("prnnumber:=" + prnnumber);

                    String elevation = str1.split(",")[j+1];
                    int elevation1 = Integer.parseInt(elevation);
                    elevationL.add(elevation1);
                    System.out.println("elevation:=" + elevation);
                    String azimuth = str1.split(",")[j+2];
                    System.out.println("azimuth:=" + azimuth);
                    int azimuth1 = Integer.parseInt(azimuth);
                    azimuthL.add(azimuth1);
                    String snr = str1.split(",")[j+3];
                    System.out.println("snr:=" + snr);


                }
            }
        }

        System.out.println("elevationL:=" + elevationL);
        System.out.println("azimuthL:=" + azimuthL);

    }
}
