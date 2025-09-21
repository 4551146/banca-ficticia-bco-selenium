package cl.kibernum.bancaficticia.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BancaFicticiaPage {

    private final WebDriver driver;
    private By inputUsuario = By.id("username");
    private By inputPassword = By.id("password");
    private By btnEntrar = By.xpath("//button[contains(text(),'Entrar')]");
    private By spanBienvenido = By.xpath("//div[@id = 'menu-section']/h2");
    private By spanIncorrecta = By.xpath("//div[@id='login-message']//div");
    private By btnConsultaSaldo = By.id("btn-balance");
    private By spanConsultaSaldo = By.id("balance-info");
    private By btnTransferencia = By.id("btn-transfer");
    private By inputDestino = By.id("destino");
    private By inputMonto = By.id("monto");
    private By inputMotivo = By.id("motivo");
    private By spanTransferencia = By.xpath("//div[@id = 'transfer-message']//div");
    private By btnTransferir = By.xpath("//button[contains(text(),'Transferir')]");
    private By btnCerrarSesion = By.id("btn-logout");
    private By labelIniciarSesion = By.xpath("//div[@id = 'login-section']/h2");

    public BancaFicticiaPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void clickBtnEntrar(){
        driver.findElement(btnEntrar).click();
    }

    public void clickBtnSaldo(){
        driver.findElement(btnConsultaSaldo).click();
    }

    public void clickBtnTransferencia(){
        driver.findElement(btnTransferencia).click();
    }

    public void sendKeysUsuario(String user){
        driver.findElement(inputUsuario).sendKeys(user);
    }

    public void sendKeysPassword(String pass){
        driver.findElement(inputPassword).sendKeys(pass);
    }
    
    public String getTextLabelBienvenido(){
        return driver.findElement(spanBienvenido).getAttribute("innerHTML");
    }

    public String getTextLabelCredencialesIncorrectas(){
        return driver.findElement(spanIncorrecta).getAttribute("innerHTML");
    }

    public boolean isVisibleTextSaldo(){
        return driver.findElement(spanConsultaSaldo).isDisplayed();
    }

    public void sendKeysDestino(String destino){
        driver.findElement(inputDestino).sendKeys(destino);
    }

    public void sendKeysMonto(String monto){
        driver.findElement(inputMonto).sendKeys(monto);
    }

    public void sendKeysMotivo(String motivo){
        driver.findElement(inputMotivo).sendKeys(motivo);
    }

    public String getTextLabelTransferencia(){
        return driver.findElement(spanTransferencia).getAttribute("innerHTML");
    }

    public void clickBtnTrasnferir(){
        driver.findElement(btnTransferir).click();
    }

    public void clickBtnCerrarSesion(){
        driver.findElement(btnCerrarSesion).click();
        
    }

    public String getTextLabelInicio(){
        return driver.findElement(labelIniciarSesion).getAttribute("innerHTML");
    }
}
