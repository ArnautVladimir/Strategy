

public class Warrior {
	
	private String name;
	private int health;
	private int strong;
	private int defence;
	private int stepDistance;
	private int distanceAttack;
	private int warriorCollumnNumber;
	private int warriorLineNumber;
	private String warriorSymbols;
	private int amountOfSteps;
	private boolean isAlive;
	private boolean isSteps;
	private boolean isAttack;
	
	
	public Warrior(){}
	
	public Warrior(String name, int health, int strong, int defence, 
	               int stepDistance, int distanceAttack,
	               String warriorSymbols){
		this.name=name;
		this.health=health;
		this.strong=strong;
		this.defence=defence;
		this.stepDistance=stepDistance;
		this.distanceAttack=distanceAttack;
		this.warriorSymbols=warriorSymbols;
		this.isAlive=true;
		this.isSteps=true;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public int getHealth(){
		return this.health;
	}
	public void setWarriorLineNumber(int warriorLineNumber){
		this.warriorLineNumber=warriorLineNumber;
	}
	
	public int getWarriorLineNumber(){
		return this.warriorLineNumber;
	}
	public void setHealth(int health){
		this.health=health;
	}
	
	public int getWarriorCollumnNumber(){
		return this.warriorCollumnNumber;
	}
	public void setWarriorCollumnNumber(int warriorCollumnNumber){
		this.warriorCollumnNumber=warriorCollumnNumber;
	}
	
	public String getWarriorSymbols(){
		return this.warriorSymbols;
	}
	public void setWarriorSymbols(String warriorSymbol){
		this.warriorSymbols=warriorSymbols;
	}
	
	public boolean getIsAlive(){
		return this.isAlive;
	}
	public void setIsAlive(boolean isAlive){
		this.isAlive=isAlive;
	}
	
	public boolean getIsSteps(){
		return this.isSteps;
	}
	public void setIsSteps(boolean isSteps){
		this.isSteps=isSteps;
	}
	
	public boolean getIsAttack(){
		return this.isAttack;
	}
	public void setIsAttack(boolean isAttack){
		this.isAttack=isAttack;
	}
	
	public int getStepDistance(){
		return this.stepDistance;
	}
	
	public int getDistanceAttack(){
		return this.distanceAttack;
	}
	
	
	public int getAmountOfSteps(){
		return this.amountOfSteps;
	}
	
	public void setAmountOfSteps(int amountOfSteps){
		this.amountOfSteps=amountOfSteps;
	}
}