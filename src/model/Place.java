package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Place {

	// Atributes
	private String name;
	private DepartmentPlace department;
	private double squarekilometers;
	private TypePlace type;
	private String photo;
	private double economicResourcesNeeded;
	private Specie[] species;
	private Calendar inaugurationDate;
	private Community community;

	/**
	 * Description: This method is the constructor of Place
	 * 
	 * @param name                    String, the name of the place
	 * @param department              DepartmentPlace, the department of the place
	 * @param squarekilometers        double, the square kilometers of the plces
	 * @param type                    int, the option of the type of the place
	 * @param photo                   String, the internet direction of the photo of
	 *                                the place
	 * @param economicResourcesNeeded double, the economic resources that the place
	 *                                need to be preserved
	 * @param community               Community, the community object that takes
	 *                                care of the place
	 * @param inaugurationDate        Calendar, the inauguration date of the place
	 */
	public Place(String name, DepartmentPlace department, double squarekilometers, TypePlace type, String photo,
			double economicResourcesNeeded, Community community, Calendar inaugurationDate) {

		this.name = name;
		this.department = department;
		this.squarekilometers = squarekilometers;
		this.type = type;
		this.photo = photo;
		this.economicResourcesNeeded = economicResourcesNeeded;
		species = new Specie[50];
		this.inaugurationDate = Calendar.getInstance();
		this.community = community;

	}

	/**
	 * Description:This method must show the information of the place
	 * 
	 * @return String with all the information of the place
	 */
	public String toString() {

		String msg = "";

		msg += "Name: " + name;
		msg += "\nDepartment: " + department;
		msg += "\nExtension: " + squarekilometers;
		msg += "\nPlace type: " + type;
		msg += "\nPhoto: " + photo;
		msg += "\nCommunity: " + community.getName();
		msg += "\nEconomic resources needed: " + economicResourcesNeeded;
		msg += "\nRegistration Date: " + new SimpleDateFormat("dd-MM-yyyy").format(inaugurationDate.getTime());
		msg += "\nSpecies: " + toStringSpecies();
		return msg;

	}

	/**
	 * Description:This method must search the species of the place in
	 * the arrangement species and organice them in a text string
	 * pre: species arrangement must be initialized
	 * 
	 * @return String with the names of the species registered in the place
	 */
	public String toStringSpecies() {
		String msg = "";
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				msg += species[i].getName() + "  ";
			}
		}
		return msg;
	}

	/**
	 * Description: This method must get the name of the place
	 * 
	 * @return String with the name
	 */
	public String getName() {

		return name;

	}

	/**
	 * Description: This method must get the community of the place
	 * 
	 * @return Community with the object
	 */
	public Community getCommunity() {

		return community;

	}

	/**
	 * Description: This method must get the square kilometers of the place
	 * 
	 * @return double with the value of the square kilometers
	 */
	public double getSquareKilometers() {

		return squarekilometers;

	}

	/**
	 * Description: This method must get the department of the place
	 * 
	 * @return DepartmentPlace with the literal of department registered in the
	 *         place
	 */
	public DepartmentPlace getDepartment() {
		return department;
	}

	/**
	 * Description: This method validate if the name of the specie isnt
	 * registered already
	 * in a Specie object of the species arrangement
	 * pre: species arrangement must be initialized
	 * 
	 * @param specieName String, the name of the specie
	 * @return boolean true if the name isnt registered already, otherwise false
	 */
	public boolean validateSpecieName(String specieName) {

		for (int z = 0; z < species.length; z++) {

			if (species[z] != null && species[z].getName().equals(specieName)) {

				return false;

			}

		}

		return true;

	}

	/**
	 * Description:Allows to save a specie in the arrangment species
	 * pre: the arrangement species must be initialized
	 * pos: the arrangement species is modified with the new Specie object
	 * 
	 * @param newSpecie Specie, the Specie object with all the information of the
	 *                  species
	 * @return boolean true if the object could be saved, otherwise false
	 */
	public boolean addSpecie(Specie newSpecie) {

		for (int i = 0; i < species.length; i++) {

			if (species[i] == null && validateSpecieName(newSpecie.getName())) {

				species[i] = newSpecie;

				return true;

			}

		}

		return false;

	}

	/**
	 * Description: This method allows to list the species saved in the arrangement
	 * species
	 * pre: species arrangement must be initialized
	 * 
	 * @return String in list format with the information of the registered species
	 */
	public String listSpecies() {

		String list = "";

		for (int i = 0; i < species.length; i++) {

			if (species[i] != null) {
				list += "\n" + species[i].getName();
			}

		}

		return list;

	}

	/**
	 * Description:this method search for a Specie trough its name,
	 * comparing the String typped with the name of the saved species
	 * in the arrangement species
	 * pre: the arrangement species must be initialized
	 * 
	 * @param name String, the name of the specie
	 * @return Specie with the info of the specie with that name otherwise null
	 */
	public Specie searchSpecie(String name) {

		for (int x = 0; x < species.length; x++) {

			Specie temporal = species[x];

			if (temporal != null) {

				if (name.equals(temporal.getName())) {

					return temporal;

				}

			}

		}

		return null;

	}

	/**
	 * Description:This method allows to modify the saved species information
	 * 
	 * @param name                    String, the name of the place
	 * @param newName                 String, the name of the specie
	 * @param newClassificationSpecie int, the option of the classification of the
	 *                                specie
	 * @param newPhoto                String, web direction of a photo of the specie
	 * @param newNumberofSpecimens    String, the number of specimens of the specie
	 * @return boolean true if the modification could be done, otherwise false
	 */
	public boolean modifySpecieInfo(String name, String newName, int newClassificationSpecie, String newPhoto,
			String newNumberofSpecimens) {
		Specie temporal = searchSpecie(name);
		if (temporal != null) {
			temporal.setName(newName);
			temporal.setClassification(ClassificationSpecie.values()[newClassificationSpecie - 1]);
			temporal.setPhoto(newPhoto);
			temporal.setNumberOfSpecimens(newNumberofSpecimens);
			return true;
		}

		return false;
	}

	/**
	 * Description: This method search the number of species in the arrangement
	 * species
	 * pre: species arrangement must be initialized
	 * 
	 * @return int with the number of species in the arrangement
	 */
	public int searchNumberofSpecies() {

		int contador = 0;

		for (int p = 0; p < species.length; p++) {

			if (species[p] != null) {

				contador++;

			}

		}

		return contador;
	}

}