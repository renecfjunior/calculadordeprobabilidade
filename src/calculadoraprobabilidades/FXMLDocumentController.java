
package calculadoraprobabilidades;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;



public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lblMessage;

    @FXML
    private TextField inptC;

    @FXML
    private TextField inptT;

    @FXML
    private Text lblResult;

    @FXML
    private Button btnCalc;
    
    public Double chances;
    
    public Double total;
    
    public Double result;

    @FXML
    void onClick(ActionEvent event) {
     
        try{
     // Obtendo o valor em String e convertendo para Double com o parse Double.
        chances = Double.parseDouble(inptC.getText());
        
        total = Double.parseDouble(inptT.getText());
        
        result = chances / total * 100;
        
        //Formatando o resultado para deixar com apenas duas casas decimais.
        String formatResult = new DecimalFormat("#.00").format(result);
        
        //Apresentando o resultado já formatado na tela.
        lblResult.setText(formatResult + "%");
        
        }
        // Exception para valores que não sejam números.
        catch(NumberFormatException e){
            lblResult.setText("Número Inválido!");
        }
        // Exception para tratar algum erro genérico que possa apresentar.
        catch(Exception e){
            lblResult.setText("Error");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
