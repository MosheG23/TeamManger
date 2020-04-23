package creational;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your polygon type");
		
		Polygon polygon = PolygonFactory.getPolygon(scan.nextLine().toLowerCase());
		if (polygon == null) {
			System.out.println("Not an existing polygon type");	
		}
		System.out.println(polygon.getType());
		
		scan.close();

	}

}
