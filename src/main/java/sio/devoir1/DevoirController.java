package sio.devoir1;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sio.devoir1.models.Plat;
import java.net.URL;
import java.util.*;

public class DevoirController implements Initializable {

    private HashMap<String, ArrayList<Plat>> lesPlats;
    private HashMap<String,HashMap<String, ArrayList<Plat>>> lesCartes;
    Alert alert;
    TreeItem noeudCartes;
    String menuPris;
    String cartePrises;
    Plat unPlat;





    @FXML
    private ListView lvCategories;
    @FXML
    private ListView lvMenus;
    @FXML
    private ListView lvCartes;
    @FXML
    private TableColumn tcNomPlat;
    @FXML
    private TableView<Plat> tvPlats;
    @FXML
    private TableColumn tcPrixPlat;
    @FXML
    private Button btnAjouter;
    @FXML
    private TreeView tvCartes;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img2;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // A ne pas effacer
        lesPlats = new HashMap<>();
        lesCartes = new HashMap<>();
        noeudCartes = new TreeItem<>(lvCartes.getSelectionModel().getSelectedItems());
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Choix incorrect");
        alert.setHeaderText("");
        // On charge les données
        downloadDatas();

        // Pour que les images prennent toute la largeur et hauteur de chaque Pane
        img1.fitWidthProperty().bind(pane1.widthProperty());
        img1.fitHeightProperty().bind(pane1.heightProperty());
        img1.setPreserveRatio(false);

        img2.fitWidthProperty().bind(pane2.widthProperty());
        img2.fitHeightProperty().bind(pane2.heightProperty());
        img2.setPreserveRatio(false);

        img3.fitWidthProperty().bind(pane3.widthProperty());
        img3.fitHeightProperty().bind(pane3.heightProperty());
        img3.setPreserveRatio(false);

        tcNomPlat.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcPrixPlat.setCellValueFactory(new PropertyValueFactory<>("prix"));

        lvCartes.getItems().addAll("Carte d'hiver","Carte de printemps","Carte de noël");
        lvMenus.getItems().addAll("Menu BIO","Menu VIP","Menu enfant","Menu végétarien");



        // A vous de jouer pour remplir le ListView avec les catégories
        lvCategories.getItems().addAll("Desserts","Entrées","Plats");

        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Informations Manquantes");
    }

    // Permet de charger les données dans la HashMap "lesPlats"
    public void downloadDatas()
    {
        // A ne pas effacer
        // Entrées
        ArrayList<Plat> entrees = new ArrayList<>();
        entrees.add(new Plat("Salade César", 5.50,"/Images/Image1.jpg"));
        entrees.add(new Plat("Soupe à l’oignon", 4.00,"/Images/Image2.jpg"));
        entrees.add(new Plat("Bruschetta", 3.80,"/Images/Image3.jpg"));
        entrees.add(new Plat("Carpaccio de bœuf", 6.50,"/Images/Image4.jpg"));
        entrees.add(new Plat("Assiette de charcuterie", 7.00,"/Images/Image5.jpg"));
        entrees.add(new Plat("Œufs mimosa", 4.20,"/Images/Image6.jpg"));
        entrees.add(new Plat("Salade de chèvre chaud", 5.90,"/Images/Image7.jpg"));
        entrees.add(new Plat("Tapenade avec toasts", 3.50,"/Images/Image8.jpg"));

        // Plats principaux
        ArrayList<Plat> plats = new ArrayList<>();
        plats.add(new Plat("Steak frites", 12.50,"/Images/Image9.jpg"));
        plats.add(new Plat("Poulet rôti", 11.00,"/Images/Image10.jpg"));
        plats.add(new Plat("Lasagnes", 10.50,"/Images/Image11.jpg"));
        plats.add(new Plat("Pizza Margherita", 9.90,"/Images/Image12.jpg"));
        plats.add(new Plat("Bœuf bourguignon", 13.50,"/Images/Image13.jpg"));
        plats.add(new Plat("Couscous royal", 14.00,"/Images/Image14.jpg"));
        plats.add(new Plat("Risotto aux champignons", 11.50,"/Images/Image15.jpg"));
        plats.add(new Plat("Poisson grillé", 12.80,"/Images/Image16.jpg"));

        // Desserts
        ArrayList<Plat> desserts = new ArrayList<>();
        desserts.add(new Plat("Tiramisu", 4.50,"/Images/Image17.jpg"));
        desserts.add(new Plat("Crème brûlée", 4.20,"/Images/Image18.jpg"));
        desserts.add(new Plat("Mousse au chocolat", 3.90,"/Images/Image19.jpg"));
        desserts.add(new Plat("Profiteroles", 5.20,"/Images/Image20.jpg"));
        desserts.add(new Plat("Île flottante", 4.00,"/Images/Image21.jpg"));
        desserts.add(new Plat("Tarte aux pommes", 4.80,"/Images/Image22.jpg"));
        desserts.add(new Plat("Fondant au chocolat", 5.50,"/Images/Image23.jpg"));
        desserts.add(new Plat("Panna cotta aux fruits rouges", 4.70,"/Images/Image24.jpg"));

        // Remplissage de la HashMap
        lesPlats.put("Entrées", entrees);
        lesPlats.put("Plats", plats);
        lesPlats.put("Desserts", desserts);



    }

    @FXML
    public void lvCategoriesClicked(Event event) {
        // A vous de jouer pour afficher les plats de la catégorie sélectionnée

        //Méthode qui simplifie la vie
        tvPlats.setItems(FXCollections.observableList
                (lesPlats.get(lvCategories.getSelectionModel().getSelectedItem())));

        //Méthode Relou
        /*if (lvCategories.getSelectionModel().getSelectedItem() == "Entrées")
        {


                tvPlats.getItems().clear();
                tvPlats.getItems().addAll(lesPlats.get("Entrées"));


        }

        if (lvCategories.getSelectionModel().getSelectedItem() == "Plats")
        {

                tvPlats.getItems().clear();
                tvPlats.getItems().addAll(lesPlats.get("Plats"));


        }

        if (lvCategories.getSelectionModel().getSelectedItem() == "Desserts")
        {

                tvPlats.getItems().clear();
                tvPlats.getItems().addAll(lesPlats.get("Desserts"));
        }*/

    }


    @FXML
    public void btnAjouterClicked(Event event) {

        // A vous de jouer pour vérfiier les infos et remplir la HashMap "lesCartes"

        if (tvPlats.getSelectionModel().getSelectedItem() == null)
        {
            alert.setHeaderText("Veuillez Choisir un Plat");
            alert.showAndWait();
        } else if (lvCartes.getSelectionModel().getSelectedItem()==null) {
            alert.setHeaderText("Veuillez Choisir une Carte");
            alert.showAndWait();
        } else if (lvMenus.getSelectionModel().getSelectedItem() == null) {
            alert.setHeaderText("Veuillez Choisir un Menu");
            alert.showAndWait();
        }  else {
           cartePrises = lvCartes.getSelectionModel().getSelectedItem().toString();
             menuPris = lvMenus.getSelectionModel().getSelectedItem().toString();



            unPlat = new Plat(tvPlats.getSelectionModel().getSelectedItem().getNom()
                    ,tvPlats.getSelectionModel().getSelectedItem().getPrix()
                    ,tvPlats.getSelectionModel().getSelectedItem().getPhoto());

            if (!lesCartes.containsKey(cartePrises))
            {
                lesCartes.put(cartePrises,new HashMap<>());
            }
            if (!lesCartes.get(cartePrises).containsKey(menuPris))
            {
                lesCartes.get(cartePrises).put(menuPris,new ArrayList<>());
            }

            if (lesCartes.get(cartePrises).get(menuPris).size() > 2 )
            {
                alert.setHeaderText("Il faut 3 plats maximum");
                alert.showAndWait();

            }else {
                lesCartes.get(cartePrises).get(menuPris).add(unPlat);
                afficherLesCartes();
            }



        }

    }

    public void afficherLesCartes()
    {
        // A vous de jouer pour afficher les données dans le TreeView

        TreeItem noeudMenu;
        TreeItem noeudPlat;

        noeudCartes.getChildren().clear();


        for(String nomCartes : lesCartes.keySet())
        {
            noeudCartes = new TreeItem(nomCartes);
            for(String nomMenu : lesCartes.get(nomCartes).keySet())
            {
                noeudMenu = new TreeItem<>(nomMenu);



                    for (Plat nomPlat : lesCartes.get(nomCartes).get(nomMenu)) {

                        String lesPlats = nomPlat.getNom() + " - " + nomPlat.getPrix();
                        noeudPlat = new TreeItem<>(lesPlats);
                        noeudMenu.getChildren().add(noeudPlat);
                        noeudMenu.setExpanded(true);




                    }


                noeudCartes.getChildren().add(noeudMenu);
                noeudCartes.setExpanded(true);
            }


            tvCartes.setRoot(noeudCartes);
        }

    }



    @FXML
    public void tvCartesClicked(Event event) {

        // A ne pas effacer
        img1.setImage(null);
        img2.setImage(null);
        img3.setImage(null);

        // A vous de jouer pour gérer les différents cas lors d'un clique sur le TreeView
        TreeItem noeudClique = (TreeItem) tvCartes.getSelectionModel().getSelectedItem() ;
        if (!(noeudClique == null))
        {
            if(noeudClique.getChildren().size()==1)
            {
                cartePrises = lvCartes.getSelectionModel().getSelectedItem().toString();
                menuPris = lvMenus.getSelectionModel().getSelectedItem().toString();

                String parentCarte = noeudClique.getParent().getValue().toString();

                 List<Plat> photoPlat = lesCartes.get(cartePrises).get(menuPris);



                    //Ici je pense avoir fait les choses correctement mais ne sait pas pourquoi les images ne s'affiche pas
                    if(!(photoPlat == null) && photoPlat.size()==3)
                    {
                        img1.setImage(new Image(photoPlat.get(0).getPhoto()));
                        img2.setImage(new Image(photoPlat.get(1).getPhoto()));
                        img3.setImage(new Image(photoPlat.get(2).getPhoto()));
                    }


            }
        }

    }
}