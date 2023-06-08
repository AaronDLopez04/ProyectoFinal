package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblLinea;
    private JLabel lblColor;
    private JLabel lblUbicacion;
    private JLabel lblUrl;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtLinea;
    private JTextField txtColor;
    private JTextField txtUbicacion;
    private JTextField txtUrl;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JTable tabla;
    private JScrollPane scroll;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel image;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(255, 255, 255));
        lblId = new JLabel("ID");
        txtId = new JTextField(4);
        txtId.setText("0");
        txtId.setEnabled(false);
        lblNombre = new JLabel("Nombre");
        txtNombre = new JTextField(10);
        lblLinea = new JLabel("Linea");
        txtLinea = new JTextField(4);
        lblColor = new JLabel("Color");
        txtColor = new JTextField(10);
        lblUbicacion = new JLabel("Ubicacion");
        txtUbicacion = new JTextField(30);
        lblUrl = new JLabel("Url");
        txtUrl = new JTextField(40);

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblLinea);
        panel1.add(txtLinea);
        panel1.add(lblColor);
        panel1.add(txtColor);
        panel1.add(lblUbicacion);
        panel1.add(txtUbicacion);
        panel1.add(lblUrl);
        panel1.add(txtUrl);

        btnAgregar = new JButton("Agregar");
        panel1.add(btnAgregar);

        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(10, 115, 10));

        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);

        tabla = new JTable();
        scroll = new JScrollPane(tabla);
        panel2.add(scroll);

        //panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(10, 115, 10));
        image = new JLabel("...");
        panel3.add(image);

        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(255, 255, 255));

        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");
        panel4.add(btnEliminar);
        panel4.add(btnActualizar);



        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblLinea() {
        return lblLinea;
    }

    public void setLblLinea(JLabel lblLinea) {
        this.lblLinea = lblLinea;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JLabel getLblUbicacion() {
        return lblUbicacion;
    }

    public void setLblUbicacion(JLabel lblUbicacion) {
        this.lblUbicacion = lblUbicacion;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtLinea() {
        return txtLinea;
    }

    public void setTxtLinea(JTextField txtLinea) {
        this.txtLinea = txtLinea;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextField txtColor) {
        this.txtColor = txtColor;
    }

    public JTextField getTxtUbicacion() {
        return txtUbicacion;
    }

    public void setTxtUbicacion(JTextField txtUbicacion) {
        this.txtUbicacion = txtUbicacion;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImage() {
        return image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtLinea.setText("");
        txtColor.setText("");
        txtUbicacion.setText("");
        txtUrl.setText("");
    }
}
