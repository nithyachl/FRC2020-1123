package frc.robot;
import frc.robot.subsystems.*;
import java.util.TreeMap;

import frc.robot.subsystems.LimelightVision;

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class shooterClass {
    TreeMap<Double, Double> data = new TreeMap<Double, Double>();

    public shooterClass() {
        try{
        Scanner scanner = new Scanner(new File("/home/lvusser/deploy/ballisticsTest.txt"));
        while (scanner.hasNext()) {
            Double area = scanner.nextDouble();
            Double RPM =scanner.nextDouble();
            data.put(area, RPM);
          }
          scanner.close();
        }
        catch(Exception e){
            
        }
    }
    public double getRPM(double area)
    {
        return data.get(data.higherKey(area));
    }


}