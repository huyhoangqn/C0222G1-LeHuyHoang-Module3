package model.bean;

public class Employee {
    private int id;
    private String name;
    private String birthday;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    private int idPosition;
    private int idEducation;
    private int idDivision;

    private String namePosition;
    private String nameEducation;
    private String nameDivision;

    public Employee(int id, String name, String birthday, String idCard, double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public Employee(String name, int idPosition, int idEducation) {
        this.name = name;
        this.idPosition = idPosition;
        this.idEducation = idEducation;
    }

    public Employee(String name, String birthday, String idCard, double salary, String phone, String email,
                    String address, int idPosition, int idEducation, int idDivision) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idEducation = idEducation;
        this.idDivision = idDivision;
    }

    public Employee(int id, String name, String birthday, String idCard, double salary, String phone, String email,
                    String address, int idPosition, int idEducation, int idDivision) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idPosition = idPosition;
        this.idEducation = idEducation;
        this.idDivision = idDivision;
    }


    public Employee(int id, String name, String birthday, String idCard, double salary, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Employee(String name, String birthday, String idCard, double salary, String phone, String email, String address) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Employee(int id, String name, String birthday, String idCard, double salary, String phone, String email, String address, String namePosition, String nameEducation, String nameDivision) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.namePosition = namePosition;
        this.nameEducation = nameEducation;
        this.nameDivision = nameDivision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(int idEducation) {
        this.idEducation = idEducation;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }
}
