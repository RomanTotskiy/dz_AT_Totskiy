package day2quest2;

public abstract class AllBuild{
    String name;
    int area;
    int value;
    int fullValue;


    AllBuild(String name,int area, int value,int fullValue){
        this.name=name;
        this.area=area;
        this.value=value;
        this.fullValue=value * area;
    }
}
