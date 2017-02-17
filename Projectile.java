// Projectile motion project v1
// Date: Feb 16, 2017
// For this completion of the projectile motion project, there is only
// an option for computing a table of values for an object that has been
// launched at an angle, following a nature of symmetry
// Following versions of this project will include the option for different
// types of launched projectiles
import java.util.*;
public class Projectile{
	public static final double ACCELERATION = -9.81;
	
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		displayMessage();
		System.out.println("Velocity (meters/second)? ");
		double velocity = console.nextDouble();
		System.out.println("Angle (degrees)? ");
		double angle = Math.toRadians(console.nextDouble());
		System.out.println("How many steps do you want displayed? ");
		int steps = console.nextInt();
		displayTable(velocity, angle, steps);
	}

	public static void displayMessage(){
		System.out.println("Welcome to the Projectile Trajectory program...");
		System.out.println("where you can find any desired value based on the type");
		System.out.println("of trajectory the object is in.");
		System.out.println();
	}
	
	public static void displayTable(double velocity, double angle, int steps){
		
		double xVelocity = velocity * Math.cos(angle);
		double yVelocity = velocity * Math.sin(angle);
		double totalTime = -2.0 * yVelocity / ACCELERATION;
		double timeIncrement = totalTime / steps;
		double xIncrement = xVelocity * timeIncrement;
		
		double x = 0.0;
		double y = 0.0;
		double t = 0.0;
		System.out.println("Step\tX\tY\tTime");
		System.out.println("0\t0.0\t0.0\t0.0");
		for(int i = 1; i <= steps; i++){
			t += timeIncrement;
			x += xIncrement; 
			y = displacement(yVelocity, t, ACCELERATION);
			System.out.println(i + "\t" + round2(x) + "\t" + round2(y) + "\t" + round2(t));
			
		}
		
	}
	public static double round2(double n){
		return Math.round(n * 100.0) / 100.0;
	}
	
	public static double displacement(double v, double t, double a){
		return v * t + 0.5 * a * t * t;
	}
	
}