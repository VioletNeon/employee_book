import java.util.*;

public class EmployeeBook {
    private final Map<String, Employee> employees;

    public EmployeeBook() {
        this.employees = new HashMap<>();
    }

    public boolean addEmployee(Employee employee) {
        String employeeFullName = employee.getFullName();

        if (this.employees.containsKey(employeeFullName)) {
            return false;
        }

        this.employees.put(employeeFullName, employee);

        return true;
    }

    public void removeEmployee(String employeeFullName) {
        this.employees.remove(employeeFullName);
    }

    public Employee getEmployeeByFullName (String employeeFullName) {
        return this.employees.get(employeeFullName);
    }

    public void showEmployees() {
        System.out.println(this.employees);
    }

    public float getSalaryAmount() {
        float sum = 0;

        for (Employee employee : this.employees.values()) {
            sum += employee.getSalary();
        }

        return sum;
    }

    public float getSalaryMin() {
        float min = Float.MIN_VALUE;

        for (Employee employee : this.employees.values()) {
            float salary = employee.getSalary();

            if (salary < min) {
                min = salary;
            }
        }

        return min;
    }

    public float getSalaryMax() {
        float max = Float.MIN_VALUE;

        for (Employee employee : this.employees.values()) {
            float salary = employee.getSalary();

            if (salary > max) {
                max = salary;
            }
        }

        return max;
    }

    public float getSalaryAverage() {
        float sum = getSalaryAmount();

        return sum / this.employees.size();
    }

    public void printEmployeesFullNames() {
        for (Employee employee : this.employees.values()) {
            System.out.println(employee.getFullName());
        }
    }

    public void performSalaryIndexation(int indexationPercentage) {
        for (Employee employee : this.employees.values()) {
            float salary = employee.getSalary();
            salary += salary * indexationPercentage / 100;

            employee.setSalary(salary);
        }
    }

    public List<Employee> getEmployeeListByDepartment(int department) {
        List<Employee> employeeListByDepartment = new ArrayList<>();

        for (Employee employee : this.employees.values()) {
            int employeeDepartment = employee.getDepartment();

            if (department == employeeDepartment) {
                employeeListByDepartment.add(employee);
            }
        }

        if (employeeListByDepartment.isEmpty()) {
            throw new IllegalArgumentException("В департамент " + department + " сотрудники не наняты");
        }

        return employeeListByDepartment;
    }

    public float getSalaryMinByDepartment(int department) {
        float minSalary = Float.MIN_VALUE;

        List<Employee> employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();

            if (salary < minSalary) {
                minSalary = salary;
            }
        }

        return minSalary;
    }

    public float getSalaryMaxByDepartment(int department) {
        float maxSalary = Float.MIN_VALUE;

        List<Employee> employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();

            if (salary > maxSalary) {
                maxSalary = salary;
            }
        }

        return maxSalary;
    }

    public float getSalaryAmountByDepartment(int department) {
        float sumSalary = 0;

        List<Employee> employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();

            sumSalary += salary;
        }

        return sumSalary;
    }

    public float getSalaryAverageByDepartment(int department) {
        float sumSalary = getSalaryAmountByDepartment(department);

        List<Employee> employeeByDepartment = getEmployeeListByDepartment(department);

        return sumSalary / employeeByDepartment.size();
    }

    public void performSalaryIndexationByDepartment(int indexationPercentage, int department) {
        List<Employee> employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();
            salary += salary * indexationPercentage / 100;

            employee.setSalary(salary);
        }
    }

    public void showEmployeeWithoutDepartment(Employee employee) {
        System.out.println("Employee {" + "id=" + employee.getId() + ", fullName='" + employee.getFullName() + '\'' + ", salary=" + employee.getSalary() + '}');
    }

    public void showEmployeesByDepartment(int department) {
        List<Employee> employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            showEmployeeWithoutDepartment(employee);
        }
    }

    public void getSalaryLessThanPointer(int pointer) {
        for (Employee employee : this.employees.values()) {
            float salary = employee.getSalary();

            if (salary < pointer) {
                showEmployeeWithoutDepartment(employee);
            }
        }
    }

    public void getSalaryMoreThanPointer(int pointer) {
        for (Employee employee : this.employees.values()) {
            float salary = employee.getSalary();

            if (salary >= pointer) {
                showEmployeeWithoutDepartment(employee);
            }
        }
    }
}