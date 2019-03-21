package exception;

/*
 *Name: Khoa Pham
 *Class: CIS35B
 *Assignment 3 ( Lab3)
 *Due: 5/15/2018
 *date submitted: 5/15/2018
 */

import adapter.FixAuto;

public class AutoException implements FixAuto {
	public AutoException(){
		System.out.println("Part 2: Self Healing!\n");
	}
	public void fix(int errorno) {
		Fix1to100 f1 = new Fix1to100();
		switch (errorno) {
		case 1:
			f1.fix1();
			break;
		case 2:
			f1.fix2();
			break;
		case 3:
			f1.fix3();
			break;
		case 4:
			f1.fix4();
			break;
		case 5:
			f1.fix5();
			break;
		}
	}

}
