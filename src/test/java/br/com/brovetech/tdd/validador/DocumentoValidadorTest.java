package br.com.brovetech.tdd.validador;


import org.junit.Assert;
import org.junit.Test;

public class DocumentoValidadorTest {

    @Test
    public void deveValidarCPFNull(){
        String cpf = null;

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFVazio(){
        var cpf = "";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFSemMascaraComDigitosIguais(){
        var cpf = "00000000000";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFComMascaraComDigitosIguais(){
        var cpf = "000.000.000-00";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFSemMascaraComDigitosIguais2(){
        var cpf = "22222222222";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFComMascaraComDigitosIguais2(){
        var cpf = "222.222.222-22";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFSemMascaraMaisDeOnzeDigitos(){
        var cpf = "000000000000";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFComMascaraMaisDeOnzeDigitos(){
        var cpf = "000.000.000-000";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFSemMascaraComDigitosErrados(){
        var cpf = "05335684988";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFComMascaraComDigitosErrados(){
        var cpf = "053.356.849-88";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertFalse(resultado);
    }
    @Test
    public void deveValidarCPFSemMascaraComDigitosCorretos(){
        var cpf = "05335684984";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertTrue(resultado);
    }
    @Test
    public void deveValidarCPFComMascaraComDigitosCorretos(){
        var cpf = "053.356.849-84";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertTrue(resultado);
    }
    @Test
    public void deveValidarCPFSemMascaraComDigitosCorretos2(){
        var cpf = "06484585989";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertTrue(resultado);
    }
    @Test
    public void deveValidarCPFComMascaraComDigitosCorretos2(){
        var cpf = "064.845.859-89";

        var resultado = DocumentoValidador.validarCPF(cpf);
        Assert.assertTrue(resultado);
    }
}
