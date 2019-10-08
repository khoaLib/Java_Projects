package scale;
/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 4 ( Lab4)
 *Due: 5/29/2018
 *date submitted: 5/29/2018
 */
public interface Scalable {
	public void setUpUpdateData(int decisionOpt, String[] arrayData);

	public void editNewOptionName(String optSetName, String OptionName, String newOptionName, String k);

	public void editNewOptionPrice(String optSetName, float OptionPrice, float newNum, String k);
}
