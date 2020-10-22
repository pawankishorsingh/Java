//Principle:Separate aspects that change from those which don't
//Principle:Always program to an interface
interface FlyBehaviour {
    void fly();
}
class FlyWithWings implements FlyBehaviour {
    public void fly(){
        System.out.println("Duck flying with wings");
    }
}
class FlyNoWay implements FlyBehaviour{
    public void fly(){
        System.out.println("Ducks does not fly");
    }
}
interface QuackBehaviour {
    void quack();
}
class Quack implements QuackBehaviour {
    public void quack(){
        System.out.println("Real queak sound");
    }
}
class Squeak implements QuackBehaviour{
    public void quack(){
        System.out.println("Squeak sound");
    }
}
//Principle:Favour Composition over inheritance
abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    //Aspect that all subclasses MUST define
    public abstract void display ();

    //It'll invoke fly() & quack() polymorphically
    void performFly(){
        flyBehaviour.fly();
    }
    void performQuack(){
        quackBehaviour.quack();
    }

    //Set the behaviour on the fly
    void setFlyBehaviour(FlyBehaviour fb){
        flyBehaviour = fb;
    }
    void setQuackBehaviour(QuackBehaviour qb){
        quackBehaviour = qb;
    }
    //Aspect that doesn't change
    void swim(){
        System.out.println("All ducks swim, nothing special there.");
    }
}
class MallardDuck extends Duck {
    public MallardDuck(){
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }
    @Override
    public void display() {
        System.out.println("Real Mallard Duck's display");
    }
}
public class Test {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        System.out.println("Original behaviour:");
        mallard.performFly(); //Duck flying with wings
        mallard.performQuack(); //Real queak sound
        mallard.setFlyBehaviour(new FlyNoWay());
        mallard.setQuackBehaviour(new Squeak());
        System.out.println("\nChanged behaviour:");
        mallard.performFly(); //Ducks does not fly
        mallard.performQuack(); //Squeak sound
    }
}
