package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Acknowledgement_Message {
    @FXML
    private Label Message;
    private int a;
    private Stage stage;
    @FXML
    void initialize()
    {
        if ( a == 0)
            Message.setText("DONE!!");
        else if ( a == 1)
            Message.setText("BUDGET EXCEEDED");
        else if ( a== -1)
        {
            Message.setText("QUANTITY NOT AVAILABLE");
        }
    }
    @FXML
    public void Done()
    {
        stage.close();
    }
    public void set(int a, Stage b)
    {
        this.a = a;
        stage  = b;
    }

}
