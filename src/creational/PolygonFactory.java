package creational;

import java.util.HashMap;
import java.util.Map;

public class PolygonFactory {

	static Map<String, Polygon> shapes = new HashMap<String, Polygon>(){{
	    put("square", new Square());
	    put("triangle", new Triangle());
	    put("octagon", new Octagon());
	}};
	
	
	public static Polygon getPolygon(String type) {
		return shapes.get(type);
	}

}
