package main;

public class MainClass {
	public String triangle(int x, int y, int z) {
		if(x<1||x>99 || y<1||y>99 || z<1||z>99)return "INVALID INPUT";
		else if(x+y<=z || y+z<=x || x+z<=y)return "NOT A TRIANGLE";
		else if(x==y && x==z)return "EQUILATERAL";
		else if((x==y && x!=z)||(x==z && x!=y)||(y==z && x!=y))return "ISOSCELES";
		else if(x!=y && x!=z && y!=z)return "SCALENE";
		else return "INVALID INPUT";
	}
}