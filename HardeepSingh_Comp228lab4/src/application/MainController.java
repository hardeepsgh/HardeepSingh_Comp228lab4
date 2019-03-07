package application;
//imported files
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleGroupBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainController {

	@FXML
	private TextField _nameTextBox; // text field for name
	@FXML
	private TextField _addreessTextBox; // text field for address
	@FXML
	private TextField _provinceTextBox; // text field for province
	@FXML
	private TextField _cityTextBox; // text field for city
	@FXML
	private TextField _postalCodeTextBox; // text field for postal code
	@FXML
	private TextField _phoneNumberTextBox; // text field for nphone number
	@FXML
	private TextField _emailTextBox; // text field for email
	@FXML
	private TextArea _summaryTextArea; // text field for summay
	@FXML
	private TextArea _courseTextArea; // text field for courses
	@FXML
	private Button _displayBtn; // button  for display
	@FXML
	private RadioButton _compSciRadioBtn; // button for stream
	@FXML
	private RadioButton _businessRadioBtn;// button for stream
	@FXML
	private CheckBox _studentCouncilRadioBtn; // box for activities
	@FXML
	private CheckBox _volunteerWorkRadioBtn;
	@FXML
	private ComboBox _courseComboBox; // selecting courses
	@FXML
	ToggleGroup radioGroup = new ToggleGroup(); // put radio buttons in one group
	@FXML
	private ListView _courseList; // to save courses

	@FXML
	public void initialize() {  // run before startting application
		_compSciRadioBtn.setToggleGroup(radioGroup);  // added to group
		_compSciRadioBtn.setOnAction(new ProgramHandler()); // event handler set
		_businessRadioBtn.setToggleGroup(radioGroup); // added to group
		_businessRadioBtn.setOnAction(new ProgramHandler());// event handler set
		_courseComboBox.getItems().addAll("java", "oops", "C", "C++"); // combobox initialized
		_courseComboBox.setOnAction(new ComboHandler());// event handler set
		_courseComboBox.setValue("java"); // first value set
		_compSciRadioBtn.setSelected(true); // computer sci set as default
		_displayBtn.setOnAction(new DisplayHandler());// event handler set

	}

	// an inner class to handle the click of the Display button
	private class DisplayHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onDisplayBtnClicked();
		}

	}

	// an inner class to handle the click of the combobox change
	private class ComboHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onComboChange();
		}

	}

	// an inner class to handle the click of the program button change
	private class ProgramHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			onRadioChange();
		}

	}

	@FXML
	private void onExitClicked() {
		// ends the application
		System.exit(0);
	}
	// function for display button clicked
	private void onDisplayBtnClicked() {
		String output = "";
		//output string created
		output = "Name: " + _nameTextBox.getText() + "\nAddress: " + _addreessTextBox.getText() + "\nProvince: "
				+ _provinceTextBox.getText() + "\nCity: " + _cityTextBox.getText() + "\nPostal Code: "
				+ _postalCodeTextBox.getText() + "\nPhone Number: " + _phoneNumberTextBox.getText() + "\nEmail"
				+ _emailTextBox.getText() + "\nJoined Studen Council. :" + _studentCouncilRadioBtn.isSelected()
				+ "\nDid Volunteer Work. : " + _volunteerWorkRadioBtn.isSelected() + "\nCourses Taken :"
				+ _courseList.getItems().toString().substring(1, _courseList.getItems().toString().length() - 1) + "\n";
		if (_compSciRadioBtn.isSelected()) { // check for stream
			output += "Program : Computer Science";
		} else {
			output += "Program : Business";
		}
		_summaryTextArea.setText(output); // summery displaye din textarea

	}
	// function to handle tadio button change
	private void onRadioChange() {

		if (_compSciRadioBtn.isSelected()) { //check for stream
			_courseComboBox.getItems().clear();
			_courseComboBox.getItems().addAll("java", "oops", "C", "C++");// combo box reset
			_courseComboBox.setValue("java");

		} else {
			_courseComboBox.getItems().clear();
			_courseComboBox.getItems().addAll("Business1", "business2", "Business", "business4");
			_courseComboBox.setValue("Business1");
		}
		// course list cleared
		_courseList.getItems().clear();
	}

	// function for combo change
	@FXML
	private void onComboChange() {
		// check for null and duplicate entry

		if (_courseComboBox.getValue() != null
				&& !_courseList.getItems().toString().contains(_courseComboBox.getValue().toString())) {
			//course added in list
			_courseList.getItems().add(_courseComboBox.getValue().toString());
		}
		// _courseComboBox.getItems().remove(_courseComboBox.getValue());
		// System.out.println("---------->"+_courseList.getItems().toString());

		// if( _courseComboBox.getValue()!=null &&
		// !_courseList.getItems().toString().contains(
		// _courseComboBox.getValue().toString() )){
		// _courseList.getItems().add( _courseComboBox.getValue().toString());
		// _courseTextArea.setText(_courseTextArea.getText() +"\n"+
		// _courseComboBox.getValue());
		// }
	}
}
