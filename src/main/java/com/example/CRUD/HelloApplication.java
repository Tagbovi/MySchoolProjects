package com.example.CRUD;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    Scene scene,scene2;
    TableView<Books> tableView;
    @Override
    public void start(Stage stage) throws IOException {

        //First Scene (HomePage)
        VBox vBox1=new VBox();
        Label label1 = new Label("Simple CRUD App By Precious");
//Adding an Image
        Image image = new Image(new FileInputStream("C:\\Users\\Administrator\\Downloads\\ima.jpg"));

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setFitHeight(80);
        imageView.setPreserveRatio(true);
        label1.setGraphic(imageView);

        // Setting font to the label
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 25);
        label1.setFont(font);

        // Filling color to the label
        label1.setTextFill(Color.BROWN);

        // Setting the position
        label1.setTranslateX(150);
        label1.setTranslateY(25);
        
//creating a button
        Button helloApplication_btn=new Button("Open");
        helloApplication_btn.setMinWidth(100);



        vBox1.getChildren().addAll(label1,helloApplication_btn);
        scene=new Scene(vBox1, 595, 250, Color.BEIGE);
        stage.setScene(scene);



        stage.setTitle("Home");
        stage.show();

        helloApplication_btn.setOnAction(actionEvent -> {
            stage.setScene(scene2);
        });

        stage.setScene(scene2);
        stage.show();







     //Second scene(Next Page) Tableview page
      VBox vBox=new VBox();

        scene2 = new Scene( vBox,700, 450);
        
        //initialling table and adding columns to table
        tableView=new TableView<>();
        TableColumn<Books,String> scienceBookColomn=new TableColumn<>("Science");
        scienceBookColomn.setMinWidth(200);
        scienceBookColomn.setCellValueFactory(new PropertyValueFactory<>("scienceBooks"));

        TableColumn<Books,String> englishBookColomn=new TableColumn<>("English");
        englishBookColomn.setMinWidth(200);

        englishBookColomn.setCellValueFactory(new PropertyValueFactory<>("englishBooks"));

        TableColumn<Books,Double> priceListsColomn=new TableColumn<>("Prices");
        priceListsColomn.setMinWidth(200);
        priceListsColomn.setCellValueFactory(new PropertyValueFactory<>("priceLists"));


        vBox.isResizable();
        tableView.getColumns().addAll(scienceBookColomn,englishBookColomn,priceListsColomn);
        tableView.setItems(getBooks());


        HBox hBox=new HBox();
      hBox.setSpacing(5);

        hBox.setStyle("-fx-background-color: blue" );
        hBox.setPadding(new Insets(10,10,10,10));

        vBox.getChildren().addAll(tableView,hBox);
        
//textfields for entry
        TextField sciencetf=new TextField();
        sciencetf.setPromptText("Science entry field");
        sciencetf.minWidth(50);


        TextField englishtf=new TextField();
        englishtf.setPromptText("English entry field");
        englishtf.minWidth(50);

        TextField pricetf=new TextField();
        pricetf.setPromptText("Price entry field");
        pricetf.minWidth(50);

//addbutton
        Button addbtn=new Button();
        addbtn.setText("Add");
     addbtn.setMinWidth(50);

        //delete button
        Button deletebtn=new Button();
        deletebtn.setText("Delete");
        deletebtn.setMinWidth(50);


//action listener
        addbtn.setOnAction(actionEvent -> {
           Books books=new Books();
           books.setEnglishBooks(englishtf.getText());
           books.setScienceBooks(sciencetf.getText());
            
//execption
           try{
               books.setPriceLists(Double.parseDouble(pricetf.getText()));
           }

           catch (Exception e){
               pricetf.setStyle("-fx-background-color: red");
              sciencetf.clear();
              englishtf.clear();
           }

            tableView.getItems().add(books);
           sciencetf.clear();
           englishtf.clear();
           pricetf.clear();
        });

        deletebtn.setOnAction(actionEvent -> {
       ObservableList<Books> allbooks, selectedbooks;
       allbooks=tableView.getItems();
       selectedbooks=tableView.getSelectionModel().getSelectedItems();
       selectedbooks.forEach(allbooks::remove);

        });
        hBox.getChildren().addAll(sciencetf,englishtf,pricetf,addbtn,deletebtn);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();










    }



    public ObservableList<Books> getBooks(){
        ObservableList<Books> books= FXCollections.observableArrayList();
        books.add(new Books("matter","words",300.0));

        return books;
    }

    public static void main(String[] args) {
        launch();
    }
}
