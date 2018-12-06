package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class NotificacaoUtil {

	public static void montarNotificacao(String token, String mensagem) {
		try {
			JsonObject settings = new JsonObject();
			
			settings.addProperty("title", "Mensagem");
			settings.addProperty("body", mensagem);
			settings.addProperty("to", token);
			
			URL url = new URL("https://exp.host/--/api/v2/push/send");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			OutputStream outPutStream = conn.getOutputStream();
			outPutStream.write(settings.toString().getBytes("UTF-8"));
			
			InputStream inputStream = conn.getInputStream();
			String resp = getStringFromInputStream(inputStream);
			System.out.println("Response: " + resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void montarNotificacao() {
		try {
			JsonObject settings = new JsonObject();
			
			settings.addProperty("title", "Mensagem");
			settings.addProperty("body", "Bom dia!");
			settings.addProperty("to", "ExponentPushToken[M04ONuLk7MyQXgkGT03QxI]");
			
			URL url = new URL("https://exp.host/--/api/v2/push/send");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			OutputStream outPutStream = conn.getOutputStream();
			outPutStream.write(settings.toString().getBytes("UTF-8"));
			
			InputStream inputStream = conn.getInputStream();
			String resp = getStringFromInputStream(inputStream);
			System.out.println("Response: " + resp);	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String retornaNotificacaoJson(String notificacao) {
		Gson gson = new Gson();
		String json = gson.toJson(notificacao);
		return json;
	}
	
	
	private static String getStringFromInputStream(InputStream inputStream){
		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();
		String line;

		try{
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			while((line = bufferedReader.readLine()) != null){
				stringBuilder.append(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bufferedReader != null){
				try{
					bufferedReader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return stringBuilder.toString();
	}
	
	
	public static void main(String[] args) {
		montarNotificacao();
	}
}