package com.problem2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem2 {

	public static void main(String[] args) {
		
		String file = "src\\Demo.csv";
		BufferedReader br = null;
		String line = "";
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			while((line= br.readLine()) != null) {
				String[] row = line.split(",");
				for(String i:row) {
					System.out.println(i);
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
