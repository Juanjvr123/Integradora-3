package ui;

import java.util.Scanner;

import model.ControllerCOP16;

public class ExecutableCOP16 {

	public static void main(String[] args) {
		ExecutableCOP16 exe = new ExecutableCOP16();
		exe.menu();
	}

	// Atributes
	private Scanner reader;
	private ControllerCOP16 cntrllr;

	// Relations
	public ExecutableCOP16() {
		reader = new Scanner(System.in);
		cntrllr = new ControllerCOP16();
	}

	/**
	 * Description: This method must show and receive the option the user choose
	 * and call the other menu, or close the software
	 */
	public void menu() {

		boolean flag = true;

		do {

			System.out.println("Welcome to COP 16 software");
			System.out.println("----------------------------------");
			System.out.println("[1] Open the administrative menu");
			System.out.println("[2] Open the consultation menu");
			System.out.println("[3] Close COP 16 software");

			int option = reader.nextInt();

			switch (option) {

				case 1:

					administrativeMenu();

					break;

				case 2:

					consultationMenu();

					break;

				case 3:

					flag = false;
					System.out.println("Thank for use our services");

					break;

				default:
					System.out.println("Type a valid option");
					break;
			}

		} while (flag);

	}

	/**
	 * Description: This method must show and receive the administrative options
	 * and call the choosed methods
	 */
	public void administrativeMenu() {

		boolean flag = true;

		do {

			System.out.println("Administrative menu:");
			System.out.println("---------------------------");
			System.out.println("[1] Place Registration");
			System.out.println("[2] Community Registration");
			System.out.println("[3] Register a product in a community");
			System.out.println("[4] Delete a community product");
			System.out.println("[5] Register a specie in a place");
			System.out.println("[6] Modify a place specie information");
			System.out.println("[7] Create Proof cases");
			System.out.println("[8] Exit");

			int option = reader.nextInt();

			switch (option) {

				case 1:

					placeRegistration();

					break;

				case 2:

					communityRegistration();

					break;

				case 3:
					registerAProductToACommunity();
					break;

				case 4:

					deleteACommunityProduct();

					break;

				case 5:

					registerASpecieToAPlace();

					break;

				case 6:

					modifyaPlaceSpecieInformation();

					break;

				case 7:

					createProofCases();

					break;

				case 8:

					flag = false;
					System.out.println("Thanks for use our services");

					break;

				default:

					System.out.println("Type a valid option");

					break;

			}

		} while (flag);

	}

	/**
	 * Description: This method must show and receive the consultation options
	 * and call the choosed methods
	 */
	public void consultationMenu() {

		boolean flag = true;

		do {

			System.out.println("Welcome");
			System.out.println("[1] Place information");
			System.out.println("[2] View the place with largest number of species");
			System.out.println("[3] View the three largest places");
			System.out.println("[4] View the communities information in a department");
			System.out.println("[5] View the communities that have hospital or school absence");
			System.out.println("[6] Exit");

			int option = reader.nextInt();

			switch (option) {

				case 1:

					consultPlace();

					break;

				case 2:

					consultPlaceWithMoreSpecies();

					break;

				case 3:

					consultThreeLargestPlaces();

					break;

				case 4:

					consultCommunitiesByDepartment();

					break;

				case 5:

					consultCommunitiesbyProblem();

					break;

				case 6:

					flag = false;
					System.out.println("Thanks for use our services");

					break;

				default:

					System.out.println("Invalid option, try again");

					break;

			}

		} while (flag);

	}

	/**
	 * Description: This method allows to register a place with all the information
	 * needed
	 */
	public void placeRegistration() {

		reader.nextLine();

		System.out.println("Type the place name");
		String name = reader.nextLine();

		System.out.println("Choose the place department");
		System.out.println(cntrllr.listDepartmentPlace());
		int departmentPlace = reader.nextInt();

		System.out.println("Type the place square kilometers ");
		double squareKilometers = reader.nextDouble();

		System.out.println("Choose the place type");
		System.out.println(cntrllr.listTypePlace());
		int typePlace = reader.nextInt();

		reader.nextLine();

		System.out.println("Type the place photo url");
		String photo = reader.nextLine();

		System.out.println("Type the place economic resources needed");
		double economicResourcesNeeded = reader.nextDouble();

		reader.nextLine();

		System.out.println("Type the name of the community that takes care of the place");
		System.out.println(cntrllr.listCommunities());
		String nameCommunity = reader.nextLine();

		System.out.println("Type the inaugiration day (dd)");
		int inaugurationDay = reader.nextInt();

		System.out.println("Type the inaugiration month (mm)");
		int inaugurationMonth = reader.nextInt();

		System.out.println("Type the inaugiration year (yyyy)");
		int inaugurationYear = reader.nextInt();

		boolean result = cntrllr.savePlace(name, departmentPlace, squareKilometers, typePlace, photo,
				economicResourcesNeeded, nameCommunity, inaugurationDay, inaugurationMonth, inaugurationYear);

		if (result) {

			System.out.println("Succesful Place registration");

		} else {

			System.out.println("Unsuccesful Place registration");

		}

	}

	/**
	 * Description: This method allows to register a community with all its
	 * information
	 */
	public void communityRegistration() {

		reader.nextLine();

		System.out.println("Type the community name");
		String name = reader.nextLine();

		System.out.println("Choose the community type");
		System.out.println(cntrllr.listTypeCommunity());
		int typeCommunity = reader.nextInt();

		reader.nextLine();

		System.out.println("Type the community representative name");
		String representativeName = reader.nextLine();

		System.out.println("Type the community representative phone");
		String representativePhone = reader.nextLine();

		System.out.println("Type the community inhabitants number");
		String inhabitantsNumber = reader.nextLine();

		System.out.println("How many problems of these problems the community has");
		System.out.println(cntrllr.listMajorProblemsCommunity());
		int numberofCommunityProblems = reader.nextInt();

		boolean flag = true;

		int count = 0;
		do {

			System.out.println("Choose the community problem");
			System.out.println(cntrllr.listMajorProblemsCommunity());
			int problemCommunity = reader.nextInt();

			cntrllr.saveProblemsInCommunity(name, problemCommunity);

			count++;

			if (count >= numberofCommunityProblems) {

				flag = false;

			}

		} while (flag);

		boolean result = cntrllr.saveCommunity(name, typeCommunity, representativeName, representativePhone,
				inhabitantsNumber);

		if (result) {

			System.out.println("Succesful community registration");

		} else {

			System.out.println("Unsuccesful community registration");

		}

	}

	/**
	 * Description: This method allows to register a specie to a place
	 * with the name of the place and the information of the specie
	 */
	public void registerASpecieToAPlace() {

		reader.nextLine();

		System.out.println(cntrllr.listPlaces());
		System.out.println("Type the name of the place");
		String placeName = reader.nextLine();

		System.out.println("Type the specie name");
		String name = reader.nextLine();

		System.out.println("Choose the specie classification");
		System.out.println(cntrllr.listClassificationSpecie());
		int classificationSpecie = reader.nextInt();

		reader.nextLine();

		System.out.println("Type the specie photo direction");
		String photo = reader.nextLine();

		System.out.println("Type the specie number of specimens");
		String numberofSpecimens = reader.nextLine();

		boolean result = cntrllr.saveSpecieInPlace(placeName, name, classificationSpecie, photo, numberofSpecimens);

		if (result) {

			System.out.println("Succesful specie registration");

		} else {

			System.out.println("Unsuccesful specie registration");

		}

	}

	/**
	 * Description: This method allows to register a product to a community with
	 * the information
	 */
	public void registerAProductToACommunity() {

		reader.nextLine();

		System.out.println(cntrllr.listCommunities());

		System.out.println("Type the community name where you are going to add a product");
		String nameCommunity = reader.nextLine();

		System.out.println("Type the product name");
		String name = reader.nextLine();

		System.out.println("Type the product natural components percent");
		String naturalComponentsPercent = reader.nextLine();

		System.out.println("Choose the product type");
		System.out.println(cntrllr.listTypeProduct());
		int typeProduct = reader.nextInt();

		System.out.println("¿The product is handmade?");
		System.out.println(cntrllr.listHandmadeProduct());
		int handmadeProduct = reader.nextInt();

		boolean result = cntrllr.saveProductInCommunity(nameCommunity, name, naturalComponentsPercent, typeProduct,
				handmadeProduct);

		if (result) {

			System.out.println("Succesful product registration");

		} else {

			System.out.println("Unsuccesful product registration");

		}

	}

	/**
	 * Description: This method show a place information by its name
	 */
	public void consultPlace() {

		reader.nextLine();

		System.out.println(cntrllr.listPlaces());

		System.out.println("Type the place name");

		String name = reader.nextLine();

		String msg = cntrllr.showPlace(name);

		if (msg.equals("Inexistent place")) {

			System.out.println(msg);

		} else {

			System.out.println("The place info is: \n" + msg);

		}

	}

	/**
	 * Description: This method allows to modify a place specie information by the
	 * name of the place, the name of the specie and all the new information
	 */
	public void modifyaPlaceSpecieInformation() {

		reader.nextLine();

		System.out.println(cntrllr.listPlaces());

		System.out.println("Type the place name where the specie is going to be modified");
		String namePlace = reader.nextLine();
		System.out.println(cntrllr.querySpeciesByPlace(namePlace));

		System.out.println("Type the specie name");
		String name = reader.nextLine();

		System.out.println("Type the specie new name");
		String newName = reader.nextLine();

		System.out.println("Choose the specie new classification");
		System.out.println(cntrllr.listClassificationSpecie());
		int classificationSpecie = reader.nextInt();

		reader.nextLine();

		System.out.println("Type the specie new photo direction");
		String photo = reader.nextLine();

		System.out.println("Type the specie new number of specimens");
		String numberofSpecimens = reader.nextLine();

		boolean result = cntrllr.modifySpecieInPlaceInformation(namePlace, name, newName, classificationSpecie, photo,
				numberofSpecimens);

		if (result) {

			System.out.println("Succesful modification");

		} else {

			System.out.println("Unsuccesful modification");

		}

	}

	/**
	 * Description: This method allows to delete a product to a community by the
	 * community name and the name of the product to delete
	 */
	public void deleteACommunityProduct() {

		reader.nextLine();

		System.out.println(cntrllr.listCommunities());

		System.out.println("Type the community name where the product is going to be deleted");
		String nameCommunity = reader.nextLine();

		System.out.println(cntrllr.queryProductsByCommunity(nameCommunity));

		System.out.println("Type the name of the product to delete");
		String nameProduct = reader.nextLine();

		if (cntrllr.deleteAProductOfACommunity(nameCommunity, nameProduct)) {

			System.out.println("Product deleted succesfully");

		} else {

			System.out.println("Product elimination failed");
		}

	}

	/**
	 * Description: This method shows the place with more species
	 */
	public void consultPlaceWithMoreSpecies() {

		System.out.println("The place with most amount of species is: " + cntrllr.searchPlaceWithMoreSpecies());

	}

	/**
	 * Description: This method shows the three largest places
	 */
	public void consultThreeLargestPlaces() {

		System.out.println("The Three largest places are: " + cntrllr.searchThreeLargestPlaces());

	}

	/**
	 * Description: This method shows the communities in a department
	 */
	public void consultCommunitiesByDepartment() {

		reader.nextLine();

		System.out.println("Choose the department");
		System.out.println(cntrllr.listDepartmentPlace());
		int departmentPlace = reader.nextInt();

		System.out.println(cntrllr.searchCommunitiesByDepartment(departmentPlace));

	}

	/**
	 * Description: This method shows the communities with hospital or school
	 * absence
	 */
	public void consultCommunitiesbyProblem() {

		System.out.println(cntrllr.searchCommunitiesByProblem());

	}

	/**
	 * Description: This method allows to create proof cases
	 */
	public void createProofCases() {

		if (cntrllr.createProofCases()) {

			System.out.println("Proof cases created succesfully");

		} else {

			System.out.println("Unsuccesfull proof cases creation");

		}

	}

}