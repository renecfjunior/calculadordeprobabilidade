package calculadoraprobabilidades; 
  
import java.math.BigDecimal;
import java.math.RoundingMode;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.scene.control.Button; 
import javafx.scene.control.TextField; 
import javafx.scene.text.Text; 
  
public class FXMLDocumentController { 
  
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
       BigDecimal formatResult = result.setScale(2, RoundingMode.HALF_UP);
       if (formatResult.scale() > 2) {
           throw new Exception("Resultado com mais de duas casas decimais");
       }
  
       //Apresentando o resultado já formatado na tela. 
       lblResult.setText(formatResult + "%"); 


       
       // Cursor volta para o primeiro input após o cálculo.
       inptC.requestFocus();
  
       
       
      } catch(NumberFormatException e){
         lblResult.setText("Número Inválido!");
     } catch(Exception e){
       if (e.getMessage().equals("Resultado com mais de duas casas decimais")) {
           lblResult.setText("Resultado com mais de duas casas decimais");
       } else {
           lblResult.setText("Error");
       }
     }
   } 
   //Função para alterar e calcular ao apertar a tecla Enter.
   @FXML
   private void handleEnterPressed(ActionEvent event) {
      if (event.getSource() == inptC) {
         inptT.requestFocus();
      } else if (event.getSource() == inptT) {
         onClick(event);
      }
   
   }
   
   @FXML
   public void initialize() {
      inptC.setOnAction(this::handleEnterPressed);
      inptT.setOnAction(this::handleEnterPressed);
   }
}
