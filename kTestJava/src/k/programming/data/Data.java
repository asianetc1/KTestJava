package k.programming.data;

public class Data implements Cloneable{
	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
