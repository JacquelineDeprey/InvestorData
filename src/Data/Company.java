package Data;

import java.util.Set;

public class Company{
	
	String name;
	Set<Company> investors;
	Set<Company> investments;
	
	/*can include other fields like company type, size, location, etc. if wanted*/
	
	public Company(String name) {
		this.name = name;
		
		// TODO: Finish constructor
	}
	
	/**
	 * Compares two companies only based on name
	 */
	@Override
	public boolean equals(Object object) {
		return (object instanceof Company && ((Company) object).name == this.name);
	}

}