
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Valdo Mpinga
 * this test code validates ONLY the necessary inputs that will go to the database that are inserted on the keyboard.
 * On the database there are 20 table, anyway we only validate 3 tables because on the other tables the input are the
 * same, so to avoid redundancy, we only validated table that had unvalidated data type which were not validated previously.
 */

public class validationTests
{
    @Test
    /**
     * @param nameFormat: all variables that have the regex code
     * @param testFormatName: all test Variables
     */
    void tabela_EstadoDeEncomenda()
    {
        String NIFformat="\\d{9}";
        String testNIF="301010277";

        Assertions.assertTrue(testNIF.matches(NIFformat),"O formato padrao do NIF de 9 digitos nao foi respeitado");
    }

    @Test
    void tabela_Produto()   //falta preços de venda
    {
        String dateFormat="\\d{2}-\\d{2}-\\d{4}";
        String testDate="12-12-2001";

        String quantiyFormat="\\d{1,}";
        String testQuantity="4566666";

        Assertions.assertAll(()-> Assertions.assertEquals(true,testQuantity.matches(quantiyFormat),"Por favor, insira somente numeros inteiros"),
                ()-> Assertions.assertEquals(true,testDate.matches(dateFormat),"Por favor, insira dados no formato dd-mm-yyyy"));

    }

    @Test
    void tabela_Clientes()
    {
        String postalCodeFormat="\\d{4}-\\d{3}";
        String testPostalCode="4900-300";

        String emailFormat="\\w[a-z 0-9]+@\\w[a-z]+[.]+\\w{2,3}";
        String testEmail="joaocabral79@ipvc.pt";

        String passwordFormat="\\w{6,}\\d{1,}";
        String testPassword="helloo7";

        String cellNumberFormat="\\d{9}";
        String testCellNumber="969667274";

        Assertions.assertAll(
                ()->Assertions.assertEquals(true,testPostalCode.matches(postalCodeFormat),"O codigo postal deve estar no formato: xxxx-xxx"),
                ()->Assertions.assertEquals(true,testEmail.matches(emailFormat),"O email deve estar no formato: username@dominio.TLD"),
                ()->Assertions.assertEquals(true,testPassword.matches(testPassword),"A senha deve conter no minimo 6 letras e 1 digito no minimo"),
                ()->Assertions.assertEquals(true,testCellNumber.matches(cellNumberFormat),"O numero de celular deve ter 9 digitos"));

    }
}
