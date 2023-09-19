module WordleSolver {
   requires javafx.controls;
   requires javafx.graphics;
   requires javafx.base;
   
   opens wordlesolver to javafx.graphics, javafx.fxml;
}