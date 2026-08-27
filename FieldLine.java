
public class FieldLine {
	
	private int lineNumber;
	FieldUnit[] lineUnits;
	
	public  FieldLine(int lineNumber) {
		this.lineNumber=lineNumber;
		this.lineUnits=new FieldUnit[10];
	}
	
	public int getLineNumber() {
		return this.lineNumber;
	}
	
	public void setLineNumber(int lineNumber) {
		this.lineNumber=lineNumber;
	}
	
	public FieldUnit[] getLineUnits() {
		return this.lineUnits;
	}
	
	public void setLineUnits(FieldUnit[] lineUnits) {
		this.lineUnits=lineUnits;
	}
}