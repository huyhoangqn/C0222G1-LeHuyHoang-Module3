package model.bean;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int idCustomer;
    private TypeCustomer typeCustomer;
    private String nameCustomer;
    private String birthdayCustomer;
    private String idCardCustomer;
    private int genderCustomer;
    private String phoneCustomer;
    private String emailCustomer;
    private String addressCustomer;
    List<Contract> contractList = new ArrayList<>();

    public Customer(int idCustomer, TypeCustomer typeCustomer, String nameCustomer, String birthdayCustomer,
                    String idCardCustomer, int genderCustomer, String phoneCustomer, String emailCustomer,
                    String addressCustomer) {
        this.idCustomer = idCustomer;
        this.typeCustomer = typeCustomer;
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.idCardCustomer = idCardCustomer;
        this.genderCustomer = genderCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
    }

    public Customer(String nameCustomer, String birthdayCustomer, String idCardCustomer, int genderCustomer, String phoneCustomer, String emailCustomer, String addressCustomer) {
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.idCardCustomer = idCardCustomer;
        this.genderCustomer = genderCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
    }

    public Customer(int idCustomer, String nameCustomer, String birthdayCustomer, String idCardCustomer, int genderCustomer, String phoneCustomer, String emailCustomer, String addressCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.idCardCustomer = idCardCustomer;
        this.genderCustomer = genderCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
    }

    public Customer(int idCustomer, TypeCustomer typeCustomer, String nameCustomer, String birthdayCustomer, String idCardCustomer, int genderCustomer, String phoneCustomer, String emailCustomer, String addressCustomer, List<Contract> contractList) {
        this.idCustomer = idCustomer;
        this.typeCustomer = typeCustomer;
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.idCardCustomer = idCardCustomer;
        this.genderCustomer = genderCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
        this.contractList = contractList;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }



    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(String birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public int getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(int genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
