//Ref: https://www.geeksforgeeks.org/mvc-design-pattern/ 

class EmployeeModel {
    String employeeName;
    String employeeEmail;
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeEmail() {
        return employeeEmail;
    }
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
class EmployeeView {
    void printEmployee(String employeeName, String employeeEmail){
        System.out.println("Name:" + employeeName + ", Email:" + employeeEmail);
    }
}
class EmployeeController {
    EmployeeModel employeeModel;
    EmployeeView employeeView;
    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView){
        this.employeeModel = employeeModel;
        this.employeeView = employeeView;
    }
    public void setEmployeeName(String employeeName){
        employeeModel.setEmployeeName(employeeName);
    }
    public void setEmployeeEmail(String employeeEmail){
        employeeModel.setEmployeeEmail(employeeEmail);
    }
    public String getEmployeeName(){
        return employeeModel.getEmployeeName();
    }
    public String getEmployeeEmail(){
        return employeeModel.getEmployeeEmail();
    }
    public void updateView(){
        employeeView.printEmployee(employeeModel.getEmployeeName(), employeeModel.getEmployeeEmail());
    }
}

public class Test {
    static EmployeeModel retrieveModelFromDataBase(){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setEmployeeName("Pawan");
        employeeModel.setEmployeeEmail("pawan@xyz.com");
        return employeeModel;
    }
    public static void main(String[] args) {
        EmployeeModel employeeModel = retrieveModelFromDataBase();
        EmployeeView employeeView = new EmployeeView();
        EmployeeController employeeController = new EmployeeController(employeeModel, employeeView);
        employeeController.updateView(); //Name:Pawan, Email:pawan@xyz.com
        employeeController.setEmployeeEmail("pksingh@xyz.com");
        employeeController.updateView(); //Name:Pawan, Email:pksingh@xyz.com
    }
}
