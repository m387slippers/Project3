package project3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeightApp {
	
	
	private static ExperimentItem[] getExperimentItems(String fileName) { 
		List<ExperimentItem> experimentList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//			br.readLine(); //This line serves to read the header line?
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				experimentList.add(new ExperimentItem(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("A problem occurred reading in the songs.");
			e.printStackTrace();
		}
		return experimentList.toArray(new ExperimentItem[experimentList.size()]); 
	}
	
	private static void sortByWeight(ExperimentItem[] experimentList) {
		Arrays.sort(experimentList); //sorts according to natural ordering, which I made weight for this class.
		//can use a comparator to sort by a non-natural ordering as well.
	}
	
	private static void printExperimentList(ArrayList<ExperimentItem> experimentList) {
		for (ExperimentItem el : experimentList) {
				System.out.println(el); //and then print the experiment.
			}
	}
	
	public static void main(String[] args) {
		int currentWeight = 0;
		int currentRating = 0;
		ExperimentItem[] experimentList = getExperimentItems("src/project3/res/knapsack.csv"); //for whatever reason, when I tried renaming the file it made a copy, and won't let me delete the OG
		ArrayList<ExperimentItem> tripList = new ArrayList<>(); //an arraylist so it can be resized on the fly
		sortByWeight(experimentList);
		
		for (ExperimentItem el : experimentList) {
			if (currentWeight + el.getWeight() <= 700) { //if won't go overweight
				currentWeight += el.getWeight(); //add the weight
				currentRating += el.getRating(); //and add the rating
				tripList.add(el);  //and then add the experiment to the tripList.
			}
		}
		System.out.println("By selecting the lightest possible experiments, we can achieve\n"
				+ "a total rating of " + currentRating + " at a weight of " + currentWeight + "lbs.\n");
		
		System.out.println("The list of experiments that can be taken are as follows:");
		printExperimentList(tripList);
	}

}
