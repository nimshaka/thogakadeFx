package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private DatePicker dateDOB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("MR.");
        titles.add("MRS.");
        titles.add("MISS.");
        cmbTitle.setItems(titles);
    }

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String title = cmbTitle.getValue();
        LocalDate dob = dateDOB.getValue();
        Customer customer = new Customer(id,name,address,contact,title,dob);

        List<Customer> customerList= DBConnection.getInstance().getConnection();
        customerList.add(customer);
        System.out.println(customer);

    }

}
