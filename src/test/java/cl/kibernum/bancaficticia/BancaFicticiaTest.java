package cl.kibernum.bancaficticia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cl.kibernum.bancaficticia.Pages.BancaFicticiaPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BancaFicticiaTest {

    private WebDriver driver;
    private BancaFicticiaPage bancaFicticiaPage;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        bancaFicticiaPage = new BancaFicticiaPage(driver);
        driver.manage().window().maximize();
        driver.get("https://bco-selenium.netlify.app/");
    }

    @Test
    public void loginExitosoConUsuarioValido(){
        bancaFicticiaPage.sendKeysUsuario("sofia");
        bancaFicticiaPage.sendKeysPassword("academy");
        bancaFicticiaPage.clickBtnEntrar();
        assertTrue(bancaFicticiaPage.getTextLabelBienvenido().contains("Bienvenido"), "No es visible mensaje de bienvenida");
    }

    @Test
    public void loginFallidoConCredencialesIncorrectas(){
        bancaFicticiaPage.sendKeysUsuario("testqa");
        bancaFicticiaPage.sendKeysPassword("testqa");
        bancaFicticiaPage.clickBtnEntrar();
        assertTrue(bancaFicticiaPage.getTextLabelCredencialesIncorrectas().contains("Credenciales incorrectas"), "No es visible mensaje de error");
    }

    @Test
    public void consultarSaldoTrasLogin(){
        bancaFicticiaPage.sendKeysUsuario("sofia");
        bancaFicticiaPage.sendKeysPassword("academy");
        bancaFicticiaPage.clickBtnEntrar();
        bancaFicticiaPage.clickBtnSaldo();
        assertTrue(bancaFicticiaPage.isVisibleTextSaldo(), "No es visible span de saldo");
    }

    @Test
    public void transferenciaBancariaExitosa(){
        bancaFicticiaPage.sendKeysUsuario("sofia");
        bancaFicticiaPage.sendKeysPassword("academy");
        bancaFicticiaPage.clickBtnEntrar();
        bancaFicticiaPage.clickBtnTransferencia();
        bancaFicticiaPage.sendKeysDestino("Personaficticia");
        bancaFicticiaPage.sendKeysMonto("4000");
        bancaFicticiaPage.sendKeysMotivo("Feliz cumpleaños");
        bancaFicticiaPage.clickBtnTrasnferir();
        assertTrue(bancaFicticiaPage.getTextLabelTransferencia().contains("Transferencia exitosa a Personaficticia por $4000. Motivo: Feliz cumpleaños"), "No es visible mensaje de transferencia exitosa"); 
    }

    @Test
    public void transferenciaBancariaSaldoInsuficiente(){
        bancaFicticiaPage.sendKeysUsuario("sofia");
        bancaFicticiaPage.sendKeysPassword("academy");
        bancaFicticiaPage.clickBtnEntrar();
        bancaFicticiaPage.clickBtnTransferencia();
        bancaFicticiaPage.sendKeysDestino("Personaficticia");
        bancaFicticiaPage.sendKeysMonto("10000");
        bancaFicticiaPage.sendKeysMotivo("Feliz cumpleaños");
        bancaFicticiaPage.clickBtnTrasnferir();
        assertTrue(bancaFicticiaPage.getTextLabelTransferencia().contains("Saldo insuficiente"), "No es visible mensaje de monto insuficiente");   
    }

    @Test
    public void testCerrarSesion(){
        bancaFicticiaPage.sendKeysUsuario("sofia");
        bancaFicticiaPage.sendKeysPassword("academy");
        bancaFicticiaPage.clickBtnEntrar();
        bancaFicticiaPage.clickBtnCerrarSesion();
        assertTrue(bancaFicticiaPage.getTextLabelInicio().contains("Iniciar Sesión"), "No se muestra página para iniciar sesión");
    }

    @AfterEach
    void downSetUp(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
    
}
