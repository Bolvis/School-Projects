class Person constructor(val name:String, val surname:String, val age:String)
{

    override fun toString(): String {
        return "[Name: "+this.name+" Surname: "+this.surname+" Age: "+this.age+"]"
    }
}