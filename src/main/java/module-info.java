module edu.farmingdale.g5_csc325_semesterproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.g5_csc325_semesterproj to javafx.fxml;
    exports edu.farmingdale.g5_csc325_semesterproj;
}