package model;

public class Product {

	// Atributes
	private String name;
	private String naturalComponentsPercent;
	private TypeProduct type;
	private HandmadeProduct handmade;

	/**
	 * Description: This method is the constructor of product
	 *
	 * @param name                     String, the name of the product
	 * @param naturalComponentsPercent String, the percent of natural components
	 *                                 that the product has
	 * @param type                     TypeProduct, the type of the product
	 * @param handmade                 HandmadeProduct, the type of production
	 *                                 of the product
	 */
	public Product(String name, String naturalComponentsPercent, TypeProduct type, HandmadeProduct handmade) {

		this.name = name;
		this.naturalComponentsPercent = naturalComponentsPercent;
		this.type = type;
		this.handmade = handmade;

	}

	/**
	 * Description:This method must show the information of the product
	 * 
	 * @return String with all the information of the product
	 */
	public String toString() {

		String msg = "";

		msg += "Name: " + name;
		msg += "\nNatural components percent: " + naturalComponentsPercent;
		msg += "\nProduct type: " + type;
		msg += "\n¿Its handmade?: " + handmade;

		return msg;

	}

	/**
	 * Description:This method must get the name of the product
	 * 
	 * @return String with the name of the product
	 */
	public String getName() {

		return name;

	}

}