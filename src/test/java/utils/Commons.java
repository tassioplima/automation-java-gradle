package utils.data;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import model.Plataforma;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Hooks;
import utils.api.AppiumSession;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Commons {

	public static PointOption point = new PointOption();

	public static void longPress(int x, int y) {
		TouchAction action = new TouchAction(Hooks.driver);
		action.longPress(point.withCoordinates(x, y)).perform().release();
	}

	public static void tap(int x, int y) {
		TouchAction action = new TouchAction(Hooks.driver);
		action.tap(point(x, y)).release().perform();
	}

	public static void tapQts(int x, int y, int quantidade) {
		TouchAction action = new TouchAction(Hooks.driver);
		for (int i = 0; i <= quantidade; i++) {
			action.tap(point(x, y)).release().perform();
		}
	}

	public static void tapiOS(String x, String y) {
		Map<String, Object> tap = new HashMap<>();
		tap.put("x", x);
		tap.put("y", y);
		Hooks.driver.executeScript("mobile: tap", tap);
	}

	public static void tapiOSQts(String x, String y, int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			Map<String, Object> tap = new HashMap<>();
			tap.put("x", x);
			tap.put("y", y);
			Hooks.driver.executeScript("mobile: tap", tap);
		}
	}

	public static void waitForVisibilityElement(MobileElement mobile) {
		WebDriverWait wait = new WebDriverWait(Hooks.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(mobile));
	}
	
	public static void waitForVisibilityElement(MobileElement mobile, int time) {
		WebDriverWait wait = new WebDriverWait(Hooks.driver, time);
		wait.until(ExpectedConditions.visibilityOf(mobile));
	}

	public static void waitForInvisibilityElement(MobileElement mobile) {
		WebDriverWait wait = new WebDriverWait(Hooks.driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(mobile));
	}
	
	public static void waitForInvisibilityElement(MobileElement mobile, int time) {
		WebDriverWait wait = new WebDriverWait(Hooks.driver, time);
		wait.until(ExpectedConditions.invisibilityOf(mobile));
	}

	public static void swipeiOSEsquerda() {
		Map<String, Object> tap = new HashMap<>();
		tap.put("direction", "right");
		Hooks.driver.executeScript("mobile: swipe", tap);
	}

	public static void swipeiOSDireita() {
		Map<String, Object> tap = new HashMap<>();
		tap.put("direction", "left");
		Hooks.driver.executeScript("mobile: swipe", tap);
	}

	public static void longPressiOS(String x, String y, int tempo) {
		Map<String, Object> tap = new HashMap<>();
		tap.put("x", x);
		tap.put("y", y);
		tap.put("duration", tempo);
		Hooks.driver.executeScript("mobile: touchAndHold", tap);
	}

	/**
	 * @param startP     valor inicial da porcentagem começando de 0.1 até 0.9
	 * @param endP       valor final da porcentagem começando de 0.1 até 0.9
	 * @param anchorP    valor médio da ancoragem pode ser usado 0.5
	 * @param quantidade valor de quantidade execuções do swipe
	 */
	public static void swipeHorizontalQtd(double startP, double endP, double anchorP, int quantidade) {
		Dimension size = Hooks.driver.manage().window().getSize();
		TouchAction action = new TouchAction(Hooks.driver);

		int anchor = (int) (size.height * anchorP);
		int startPoint = (int) (size.width * startP);
		int endPoint = (int) (size.width * endP);

		for (int i = 0; i <= quantidade; i++) {
			action.press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(500)))
					.moveTo(point(endPoint, anchor)).release().perform();

		}

	}

	/**
	 * @param startP  valor inicial da porcentagem começando de 0.1 até 0.9
	 * @param endP    valor final da porcentagem começando de 0.1 até 0.9
	 * @param anchorP valor médio da ancoragem pode ser usado 0.5
	 */
	public static void swipeHorizontalPorPorcentagem(double startP, double endP, double anchorP) {
		
		TouchAction action = new TouchAction(Hooks.driver);
		Dimension size = Hooks.driver.manage().window().getSize();

		int anchor = (int) (size.height * anchorP);
		int startPoint = (int) (size.width * startP);
		int endPoint = (int) (size.width * endP);

		action.press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(500))).moveTo(point(endPoint, anchor))
				.release().perform();

	}

	/**
	 * @param startP     valor inicial da porcentagem começando de 0.1 até 0.9
	 * @param endP       valor final da porcentagem começando de 0.1 até 0.9
	 * @param anchorP    valor médio da ancoragem pode ser usado 0.5
	 * @param quantidade valor de quantidade execuções do swipe
	 */
	public static void swipeVerticalQtd(double startP, double endP, double anchorP, int quantidade) {
		
		TouchAction action = new TouchAction(Hooks.driver);
		Dimension size = Hooks.driver.manage().window().getSize();

		int anchor = (int) (size.width * anchorP);
		int startPoint = (int) (size.height * startP);
		int endPoint = (int) (size.height * endP);

		for (int i = 0; i <= quantidade; i++) {
			action.press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(500)))
					.moveTo(point(anchor, endPoint)).release().perform();
		}

	}

	/**
	 * @param startP  valor inicial da porcentagem começando de 0.1 até 0.9
	 * @param endP    valor final da porcentagem começando de 0.1 até 0.9
	 * @param anchorP valor médio da ancoragem pode ser usado 0.5
	 */
	public static void swipeVerticalPorPorcentagem(double startP, double endP, double anchorP) {
		
		TouchAction action = new TouchAction(Hooks.driver);
		Dimension size = Hooks.driver.manage().window().getSize();

		int anchor = (int) (size.width * anchorP);
		int startPoint = (int) (size.height * startP);
		int endPoint = (int) (size.height * endP);

		action.press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(500))).moveTo(point(anchor, endPoint))
				.release().perform();

	}

	/**
	 * Esconde o Keyboard
	 */
	public static void hideKeyboard() {
		Hooks.driver.hideKeyboard();
	}

	public static void scroll(double inicio, double fim) throws InterruptedException {
		Thread.sleep(2000);

		Dimension size = Hooks.driver.manage().window().getSize();

		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(Hooks.driver);

		WaitOptions waitOptions = new WaitOptions();
		waitOptions.withDuration(Duration.ofMillis(500));

		action.press(PointOption.point(x, start_y)).waitAction(waitOptions).moveTo(PointOption.point(x, end_y))
				.release().perform();
	}

	public static void scroll(double inicio, double fim, MobileElement elemento) throws Exception {

		boolean elementoEncontrado = false;
		boolean elementoExistente = true;
		long tempoInicio;
		long espera;
		tempoInicio = System.currentTimeMillis();

		Dimension size = Hooks.driver.manage().window().getSize();

		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(Hooks.driver);

		WaitOptions waitOptions = new WaitOptions();
		waitOptions.withDuration(Duration.ofMillis(500));

		while (!elementoEncontrado && elementoExistente) {
			action.press(PointOption.point(x, start_y)).waitAction(waitOptions).moveTo(PointOption.point(x, end_y))
					.release().perform();
			try {
				elemento.getText();
				elementoEncontrado = true;
			} catch (Exception e) {

			}

			espera = System.currentTimeMillis() - tempoInicio;
			if (espera > 15000 && !elementoEncontrado) {
				elementoExistente = false;

			}
		}
		if (!elementoExistente) {
			throw new Exception("Elemento não encontrado!");
		}

	}

	public static void validarTexto(MobileElement elemento, String texto) {
		if (Setup.plataforma.equals(Plataforma.Android.getDescricao())) {
			String txtElement = elemento.getText();
			assertEquals(texto, txtElement);
		} else {
			String txtElement = elemento.getText();
			assertTrue("O elemento nao contem o texto: " + texto, txtElement.contains(texto));
		}

	}

	public static void validarExistenciaElemento(MobileElement elemento, boolean condicao) throws Exception {
		if (condicao) {
			try {
				elemento.isDisplayed();
			} catch (Exception e) {
				throw new Exception("Elemento não encontrado!");
			}
		}
		if (!condicao) {
			try {
				elemento.isDisplayed();
				if(elemento.getAttribute("visible").equals("true")) {
					Assert.fail("Elemento nao era para ser exibido, entretanto o mesmo eh exibido na tela");
				}
				
			} catch (Exception e) {
				System.out.println("Elemento não encontrado com sucesso para testes negativo!");
			}
		}
	}

	public static void swipeAteoElemento(MobileElement elemento, int p1_x, int p1_y, int p2_x, int p2_y,
			int tempoEspera) throws Exception {
		boolean elementoEncontrado = false;
		boolean elementoExistente = true;
		long tempoInicio;
		long espera;
		tempoInicio = System.currentTimeMillis();
		while (!elementoEncontrado && elementoExistente) {
			new TouchAction(Hooks.driver).press(PointOption.point(p1_x, p1_y))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(tempoEspera)))
					.moveTo(PointOption.point(p2_x, p2_y)).release().perform();

			try {
				elemento.getText();
				elementoEncontrado = true;
			} catch (Exception e) {

			}

			espera = System.currentTimeMillis() - tempoInicio;
			if (espera > 15000 && !elementoEncontrado) {
				elementoExistente = false;

			}
		}
		if (!elementoExistente) {
			throw new Exception("Elemento não encontrado!");
		}
	}

	public static void swipeParaDireita() throws InterruptedException {

		Dimension size = Hooks.driver.manage().window().getSize();

		int y = size.height / 2;
		int start_x = (int) (size.width * 0.9);
		int end_x = (int) (size.width * 0.1);

		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(Hooks.driver);

		WaitOptions waitOptions = new WaitOptions();
		waitOptions.withDuration(Duration.ofMillis(500));

		action.press(PointOption.point(start_x, y)).waitAction(waitOptions).moveTo(PointOption.point(end_x, y))
				.release().perform();

		Thread.sleep(2000);
	}

	public static void swipeParaEsquerda() throws InterruptedException {

		Dimension size = Hooks.driver.manage().window().getSize();

		int y = size.height / 2;
		int start_x = (int) (size.width * 0.1);
		int end_x = (int) (size.width * 0.9);

		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(Hooks.driver);

		WaitOptions waitOptions = new WaitOptions();
		waitOptions.withDuration(Duration.ofMillis(500));

		action.press(PointOption.point(start_x, y)).waitAction(waitOptions).moveTo(PointOption.point(end_x, y))
				.release().perform();

		Thread.sleep(2000);
	}

	public static String formatarStringSaldo(String saldo) {
		if (saldo.contains("-")) {
			saldo = saldo.replaceAll("[^,?0-9.]", "");
			saldo = String.format("-" + saldo);
		} else {
			saldo = saldo.replaceAll("[^,?0-9.]", "");
		}
		saldo = saldo.replace(".", "");
		saldo = saldo.replace(",", ".");

		return saldo;
	}
	
	public static void validarTextoParcialmente(MobileElement elemento, String texto){
		if(!elemento.getText().contains(texto)){
			System.out.println("Texto do elemento: "+elemento.getText()+" diferente do texto esperado: "+texto);
			Assert.fail();
		}
	}
	
	public static void swipeHorizontalTESTE(int startPX, int y) {
		
		TouchAction action = new TouchAction(Hooks.driver);
		Dimension size = Hooks.driver.manage().window().getSize();
		
//		int anchor = (int) (size.height - startPX);
		int startP = (int) (size.width - startPX);
		int endP = startP - 300 - startPX;

		action.press(point(startP, y)).waitAction(waitOptions(ofMillis(500))).moveTo(point(endP, y))
				.release().perform();

	}
	
	public static void swipeVerticalTESTE() {
		
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(Hooks.driver);
		Dimension size = Hooks.driver.manage().window().getSize();
		
		int anchor = (int) (size.width/2);
		int startP = (int) (size.height - 400);
		int endP = size.height - startP;

		action.press(point(anchor, startP)).waitAction(waitOptions(ofMillis(500))).moveTo(point(anchor, endP))
				.release().perform();

	}
	
	public static void swipeHorizontalIOSTeste(MobileElement element) {
		Dimension size = Hooks.driver.manage().window().getSize();
		
		int xElement = element.getLocation().getX();
		int yElement = element.getLocation().getY();
		int startP = (int) (size.width - xElement);
		int endP = startP - 100 - xElement;
		
		Map<String, Object> tap = new HashMap<>();
		tap.put("duration", 1.0);
		tap.put("fromX", startP);
		tap.put("fromY", yElement);
		tap.put("toX", endP);
		tap.put("toY", yElement);
		tap.put("element", element.getId());
		Hooks.driver.executeScript("mobile: dragFromToForDuration", tap);
	}
	
	public static void swipeVerticalIOSTeste(MobileElement element, boolean swipeDown) {
		String direction = (swipeDown == true) ? "down" : "up" ;
		Map<String, Object> tap = new HashMap<>();
		tap.put("duration", 1.0);
		tap.put("direction", direction);
		tap.put("element", element.getId());
		Hooks.driver.executeScript("mobile: swipe", tap);
	}
	
	public static void swipeVerticalIOSTeste2(boolean swipeDown) {
		String direction = (swipeDown == true) ? "down" : "up" ;
		Map<String, Object> tap = new HashMap<>();
		tap.put("duration", 1.0);
		tap.put("direction", direction);
		Hooks.driver.executeScript("mobile: swipe", tap);
	}
	
	public static void waitToBeClicableCustom(MobileElement mobile, int time){
		
		WebDriverWait wait = new WebDriverWait(Hooks.driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(mobile));
	}
	
	public static boolean isDisplayedBoolean(MobileElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isDisplayedBoolean(By xpath) {
		
		MobileElement element = Hooks.driver.findElement(xpath);
		
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
	public static void scrollAteElementoCimaParaBaixo(MobileElement elemento) {
		swipeVerticaAteElemento(elemento, "baixo");
	}
			
	public static void scrollAteElementoCimaParaBaixo(String locator, String value) {
		swipeVerticaAteElemento(locator, value, "baixo");
	}		
	
	public static void scrollAteElementoBaixoParaCima(MobileElement elemento) {
		swipeVerticaAteElemento(elemento, "cima");
	}
	
	public static void scrollAteElementoBaixoParaCima(String locator, String value) {
		swipeVerticaAteElemento(locator, value, "cima");
	}
	
	
	public static void swipeVerticaAteElemento(MobileElement elemento, String direcao) {
		boolean elementoEncontrado = false;
		boolean elementoExistente = true;
		long tempoInicio =  System.currentTimeMillis();
		long tempoMaximoTentativaParaEncontrarElemento;
		
		TouchAction action = new TouchAction(Hooks.driver);
		
		Dimension size = Hooks.driver.manage().window().getSize();
		int width = size.width;
		int height = size.height;
		
		int startYCoordinate = (int) (height* .6);
		int endYCoordinate = (int) (height* .2);
		int middleOfX = width / 2;
		
		
		while(!elementoEncontrado && elementoExistente) {
			tempoMaximoTentativaParaEncontrarElemento = System.currentTimeMillis() - tempoInicio;
			
			try {
				Commons.waitForVisibilityElement(elemento, 5);
				elementoEncontrado = true;
			}catch (Exception e) {
				
				if(direcao.equals("baixo")) {
					action.press(PointOption.point(middleOfX, startYCoordinate))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
				}
				else {
				
					action.press(PointOption.point(middleOfX, endYCoordinate))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(middleOfX, startYCoordinate)).release().perform();
				}
			}
			
			if (tempoMaximoTentativaParaEncontrarElemento > 60000 && !elementoEncontrado) {
				System.err.println("Elemento nao existe apos tentativas do swipe");
				elementoExistente = false;

			}
		}
	}
	
	/**
	 * metodo para scroll em elementos que nao estao no pageobject
	 * @param locator locator desejado
	 * @param value    valor do locator  
	 */
	public static void swipeVerticaAteElemento(String locator, String value, String direcao) {
		boolean elementoEncontrado = false;
		boolean elementoExistente = true;
		long tempoInicio =  System.currentTimeMillis();
		long tempoMaximoTentativaParaEncontrarElemento;
		
		TouchAction action = new TouchAction(Hooks.driver);
		
		Dimension size = Hooks.driver.manage().window().getSize();
		int width = size.width;
		int height = size.height;
		
		int startYCoordinate = (int) (height* .6);
		int endYCoordinate = (int) (height* .2);
		int middleOfX = width / 2;
	
		
		while(!elementoEncontrado && elementoExistente) {
			tempoMaximoTentativaParaEncontrarElemento = System.currentTimeMillis() - tempoInicio;
			
			try {
				switch (locator) {
				case "xpath":
					Commons.waitForVisibilityElement(Hooks.driver.findElement(By.xpath(value)), 5);
					break;
				case "id":
					Commons.waitForVisibilityElement(Hooks.driver.findElement(By.id(value)), 5);
					break;
				case "accessibility":
					Commons.waitForVisibilityElement(Hooks.driver.findElement(MobileBy.AccessibilityId(value)), 5);
					break;
				case "iOSNsPredicate":
						Commons.waitForVisibilityElement(Hooks.driver.findElement(MobileBy.iOSNsPredicateString(value)), 5);
					break;
					
				default:
					throw new Exception("Opcao invalida");
				}
				elementoEncontrado = true;
			}catch (Exception e) {
				
				if(direcao.equals("baixo")) {
					action.press(PointOption.point(middleOfX, startYCoordinate))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
				}
				else {
				
					action.press(PointOption.point(middleOfX, endYCoordinate))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(middleOfX, startYCoordinate)).release().perform();
				}
			}
			
			if (tempoMaximoTentativaParaEncontrarElemento > 60000 && !elementoEncontrado) {
				System.err.println("Elemento nao existe apos tentativas do swipe");
				elementoExistente = false;

			}
		}
	}
	
	public static void scrollAteElementoDireitaParaEsqueda(List<MobileElement> elementos, String textoDesejado) {
		swipeHorizontalaAteElemento(elementos, "direita", textoDesejado);
	}
	
	//melhorar para passar a propriedade
	public static void swipeHorizontalaAteElemento(List <MobileElement> elementos, String direcao, String textoDesejado) {
		boolean elementoEncontrado = false;
		boolean elementoExistente = true;
		
		TouchAction action;
		long tempoInicio =  System.currentTimeMillis();
		long tempoMaximoTentativaParaEncontrarElemento;
		
		while(!elementoEncontrado && elementoExistente) {
			tempoMaximoTentativaParaEncontrarElemento = System.currentTimeMillis() - tempoInicio;
			
			MobileElement elementoAnterior = elementos.get(0);
			MobileElement elementoPosterior = elementos.get(1);
			int midOfY = elementoPosterior.getLocation().y +(elementoPosterior.getSize().height/2);
			int fromXLocation = elementoPosterior.getLocation().x;
			int toXLocation = elementoAnterior.getLocation().x;
			
				if(!elementoAnterior.getText().contains(textoDesejado)) {
					if(direcao.equals("direita")) {
						
						 action =new TouchAction(Hooks.driver);
						action.press(PointOption.point(fromXLocation, midOfY))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(toXLocation, midOfY))
						.release()
						.perform();

					}
				
			}
				else {
					elementoEncontrado = true;
				}
					
				if (tempoMaximoTentativaParaEncontrarElemento > 60000 && !elementoEncontrado) {
					System.err.println("Elemento nao existe apos tentativas do swipe");
					elementoExistente = false;

				}
		}
	}
	
	public static void removerApp() throws IOException {
		Process process;
		if(Setup.plataforma.equalsIgnoreCase(Plataforma.Android.getDescricao())) {
			 process = Runtime.getRuntime().exec(new String[]{"bash", "-l", "-c", "adb shell pm uninstall "+AppiumSession.driver.getCapabilities().getCapability("appPackage")});
		}
		else
		 process = Runtime.getRuntime().exec(new String[]{"bash", "-l", "-c", "ideviceinstaller -u "+AppiumSession.driver.getCapabilities().getCapability("udid")+" -U "+AppiumSession.driver.getCapabilities().getCapability("bundleId")});
	}
	
}

