package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.searchCard;

import java.io.FileNotFoundException;

public class Controller {

    @FXML
    public Button searchButton;
    @FXML
    public TextField searchTextField;
    @FXML
    public ImageView myFullImageView;
    @FXML
    public ImageView myCardImageView;


    @FXML
    public void displayFullImage() throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getFullPicture();

        Image myImage = new Image(path);
        myFullImageView.setImage(myImage);
    }
    @FXML
    public void searchTextFullImageFieldAction(ActionEvent event) throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getFullPicture();

        Image myImage = new Image(path);
        myFullImageView.setImage(myImage);
    }

    @FXML
    public void displayCardImage() throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getGamePicture();

        Image myImage = new Image(path);
        myCardImageView.setImage(myImage);
    }
    @FXML
    public void searchTextCardImageFieldAction(ActionEvent event) throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getGamePicture();

        Image myImage = new Image(path);
        myCardImageView.setImage(myImage);
    }



}
