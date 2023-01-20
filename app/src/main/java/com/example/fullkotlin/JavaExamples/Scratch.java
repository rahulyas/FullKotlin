package com.example.fullkotlin.JavaExamples;

public class Scratch {

    public static void main(String[] args) {
        double x1 = 0;
        double y1 = 0;
        // (x,y)
        double x2 = 360;
        double y2 = 300;
        // (-X,Y)
        double x3 = -360;
        double y3 = 300;
        // (-X,-Y)
        double x4 = -20;
        double y4 = -20;


//        double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

//        double ac = Math.abs(y2 - y1);
//        double bc = Math.abs(x2 - x1);
//        double ca = Math.hypot(ac, bc);


//        double angle1 = Math.atan2(distance - fixedX, distance - fixedY);
//        double angle2 = Math.atan2(x2 - fixedX, y2 - fixedY);

//        double a = (y2 - y1)*2;
//        double b = (x2 - x1)*2;
//        double c = sqrt(a * a + b * b);
//        double d = Math.hypot(a,b);


//
//        double r = Math.toRadians(distance);
//        double r1 = Math.toDegrees(1);

        double angle = Math.atan2((y2 - y1),(x2 - x1))*180/Math.PI;
        double angle1 = Math.atan2((y3 - y1),(x3 - x1))*180/Math.PI;
        double angle2 = Math.atan2((y4 - y1),(x4 - x1))*180/Math.PI;

        double newangle2 = angle2 + 360;


//        double angle2 = angle + Math.ceil( -angle / 360) * 360;
//        double angle3 = angle + Math.floor( -angle / 360) * 360;
//        double angle4 = angle + Math.round( -angle / 360) * 360;


        System.out.println("tan(x,y) = " + angle);
        System.out.println("tan(-x,y) = " + angle1);
        System.out.println("tan(-x,-y) = " + newangle2);


        double angle4= 135;
        double rad = Math.toRadians(angle4);
        double sin = Math.sin(rad) * 300;
        double cos = Math.cos(rad) * 300;
        System.out.println("sin(x) = " + sin);
        System.out.println("cos(x) = " + cos);



    }

}
