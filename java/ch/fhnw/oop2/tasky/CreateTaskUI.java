package ch.fhnw.oop2.tasky;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

public class CreateTaskUI extends VBox {
	private Button buttonSave;
	private Button buttonDelete;
	private HBox buttons;
	private VBox creator;

	public CreateTaskUI() {
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		buttons = new HBox();
		buttonSave = new Button("Save");
		buttonDelete = new Button("Delete");
		creator = getCreator();

	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setSpacing(10);
		
		buttons.setSpacing(10);
		buttons.getChildren().addAll(buttonSave, buttonDelete);

		creator.setPrefWidth(Starter.WIDTH / 2);
		creator.setSpacing(10);

		getChildren().addAll(creator, buttons);
	}

	private VBox getCreator() {
		VBox listVBox = new VBox();
		Map<String, Node> items = new LinkedHashMap<>();
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
		label.setPrefWidth(40);
		hbox.getChildren().addAll(label, node);
		return hbox;
	}

}
