package com.DAWI_I202224460.Espinoza_Atalaya_Italo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class EspinozaAtalayaItaloApplication {

	private static boolean isBrowserOpened = false;

	public static void main(String[] args) {
		SpringApplication.run(EspinozaAtalayaItaloApplication.class, args);
		/*try {
			Thread.sleep(3000);
			if (!isBrowserOpened) {
				Runtime.getRuntime().exec("cmd /c start http://localhost:8080/maintenance/start");
				isBrowserOpened = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
