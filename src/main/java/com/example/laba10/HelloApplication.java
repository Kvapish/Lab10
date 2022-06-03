package com.example.laba10;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static CirclesList circles_List = new CirclesList();
    public static ConesList cones_List = new ConesList();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        TableView<Circle> circle_table = new TableView<Circle>();

        TableColumn<Circle, Double> radius = new TableColumn<Circle, Double>("Radius");
        TableColumn<Circle, Double> square = new TableColumn<Circle, Double>("Square");
        TableColumn<Circle, Double> perimeter = new TableColumn<Circle, Double>("Perimeter");


        radius.setCellValueFactory(new PropertyValueFactory<>("radius"));
        square.setCellValueFactory(new PropertyValueFactory<>("square"));
        perimeter.setCellValueFactory(new PropertyValueFactory<>("perimeter"));


        radius.setSortType(TableColumn.SortType.DESCENDING);


        ObservableList<Circle> circles_list = getCircleList();
        circle_table.setItems(circles_list);

        circle_table.getColumns().addAll(radius, square, perimeter);
        //----------------------------------------------------------------------------------------------
        TableView<Cone> cone_table = new TableView<Cone>();
        TableColumn<Cone, Double> right_radius = new TableColumn<Cone, Double>("Radius");
        TableColumn<Cone, Double> right_square = new TableColumn<Cone, Double>("Square");
        TableColumn<Cone, Double> right_volume = new TableColumn<Cone, Double>("Volume");
        TableColumn<Cone, Double> right_height = new TableColumn<Cone, Double>("Height");


        right_radius.setCellValueFactory(new PropertyValueFactory<>("radius"));
        right_square.setCellValueFactory(new PropertyValueFactory<>("square"));
        right_volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        right_height.setCellValueFactory(new PropertyValueFactory<>("height"));

        right_radius.setSortType(TableColumn.SortType.DESCENDING);

        ObservableList<Cone> cones_list = getConeList();
        cone_table.setItems(cones_list);
        cone_table.getColumns().addAll(right_radius, right_square, right_volume, right_height);
        //----------------------------------------------------------------------------------------------
        TableView<Circle> circle_table1 = new TableView<Circle>();

        TableColumn<Circle, Double> radius_average = new TableColumn<Circle, Double>("Radius");
        TableColumn<Circle, Double> square_average = new TableColumn<Circle, Double>("Square");
        TableColumn<Circle, Double> perimeter_average = new TableColumn<Circle, Double>("Perimeter");

        radius_average.setCellValueFactory(new PropertyValueFactory<>("radius"));
        square_average.setCellValueFactory(new PropertyValueFactory<>("square"));
        perimeter_average.setCellValueFactory(new PropertyValueFactory<>("perimeter"));

        radius_average.setSortType(TableColumn.SortType.DESCENDING);

        ObservableList<Circle> circles_list1 = findAverageReturnObs();
        circle_table1.setItems(circles_list1);
        circle_table1.getColumns().addAll(radius_average, square_average, perimeter_average);
        //----------------------------------------------------------------------------------------------
        TableView<Cone> cone_table1 = new TableView<Cone>();
        TableColumn<Cone, Double> largest_volume_radius = new TableColumn<Cone, Double>("Radius");
        TableColumn<Cone, Double> largest_volume_square = new TableColumn<Cone, Double>("Square");
        TableColumn<Cone, Double> largest_volume_volume = new TableColumn<Cone, Double>("Volume");
        TableColumn<Cone, Double> largest_volume_height = new TableColumn<Cone, Double>("Height");


        largest_volume_radius.setCellValueFactory(new PropertyValueFactory<>("radius"));
        largest_volume_square.setCellValueFactory(new PropertyValueFactory<>("square"));
        largest_volume_volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        largest_volume_height.setCellValueFactory(new PropertyValueFactory<>("height"));

        right_radius.setSortType(TableColumn.SortType.DESCENDING);

        ObservableList<Cone> cones_list1 = LargestVolume();
        cone_table1.setItems(cones_list1);
        cone_table1.getColumns().addAll(largest_volume_radius, largest_volume_square, largest_volume_volume, largest_volume_height);


        Label circles_label = new Label("Circles : ");
        Label cones_label = new Label("Cones : ");
        Label averageSquare = new Label("Average square of circles : " + circles_List.getAverageSquare());
        Label averageSquare1 = new Label("Circles : ");
        Label largestVolume1 = new Label("Cones : ");
        Label largestVolume = new Label("The largest volume of the cone : " + cones_List.getLargestVolume());


        circles_label.setPadding(new Insets(15));
        circles_label.setFont(Font.font(15));
        averageSquare.setPadding(new Insets(15));
        averageSquare1.setPadding(new Insets(15));

        cones_label.setPadding(new Insets(15));
        cones_label.setFont(Font.font(15));
        largestVolume.setPadding(new Insets(15));
        largestVolume1.setPadding(new Insets(15));

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.getChildren().add(circles_label);
        root.getChildren().add(circle_table);
        root.getChildren().add(averageSquare);
        root.getChildren().add(averageSquare1);
        root.getChildren().add(circle_table1);
        root.getChildren().add(cones_label);
        root.getChildren().add(cone_table);
        root.getChildren().add(largestVolume);
        root.getChildren().add(largestVolume1);
        root.getChildren().add(cone_table1);


        stage.setTitle("Circles , Cones TableView");

        Scene scene = new Scene(root, 600, 800);
        stage.setScene(scene);
        stage.show();

    }

    private ObservableList<Circle> getCircleList() {
        double side = -1;
        int M = 10;
        ObservableList<Circle> circles_list = FXCollections.observableArrayList();
        for (int i = 0; i < M; i++) {
            while (Circle.CorrectRadius("" + (side = Math.random() * 11 - 5)) < 0) {
            }
            circles_list.add(new Circle(side));
            circles_List.add(new Circle(side));
        }
        return circles_list;
    }

    public ObservableList findAverageReturnObs() {
        ObservableList<Circle> circles_listObs = FXCollections.observableArrayList();
        for (Circle circle : circles_List.getCircles_list()) {
            if (circles_List.getAverageSquare() > circle.getSquare()) {
                circles_listObs.add(circle);
            }
        }
        return circles_listObs;
    }

    public ObservableList LargestVolume() {
        ObservableList<Cone> cones_listObs = FXCollections.observableArrayList();
        for (Cone cone : cones_List.getCone_list()) {
            if (cones_List.getLargestVolume() <= cone.getVolume())
                cones_listObs.add(cone);
        }
        return cones_listObs;
    }

    private ObservableList<Cone> getConeList() {
        double side = -1;
        double height = -1;
        int M = 10;
        ObservableList<Cone> cones_list = FXCollections.observableArrayList();
        for (int i = 0; i < M; i++) {
            while (Cone.CorrectRadius("" + (side = Math.random() * 11 - 5)) < 0 || Cone.CorrectHeight("" + (height = Math.random() * 11 - 5)) < 0) {
            }
            cones_list.add(new Cone(side, height));
            cones_List.list.add(new Cone(side, height));
        }
        return cones_list;
    }
}