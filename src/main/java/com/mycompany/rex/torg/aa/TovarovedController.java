package com.mycompany.rex.torg.aa;

import java.io.IOException;
import javafx.fxml.FXML;

public class TovarovedController {

    @FXML
    public void switchToNomenclature() throws IOException {
       App.setRoot("nomenclature");
    }
    @FXML
    public void switchToBack() throws IOException{
        App.setRoot("secondary");
    }


}
