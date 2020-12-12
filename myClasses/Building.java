package myClasses;
import java.util.Scanner;

public class Building
{
	// Количество когда-либо построенных зданий.
	private static int countOfBuildings = 0;
	// Тип здания.
	private String typeOfBuilding;
	// Длина стороны основания.
	private double sideLength;
	// Высота фундамента.
	private double basementHeight;
	// Высота этажа.
	private double floorHeight;
	// Количество этажей.
	private int floorAmount;
	// Объект класса фасада здания, содержащий информацию об окнах здания.
	private Facade facade = new Facade();
	// Коэффициент устойчивости.
	private double stabilityFactor;
	/* Функция по установке переданных значений в свойства экземпляра класса Building. */
	private void setBuiling(String typeOfBuilding, double sideLength, double basementHeight, double floorHeight, int floorAmount, double stabilityFactor)
	{
		this.typeOfBuilding = typeOfBuilding;
		this.sideLength = sideLength;
		this.basementHeight = basementHeight;
		this.floorHeight = floorHeight;
		this.floorAmount = floorAmount;
		this.stabilityFactor = stabilityFactor;
	}
	// Конструктор.
	public Building()
	{
		this.initBuilding();
		countOfBuildings++;
	}
	// Название строительной компании.
	public static String companyName = "Альянс";
	// Статический метод по получению количества зданий.
	public static int getCountOfBuildings()
	{
		return countOfBuildings;
	}
	/* Функция по выводу свойств экземпляра класса Building. */
	public void getBuilding()
	{
		System.out.println("Свойства данного здания:");
		System.out.println("Название строительной компании: " + companyName);
		System.out.println("Количество когда-либо построенных этой компанией зданий: " + countOfBuildings);
		System.out.println("Тип здания: " + typeOfBuilding);
		System.out.println("Длина стороны основания: " + sideLength);
		System.out.println("Высота фундамента: " + basementHeight);
		System.out.println("Высота этажа: " + floorHeight);
		System.out.println("Количество этажей: " + floorAmount);
		facade.getFacade();
		System.out.println("Коэффициент устойчивости: " + stabilityFactor + "\n");
	}
	/* Функция по заданию свойств по умолчанию экземпляра класса Building. */
	public void initBuilding()
	{
		setBuiling("Жилое здание", 1.0, 1.0, 1.0, 1, 1.0);
		facade.setFacade(0, 0);
	}
	/* Функция по вводу с клавиатуры свойств для экземпляра класса Building */
	public void inputBuilding()
	{
		// Защиты от дурака для ввода всех необходимых данных.
		System.out.print("Введите тип вашего здания (непустой строкой): ");
		Scanner scanner = new Scanner(System.in);
		typeOfBuilding = scanner.nextLine();
		while (typeOfBuilding.length() == 0)
		{
			System.out.print("Неверный ввод типа здания - он должен быть непустой строкой. Попробуйте еще раз: ");
			scanner = new Scanner(System.in);
			typeOfBuilding = scanner.nextLine();
		}
		System.out.print("Введите длину стороны вашего здания: ");
		scanner = new Scanner(System.in);
		sideLength = scanner.nextDouble();
		while (sideLength <= 0)
		{
			System.out.print("Неверный ввод длины стороны - она должна быть положительным числом. Попробуйте еще раз: ");
			scanner = new Scanner(System.in);
			sideLength = scanner.nextDouble();
		}

		System.out.print("Введите высоту фундамента вашего здания: ");
		scanner = new Scanner(System.in);
		basementHeight = scanner.nextDouble();
		while (basementHeight <= 0)
		{
			System.out.print("Неверный ввод высоты фундамента - она должна быть положительным числом. Попробуйте еще раз: ");
			scanner = new Scanner(System.in);
			basementHeight = scanner.nextDouble();
		}

		System.out.print("Введите высоту одного этажа вашего здания: ");
		scanner = new Scanner(System.in);
		floorHeight = scanner.nextDouble();
		while (floorHeight <= 0)
		{
			System.out.print("Неверный ввод высоты этажа - она должна быть положительным числом. Попробуйте еще раз: ");
			scanner = new Scanner(System.in);
			floorHeight = scanner.nextDouble();
		}

		System.out.print("Введите количество этажей вашего здания: ");
		scanner = new Scanner(System.in);
		floorAmount = scanner.nextInt();
		while (floorAmount <= 0)
		{
			System.out.print("Неверный ввод количества - оно должно быть положительным целым числом. Попробуйте еще раз: ");
			scanner = new Scanner(System.in);
			floorAmount = scanner.nextInt();
		}
		facade.inputFacade();
		// Расчет коэффицента устойчивости.
		stabilityFactor = (double)(sideLength * sideLength * Math.sqrt(basementHeight)) / (floorHeight * floorAmount);
		// Если коэффициент устойчивости меньше 1 - здание упадет; необхлдим повторный ввод характеристик
		if (stabilityFactor < 1.0)
		{
			System.out.println("Здание не смогло устоять и рухнуло!\n");
			initBuilding();
		}
		else
		{
			System.out.println("Отлично! Здание получилось устойчивым с коэффициентом устойчивости k = " + stabilityFactor + ".\n");
		}
	}
	/* Функция по сложению двух экземпляров класса Building, где build - экземпляр, который будет прибавляться. */
	public void addToBuilding(Building build)
	{
		if (this == build)
		{
			System.out.println("Невозможно сложить здание с самим собой!");
			return;
		}
		System.out.println("Совмещаем два здания... Их свойства такие:");
		System.out.println("Типы зданий: " + typeOfBuilding + " и " + build.typeOfBuilding + "\n" + "Длины сторон оснований: " + sideLength + " и " + build.sideLength + "\n" +
			"Высоты фундаментов: " + basementHeight + " и " + build.basementHeight + "\n" + "Высоты этажей: " + floorHeight + " и " + build.floorHeight + "\n" +
			"Количества этажей: " + floorAmount + " и " + build.floorAmount + "\n" + "Коэффициенты устойчивости: " + stabilityFactor + " и " + build.stabilityFactor + "\n" + 
			"Общие количества окон: " + facade.getWindowsAmount() + " и " + build.facade.getWindowsAmount() + "\n" +
			"Количества открытых окон: " + facade.getOpenedWindowsAmount() + " и " + build.facade.getOpenedWindowsAmount() + "\n");
		
		String s = typeOfBuilding;
		typeOfBuilding = new String();
		typeOfBuilding = s + " " + build.typeOfBuilding;

		if (sideLength < build.sideLength)
			sideLength = build.sideLength;

		if (basementHeight < build.basementHeight)
			basementHeight = build.basementHeight;

		if (floorHeight < build.floorHeight)
			floorHeight = build.floorHeight;

		floorAmount = floorAmount + build.floorAmount;

		facade.addToFacade(build.facade);
		// Расчет нового коэффициента устойчивости и проверка его корректности.
		stabilityFactor = (double)(sideLength * sideLength * Math.sqrt(basementHeight)) / (floorHeight * floorAmount);
		if (stabilityFactor < 1)
		{
			System.out.println("К сожалению, после совмещения двух зданий новое здание сразу же развалилось, так как его коэффициент устойчивости k = " + stabilityFactor + " меньше единицы.\n");
			initBuilding();
		}
		else
		{
			System.out.println("Отлично! Новое здание устояло. Его свойства такие:");
			getBuilding();
		}
	}
	/* Функция по добавлению floorsToAdd этажей экземпляру класса Building. */
	public void addFloors()
	{
		int floorsToAdd;
		// Защита от дурака для ввода floorsToAdd.
		System.out.print("Введите количество этажей для добавления к вашему зданию: ");
		Scanner scanner = new Scanner(System.in);
		floorsToAdd = scanner.nextInt();
		while (floorsToAdd < 0)
		{
			System.out.print("Неверный ввод количества - оно должно быть неотрицательным целым числом. Попробуйте еще раз: ");
			scanner = new Scanner(System.in);
			floorsToAdd = scanner.nextInt();
		}

		floorAmount = floorAmount + floorsToAdd;
		// Расчет нового коэффициента устойчивости и проверка его корректности.
		stabilityFactor = (double)(sideLength * sideLength * Math.sqrt(basementHeight)) / (floorHeight * floorAmount);
		if (stabilityFactor < 1.0)
		{
			System.out.println("Коэффициент стабильности вашего здания k = " + stabilityFactor +
				" стал меньше единицы.\nОно может рухнуть с минуты на минуту. Попробуйте изменить количество этажей к добавлению (например, на 0)\n");
			floorAmount = floorAmount - floorsToAdd;
			addFloors();
		}
		else
		{
			System.out.println("Отлично! Здание получилось устойчивым с коэффициентом устойчивости k = " + stabilityFactor + "\n");
			// Отображение информации о здании.
			getBuilding();
		}
	}

	/* Функция по удалению floorsToRemove этажей у экземпляра класса Building. */
	public void removeFloors()
	{
		int floorsToRemove;
		// Защита от дурака для ввода floorsToRemove.
		System.out.print("Введите количество этажей для удаления с вашего здания: ");
		Scanner scanner = new Scanner(System.in);
		floorsToRemove = scanner.nextInt();
		while (floorsToRemove < 0 || floorsToRemove >= floorAmount)
		{
			System.out.print("Неверный ввод количества - оно должно быть неотрицательным целым числом и меньшим общего числа этажей. Попробуйте еще раз: ");
			scanner = new Scanner(System.in);
			floorsToRemove = scanner.nextInt();
		}
		// Расчет нового коэффициента устойчивости.
		floorAmount = floorAmount - floorsToRemove;
		stabilityFactor = (double)(sideLength * sideLength * Math.sqrt(basementHeight)) / (floorHeight * floorAmount);
		System.out.println("Этажи успешно удалены!");
		// Отображение информации о здании.
		getBuilding();
	}

	public void openWindowsOnFacade()
	{
		facade.openWindows();
		getBuilding();
	}

	public void closeWindowsOnFacade()
	{
		facade.closeWindows();
		getBuilding();
	}
	
	public void returnStabilityFactor(HelpClass h)
	{
		h.field = stabilityFactor;
	}

};