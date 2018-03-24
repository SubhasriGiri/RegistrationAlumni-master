package alumni.cit.edu.in.alumni;

import android.view.View;
import android.widget.EditText;

/**
 * Created by breezil on 12/20/2017.
 */

public class Search {
private String Regno;
    private String Username;
    private String Email;
    private String Password;
    private String Mobileno;
    private String Gender;
    private String Address;
    private String Country;
    private String State;
    private String Pincode;
    private String Profession;
    private String Companyname;
    private String Specialization;
    private String Caddress;
    private String Department;
    private String Batch;
    private String Year;

    public Search() {
    }

    public Search(String Username,String Email,String Address,String Mobileno,String Country,String State,String Pincode,String Profession,String Companyname, String Specialization,String Caddress,String Department,String Regno,String Batch,String Year) {

        this.Username = Username;
        this.Email= Email;
        this.Mobileno = Mobileno;
        this.Address = Address;
        this.Country = Country;
        this.State = State;
        this.Pincode = Pincode;
        this.Profession = Profession;
        this.Companyname= Companyname;
        this.Specialization = Specialization;
        this.Caddress = Caddress;
        this.Department =Department;
        this.Regno=Regno;
        this.Batch = Batch;
        this.Year = Year;

    }
    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }
    public String getRegno() {
        return Regno;
    }

    public void setRegno(String Regno) {
        this.Regno = Regno;
    }


    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }
    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department= Department;
    }
    public String getCaddress() {
        return Caddress;
    }

    public void setCaddress(String Caddress) {
        this.Caddress = Caddress;
    }
    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }
    public String getCompanyname() {
        return Companyname;
    }

    public void setCompanyname(String Companyname) {
        this.Companyname = Companyname;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State= State;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }



    public String getAddress() {
        return Address ;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender ;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }


    public String getMobileno() {
        return Mobileno ;
    }

    public void setMobileno(String Mobileno) {
        this.Mobileno = Mobileno;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }


}
