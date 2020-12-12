import java.util.Scanner;
import java.util.ArrayList;
import myClasses.Facade;
import myClasses.Building;
import myClasses.HelpClass;

public class PR_Lab_9_Java{
	public static void main(String[] args){
		/* Работа с экземплярами класса. */
		Building firstBuilding = new Building();
		Building secondBuilding = new Building();

		System.out.println("Программа по созданию зданий.\nВсе размерные данные вводятся в метрах.\n");
		System.out.println("Работа с экземплярами класса: ");

		firstBuilding.inputBuilding();
		secondBuilding.initBuilding();

		firstBuilding.addToBuilding(secondBuilding);

		firstBuilding.addFloors();
		firstBuilding.removeFloors();
		/*............................................*/
		
		/* Список объектов. */
		int amount = 2;
		ArrayList<Building> firstDynamicArray = new ArrayList<>();
		Building helpBuilding = new Building();

		System.out.println("\nСписок объектов: ");

		firstDynamicArray.add(new Building());
		firstDynamicArray.get(0).inputBuilding();
		firstDynamicArray.add(new Building());
		firstDynamicArray.get(1).initBuilding();
		firstDynamicArray.get(0).addToBuilding(firstDynamicArray.get(1));
		/*...............................*/
		
		/* Массив объектов. */
		Building[] firstArrayOfDyn = new Building[amount];
		Building[] secondArrayOfDyn = new Building[amount];
		for (int i = 0; i < amount; i++)
		{
			firstArrayOfDyn[i] = new Building();
			secondArrayOfDyn[i] = new Building();
		}

		System.out.println("\nМассив объектов: ");

		firstArrayOfDyn[0].inputBuilding();
		secondArrayOfDyn[1].initBuilding();

		firstArrayOfDyn[0].addToBuilding(secondArrayOfDyn[1]);
		/*..............................*/
		
		/* Новые функции Ассоциации. */
		Building building = new Building();
		System.out.println("\nНовые функции Ассоциации: ");

		building.inputBuilding();

		building.openWindowsOnFacade();
		building.closeWindowsOnFacade();
		/*..........................*/	
				
		/* Возврат значения с плавающей точкой через вспомогательный класс. */
		System.out.println("\nВозврат значения с плавающей точкой через вспомогательный класс: ");
		building = new Building();
		HelpClass h = new HelpClass();
		
		building.inputBuilding();
		building.returnStabilityFactor(h);
		System.out.println("Значение фактора стабильности данного здания: " + h.field);
		/*................................................................*/	
				
		/* Проверка использования this в функции AddToBuilding(). */
		System.out.println("\nПроверка использования this в функции AddToBuilding(): ");
		building = new Building();
		
		building.inputBuilding();
		
		building.addToBuilding(building);
		/*........................................................*/
		
		/* Использование статического метода и изменение статичсекого поля. */
		System.out.println("\nИспользование статического метода и изменение статичсекого поля: ");
		Building.companyName = "Авангард";
		System.out.println("\nОбщее количество когда-либо построенных этой компанией зданий: " + Building.getCountOfBuildings());
		building.getBuilding();
	}
}
