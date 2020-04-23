package creational;

public class Triangle implements Polygon{

	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}

}
