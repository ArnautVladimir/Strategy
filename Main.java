
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		
		FieldLine[] battleField = createField();
		Warrior[] whiteWarriors = new Warrior[4];
		Warrior[] blackWarriors = new Warrior[4];
		
		whiteWarriors[0] = new Warrior("whiteHorseman", 100, 50, 50, 5, 1, "wH");
		whiteWarriors[1] = new Warrior("whiteSwardman", 70, 40, 50, 3, 1, "wS");
		whiteWarriors[2] = new Warrior("whiteJavelinman", 70, 40, 60, 3, 2, "wJ");
		whiteWarriors[3] = new Warrior("whiteArcher", 60, 40, 40, 3, 7, "wA");
		blackWarriors[0] = new Warrior("blackHorseman", 100, 50, 50, 5, 1, "bH");
		blackWarriors[1] = new Warrior("blackSwardman", 70, 40, 50, 3, 1, "bS");
		blackWarriors[2] = new Warrior("blackJavelinman", 70, 40, 60, 3, 2, "bJ");
		blackWarriors[3] = new Warrior("blackArcher", 60, 40, 40, 3, 7, "bA");
		
	   
		//Warrior[] test= new Warrior[4];
		//System.out.println(test[0]);
		
		battleFieldPainting(battleField);
		
	  FieldLine[] battleFieldWithWarriors=placeWarriorsOnBattleField(battleField, whiteWarriors, blackWarriors, 2, 3);
	  //battleFieldPainting(battleFieldWithWarriors);
		
		battleFieldWithWarriors[1].getLineUnits()[0].setIsEmpty(false);
		battleFieldWithWarriors[1].getLineUnits()[0].setWarriorSymbol("bS");
		battleFieldWithWarriors[1].getLineUnits()[3].setIsEmpty(false);
		battleFieldWithWarriors[1].getLineUnits()[3].setWarriorSymbol("bH");
		
		//battleFieldWithWarriors[14].getLineUnits()[1].setIsEmpty(false);
		//battleFieldWithWarriors[13].getLineUnits()[2].setIsEmpty(false);
		//battleFieldWithWarriors[10].getLineUnits()[3].setIsEmpty(false);
		
		//battleFieldWithWarriors=createWarriorStepCollumn(battleFieldWithWarriors, whiteWarriors);
		//battleFieldPainting(battleFieldWithWarriors);
			
		//battleFieldWithWarriors=createWarriorStepCollumn(battleFieldWithWarriors, blackWarriors);
		//battleFieldPainting(battleFieldWithWarriors);
		
		battleFieldPainting(battleFieldWithWarriors);
		
		battleFieldWithWarriors=createWarriorStep(battleFieldWithWarriors, whiteWarriors, blackWarriors);
		battleFieldPainting(battleFieldWithWarriors);
		
		battleFieldWithWarriors=createWarriorStep(battleFieldWithWarriors, blackWarriors, whiteWarriors);
		battleFieldPainting(battleFieldWithWarriors);
 }	
	
//===============================================================
	
	public static boolean lineIsEmpty(FieldUnit[] lineUnits) {
		
		for (FieldUnit unit: lineUnits) {
			if (!unit.getIsEmpty()){
			return false;
			}
		}
		return true;
	}
	
//===============================================================

	public static void battleFieldPainting(FieldLine[] battleField) {
		System.out.println("                         Battle      ");
		System.out.println("      0    1    2    3    4    5    6    7    8    9  ");
		int lineNumber = 0;
		for (FieldLine line: battleField){
			
			FieldUnit[] lineUnits=line.getLineUnits();
			
			if(lineIsEmpty(lineUnits)){
				
				System.out.println("   ---------------------------------------------------");
				if (lineNumber<10) {
		     System.out.println(" "+ lineNumber+" |    |    |    |    |    |    |    |    |    |    |");
				} else {
				System.out.println(lineNumber+" |    |    |    |    |    |    |    |    |    |    |");
				}
				
		   } else {
				System.out.println("   ---------------------------------------------------");
				if (lineNumber<10) {
				System.out.print(" "+ lineNumber+" |");
				for (FieldUnit unit: lineUnits) {
					if (unit.getIsEmpty()){
						System.out.print("    |");
			    } else {
						System.out.print(" " + unit.getWarriorSymbols() + " |");
					}
		     }
				System.out.println("");
				} else {
					System.out.print(lineNumber+" |");
				for (FieldUnit unit: lineUnits) {
					if (unit.getIsEmpty()){
						System.out.print("    |");
			    } else {
						System.out.print(" " + unit.getWarriorSymbols() + " |");
					}
		     }
				System.out.println("");
				}
			}
		lineNumber+=1;  
		}
		
		System.out.println("   ---------------------------------------------------");
		System.out.println("      0    1    2    3    4    5    6    7    8    9   ");
  }

//===============================================================
	
	public static FieldLine[] createField(){
		FieldLine[] field = new FieldLine[16];
		for(int j=0; j<16; j++) {
			FieldLine line=new FieldLine(j);
			
			for(int i=0; i<10; i++) {
			line.getLineUnits()[i]=new FieldUnit(j, i, true, "  ");
		  }
			field[j]=line;
		}
		return field;
	}
	
//===============================================================
	
	public static FieldLine[] placeWarriorsOnBattleField(FieldLine[] battleField, Warrior[] whiteWarriors, Warrior[] blackWarriors, int numberOne, int numberTwo) {
		FieldLine[] battleFieldWithWarriors=new FieldLine[16];
		
		System.out.println("Player first, place your warriors on the battlefield on line 0.");
		choiceCollumn(battleField, whiteWarriors, 0);
		System.out.println("Player second, place your warriors on the battlefield on line 15.");
		choiceCollumn(battleField, blackWarriors, 15);
		return battleField;
	}
	
//==============================================================
	
	public static void choiceCollumn (FieldLine[] battleField, Warrior[] Warriors, int lineNumber) {
		for (Warrior unit: Warriors) {
			boolean isUnitFool = true;
			while (isUnitFool) {
				Scanner innerScanner=new Scanner(System.in);
				System.out.println("Enter number of collumn for your " + unit.getName());
				int choiceCollumn = 20;
				try {
					choiceCollumn=innerScanner.nextInt();
					} catch(Exception e){}
				if (choiceCollumn<10 && battleField[lineNumber].getLineUnits()[choiceCollumn].getIsEmpty()){
					battleField[lineNumber].getLineUnits()[choiceCollumn].setIsEmpty(false);
					battleField[lineNumber].getLineUnits()[choiceCollumn].setWarriorSymbol(unit.getWarriorSymbols());
					unit.setWarriorLineNumber(lineNumber);
					unit.setWarriorCollumnNumber(choiceCollumn);
					isUnitFool = false;
				} else {
					System.out.println("WRONG NUMBER");
				}
			}
		}
	}
	
//==============================================================
	
	public static int choiceAction (FieldLine[] battleField, Warrior warrior, String[] targetsSymbols) {
		int result = 0;
		int choice = 0;
		boolean isChoiceWrong = true;
		
		targetsForAttack (battleField, warrior, targetsSymbols);
		
		while (isChoiceWrong) {
			if (warrior.getIsAlive() && warrior.getIsSteps() && !warrior.getIsAttack()) {
				System.out.println("1) Make steps   2) Cancel");
			} else if (warrior.getIsAlive() && warrior.getIsSteps() && warrior.getIsAttack()) {
				System.out.println("1) Make steps   2) Attack   3) Cancel");
			} else {
				System.out.println("Warrior "+ warrior.getName()+ "does not have steps");
				return 3;
			}
			Scanner choiceNumber = new Scanner(System.in);
			try{
				choice=choiceNumber.nextInt();
			} catch (Exception e) {}
			switch (choice) {
				case 1: return 1;
				case 2: 
				if (warrior.getIsAttack()) {
					return 2;
				} else { return 3;
				}
				case 3: 
				if (warrior.getIsAttack()) {
					return 3;
				} else { System.out.println("Enter number 1 or 2");
				}
				break;
				default:
				if (warrior.getIsAttack()) {
					System.out.println("Enter number 1-3");
				} else { 
				System.out.println("Enter number 1 or 2");
				}
				break;
			}
		}
		return result;
	}
	
//===============================================================
	
	public static boolean unitIsEmptyInCollumn (FieldLine[] battleField, int lineNumber, int warriorLineNumber, int collumnNumberForTest, boolean isLineNumberMore) {
		
		int firstLine=warriorLineNumber+1;
		if (isLineNumberMore) {
			for (int i=firstLine; i<=lineNumber; i++){
				if (!battleField[i].getLineUnits()[collumnNumberForTest].getIsEmpty()) {
					return false;
				}
			}
		} else {
			firstLine=warriorLineNumber-1;
			for (int i=firstLine; i>=lineNumber; i--){
				if (!battleField[i].getLineUnits()[collumnNumberForTest].getIsEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
//===============================================================
	
	public static boolean unitIsEmptyInLine (FieldLine warriorFieldLine, int collumnNumber, int lineNumber, int warriorLineNumber, int warriorCollumnNumber, boolean isCollumnNumberMore) {
		
		int firstCollumn=warriorCollumnNumber+1;
		if (isCollumnNumberMore) {
			for (int i=firstCollumn; i<=collumnNumber; i++){
				if (!warriorFieldLine.getLineUnits()[i].getIsEmpty()) {
					return false;
				}
			}
		} else {
			firstCollumn=warriorCollumnNumber-1;
			for (int i=firstCollumn; i>=collumnNumber; i--){
				if (!warriorFieldLine.getLineUnits()[i].getIsEmpty()) {
					return false;
				}
			}
		}
		return true;
	}

//===============================================================
	
	public static String[] addTargetSymbols (String[] targetsSymbols, String targetSymbols, Warrior warrior) {
		if (!targetSymbols.isEmpty()) {
			for (int i=0; i<targetsSymbols.length; i++) {
				if (targetsSymbols[i]!=null && targetSymbols.equals(targetsSymbols[i])) {
					break;
				}
				if (targetsSymbols[i]==null) {
					targetsSymbols[i] = targetSymbols;
					warrior.setIsAttack(true);
					break;
				}
			}
		}
		return targetsSymbols;
	}
	
//===============================================================
	
	public static String[] targetsForAttack (FieldLine[] battleField, Warrior warrior, String[] targetsSymbols) {
		int numberLineStartPoint;
		int numberCollumnStartPoint;
		int numberLineEndPoint;
		
		int numberCollumnEndPoint;
		String targetSymbols;
		boolean isWarriorWhite=true;
		
		numberLineStartPoint = (warrior.getWarriorLineNumber()-warrior.getDistanceAttack() < 0) ? 0 : warrior.getWarriorLineNumber()-warrior.getDistanceAttack();
		numberLineEndPoint = (warrior.getWarriorLineNumber()+warrior.getDistanceAttack() > 15) ? 15 : warrior.getWarriorLineNumber()+warrior.getDistanceAttack();
		numberCollumnStartPoint = (warrior.getWarriorCollumnNumber()-warrior.getDistanceAttack() < 0) ? 0 : warrior.getWarriorCollumnNumber()-warrior.getDistanceAttack();
		numberCollumnEndPoint = (warrior.getWarriorCollumnNumber()+warrior.getDistanceAttack() > 9) ? 9 : warrior.getWarriorCollumnNumber()+warrior.getDistanceAttack();
		if (warrior.getWarriorSymbols().substring(0,1).equals("b")) {
			isWarriorWhite=false;
		}
		for (int i=numberLineStartPoint; i<=numberLineEndPoint; i++) {
			FieldUnit[] lineForTest = battleField[i].getLineUnits();
			for (int j=numberCollumnStartPoint; j<=numberCollumnEndPoint; j++) {
				if (lineForTest[j].getIsEmpty()) {
					continue;
				}
				switch (lineForTest[j].getWarriorSymbols()) {
					case "bH":
					targetSymbols=(isWarriorWhite) ? "bH" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
					case "bS":
					targetSymbols=(isWarriorWhite) ? "bS" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
					case "bJ":
					targetSymbols=(isWarriorWhite) ? "bJ" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
					case "bA":
					targetSymbols=(isWarriorWhite) ? "bA" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
					case "wH":
					targetSymbols=(!isWarriorWhite) ? "wH" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
					case "wS":
					targetSymbols=(!isWarriorWhite) ? "wS" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
					case "wJ":
					targetSymbols=(!isWarriorWhite) ? "wJ" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
					case "wA":
					targetSymbols=(!isWarriorWhite) ? "wA" : "";
					addTargetSymbols(targetsSymbols, targetSymbols, warrior);
					break;
				}
			}
	  }
		
		return targetsSymbols;
	}
	
//================================================================
	
	public static FieldLine[] createWarriorStep (FieldLine[] battleFieldWithWarriors, Warrior[] warriors, Warrior[] warriorsTargets) {
		int lineNumber=0;
		int collumnNumber=0;
		int lineStep=0;
		int collumnStep=0;
		int totalStep=0;
		
		boolean isLineNumberMore=true;
		boolean isCollumnNumberMore=true;
		Warrior warrior=new Warrior();
		for (int i=0; i<warriors.length; i++) {
			String[] targetsSymbols = new String[4];
			Warrior[] targetsForAttack = new Warrior[4];
			boolean isKoordinatsWrong=true;
			warrior=warriors[i];
			
			int warriorLineNumber=warrior.getWarriorLineNumber();
			int warriorCollumnNumber=warrior.getWarriorCollumnNumber();
			System.out.println("Enter new coordinats for "+ warrior.getName());
			System.out.println("You can make " + warrior.getStepDistance() +" or less steps");
			switch (choiceAction(battleFieldWithWarriors, warrior, targetsSymbols)) {
				case 1:
				while (isKoordinatsWrong) {
					Scanner lineScanner = new Scanner(System.in);
					Scanner collumnScanner = new Scanner(System.in);
					System.out.print("Enter the line number for "+ warrior.getName()+": ");
					lineNumber=20;
					try{
						lineNumber=lineScanner.nextInt();
					} catch (Exception e) {}
					System.out.print("Enter the collumn number for "+ warrior.getName()+": ");
					collumnNumber=20;
					try{
						collumnNumber=collumnScanner.nextInt();
					} catch (Exception e) {}
					if (lineNumber>15 || lineNumber<0){
						System.out.println("WRONG Line number can be from 0 to 15");
					} else if (collumnNumber>9 || collumnNumber<0){
						System.out.println("WRONG Collumn number can be from 0 to 9");
					} else {
						if (lineNumber>warrior.getWarriorLineNumber()) {
							lineStep=lineNumber-warrior.getWarriorLineNumber();
							isLineNumberMore=true;
						} else {
							lineStep=warrior.getWarriorLineNumber()-lineNumber;
							isLineNumberMore=false;
						}
						if (collumnNumber>warrior.getWarriorCollumnNumber()) {
							collumnStep=collumnNumber-warrior.getWarriorCollumnNumber();
							isCollumnNumberMore=true;
						} else {
							collumnStep=warrior.getWarriorCollumnNumber()-collumnNumber;
							isCollumnNumberMore=false;
						}
						totalStep=lineStep+collumnStep;
						if ( totalStep > warrior.getStepDistance()) {
							System.out.println("WRONG : Too many steps. You may make "+ warrior.getStepDistance()+ " or less steps.");
						} else {
							boolean emptyUnitsInCollumn = unitIsEmptyInCollumn(battleFieldWithWarriors, lineNumber, warriorLineNumber, warriorCollumnNumber, isLineNumberMore);
							FieldLine warriorFieldLine = battleFieldWithWarriors[lineNumber];
							boolean emptyUnitsInLine = unitIsEmptyInLine(warriorFieldLine, collumnNumber, lineNumber, warriorLineNumber, warriorCollumnNumber, isCollumnNumberMore);
						  if (emptyUnitsInLine && emptyUnitsInCollumn) {
								isKoordinatsWrong=false;
							} else {
								warriorFieldLine = battleFieldWithWarriors[warriorLineNumber];
								emptyUnitsInLine = unitIsEmptyInLine(warriorFieldLine, collumnNumber, lineNumber, warriorLineNumber, warriorCollumnNumber, isCollumnNumberMore);
								int collumnNumberForTest = collumnNumber;
								emptyUnitsInCollumn = unitIsEmptyInCollumn(battleFieldWithWarriors, lineNumber, warriorLineNumber, collumnNumberForTest, isLineNumberMore);
							}
							if (emptyUnitsInLine && emptyUnitsInCollumn) {
								isKoordinatsWrong=false;
							} else {
								System.out.println("You can not make steps because way is not free.");
							}
				}
					}
				}
				battleFieldWithWarriors[warrior.getWarriorLineNumber()].getLineUnits()[warrior.getWarriorCollumnNumber()].setIsEmpty(true);
				battleFieldWithWarriors[warrior.getWarriorLineNumber()].getLineUnits()[warrior.getWarriorCollumnNumber()].setWarriorSymbol("");
				warrior.setWarriorLineNumber(lineNumber);
				warrior.setWarriorCollumnNumber(collumnNumber);
				battleFieldWithWarriors[lineNumber].getLineUnits()[collumnNumber].setIsEmpty(false);
				battleFieldWithWarriors[lineNumber].getLineUnits()[collumnNumber].setWarriorSymbol(warrior.getWarriorSymbols());
				
				boolean isSteps = (warrior.getStepDistance()-totalStep == 0) ? false : true;
				warrior.setIsSteps(isSteps);
				
				
				break;
			  case 2:
			  System.out.println("You want to attack: ");
				int countTargets = 0;
				for (String targetSymbols : targetsSymbols) {
					if (targetSymbols==null) {
						continue;
					}
					
					for (Warrior warriorTarget : warriorsTargets) {
						if (targetSymbols.equals(warriorTarget.getWarriorSymbols()) && warriorTarget.getIsAlive()) {
							targetsForAttack[countTargets] = warriorTarget;
							System.out.print((countTargets+1) + ") " + warriorTarget.getName() + "  ");
							countTargets++;
						}
					}
				}
				System.out.println((countTargets+1) + ") Cansel");
			  break;
				case 3:
				continue;
			}
		}
		return battleFieldWithWarriors;
	}
	
//===============================================================	
	
}
