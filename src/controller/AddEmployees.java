package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Companies;
import util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddEmployees {
    public TextField txtEmpID;
    public TextField txtFName;
    public TextField txtLName;
    public TextField txtEmail;
    public TextField txtMobile;
    public Label txtVisaNo;
    public TextField txtSalary;
    public Button btnSubmit;
    public Button btnUpdate;
    public Button btnStatus;
    public Button btnViewEmployees;
    public ComboBox <Companies> cmbCompany;
    public ComboBox cmbBranch;
    public ComboBox cmbDepartment;
    public ComboBox cmbGender;
    public DatePicker dateOfBirth;
    public DatePicker dateOfJoining;
    public ComboBox cmbVisaStatus;
    public Button btnNewEmployee;
    public ComboBox cmbPosition;
    public AnchorPane addEmployee;




    public void initialize() throws SQLException {

        // Add Gender to the comboBox

        ObservableList <String> gender = cmbGender.getItems();
        gender.add("Male");
        gender.add("Female");

        //ADD Visa Status to comboBox

        ObservableList visaStatus = cmbVisaStatus.getItems();
        visaStatus.add("Visit Visa");
        visaStatus.add("Employment Visa From Different Company");
        visaStatus.add("Employment Visa From Our Company");
        visaStatus.add("No Visa");


        // Fetch company names from the database and add it in the combo box

        ObservableList<Companies> companies = cmbCompany.getItems();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM companies");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String companyId = resultSet.getString(1);
            String companyName = resultSet.getString(2);
            String type = resultSet.getString(3);
            String description = resultSet.getString(4);
            String createdAt = resultSet.getString(5);
            createdAt = createdAt.substring(0, 10);
            LocalDate createdAts = LocalDate.parse(createdAt);
            String updatedAt = resultSet.getString(6);
            updatedAt.substring(0, 10);
            LocalDate updateAts = LocalDate.parse(createdAt);
            companies.add(new Companies(companyId,companyName, type, description, createdAts, updateAts));

        }

        //When Select the company relevant Branches will load.

        cmbCompany.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Companies>() {
            @Override
            public void changed(ObservableValue<? extends Companies> observable, Companies oldValue, Companies newValue) {
                Companies selectedItem = cmbCompany.getSelectionModel().getSelectedItem();
                String companyId = newValue.getCompanyId();
                try {

                    PreparedStatement preparedStatement1 = DBConnection.getInstance().getConnection().prepareStatement("Select * from branches where company_id = ?");
                    preparedStatement1.setObject(1,companyId);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    ObservableList items = cmbBranch.getItems();
                    items.clear();
                    while (resultSet1.next()){
                        items.add(resultSet1.getString(3));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        PreparedStatement preparedStatement1 = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM roles");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        ObservableList<String> roles = cmbDepartment.getItems();
        while (resultSet1.next()){
            roles.add(resultSet1.getString(2));
        }

    }



    public void btnNewEmployee_OnMouseClick(MouseEvent mouseEvent) throws SQLException {
        ResultSet resultSet = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from employees");
        if (resultSet.next()){
            new Alert(Alert.AlertType.INFORMATION,"The email, mobile or nic already in use",ButtonType.OK).show();
            return;
        }else {
            txtEmpID.setText("1");
        }
    }
}
