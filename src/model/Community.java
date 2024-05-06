package model;

public class Community {

	// Atributes
	private String name;
	private TypeCommunity type;
	private String representativeName;
	private String representativePhone;
	private String inhabitantsNumber;
	private MajorProblemsCommunity[] majorProblems;
	private Product[] products;

	/**
	 * Description: This method is the constructor of Community
	 * 
	 * @param name                String, the name of the community
	 * @param type                int, the option of the type of the community
	 * @param representativeName  String, the name of the person that represents the
	 *                            community
	 * @param representativePhone String, the phone number of the person that
	 *                            represents the community
	 * @param inhabitantsNumber   String, the number of inhabitants who belong to
	 *                            the community
	 */
	public Community(String name, TypeCommunity type, String representativeName, String representativePhone,
			String inhabitantsNumber) {

		this.name = name;
		this.type = type;
		this.representativeName = representativeName;
		this.representativePhone = representativePhone;
		this.inhabitantsNumber = inhabitantsNumber;
		products = new Product[20];
		majorProblems = new MajorProblemsCommunity[4];
	}

	/**
	 * Description:This method must show the information of the community
	 * 
	 * @return String with all the information of the community
	 */
	public String toString() {

		String msg = "";

		msg += "Name: " + name;
		msg += "\nCommunity type: " + type;
		msg += "\nName of the representative: " + representativeName;
		msg += "\nPhone of the representative: " + representativePhone;
		msg += "\nInhabitants number: " + inhabitantsNumber;
		msg += "\nMajor problems: " + toStringMajorProblems();

		return msg;

	}

	/**
	 * Description:This method must search the major problems of the community in
	 * the arrangement majorProblemsCommunity and organice them in a text string
	 * pre: majorProblems arrangement must be initialized
	 * 
	 * @return String with the major problems of the community
	 */
	public String toStringMajorProblems() {
		String msg = "";
		for (int i = 0; i < majorProblems.length; i++) {
			if (majorProblems[i] != null) {
				msg += majorProblems[i] + "  ";
			}
		}
		return msg;
	}

	/**
	 * Description:This method must get the products that a community have
	 * registered
	 * in the arrangement products
	 * 
	 * @return Product[] with the products registered in the community
	 */
	public Product[] getProducts() {
		return products;
	}

	/**
	 * Description: This method validate if the name of the product isnt registered
	 * already
	 * in a Product object of the products arrangement
	 * pre: products arrangement must be initialized
	 * 
	 * @param nameProduct String, the name of the product
	 * @return boolean true if the name isnt registered already, otherwise false
	 */
	public boolean validateProductName(String nameProduct) {

		for (int z = 0; z < products.length; z++) {

			if (products[z] != null) {

				if (nameProduct.equals(products[z].getName())) {

					return false;
				}
			}

		}

		return true;

	}

	/**
	 * Description:Allows to save a product in the arrangment producta
	 * pre: the arrangement products must be initialized
	 * pos: the arrangement products is modified with the new Product object
	 * 
	 * @param newProduct Product, the Product object with all the information of the
	 *                   product
	 * @return boolean true if the object could be saved, otherwise false
	 */
	public boolean addProduct(Product newProduct) {

		for (int i = 0; i < products.length; i++) {

			if (products[i] == null && validateProductName(newProduct.getName())) {

				products[i] = newProduct;

				return true;

			}

		}

		return false;

	}

	/**
	 * Description: This method must get the name of the community
	 * 
	 * @return String with the name
	 */
	public String getName() {

		return name;

	}

	/**
	 * Description: This method must get the majorProblems of the arrangement
	 * MajorProblemsCommunity
	 * of the community
	 * 
	 * @return MajorProblemsCommunity[] with the major problems registered in the
	 *         community
	 */
	public MajorProblemsCommunity[] getMajorMajorProblemsCommunity() {

		return majorProblems;

	}

	/**
	 * Descripcion: This method allows to delete a product by its name
	 * pre: the arrangement products must be initialized
	 * pos: the arragement products is modified
	 * 
	 * @param name String, the name of the product to delete
	 * @return boolean, true if the products is deleted otherwise false
	 */
	public boolean deleteProduct(String name) {

		int index = searchProductIndex(name);
		if (index != -1) {
			products[index] = null;

			return true;
		}

		return false;
	}

	/**
	 * Descripcion: This method allows to get Ethe index of a product by its name
	 * pre: EThe arrangement products must be initialized
	 * 
	 * @param name String, the name of the product to delete
	 * @return int, the product index. -1 if the product isnt registered
	 */
	public int searchProductIndex(String name) {

		for (int i = 0; i < products.length; i++) {

			Product temporal = products[i];

			if (temporal != null) {

				if (name.equals(temporal.getName())) {
					return i;

				}

			}

		}

		return -1;

	}

	/**
	 * Description: This method allows to list the products saved in the arrangement
	 * products
	 * pre: products arrangement must be initialized
	 * 
	 * @return String in list format with the information of the registered products
	 */
	public String listProducts() {

		String list = "";

		for (int i = 0; i < products.length; i++) {

			if (products[i] != null) {
				list += "\n" + products[i].getName();
			}

		}

		return list;

	}

	/**
	 * Description: This method adds a new major problem to majorProblems
	 * arrangement
	 * pre: majorProblems arrangement must be initialized
	 * pos: majorProblems arrangement is modified with the new major problem added
	 * 
	 * @param newMajorProblem MajorProblemsCommunity, the major problem that is
	 *                        going to be added
	 * @return boolean True if the problem is succesfully saved, otherwise false
	 */
	public boolean addMajorProblem(MajorProblemsCommunity newMajorProblem) {

		for (int i = 0; i < majorProblems.length; i++) {

			if (majorProblems[i] == null && validateMajorProblemName(newMajorProblem)) {

				majorProblems[i] = newMajorProblem;

				return true;

			}

		}

		return false;

	}

	/**
	 * Description: This method validate if the problem isnt registered already
	 * in the community
	 * pre: majorProblems arrangement must be initialized
	 * 
	 * @param nameProblem String, the name of the problem
	 * @return boolean true if the name isnt registered already, otherwise false
	 */
	public boolean validateMajorProblemName(MajorProblemsCommunity nameProblem) {

		for (int z = 0; z < majorProblems.length; z++) {

			if (majorProblems[z] != null) {

				if (nameProblem.equals(majorProblems[z])) {

					return false;
				}
			}

		}

		return true;

	}

	/**
	 * Description: This method must check if the arrangement majorProblems have
	 * POTABLE_WATER_ABSENCE or BASIC_ALIMENTS_ABSENCE literals
	 * pre: majorProblems arrangement must be initialized
	 * 
	 * @return boolean false if the arrangement have them, otherwise true
	 */
	public boolean checkProblem() {

		boolean flag = true;

		for (int z = 0; z < majorProblems.length; z++) {

			if (majorProblems[z] == MajorProblemsCommunity.POTABLE_WATER_ABSENCE
					|| majorProblems[z] == MajorProblemsCommunity.BASIC_ALIMENTS_ABSENCE) {

				flag = false;

			}
		}

		return flag;

	}

}