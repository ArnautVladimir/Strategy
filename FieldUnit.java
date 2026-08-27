
public class FieldUnit {
	
	private int lineNumber;
	private int collumnNumber;
	private boolean isEmpty;
	private String warriorSymbols;
	
	public FieldUnit(int lineNumber, int collumnNumber, boolean isEmpty, String warriorSymbols) {
		this.lineNumber = lineNumber;
		this.collumnNumber = collumnNumber;
		this.isEmpty = isEmpty;
		this.warriorSymbols = warriorSymbols;
	}
	
	public int getLineNumber () {
		return this.lineNumber;
	}
	
	public void setLineNumber (int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public int getCollumnNumber () {
		return this.collumnNumber;
	}
	
	public void setCollumnNumber (int collumnNumber) {
		this.collumnNumber = collumnNumber;
	}
	
	public boolean getIsEmpty () {
		return this.isEmpty;
	}
	
	public void setIsEmpty (boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	public String getWarriorSymbols () {
		return this.warriorSymbols;
	}
	
	public void setWarriorSymbol (String warriorSymbols) {
		this.warriorSymbols = warriorSymbols;
	}
}