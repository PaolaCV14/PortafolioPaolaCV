package proyecto;

//Enum que le asigna un indice a cada clase y se le asociá un String con el nombre de dicha clase
public enum Clases {
	SPINNING1("Spinning 7:00 a.m - 8:00 a.m"), SPINNING2("Spinning 9:00 a.m - 10:00 a.m"), SPINNING3("Spinning 12:00 p.m - 1:00 p.m"), SPINNING4("Spinning 6:00 p.m - 7:00 p.m"), SPINNING5("Spinning 8:00 p.m - 9:00 p.m"), 
	HITDANCE1("Hit Dance 7:00 a.m - 8:00 a.m"), HITDANCE2("Hit Dance 10:00 a.m - 11:00 a.m"), HITDANCE3("Hit Dance 12:00 p.m - 1:00 p.m"), HITDANCE4("Hit Dance 6:00 p.m - 7:00 p.m"), HITDANCE5("Hit Dance 8:00 p.m - 9:00 p.m"),
	ZUMBA1("Zumba 7:00 a.m - 8:00 a.m"), ZUMBA2("Zumba 8:00 a.m - 9:00 a.m"), ZUMBA3("Zumba 9:00 a.m - 10:00 a.m"), ZUMBA4("Zumba 10:00 a.m - 11:00 a.m"), ZUMBA5("Zumba 11:00 a.m - 12:00 p.m"),
	BOX1("Box 3:00 p.m - 4:00 p.m"), BOX2("Box 4:00 p.m - 5:00 p.m"), BOX3("Box 5:00 p.m - 6:00 p.m"), BOX4("Box 6:00 p.m - 7:00 p.m"), BOX5("Box 7:00 p.m - 8:00 p.m");

	private final String clase;
	Clases(String clase) {
		this.clase = clase;
	}
	public String getClase() {
		return clase;
	}
}
