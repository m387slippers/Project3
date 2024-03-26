package project3;

public class ExperimentItem implements Comparable<ExperimentItem> {
	
	int number;
	String name;
	Integer weight; //cannot invoke compareTo on primitive type int. 
	int rating;

	/**Ctor
	 * 
	 * @param number
	 * @param name
	 * @param weight
	 * @param rating
	 */
	public ExperimentItem(int number, String name, int weight, int rating) {
		this.number = number;
		this.name = name;
		this.weight = weight;
		this.rating = rating;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return name + " " + weight + " " + rating;
	}

	@Override
	public int compareTo(ExperimentItem o) {
		return this.weight.compareTo(o.weight);
	}
	
	
	
}
