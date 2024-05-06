package model;

public class Specie {

	// Atributes
	private String name;
	private ClassificationSpecie classification;
	private String photo;
	private String numberOfSpecimens;

	/**
	 * Description: This method is the constructor of Specie
	 *
	 * @param name                 String, the name of the specie
	 * @param classification       ClassificationSpecie, the classification of the
	 *                             specie
	 * @param photo                String, web direction of a photo of the specie
	 * @param numberOfSpecimens    String, the number of specimens of the specie
	 */
	public Specie(String name, ClassificationSpecie classification, String photo, String numberOfSpecimens) {

		this.name = name;
		this.classification = classification;
		this.photo = photo;
		this.numberOfSpecimens = numberOfSpecimens;

	}

	/**
	 * Description:This method must show the information of the specie
	 * 
	 * @return String with all the information of the specie
	 */
	public String toString() {

		String msg = "";

		msg += "Name: " + name;
		msg += "\nClasification: " + classification;
		msg += "\nPhoto: " + photo;
		msg += "\nNumber of specimens: " + numberOfSpecimens;

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

	/**
	 * Description:This method set the new name of the specie
	 * 
	 * @param name String, the new name of the specie
	 */
	public void setName(String name) {

		this.name = name;

	}

	/**
	 * Description:This method set the new classification of the specie
	 * 
	 * @param classification ClassificationSpecie, the new classification of the
	 *                       specie
	 */
	public void setClassification(ClassificationSpecie classification) {

		this.classification = classification;

	}

	/**
	 * Description:This method set the new photo of the specie
	 * 
	 * @param photo String, the new web direction of the photo of the specie
	 */
	public void setPhoto(String photo) {

		this.photo = photo;

	}

	/**
	 * Description:This method set the new photo of the specie
	 * 
	 * @param numberofSpecimens String, the new number of specimens of the specie
	 */
	public void setNumberOfSpecimens(String numberofSpecimens) {

		this.numberOfSpecimens = numberofSpecimens;

	}

}