package calculadoraprobabilidades; 
  
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat; 
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField; 
import javafx.scene.text.Text; 
  
public class FXMLDocumentController { 
  
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
  
   @FXML 
   void onClick(ActionEvent event) { 
  
     try { 
       BigDecimal chances = new BigDecimal(inptC.getText());
       BigDecimal total = new BigDecimal(inptT.getText());
  
       // Verifica se o valor total ou chances são menores que zero.
       if (total.compareTo(BigDecimal.ZERO) <= 0 || chances.compareTo(BigDecimal.ZERO) <= 0) {
         lblResult.setText("Entrada inválida");
         return;
       }
  
       // Cálculo da probabilidade
       BigDecimal result = chances.divide(total, 10, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
  
       //Formatando o resultado para deixar com apenas duas casas decimais. 
       String formatResult = result.setScale(2, RoundingMode.HALF_UP).toString();
  
       //Apresentando o resultado já formatado na tela. 
       lblResult.setText(formatResult + "%"); 
  
     } catch(NumberFormatException e){
         lblResult.setText("Número Inválido!");
     } catch(Exception e){
         lblResult.setText("Error");
     }
   } 
 }
