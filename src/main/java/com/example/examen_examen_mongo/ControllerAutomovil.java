package com.example.examen_examen_mongo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerAutomovil {
    @FXML
    TextField txtIdAutomovil;
    @FXML
    TextField txtMarca;
    @FXML
    TextField txtNacionalidad;
    @FXML
    TextField txModelo;
    @FXML
    TextField txtPrecio;
    @FXML
    TextField txtTransmicion;
    @FXML
    TextField txtCilindraje;
    @FXML
    TextField txtTipo;
    @FXML
    Button btnSave;
    @FXML
    Button btnUpdate;
    @FXML
    Button btnShow;
    @FXML
    Button btnDelete;
    @FXML
    Label lblResult;

    ConexionNube cmn=new ConexionNube();

    public void guardar(){
        Automovil auto = new Automovil();
        auto.setIdAutomovil(Integer.parseInt(txtIdAutomovil.getText()));
        auto.setPais(txtNacionalidad.getText());
        auto.setPrecio(txtPrecio.getText());
        auto.setMarca(txtMarca.getText());
        auto.setModelo(txModelo.getText());
        auto.setTrasmision(txtTransmicion.getText());
        auto.setCilindraje(txtCilindraje.getText());
        auto.setTipo(txtTipo.getText());
        if(cmn.save(auto)==true){
            lblResult.setText("Guardado con Exíto");
            //clean();
        } else{
            lblResult.setText("Datos no Aguardados");
        }
    }

    public void update(){
        Automovil autoViejo = new Automovil();
        Automovil autoNuevo = new Automovil();
        if (txtIdAutomovil!=null) {
            autoViejo.setIdAutomovil(Integer.parseInt(txtIdAutomovil.getText()));
            autoNuevo.setIdAutomovil(Integer.parseInt(txtIdAutomovil.getText()));
            autoNuevo.setPais(txtNacionalidad.getText());
            autoNuevo.setPrecio(txtPrecio.getText());
            autoNuevo.setMarca(txtMarca.getText());
            autoNuevo.setModelo(txModelo.getText());
            autoNuevo.setTrasmision(txtTransmicion.getText());
            autoNuevo.setCilindraje(txtCilindraje.getText());
            autoNuevo.setTipo(txtTipo.getText());
            if(cmn.actualizar(autoViejo,autoNuevo)==true){
                lblResult.setText("Los datos se actualizaron con exito.");
                //clean();
            } else{
                lblResult.setText("Hubo un error al actualizar los datos");
            }
        } else{
            txtIdAutomovil.setText("Asigna un valor al id");
        }
    }

    public void show(){
        if(cmn.show()==true){
            lblResult.setText("Los datos fueron mostrados en la consola");
            clean();
        } else{
            lblResult.setText("Hubo un error al mostrar los datos");
            clean();
        }
    }

    public void delete(){
        if(txtIdAutomovil!=null) {
            int idAutomovil = Integer.parseInt(txtIdAutomovil.getText());
            if (cmn.delete(idAutomovil) == true) {
                lblResult.setText("El registro fue eliminado con exito");
                clean();
            } else {
                lblResult.setText("Error al eliminar el registro");
            }
        } else{
            txtIdAutomovil.setText("Asigna un valor al id");
        }
    }

    public void clean(){
        txtIdAutomovil.setText("");
        txtNacionalidad.setText("");
        txtPrecio.setText("");
        txtMarca.setText("");
        txModelo.setText("");
        txtTransmicion.setText("");
        txtCilindraje.setText("");
        txtTipo.setText("");
    }
}