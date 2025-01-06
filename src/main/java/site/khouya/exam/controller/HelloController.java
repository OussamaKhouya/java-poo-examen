package site.khouya.exam.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import site.khouya.exam.metier.RepasDAO;
import site.khouya.exam.model.Repas;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button choisirRepaBtn;

    @FXML
    private Tab ingredTab;
    @FXML
    private TabPane tabs;

    @FXML
    private Tab repasTab;
    @FXML
    private TableColumn<?, ?> repasNomClm;
    @FXML
    private TableColumn<?, ?> repasidClm;
    @FXML
    private TableView<Repas> repasTable;

    RepasDAO repasDao = new RepasDAO();
    Repas repasChoisi = new Repas();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        repasidClm.setCellValueFactory(new PropertyValueFactory<>("id"));
        repasNomClm.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ObservableList<Repas> data = null;
        try {
            data = FXCollections.observableArrayList(
                    repasDao.getAll()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        repasTable.setItems(data);
    }

    @FXML
    void choisirRepaBtnClicked(ActionEvent event) {
        if(!repasTable.getSelectionModel().getSelectedItems().isEmpty()) {
            repasChoisi = repasTable.getSelectionModel().getSelectedItem();
            tabs.getSelectionModel().select(ingredTab);
        }
    }
}