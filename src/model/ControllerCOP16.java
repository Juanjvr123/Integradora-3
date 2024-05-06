package model;

import java.util.Calendar;

public class ControllerCOP16 {

	// Atributes
	private Place[] places;
	private Community[] communities;

	// Relations
	public ControllerCOP16() {

		places = new Place[100];
		communities = new Community[10];

		createProofCases();

	}

	/**
	 * Description: This method allows to list the places saved in the arrangement
	 * places
	 * pre: places arrangement must be initialized
	 * 
	 * @return String in list format with the information the registered places
	 */
	public String listPlaces() {

		String list = "";

		for (int i = 0; i < places.length; i++) {

			if (places[i] != null) {
				list += "\n" + places[i].getName();
			}

		}

		return list;

	}

	/**
	 * Description: This method allows to list the communities saved in the
	 * arrangement communities
	 * pre: communities arrangement must be initialized
	 * 
	 * @return String in list format with the information of the registered
	 *         communitites
	 */
	public String listCommunities() {

		String list = "";

		for (int i = 0; i < communities.length; i++) {

			if (communities[i] != null) {
				list += "\n" + communities[i].getName();
			}

		}

		return list;

	}

	/**
	 * Description: This method allows to list the departments from the
	 * DepartmentPlace enumeration.
	 * 
	 * @return String in list format with the information of the values of the
	 *         DepartmentPlace enumeration
	 */
	public String listDepartmentPlace() {

		DepartmentPlace[] arrangementDepartmentPlace = DepartmentPlace.values();

		String list = "";

		for (int i = 0; i < arrangementDepartmentPlace.length; i++) {

			list += "\n" + (i + 1) + "- " + arrangementDepartmentPlace[i];

		}

		return list;

	}

	/**
	 * Description: This method allows to list the place types from the TypePlace
	 * enumeration.
	 * 
	 * @return String in list format with the information of the values of the
	 *         TypePlace enumeration
	 */
	public String listTypePlace() {

		TypePlace[] arrangementTypePlace = TypePlace.values();

		String list = "";

		for (int i = 0; i < arrangementTypePlace.length; i++) {

			list += "\n" + (i + 1) + "- " + arrangementTypePlace[i];

		}

		return list;

	}

	/**
	 * Description: This method allows to list the community types from the
	 * TypeCommunity enumeration.
	 * 
	 * @return String in list format with the information of the values of the
	 *         TypeCommunity enumeration
	 */
	public String listTypeCommunity() {

		TypeCommunity[] arrangementTypeCommunity = TypeCommunity.values();

		String list = "";

		for (int i = 0; i < arrangementTypeCommunity.length; i++) {

			list += "\n" + (i + 1) + "- " + arrangementTypeCommunity[i];

		}

		return list;

	}

	/**
	 * Description: This method allows to list the major problems of the communities
	 * from the
	 * MajorProblemsCommunity enumeration.
	 * 
	 * @return String in list format with the information of the values of the
	 *         MajorProblemsCommunity enumeration
	 */
	public String listMajorProblemsCommunity() {

		MajorProblemsCommunity[] arrangementMajorProblemsCommunity = MajorProblemsCommunity.values();

		String list = "";

		for (int i = 0; i < arrangementMajorProblemsCommunity.length; i++) {

			list += "\n" + (i + 1) + "- " + arrangementMajorProblemsCommunity[i];

		}

		return list;

	}

	/**
	 * Description: This method allows to list the species classification from the
	 * ClassificationSpecie enumeration.
	 * 
	 * @return String in list format with the information of the values of the
	 *         ClassificationSpecie enumeration
	 */
	public String listClassificationSpecie() {

		ClassificationSpecie[] arrangementClassificationSpecie = ClassificationSpecie.values();

		String list = "";

		for (int i = 0; i < arrangementClassificationSpecie.length; i++) {

			list += "\n" + (i + 1) + "- " + arrangementClassificationSpecie[i];

		}

		return list;

	}

	/**
	 * Description: This method allows to list the products types from the
	 * TypeProduct enumeration.
	 * 
	 * @return String in list format with the information of the values of the
	 *         TypeProduct enumeration
	 */
	public String listTypeProduct() {

		TypeProduct[] arrangementTypeProduct = TypeProduct.values();

		String list = "";

		for (int i = 0; i < arrangementTypeProduct.length; i++) {

			list += "\n" + (i + 1) + "- " + arrangementTypeProduct[i];

		}

		return list;

	}

	/**
	 * Description: This method allows to list the type of production of the
	 * products from the
	 * HandMadeProduct enumeration.
	 * 
	 * @return String in list format with the information of the values of the
	 *         HandMadeProduct enumeration
	 */
	public String listHandmadeProduct() {

		HandmadeProduct[] arrangementHandmadeProduct = HandmadeProduct.values();

		String list = "";

		for (int i = 0; i < arrangementHandmadeProduct.length; i++) {

			list += "\n" + (i + 1) + "- " + arrangementHandmadeProduct[i];

		}

		return list;

	}

	/**
	 * Description: This method validate if the name of the place isnt registered
	 * already
	 * in a Place object in the places arrangement
	 * pre: places arrangement must be initialized
	 * 
	 * @param namePlace String, the name of the place
	 * @return boolean true if the name isnt registered already, otherwise false
	 */
	public boolean validatePlaceName(String namePlace) {

		for (int x = 0; x < places.length; x++) {

			if (places[x] != null) {

				if (namePlace.equals(places[x].getName())) {

					return false;

				}

			}

		}

		return true;

	}

	/**
	 * Description:Allows to save a place in the arrangment places
	 * pre: the arrangement places must be initialized
	 * pos: the arrangement places is modified with the new Place object
	 * 
	 * @param name                    String, the name of the place
	 * @param departmentPlace         int, the option of the department of the place
	 * @param squarekilometers        double, the square kilometers of the plces
	 * @param typePlace               int, the option of the type of the place
	 * @param photo                   String, the internet direction of the photo of
	 *                                the place
	 * @param economicResourcesNeeded double, the economic resources that the place
	 *                                need to be preserved
	 * @param nameCommunity           String, the name of the community that takes
	 *                                care of the place
	 * @param inaugurationDay         int, the day of inauguration
	 * @param inaugurationMonth       int, the month of inauguration
	 * @param inaugurationYear        int, the year of inauguration
	 * @return boolean true if the object could be saved, otherwise false
	 */
	public boolean savePlace(String name, int departmentPlace, double squarekilometers, int typePlace, String photo,
			double economicResourcesNeeded, String nameCommunity, int inaugurationDay, int inaugurationMonth,
			int inaugurationYear) {

		Calendar inaugurationDate = Calendar.getInstance();

		inaugurationDate.set(Calendar.DAY_OF_MONTH, inaugurationDay);
		inaugurationDate.set(Calendar.MONTH, inaugurationMonth - 1);
		inaugurationDate.set(Calendar.YEAR, inaugurationYear);

		DepartmentPlace newDepartmentPlace = DepartmentPlace.VALLE;

		switch (departmentPlace) {

			case 1:
				newDepartmentPlace = DepartmentPlace.CHOCO;
				break;

			case 2:
				newDepartmentPlace = DepartmentPlace.VALLE;
				break;

			case 3:
				newDepartmentPlace = DepartmentPlace.CAUCA;
				break;

			case 4:
				newDepartmentPlace = DepartmentPlace.NARINO;
				break;

		}

		TypePlace newTypePlace = TypePlace.PROTECTED_AREA;

		switch (typePlace) {

			case 1:
				newTypePlace = TypePlace.PROTECTED_AREA;
				break;

			case 2:
				newTypePlace = TypePlace.PRIVATE_AREA;
				break;

			case 3:
				newTypePlace = TypePlace.NATIONAL_PARK;
				break;

		}

		Community newCommunity = saveCommunityInPlace(nameCommunity);

		Place newPlace = new Place(name, newDepartmentPlace, squarekilometers, newTypePlace, photo,
				economicResourcesNeeded, newCommunity, inaugurationDate);

		for (int i = 0; i < places.length; i++) {

			if (places[i] == null) {

				if (validatePlaceName(name)) {

					places[i] = newPlace;

					return true;

				}

			}

		}

		return false;
	}

	/**
	 * Description:This method allows search a community of type Community saved in
	 * the arrangement
	 * communities
	 * pre: the arrangement communities must be initialized
	 * 
	 * @param nameCommunity String, the name of the community
	 * @return Community the community saved with that name, otherwise null
	 */
	public Community saveCommunityInPlace(String nameCommunity) {

		for (int s = 0; s < communities.length; s++) {

			Community temporal = communities[s];

			if (communities[s] != null && communities[s].getName().equals(nameCommunity)) {

				return temporal;

			}

		}

		return null;

	}

	/**
	 * Description: This method validate if the name of the community isnt
	 * registered already
	 * in a Community object of the commnities arrangement
	 * pre: communities arrangement must be initialized
	 * 
	 * @param nameCommunity String, the name of the community
	 * @return boolean true if the name isnt registered already, otherwise false
	 */
	public boolean validateCommunityName(String nameCommunity) {

		for (int x = 0; x < communities.length; x++) {

			if (communities[x] != null) {

				if (nameCommunity.equals(communities[x].getName())) {

					return false;

				}

			}

		}

		return true;

	}

	/**
	 * Description:Allows to save a community in the arrangment communities
	 * pre: the arrangement communities must be initialized
	 * pos: the arrangement communities is modified with the new Community object
	 * 
	 * @param name                String, the name of the community
	 * @param typeCommunity       int, the option of the type of the community
	 * @param representativeName  String, the name of the person that represents the
	 *                            community
	 * @param representativePhone String, the phone number of the person that
	 *                            represents the community
	 * @param inhabitantsNumber   String, the number of inhabitants who belong to
	 *                            the community
	 * @return boolean true if the object could be saved, otherwise false
	 */
	public boolean saveCommunity(String name, int typeCommunity, String representativeName, String representativePhone,
			String inhabitantsNumber) {

		TypeCommunity newTypeCommunity = TypeCommunity.INDIGENA;

		switch (typeCommunity) {

			case 1:
				newTypeCommunity = TypeCommunity.AFROCOLOMBIANA;
				break;

			case 2:
				newTypeCommunity = TypeCommunity.INDIGENA;
				break;

			case 3:
				newTypeCommunity = TypeCommunity.RAIZAL;
				break;

		}

		Community newCommunity = new Community(name, newTypeCommunity, representativeName, representativePhone,
				inhabitantsNumber);

		for (int i = 0; i < communities.length; i++) {

			if (communities[i] == null) {

				if (validateCommunityName(name)) {

					communities[i] = newCommunity;

					return true;

				}

			}

		}

		return false;
	}

	/**
	 * Description:This method allows to save a problem to a community in the
	 * arrangement communities
	 * pre: the arrangement communities must be initialized
	 * 
	 * @param nameCommunity          String, the name of the community
	 * @param majorProblemsCommunity int, the option of the major problem
	 * @return boolean true if the problem could be saved, otherwise false
	 */
	public boolean saveProblemsInCommunity(String nameCommunity, int majorProblemsCommunity) {

		MajorProblemsCommunity newMajorProblemsCommunity = null;

		switch (majorProblemsCommunity) {

			case 1:
				newMajorProblemsCommunity = MajorProblemsCommunity.HOSPITAL_ABSENCE;
				break;

			case 2:
				newMajorProblemsCommunity = MajorProblemsCommunity.SCHOOL_ABSENCE;
				break;

			case 3:
				newMajorProblemsCommunity = MajorProblemsCommunity.POTABLE_WATER_ABSENCE;
				break;

			case 4:
				newMajorProblemsCommunity = MajorProblemsCommunity.BASIC_ALIMENTS_ABSENCE;
				break;

		}

		for (int w = 0; w < communities.length; w++) {

			if (communities[w] != null) {

				if (communities[w].getName().equals(nameCommunity)) {

					return communities[w].addMajorProblem(newMajorProblemsCommunity);

				}

			}

		}

		return false;

	}

	/**
	 * Description:This method allows to save a specie in a place of the arrangement
	 * places
	 * pre: the arrangement places must be initialized
	 * 
	 * @param namePlace            String, the name of the place
	 * @param name                 String, the name of the specie
	 * @param classificationSpecie int, the option of the classification of the
	 *                             specie
	 * @param photo                String, web direction of a photo of the specie
	 * @param numberofSpecimens    String, the number of specimens of the specie
	 * @return boolean true if the registration could be done, otherwise false
	 */
	public boolean saveSpecieInPlace(String namePlace, String name, int classificationSpecie, String photo,
			String numberofSpecimens) {

		ClassificationSpecie newClassificationSpecie = ClassificationSpecie.FAUNA; // se inicializa con un valor
																					// cualquiera

		switch (classificationSpecie) {

			case 1:
				newClassificationSpecie = ClassificationSpecie.FLORA;
				break;

			case 2:
				newClassificationSpecie = ClassificationSpecie.FAUNA;
				break;

		}

		Specie newSpecie = new Specie(name, newClassificationSpecie, photo, numberofSpecimens);

		for (int i = 0; i < places.length; i++) {

			if (places[i] != null) {

				if (places[i].getName().equals(namePlace)) {

					return places[i].addSpecie(newSpecie);

				}

			}

		}

		return false;
	}

	/**
	 * Description:This method allows to save a product in a community of the
	 * arrangement communities
	 * pre: the arrangement communities must be initialized
	 * 
	 * @param nameCommunity            String, the name of the community
	 * @param name                     String, the name of the product
	 * @param naturalComponentsPercent String, the percent of natural components
	 *                                 that the product has
	 * @param typeProduct              int, the option of the type of the product
	 * @param handmadeProduct          int, the option of the type of production
	 *                                 of the product
	 * @return boolean true if the registration could be done, otherwise false
	 */
	public boolean saveProductInCommunity(String nameCommunity, String name, String naturalComponentsPercent,
			int typeProduct, int handmadeProduct) {

		TypeProduct newTypeProduct = TypeProduct.ALIMENT;

		switch (typeProduct) {

			case 1:
				newTypeProduct = TypeProduct.CRAFT;
				break;

			case 2:
				newTypeProduct = TypeProduct.ALIMENT;
				break;

		}

		HandmadeProduct newHandmadeProduct = HandmadeProduct.YES;

		switch (handmadeProduct) {

			case 1:
				newHandmadeProduct = HandmadeProduct.YES;
				break;

			case 2:
				newHandmadeProduct = HandmadeProduct.NO;
				break;

		}

		Product newProduct = new Product(name, naturalComponentsPercent, newTypeProduct, newHandmadeProduct);

		for (int w = 0; w < communities.length; w++) {

			if (communities[w] != null) {

				if (communities[w].getName().equals(nameCommunity)) {

					return communities[w].addProduct(newProduct);

				}

			}

		}

		return false;

	}

	/**
	 * Description:this method search for a Place trough its name,
	 * comparing the String typped with the name of the saved Place
	 * in the arrangement places
	 * pre: the arrangement places must be initialized
	 * 
	 * @param name String, the name of the place that its going to be searched
	 * @return Place with the info of the place with that name otherwise null
	 */
	public Place searchPlace(String name) {

		for (int i = 0; i < places.length; i++) {

			Place temporal = places[i];

			if (temporal != null) {

				if (name.equals(temporal.getName())) {

					return temporal;

				}

			}

		}

		return null;

	}

	/**
	 * Description:this method search for a Community trough its name,
	 * comparing the String typped with the name of the saved community
	 * in the arrangement places
	 * 
	 * @param name String, the name of the community
	 * @return Community with the object with that name otherwise null
	 */
	public Community searchCommunity(String name) {

		for (int i = 0; i < communities.length; i++) {

			Community temporal = communities[i];

			if (temporal != null) {

				if (name.equals(temporal.getName())) {

					return temporal;

				}

			}

		}

		return null;

	}

	/**
	 * Description:this method search a place information by its name
	 * 
	 * @param name String, the name of the place
	 * @return String with the information of the place with that name otherwise
	 *         "Inexistent place"
	 */
	public String showPlace(String name) {

		Place temporal = searchPlace(name);

		if (temporal == null) {

			return "Inexistent place";

		} else {

			return temporal.toString();

		}

	}

	/**
	 * Descripcion: This method must search a place of the arrangement places,by its
	 * name an modify the information of a specie registered on it
	 * pre: places arrangement must be initialized
	 * 
	 * @param namePlace            String, the name of the place
	 * @param name                 String, the old name of the specie
	 * @param newName              String, the new name of the specie
	 * @param classificationSpecie int, the new option of the classification of the
	 *                             specie
	 * @param photo                String, the new web direction of a photo of the
	 *                             specie
	 * @param numberofSpecimens    String, the new number of specimens of the specie
	 * @return boolean true if the information is modified, otherwise false
	 */
	public boolean modifySpecieInPlaceInformation(String namePlace, String name, String newName,
			int classificationSpecie, String photo, String numberofSpecimens) {

		for (int w = 0; w < places.length; w++) {

			if (places[w] != null) {

				if (places[w].getName().equals(namePlace)) {

					return places[w].modifySpecieInfo(name, newName, classificationSpecie, photo, numberofSpecimens);

				}

			}

		}

		return false;

	}

	/**
	 * Description: This method search the list of the species registered on a place
	 * of the arrangement places
	 * 
	 * @param namePlace String, the name of the place
	 * @return String list with the names of the species registered in the place
	 */
	public String querySpeciesByPlace(String namePlace) {

		String query = "";

		Place place = searchPlace(namePlace);

		if (place != null) {

			query += place.listSpecies();

		}

		return query;

	}

	/**
	 * Description: This method search the list of the products registered on a
	 * community
	 * of the arrangement communities
	 * 
	 * @param nameCommunity String, the name of the community
	 * @return String list with the names of the products registered in the
	 *         community
	 */
	public String queryProductsByCommunity(String nameCommunity) {

		String query = "";

		Community community = searchCommunity(nameCommunity);

		if (community != null) {
			query += community.listProducts();
		}

		return query;

	}

	/**
	 * Description: this method allows to search a community of the arrangements
	 * commnities to delete a product registered on it
	 * pre: arangement communities must be initialized
	 * 
	 * @param nameCommunity String, the name of the community
	 * @param nameProduct   String, the name of the product
	 * @return boolean true if the product is succesfully deleted, otherwise false
	 */
	public boolean deleteAProductOfACommunity(String nameCommunity, String nameProduct) {

		for (int y = 0; y < communities.length; y++) {

			if (communities[y] != null) {

				if (communities[y].getName().equals(nameCommunity)) {

					return communities[y].deleteProduct(nameProduct);

				}

			}

		}

		return false;

	}

	/**
	 * Description: this method allows to search the highest number of species
	 * registered in a place
	 * pre: arangement places must be initialized
	 * 
	 * @return int with the value of the higuest number of species registered in a
	 *         place
	 */
	public int searchHighestNumbeOfSpeciesInPlace() {

		int mostAmount = 0;

		for (int n = 1; n < places.length; n++) {

			if (places[n] != null) {

				int number2 = places[n].searchNumberofSpecies();
				int number1 = places[n - 1].searchNumberofSpecies();

				if (number2 > number1 && number2 > mostAmount) {

					mostAmount = number2;

				} else if (number1 > number2 && number1 > mostAmount) {

					mostAmount = number1;

				}

			}

		}

		return mostAmount;

	}

	/**
	 * Description: this method allows to search the name of the place
	 * with the higuest number of species registered
	 * pre: arangement places must be initialized
	 * 
	 * @return String with the name of the place with more species
	 */
	public String searchPlaceWithMoreSpecies() {

		int numberofSpecies = searchHighestNumbeOfSpeciesInPlace();

		for (int n = 0; n < places.length; n++) {

			if (places[n] != null) {

				if (places[n].searchNumberofSpecies() == numberofSpecies) {

					return places[n].getName();

				}

			}

		}

		return null;

	}

	/**
	 * Description: this method allows to search the three largest square kilometers
	 * in places
	 * of the arrangement places
	 * pre: arangement places must be initialized
	 * 
	 * @return double[] with the values of the three largest square kilometers
	 */
	public double[] searchThreeLargestSquareKilometers() {

		double firstLargest = 0;

		for (int n = 1; n < places.length; n++) {

			if (places[n] != null) {

				double number2 = places[n].getSquareKilometers();
				double number1 = places[n - 1].getSquareKilometers();

				if (number2 > number1 && number2 > firstLargest) {

					firstLargest = number2;

				} else if (number1 > number2 && number1 > firstLargest) {

					firstLargest = number1;

				}

			}

		}

		double secondLargest = 0;

		for (int n = 1; n < places.length; n++) {

			if (places[n] != null) {

				double number2 = places[n].getSquareKilometers();
				double number1 = places[n - 1].getSquareKilometers();

				if (number2 > number1 && number2 > secondLargest && number2 < firstLargest) {

					secondLargest = number2;

				} else if (number1 > number2 && number1 > secondLargest && number1 < firstLargest) {

					secondLargest = number1;

				}

			}

		}

		double thrirdLargest = 0;

		for (int n = 1; n < places.length; n++) {

			if (places[n] != null) {

				double number2 = places[n].getSquareKilometers();
				double number1 = places[n - 1].getSquareKilometers();

				if (number2 > number1 && number2 > thrirdLargest && number2 < firstLargest && number2 < secondLargest) {

					thrirdLargest = number2;

				} else if (number1 > number2 && number1 > thrirdLargest && number1 < firstLargest
						&& number1 < secondLargest) {

					thrirdLargest = number1;

				}

			}

		}

		double[] largestSquareKilometers;

		largestSquareKilometers = new double[] { firstLargest, secondLargest, thrirdLargest };

		return largestSquareKilometers;

	}

	/**
	 * Description: this method allows search the name three places with more square
	 * kilometers
	 * pre: arangement places must be initialized
	 * 
	 * @return String with the name of the three largest places
	 */
	public String searchThreeLargestPlaces() {

		String firstPlaceName = "";
		String secondPlaceName = "";
		String thirdPlaceName = "";

		double[] largestSquareKilometers = searchThreeLargestSquareKilometers();

		for (int n = 0; n < places.length; n++) {

			if (places[n] != null) {

				if (places[n].getSquareKilometers() == largestSquareKilometers[0]) {

					firstPlaceName = places[n].getName();

				}

				if (places[n].getSquareKilometers() == largestSquareKilometers[1]) {

					secondPlaceName = places[n].getName();

				}

				if (places[n].getSquareKilometers() == largestSquareKilometers[2]) {

					thirdPlaceName = places[n].getName();

				}

			}

		}

		return firstPlaceName + ", " + secondPlaceName + ", " + thirdPlaceName;

	}

	/**
	 * Description: this method must search the communities that takes care of a
	 * place
	 * in the arrangement places with a certain department that is an enumeration of
	 * type
	 * DepartmentPlace
	 * pre: The arrangement places must be initialized
	 * 
	 * @param department int, that is the option of the department of the
	 *                   enumeration DepartmentPlace
	 * @return String with the name of the communities that take care of a place
	 *         and that places have a certain department
	 */
	public String searchCommunitiesByDepartment(int department) {

		String msg = "";

		String[] names = new String[places.length];

		DepartmentPlace depPlace = DepartmentPlace.values()[department - 1];

		for (int i = 0; i < places.length; i++) {

			if (places[i] != null && places[i].getDepartment().equals(depPlace)) {
				Community c = places[i].getCommunity();
				if (validateRepeatedCommunity(names, c.getName())) {
					msg += places[i].getCommunity().getName() + "\n";
					names[i] = c.getName();
				}
			}

		}

		return msg;
	}

	/**
	 * Description: this method must validate if a name of a community
	 * is repeated in the arrangement names
	 * 
	 * @param names String[], the arrangement of the names
	 * @param name  String, the name to validate
	 * @return boolean false if its a repeated name, otherwise true
	 */
	public boolean validateRepeatedCommunity(String[] names, String name) {

		boolean flag = true;

		for (int i = 0; i < names.length && flag; i++) {
			if (names[i] != null && names[i].equals(name)) {
				flag = false;
			}
		}

		return flag;
	}

	/**
	 * Description: This method allows to search the communities the arrangement
	 * communities that have an atribute of POTABLE_WATER_ASENCE or
	 * BASIC_ALIMENTS_ABSENCE
	 * pre: the communities arrangement must be initialized
	 * 
	 * @return String with the information of the communities that have those
	 *         problems
	 */
	public String searchCommunitiesByProblem() {

		String msg = "";

		for (int i = 0; i < communities.length; i++) {

			if (communities[i] != null && communities[i].checkProblem()) {

				msg += communities[i].toString() + "\n";

			}

		}

		return msg;

	}

	/**
	 * Description: This method allows to create proof objects
	 * 
	 * @return boolean true when the regisration is completed
	 */
	public boolean createProofCases() {

		saveCommunity("Embera", 3, "Luis torres", "3012345930", "134000");
		saveCommunity("Kimbaya", 2, "Jose Rojas", "3124543245", "80000");
		saveCommunity("Palenqueros", 1, "Daniel Lucumi", "3175849304", "594");
		savePlace("reserva del sol", 3, 2345432, 1, "https//www.asdfreskd.com", 2343223, "Embera", 11, 12, 2000);
		savePlace("cordillera blanca", 4, 456789876, 2, "https//www.hjjkooll.com", 4567899, "Kimbaya", 25, 05, 2007);
		savePlace("san felipe", 1, 9563678, 3, "https//www.huhuikook.com", 7500000, "Palenqueros", 01, 1, 1995);
		savePlace("cascada de niebla", 4, 93094302, 1, "https//www.jjnsesfks.com", 323465433, "Kimbaya", 28, 11, 2013);
		savePlace("cerro de luz", 4, 47382938, 3, "https//www.hjnjbkjj.com", 6789876, "Embera", 10, 10, 2001);
		savePlace("habitat del viento", 2, 789898789, 3, "https//www.sakdmskds.com", 789878, "Palenqueros", 10, 12,
				1820);
		saveProblemsInCommunity("Embera", 2);
		saveProblemsInCommunity("Embera", 1);
		saveProblemsInCommunity("Kimbaya", 3);
		saveProblemsInCommunity("Palenqueros", 4);
		saveProductInCommunity("Embera", "Dulce de coco", "20%", 1, 2);
		saveSpecieInPlace("reserva del sol", "Colibri morado", 1, "https//www.zdkifjdkss.com", "234");
		saveSpecieInPlace("san felipe", "tigre", 2, "https//www.jdsmidjss.com", "20");
		saveSpecieInPlace("cordillera blanca", "gato", 1, "https//www.jdsjdsskdkdjss.com", "102");
		saveSpecieInPlace("cascada de niebla", "salmon rojo", 1, "https//www.jdllllss.com", "3402");
		saveSpecieInPlace("habitat del viento", "Orquidea azul", 2, "https//www.jeeiwjdsl.com", "506");
		saveSpecieInPlace("habitat del viento", "Pajaro del aire", 1, "https//www.pkhjm.com", "234");
		return true;

	}

}
