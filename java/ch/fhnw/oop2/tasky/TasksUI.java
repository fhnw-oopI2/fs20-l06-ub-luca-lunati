package ch.fhnw.oop2.tasky;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TasksUI extends VBox {
	private Button buttonNew;
	private Button buttonRefresh;
	private HBox buttons;
	private HBox tasks;

	public TasksUI() {
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		tasks = new HBox();
		buttons = new HBox();
		buttonNew = new Button("New");
		buttonRefresh = new Button("Resfresh");

	}

	private void layoutControls() {
		setPadding(new Insets(10));

		buttons.setSpacing(10);
		buttons.getChildren().addAll(buttonNew, buttonRefresh);

		tasks.setPrefWidth(Starter.WIDTH / 2);
		tasks.getChildren().addAll(
				Stream.of("Todo", "Doing", "Done").map(state -> createTaskList(state)).collect(Collectors.toList()));

		getChildren().addAll(tasks, buttons);
	}

	private VBox createTaskList(String state) {
		VBox listVBox = new VBox();
		listVBox.setPrefWidth(Starter.WIDTH / 2 / 3);

		Label stateLabel = new Label(state);
		VBox taskVBox = new VBox();
		taskVBox.setId(state);

		taskVBox.getChildren().add(new TaskUI("Erster mockup task", "1", "Ich bin der erste " + state + " Task!"));
		taskVBox.getChildren().add(new TaskUI("Zweiter mockup task", "2", "Ich bin der zweite " + state + " Task!"));
		taskVBox.setPrefHeight(Starter.HEIGHT * 0.8);
		taskVBox.setStyle("-fx-padding: 10;" + "-fx-spacing: 10;" + "-fx-border-style: solid inside;"
				+ "-fx-border-width: 2;" + "-fx-border-insets: 5;");
		listVBox.getChildren().addAll(stateLabel, taskVBox);
		return listVBox;
	}

	private VBox newTaskMenu() {
		VBox listVBox = new VBox();
		Map<String, Node> items = new HashMap<>();
		items.put("ID", new TextField());
		items.put("Title", new TextField());
		items.put("Desc", new TextArea());
		items.put("Date", new DatePicker());
		items.put("State", new ComboBox<>(FXCollections.observableArrayList("Todo", "Doing", "Done")));
		listVBox.getChildren().addAll(
				items.keySet().stream().map(key -> createLine(key, items.get(key))).collect(Collectors.toList()));
		return listVBox;
	}

	private HBox createLine(String desc, Node node) {
		HBox hbox = new HBox();
		Label label = new Label(desc);
		hbox.getChildren().addAll(label, node);
		return hbox;
	}

}
