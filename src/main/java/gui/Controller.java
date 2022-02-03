package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.searchCard;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button searchButton;
    @FXML
    public TextField searchTextField;
    @FXML
    public ImageView myFullImageView;
    @FXML
    public ImageView myCardImageView;
    @FXML
    public Hyperlink myHyperLink;
    String link;


    //Old
    @FXML
    public void displayFullImage() throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getFullAbsolutePath();

        Image myImage = new Image(path);
        myFullImageView.setImage(myImage);
    }
    @FXML
    public void searchTextFullImageFieldAction(ActionEvent event) throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getFullAbsolutePath();

        Image myImage = new Image(path);
        myFullImageView.setImage(myImage);
    }

    //new
    @FXML
    public void displayCardImage() throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getGameAbsolutePath();

        Image myImage = new Image(path);
        myCardImageView.setImage(myImage);
        myHyperLink.setVisible(true);
        link = "";
        link = "https://lor.mobalytics.gg/cards/"+searcher.searchCardExact(searchString).getCardCode();
    }

    @FXML
    public void searchTextCardImageFieldAction(ActionEvent event) throws FileNotFoundException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        String path = searcher.searchCardExact(searchString).getGameAbsolutePath();

        Image myImage = new Image(path);
        myCardImageView.setImage(myImage);
        myHyperLink.setVisible(true);
        link = "";
        link = "https://lor.mobalytics.gg/cards/"+searcher.searchCardExact(searchString).getCardCode();
    }

    @FXML
    public void openMobalyticsLink(ActionEvent event) throws URISyntaxException, IOException {

        String searchString = searchTextField.getText();
        searchCard searcher = new searchCard();

        //String path = searcher.searchCardExact(searchString).getCardCode();
        //path = "https://lor.mobalytics.gg/cards/"+path;

        if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

}
