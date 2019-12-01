package k.programming.test;

public class TestPasswordCheck {

	public static void main(String[] args) {

		//String password="1234Abc@";
		String password="123Abc!@";
		//String password="!123Abc!@";
		boolean b = passCheck(password);
		if(b) {
			System.out.println("k>TestPasswordCheck.main - : true" );	//t+++
		} else {
			System.out.println("k>TestPasswordCheck.main - : false" );	//t+++
			System.out.println("k>TestPasswordCheck.main - : 패스워드는 공백을 포함할수 없으며, 8자리 이상, 대소문자, 숫자, 특수문자를 포함해야 합니다!" );	//t+++
		}
	}

	public static boolean passCheck(String password){
	    boolean result = true;
	    if(password.length() < 8){
	        result = false;
	    }
	    String upperCase = "(.*[A-Z].*)";
	    if(!password.matches(upperCase)){
	        result = false;
	    }
	    String lowerCase = "(.*[a-z].*)";
	    if(!password.matches(lowerCase)){
	    	result = false;
	    }
	    String numbers = "(.*[0-9].*)";
	    if(!password.matches(numbers)){
	        result = false;
	    }
	    String specialChars = "(.*[ ! # @ $ % ^ & * ( ) - _ = + [ ] ; : ' \" , < . > / ?].*)";
	    if(!password.matches(specialChars)){
	        result = false;
	    }
	    String space = "(.*[ ].*)";
	    if(password.matches(space)){
	        result = false;
	    }
//	    if(password.startsWith("?")){
//	        result = false;
//	    }
//	    if(password.startsWith("!")){
//	        result = false;
//	    }
	    return result;
	    
	}
	
}
